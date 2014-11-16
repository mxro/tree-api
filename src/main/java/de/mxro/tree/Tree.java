package de.mxro.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class Tree<T extends Object> implements Iterable<Tree<T>> {
  private T root;
  
  private List<Tree<T>> children;
  
  private Tree<T> parent;
  
  public Tree(final T data) {
    this.root = data;
    LinkedList<Tree<T>> _linkedList = new LinkedList<Tree<T>>();
    this.children = _linkedList;
  }
  
  public Tree<T> add(final Tree<T> childNode) {
    childNode.parent = this;
    this.children.add(childNode);
    return childNode;
  }
  
  public Tree<T> parent() {
    return this.parent;
  }
  
  public T root() {
    return this.root;
  }
  
  public List<Tree<T>> children() {
    return this.children;
  }
  
  public Iterator<Tree<T>> iterator() {
    return this.children.iterator();
  }
}
