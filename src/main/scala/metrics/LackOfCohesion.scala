package io.github.slava0135.scalametrics
package metrics

import scala.collection.mutable
import scala.meta.{Pat, Source, XtensionParseInputLike}

object LackOfCohesion {
  def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    println(tree.structure)
    val vars = new mutable.ArrayBuffer[String]
    tree.traverse {
      case v: Pat.Var =>
        vars += v.name.value
    }
    vars.length
  }
}
