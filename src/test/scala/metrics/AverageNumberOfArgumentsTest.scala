package io.github.slava0135.scalametrics
package metrics

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
}
