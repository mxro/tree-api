package de.mxro.tree

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

	def hasParent() {
		parent != null
	}

	def value() {
		value
	}

	def children() {
		children
	}

	override iterator() {
		children.iterator
	}
	
	override toString() {
		return "("+value+", "+children.size()+")"
	}
	

}
