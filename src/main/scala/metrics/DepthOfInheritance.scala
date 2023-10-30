package io.github.slava0135.scalametrics
package metrics

import scala.collection.mutable
import scala.meta.{Defn, Source, Type, XtensionParseInputLike}

object DepthOfInheritance {
  def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    var classCount = 0
    val classParent = new mutable.HashMap[String, Option[String]]
    tree.traverse {
      case cls: Defn.Class =>
        classCount += 1
        val parents = cls.templ.inits
        if (parents.isEmpty) {
          classParent.put(cls.name.value, Option.empty)
        } else {
          parents.head.traverse {
            case name: Type.Name =>
              classParent.put(cls.name.value, Option.apply(name.value))
          }
        }
    }
    val classDepth = new mutable.HashMap[String, Int]
    val updateQueue = new mutable.Queue[String]
    updateQueue.addAll(classParent.keys)
    while (updateQueue.nonEmpty) {
      val next = updateQueue.dequeue()
      classParent.get(next) match {
        case Some(None) =>
          classDepth.put(next, 1)
        case Some(Some(parent)) if !classParent.contains(parent) =>
          classDepth.put(next, 2)
        case Some(Some(parent)) if !classDepth.contains(parent) =>
          updateQueue.enqueue(next)
        case Some(Some(parent)) =>
          classDepth.put(next, classDepth(parent) + 1)
      }
    }
    val depthSum = classDepth.values.sum
    depthSum.toDouble / classCount.toDouble
  }
}
