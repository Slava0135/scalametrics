package io.github.slava0135.scalametrics
package metrics

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class NumberOfChildrenTest extends AnyFunSuite {

  def readSource(name: String): String = {
    Source.fromResource(s"metrics/NumberOfChildren/$name.scala").getLines().mkString("\n")
  }

  test("NumberOfChildren.evaluate.NoChildren") {
    val source = readSource("NoChildren")
    assert(NumberOfChildren.evaluate(source) === 0.0)
  }
}
