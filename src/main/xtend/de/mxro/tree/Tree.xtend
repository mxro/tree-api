package de.mxro.tree

import delight.functional.Closure
import java.util.LinkedList
import java.util.List

class Tree<T> implements Iterable<Tree<T>> {

	T value;
	List<Tree<T>> children;
	Tree<T> parent;

	new(T data) {
		this.value = data;
		this.children = new LinkedList<Tree<T>>();
	}

	def Tree<T> add(Tree<T> childNode) {
		childNode.parent = this
		this.children.add(childNode)
		return childNode;
	}

	def parent() {
		parent
	}

	/**
	 * Removes by identity
	 */
	def void remove(Tree<T> childNode) {
		for (var i=children.size -1;i>=0;i--) {
			val child = this.children.get(i)
			if (childNode === child) {
				this.children.remove(i)
				return
			}
		}
		throw new RuntimeException('Child not found in list: '+childNode)
	}

	def hasParent() {
		parent != null
	}

	def value() {
		value
	}

	def setValue(T value) {
		this.value = value
	}

	def children() {
		children
	}

	override iterator() {
		children.iterator
	}

	override toString() {
		return "(" + value + ", " + children.size() + ")"
	}

	def static private <T> void forEachNode(Tree<T> tree, Closure<Tree<T>> operation) {

		for (node : tree) {

			forEachNode(node, operation)

			operation.apply(tree)

		}

	}

	def void forEachNode(Closure<Tree<T>> operation) {
		forEachNode(this, operation)
	}

	def List<Tree<T>> toList() {
		toList(this)
	}

	def static private <T> List<Tree<T>> toList(Tree<T> t) {
		val l = newArrayList
		for (node : t) {

			val cl = toList(node)

			l.addAll(cl)

		}
		l.add(t)
		l
	}
	
	def String render() {
		render("  ", this)
	}
	
	def static private <T> String render(String offset, Tree<T> t) {
		var String res = t.value().toString+"\n"
		
		if (t.children.size == 0) {
			return res
		}
		
		var boolean isFirst = true
		
		for (node : t) {
			if (isFirst) {
				res += offset.substring(0, offset.length-1)+"\\"+render(offset+"  ", node)
			} else {
				res += offset+render(offset+"  ", node)
			}
			isFirst = false
		}
		res
	}
	

}
