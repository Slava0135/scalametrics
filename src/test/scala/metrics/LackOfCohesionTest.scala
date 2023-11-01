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
    NormLackOfCohesion.evaluate(source) shouldEqual 0
  }

  test("LackOfCohesion.evaluate.TwoMethodsTwoVars") {
    val source = readSource("TwoMethodsTwoVars")
    LackOfCohesion.evaluate(source) shouldEqual 1
    NormLackOfCohesion.evaluate(source) shouldEqual 0
  }

  test("LackOfCohesion.evaluate.TwoMethodsOneVar") {
    val source = readSource("TwoMethodsOneVar")
    LackOfCohesion.evaluate(source) shouldEqual 0
    NormLackOfCohesion.evaluate(source) shouldEqual 1
  }

  test("LackOfCohesion.evaluate.ManyMethodsManyVars") {
    val source = readSource("ManyMethodsManyVars")
    LackOfCohesion.evaluate(source) shouldEqual 1
    NormLackOfCohesion.evaluate(source) shouldEqual 0.333 +- 0.001
  }

  test("LackOfCohesion.evaluate.ManyClasses") {
    val source = readSource("ManyClasses")
    LackOfCohesion.evaluate(source) shouldEqual 0.5 +- 0.001
    NormLackOfCohesion.evaluate(source) shouldEqual 0.5 +- 0.001
  }

  test("LackOfCohesion.evaluate.LocalVars") {
    val source = readSource("LocalVars")
    LackOfCohesion.evaluate(source) shouldEqual 1
    NormLackOfCohesion.evaluate(source) shouldEqual 0
  }

  test("LackOfCohesion.evaluate.VarAndVal") {
    val source = readSource("VarAndVal")
    LackOfCohesion.evaluate(source) shouldEqual 0
    NormLackOfCohesion.evaluate(source) shouldEqual 1
  }
}
