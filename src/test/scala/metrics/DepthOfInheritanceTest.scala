package io.github.slava0135.scalametrics
package metrics

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.io.Source

class DepthOfInheritanceTest extends AnyFunSuite {

  def readSource(name: String): String = {
    Source.fromResource(s"metrics/DepthOfInheritance/$name.scala").getLines().mkString("\n")
  }

  test("DepthOfInheritance.evaluate.NoParent") {
    val source = readSource("NoParent")
    DepthOfInheritance.evaluate(source) shouldEqual 1
  }

  test("DepthOfInheritance.evaluate.SomeParent") {
    val source = readSource("SomeParent")
    DepthOfInheritance.evaluate(source) shouldEqual 2
  }

  test("DepthOfInheritance.evaluate.ThreeClasses") {
    val source = readSource("ThreeClasses")
    DepthOfInheritance.evaluate(source) shouldEqual 6.0/3.0 +- 0.001
  }

  test("DepthOfInheritance.evaluate.ThreeClassesReversed") {
    val source = readSource("ThreeClassesReversed")
    DepthOfInheritance.evaluate(source) shouldEqual 6.0/3.0 +- 0.001
  }

  test("DepthOfInheritance.evaluate.WithTrait") {
    val source = readSource("WithTrait")
    DepthOfInheritance.evaluate(source) shouldEqual 6.0/3.0 +- 0.001
  }
}
