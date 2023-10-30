package io.github.slava0135.scalametrics
package metrics

import scala.meta.{Defn, Source, XtensionParseInputLike}

object WeightedMethods {
  def evaluate(source: String): Int = {
    val tree = source.parse[Source].get
    var count = 0
    tree.traverse {
      case _: Defn.Def =>
        count += 1
    }
    count
  }
}

