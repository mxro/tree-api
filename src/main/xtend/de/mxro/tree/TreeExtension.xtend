package de.mxro.tree

import de.mxro.fn.Closure
import java.util.List

class TreeExtension {

	def <T, R> void forEachNode(Tree<T> tree, Closure<Tree<T>> operation) {

		for (node : tree) {

			forEachNode(node, operation)

			operation.apply(tree)

		}

	}

	def <T> List<Tree<T>> toList(Tree<T> t) {
		val l = newArrayList
		for (node : t) {

			val cl = toList(node)

			l.addAll(cl)

		}
		l.add(t)
		l
	}

}
