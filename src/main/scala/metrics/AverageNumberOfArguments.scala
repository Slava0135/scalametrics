package io.github.slava0135.scalametrics
package metrics

import scala.meta.{Defn, Source, Term, XtensionParseInputLike}

object AverageNumberOfArguments {
  def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    println(tree.structure)
    var methodParams = 0
    var methodCount = 0
    tree.traverse {
      case defN: Defn.Def =>
        methodCount += 1
        defN.traverse {
          case _: Term.Param =>
            methodParams += 1
        }
    }
    if (methodCount == 0) {
      0
    } else {
      methodParams.toDouble / methodCount.toDouble
    }
  }
}
