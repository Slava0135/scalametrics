package io.github.slava0135.scalametrics
package metrics

import scala.collection.mutable
import scala.meta.{Defn, Source, Type, XtensionParseInputLike}

object DepthOfInheritance {
  def evaluate(source: String): Double = {
    val tree = source.parse[Source].get
    println(tree.structure)
    var classCount = 0
    var depthSum = 0
    val classDepth = new mutable.HashMap[String, Int]
    tree.traverse {
      case cls: Defn.Class =>
        classCount += 1
        val parents = cls.templ.inits
        var depth = 0
        if (parents.isEmpty) {
          depth = 1
        } else {
          parents.foreach { elem =>
            elem.traverse {
              case name: Type.Name =>
                depth += classDepth.getOrElse(name.value, 1) + 1
            }
          }
        }
        depthSum += depth
        classDepth.put(cls.name.value, depth)
    }
    depthSum.toDouble / classCount.toDouble
  }
}
