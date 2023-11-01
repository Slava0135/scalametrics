package io.github.slava0135.scalametrics
package metrics

import scala.collection.mutable
import scala.meta.{Defn, Pat, Source, Term, XtensionParseInputLike}

object LackOfCohesion {
  def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    var classCount = 0
    var totalScore = 0
    tree.traverse {
      case cls: Defn.Class =>
        classCount += 1
        val vars = new mutable.HashSet[String]
        val varSets = new mutable.ArrayBuffer[mutable.HashSet[String]]
        for (member <- cls.children.last.children) {
          def addVars(pats: List[Pat]): Unit = {
            for (pat <- pats) {
              pat match {
                case varPat: Pat.Var =>
                  vars += varPat.name.value
                case _ =>
              }
            }
          }
          member match {
            case defVal: Defn.Val =>
              addVars(defVal.pats)
            case defVar: Defn.Var =>
              addVars(defVar.pats)
            case _ =>
          }
        }
        cls.traverse {
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
          for (set2 <- varSets.drop(i + 1)) {
            if (set1.intersect(set2).isEmpty) {
              empty += 1
            } else {
              nonEmpty += 1
            }
          }
        }
        totalScore += Math.max(0, empty - nonEmpty)
    }
    totalScore.toDouble / classCount.toDouble
  }
}
