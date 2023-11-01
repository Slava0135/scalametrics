package io.github.slava0135.scalametrics
package metrics

import scala.meta.{Defn, Source, Term, XtensionParseInputLike}

object AverageNumberOfArguments {
  def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    var methodParams = 0
    var methodCount = 0
    tree.traverse {
      case cls: Defn.Class =>
        for (member <- cls.children.last.children) {
          member match {
            case defN: Defn.Def =>
              methodCount += 1
              for (group <- defN.paramClauseGroups) {
                group.traverse {
                  case _: Term.Param =>
                    methodParams += 1
                }
              }
            case _ =>
          }
        }
    }
    if (methodCount == 0) {
      0
    } else {
      methodParams.toDouble / methodCount.toDouble
    }
  }
}
