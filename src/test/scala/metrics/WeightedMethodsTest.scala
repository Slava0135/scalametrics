package io.github.slava0135.scalametrics
package metrics

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class WeightedMethodsTest extends AnyFunSuite {

  def readSource(name: String): String = {
    Source.fromResource(s"metrics/WeightedMethods/$name.scala").getLines().mkString("\n")
  }

  test("WeightedMethods.evaluate.NoMethods") {
    val source = readSource("NoMethods")
    assert(WeightedMethods.evaluate(source) === 0.0)
  }

  test("WeightedMethods.evaluate.OneMethod") {
    val source = readSource("OneMethod")
    assert(WeightedMethods.evaluate(source) === 1.0)
  }

  test("WeightedMethods.evaluate.TwoClasses") {
    val source = readSource("TwoClasses")
    assert(WeightedMethods.evaluate(source) === 1.0)
  }
}
