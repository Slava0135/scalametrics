package io.github.slava0135.scalametrics
package metrics

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.io.Source

class AverageNumberOfArgumentsTest extends AnyFunSuite {

  def readSource(name: String): String = {
    Source.fromResource(s"metrics/AverageNumberOfArguments/$name.scala").getLines().mkString("\n")
  }

  test("AverageNumberOfArguments.evaluate.NoMethods") {
    val source = readSource("NoMethods")
    AverageNumberOfArguments.evaluate(source) shouldEqual 0
  }

  test("AverageNumberOfArguments.evaluate.OneMethodNoArgs") {
    val source = readSource("OneMethodNoArgs")
    AverageNumberOfArguments.evaluate(source) shouldEqual 0
  }

  test("AverageNumberOfArguments.evaluate.OneMethodManyArgs") {
    val source = readSource("OneMethodManyArgs")
    AverageNumberOfArguments.evaluate(source) shouldEqual 3
  }

  test("AverageNumberOfArguments.evaluate.TwoMethods") {
    val source = readSource("TwoMethods")
    AverageNumberOfArguments.evaluate(source) shouldEqual 1
  }

  test("AverageNumberOfArguments.evaluate.ManyClassesManyMethods") {
    val source = readSource("ManyClassesManyMethods")
    AverageNumberOfArguments.evaluate(source) shouldEqual 1.5
  }
}
