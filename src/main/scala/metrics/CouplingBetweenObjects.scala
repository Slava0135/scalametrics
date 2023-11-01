package io.github.slava0135.scalametrics
package metrics

import scala.collection.mutable
import scala.meta.{Defn, Source, Type, XtensionParseInputLike}

object CouplingBetweenObjects extends Metric {
  override def name(): String = "CBO"
  override def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    var classCount = 0
    val classes = new mutable.HashMap[String, Defn]
    tree.traverse {
      case cls: Defn.Class =>
        classCount += 1
        classes.put(cls.name.value, cls)
    }
    var totalCoupled = 0
    for (cls <- classes) {
      val uses = new mutable.HashSet[String]
      cls._2.traverse {
        case other: Type.Name if other.value != cls._1 && classes.contains(other.value) =>
          val className = other.value
          other.parent.get match {
            case select: Type.Select =>
              val classPath = select.tokens.toString()
              if (!uses.contains(classPath)) {
                uses += classPath
                totalCoupled += 1
              }
            case _ =>
              if (!uses.contains(className)) {
                totalCoupled += 1
                uses += className
              }
          }
      }
    }
    totalCoupled.toDouble / classCount.toDouble
  }
}
