package io.github.slava0135.scalametrics
package metrics

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.io.Source

class NumberOfChildrenTest extends AnyFunSuite {

  def readSource(name: String): String = {
    Source.fromResource(s"metrics/NumberOfChildren/$name.scala").getLines().mkString("\n")
  }

  test("NumberOfChildren.evaluate.NoChildren") {
    val source = readSource("NoChildren")
    NumberOfChildren.evaluate(source) shouldBe 0
  }

  test("NumberOfChildren.evaluate.OneChild") {
    val source = readSource("OneChild")
    NumberOfChildren.evaluate(source) shouldBe 0.5 +- 0.001
  }

  test("NumberOfChildren.evaluate.ManyChildren") {
    val source = readSource("ManyChildren")
    NumberOfChildren.evaluate(source) shouldBe 3.0/4.0 +- 0.001
  }

  test("NumberOfChildren.evaluate.ManyChildrenManyClasses") {
    val source = readSource("ManyChildrenManyClasses")
    NumberOfChildren.evaluate(source) shouldBe 7.0/8.0 +- 0.001
  }
}
