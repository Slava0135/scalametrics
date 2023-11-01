package io.github.slava0135.scalametrics
package metrics

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.io.Source

class LackOfCohesionTest extends AnyFunSuite {

  def readSource(name: String): String = {
    Source.fromResource(s"metrics/LackOfCohesion/$name.scala").getLines().mkString("\n")
  }

  test("LackOfCohesion.evaluate.Empty") {
    val source = readSource("Empty")
    LackOfCohesion.evaluate(source) shouldEqual 0
  }

  test("LackOfCohesion.evaluate.TwoMethodsTwoVars") {
    val source = readSource("TwoMethodsTwoVars")
    LackOfCohesion.evaluate(source) shouldEqual 1
  }

  test("LackOfCohesion.evaluate.TwoMethodsOneVar") {
    val source = readSource("TwoMethodsOneVar")
    LackOfCohesion.evaluate(source) shouldEqual 0
  }

  test("LackOfCohesion.evaluate.ManyMethodsManyVars") {
    val source = readSource("ManyMethodsManyVars")
    LackOfCohesion.evaluate(source) shouldEqual 1
  }

  test("LackOfCohesion.evaluate.ManyClasses") {
    val source = readSource("ManyClasses")
    LackOfCohesion.evaluate(source) shouldEqual 0.5 +- 0.001
  }
}
