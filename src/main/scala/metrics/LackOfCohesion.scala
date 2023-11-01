package io.github.slava0135.scalametrics
package metrics

object LackOfCohesion extends LackOfCohesionTrait {
  override def name(): String = "LCOM"
  override protected def score(empty: Int, nonEmpty: Int): Double = {
    Math.max(0, empty - nonEmpty)
  }
}
