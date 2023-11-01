package io.github.slava0135.scalametrics
package metrics

object NormLackOfCohesion extends LackOfCohesionTrait {
  override def name(): String = "NLCOM"
  override protected def score(empty: Int, nonEmpty: Int): Double = {
    val sum = empty + nonEmpty
    if (sum > 0) {
      nonEmpty.toDouble / sum.toDouble
    } else {
      0
    }
  }
}