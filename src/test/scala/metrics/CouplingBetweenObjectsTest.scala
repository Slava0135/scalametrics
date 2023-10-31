package io.github.slava0135.scalametrics
package metrics

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.io.Source

class CouplingBetweenObjectsTest extends AnyFunSuite {

  def readSource(name: String): String = {
    Source.fromResource(s"metrics/CouplingBetweenObjects/$name.scala").getLines().mkString("\n")
  }

  test("CouplingBetweenObjects.evaluate.OneClass") {
    val source = readSource("OneClass")
    CouplingBetweenObjects.evaluate(source) shouldBe 0
  }
}
