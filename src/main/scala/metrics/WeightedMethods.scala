package io.github.slava0135.scalametrics
package metrics

import scala.meta.{Defn, Source, XtensionParseInputLike}

object WeightedMethods {
  def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    var classCount = 0
    var methodCount = 0
    tree.traverse {
      case cls: Defn.Class =>
        classCount += 1
        cls.traverse {
          case _: Defn.Def =>
            methodCount += 1
        }
    }
    methodCount.toDouble / classCount.toDouble
  }
}

