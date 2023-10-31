package io.github.slava0135.scalametrics
package metrics

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
}
