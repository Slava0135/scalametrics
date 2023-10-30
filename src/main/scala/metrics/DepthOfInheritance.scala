package io.github.slava0135.scalametrics
package metrics

import scala.meta.{Defn, Source, XtensionParseInputLike}

object DepthOfInheritance {
  def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    println(tree.structure)
    tree.traverse {
      case cls: Defn.Class =>
        return cls.templ.inits.length + 1
    }
    0
  }
}
