package io.github.slava0135.scalametrics
package metrics

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class WeightedMethodsTest extends AnyFunSuite {
  test("WeightedMethods.evaluate") {
    val source = Source.fromResource("metrics/WeightedMethods/NoMethods.scala").getLines().mkString("\n")
    assert(WeightedMethods.evaluate(source) === 0)
  }
}
