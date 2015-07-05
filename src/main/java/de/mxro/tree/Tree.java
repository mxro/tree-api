package de.mxro.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Objects;

@SuppressWarnings("all")
public class Tree<T extends Object> implements Iterable<Tree<T>> {
  private T value;
  
  private List<Tree<T>> children;
  
  private Tree<T> parent;
  
  public Tree(final T data) {
    this.value = data;
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
  
  public boolean hasParent() {
    return (!Objects.equal(this.parent, null));
  }
  
  public T value() {
    return this.value;
  }
  
  public List<Tree<T>> children() {
    return this.children;
  }
  
  @Override
  public Iterator<Tree<T>> iterator() {
    return this.children.iterator();
  }
  
  @Override
  public String toString() {
    int _size = this.children.size();
    String _plus = ((("(" + this.value) + ", ") + Integer.valueOf(_size));
    return (_plus + ")");
  }
}
