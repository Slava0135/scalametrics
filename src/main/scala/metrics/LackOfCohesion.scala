package io.github.slava0135.scalametrics
package metrics

import scala.meta.{Source, XtensionParseInputLike}

object LackOfCohesion {
  def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    0
  }
}
