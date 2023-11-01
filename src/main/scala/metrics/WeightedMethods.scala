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
        for (member <- cls.children.last.children) {
          member match {
            case _: Defn.Def =>
              methodCount += 1
            case _ =>
          }
        }
    }
    methodCount.toDouble / classCount.toDouble
  }
}

