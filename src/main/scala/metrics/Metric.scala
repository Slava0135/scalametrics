package io.github.slava0135.scalametrics
package metrics

trait Metric {
  def name(): String
  def evaluate(source: String): Double
}
