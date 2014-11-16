package de.mxro.tree

import java.util.LinkedList
import java.util.List

class Tree<T> implements Iterable<Tree<T>> {

	T root;
	List<Tree<T>> children;
	Tree<T> parent;

	new(T data) {
		this.root = data;
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

	def root() {
		root
	}

	def children() {
		children
	}

	override iterator() {
		children.iterator
	}
	

}
