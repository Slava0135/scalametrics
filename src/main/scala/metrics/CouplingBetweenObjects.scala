package io.github.slava0135.scalametrics
package metrics

import scala.collection.mutable
import scala.meta.{Defn, Source, Type, XtensionParseInputLike}

object CouplingBetweenObjects {
  def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    println(tree.structure)
    var classCount = 0
    val classes = new mutable.HashMap[String, Defn]
    tree.traverse {
      case cls: Defn.Class =>
        classCount += 1
        classes.put(cls.name.value, cls)
    }
    var totalCoupled = 0
    for (cls <- classes) {
      cls._2.traverse {
        case other: Type.Name if other.value != cls._1 && classes.contains(other.value) =>
          totalCoupled += 1
      }
    }
    totalCoupled.toDouble / classCount.toDouble
  }
}
