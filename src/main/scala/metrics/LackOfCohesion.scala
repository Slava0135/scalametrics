package io.github.slava0135.scalametrics
package metrics

import scala.collection.mutable
import scala.meta.{Defn, Pat, Source, Term, XtensionParseInputLike}

object LackOfCohesion {
  def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    println(tree.structure)
    val vars = new mutable.HashSet[String]
    val varSets = new mutable.ArrayBuffer[mutable.HashSet[String]]
    tree.traverse {
      case v: Pat.Var =>
        vars += v.name.value
    }
    tree.traverse {
      case m: Defn.Def =>
        val uses = new mutable.HashSet[String]
        m.traverse {
          case v: Term.Name if vars.contains(v.value) =>
            uses += v.value
        }
        varSets += uses
    }
    var empty = 0
    var nonEmpty = 0
    for (i <- 0 until varSets.length - 1) {
      val set1 = varSets.apply(i)
      for (set2 <- varSets.drop(i+1)) {
        if (set1.intersect(set2).isEmpty) {
          empty += 1
        } else {
          nonEmpty += 1
        }
      }
    }
    Math.max(0, empty - nonEmpty)
  }
}
