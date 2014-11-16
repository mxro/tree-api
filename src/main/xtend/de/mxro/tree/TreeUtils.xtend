package de.mxro.tree

class TreeUtils {
	
	def private static <T> void traverse(Tree<T> tree, Closure2<T, T> operation) {

		for (node: tree) {
			
			traverse(node, operation)
			
			operation.apply(tree.root, node.root)
			
		}
		
	}
	
	def private static <T> List<Tree<T>> toList(Tree<T> t) {
		val l = newArrayList
		for (node:t) {
			
			val cl = toList(node)
			
			l.addAll(cl)
			
		}
		l.add(t.root)
		l
	}
	
}