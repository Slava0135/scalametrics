package io.github.slava0135.scalametrics
package metrics

import scala.collection.mutable
import scala.meta.{Defn, Source, Type, XtensionParseInputLike}

object NumberOfChildren extends Metric {
  override def name(): String = "NOC"
  override def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    val classChildrenN = new mutable.HashMap[String, Int]
    var classCount = 0
    tree.traverse {
      case cls: Defn.Class =>
        classCount += 1
        val parents = cls.templ.inits
        if (parents.nonEmpty) {
          parents.head.traverse {
            case name: Type.Name =>
              classChildrenN.update(name.value, classChildrenN.getOrElse(name.value, 0) + 1)
          }
        }
    }
    classChildrenN.values.sum.toDouble / classCount
  }
}
