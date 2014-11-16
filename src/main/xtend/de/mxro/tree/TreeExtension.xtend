package de.mxro.tree

import java.util.List
import de.mxro.fn.Closure2

class TreeExtension {
	
	
	def <T> void traverse(Tree<T> tree, Closure2<T, T> operation) {

		for (node: tree) {
			
			traverse(node, operation)
			
			operation.apply(tree.root, node.root)
			
		}
		
	}
	
	def  <T> List<Tree<T>> toList(Tree<T> t) {
		val l = newArrayList
		for (node:t) {
			
			val cl = toList(node)
			
			l.addAll(cl)
			
		}
		l.add(t)
		l
	}
	
	
}