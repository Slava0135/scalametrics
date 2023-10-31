package io.github.slava0135.scalametrics
package metrics

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.io.Source

class CouplingBetweenObjectsTest extends AnyFunSuite {

  def readSource(name: String): String = {
    Source.fromResource(s"metrics/CouplingBetweenObjects/$name.scala").getLines().mkString("\n")
  }

  test("CouplingBetweenObjects.evaluate.OneClass") {
    val source = readSource("OneClass")
    CouplingBetweenObjects.evaluate(source) shouldEqual 0
  }

  test("CouplingBetweenObjects.evaluate.TwoClasses") {
    val source = readSource("TwoClasses")
    CouplingBetweenObjects.evaluate(source) shouldEqual 0.5 +- 0.001
  }
}
