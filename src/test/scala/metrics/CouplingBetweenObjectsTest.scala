package io.github.slava0135.scalametrics
package metrics

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class CouplingBetweenObjectsTest extends AnyFunSuite {

  def readSource(name: String): String = {
    Source.fromResource(s"metrics/CouplingBetweenObjects/$name.scala").getLines().mkString("\n")
  }

  test("CouplingBetweenObjects.evaluate.OneClass") {
    val source = readSource("OneClass")
    assert(CouplingBetweenObjects.evaluate(source) === 0.0)
  }
}
