package io.github.slava0135.scalametrics
package metrics

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class DepthOfInheritanceTest extends AnyFunSuite {

  def readSource(name: String): String = {
    Source.fromResource(s"metrics/DepthOfInheritance/$name.scala").getLines().mkString("\n")
  }

  test("DepthOfInheritance.evaluate.NoParent") {
    val source = readSource("NoParent")
    assert(DepthOfInheritance.evaluate(source) === 1.0)
  }

  test("DepthOfInheritance.evaluate.SomeParent") {
    val source = readSource("SomeParent")
    assert(DepthOfInheritance.evaluate(source) === 2.0)
  }
}
