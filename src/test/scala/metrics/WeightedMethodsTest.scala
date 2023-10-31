package io.github.slava0135.scalametrics
package metrics

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.io.Source

class WeightedMethodsTest extends AnyFunSuite {

  def readSource(name: String): String = {
    Source.fromResource(s"metrics/WeightedMethods/$name.scala").getLines().mkString("\n")
  }

  test("WeightedMethods.evaluate.NoMethods") {
    val source = readSource("NoMethods")
    WeightedMethods.evaluate(source) shouldBe 0
  }

  test("WeightedMethods.evaluate.OneMethod") {
    val source = readSource("OneMethod")
    WeightedMethods.evaluate(source) shouldBe 1
  }

  test("WeightedMethods.evaluate.TwoClasses") {
    val source = readSource("TwoClasses")
    WeightedMethods.evaluate(source) shouldBe 1
  }

  test("WeightedMethods.evaluate.ManyMethodsManyClasses") {
    val source = readSource("ManyMethodsManyClasses")
    WeightedMethods.evaluate(source) shouldBe 6.0/4.0 +- 0.001
  }
}
