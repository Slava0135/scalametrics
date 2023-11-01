package io.github.slava0135.scalametrics

import metrics._

import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      System.err.println("expecting exactly 1 argument (filename)")
      sys.exit(1)
    }
    val source = Source.fromFile(args.apply(0))
    val code = try {
      source.mkString
    } finally {
      source.close()
    }
    val metrics = Array(WeightedMethods, DepthOfInheritance, NumberOfChildren, CouplingBetweenObjects, LackOfCohesion, AverageNumberOfArguments)
    println("-- code metrics --")
    metrics.foreach { it =>
      println("%s : %.3f (avg)".format(it.name().padTo(5, " ").mkString, it.evaluate(code)))
    }
  }
}
