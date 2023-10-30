package io.github.slava0135.scalametrics
package metrics

import org.scalatest.funsuite.AnyFunSuite

class WeightedMethodsTest extends AnyFunSuite {
  test("WeightedMethods.cube") {
    assert(WeightedMethods.cube(3) === 27)
  }
}
