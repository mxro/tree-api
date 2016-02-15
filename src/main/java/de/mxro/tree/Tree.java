package de.mxro.tree;

import com.google.common.base.Objects;
import delight.functional.Closure;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

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
  
  /**
   * Removes by identity
   */
  public void remove(final Tree<T> childNode) {
    for (int i = (this.children.size() - 1); (i >= 0); i--) {
      {
        final Tree<T> child = this.children.get(i);
        if ((childNode == child)) {
          this.children.remove(i);
          return;
        }
      }
    }
    throw new RuntimeException(("Child not found in list: " + childNode));
  }
  
  public boolean hasParent() {
    return (!Objects.equal(this.parent, null));
  }
  
  public T value() {
    return this.value;
  }
  
  public T setValue(final T value) {
    return this.value = value;
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
  
  private static <T extends Object> void forEachNode(final Tree<T> tree, final Closure<Tree<T>> operation) {
    for (final Tree<T> node : tree) {
      {
        Tree.<T>forEachNode(node, operation);
        operation.apply(tree);
      }
    }
  }
  
  public void forEachNode(final Closure<Tree<T>> operation) {
    Tree.<T>forEachNode(this, operation);
  }
  
  public List<Tree<T>> toList() {
    return Tree.<T>toList(this);
  }
  
  private static <T extends Object> List<Tree<T>> toList(final Tree<T> t) {
    ArrayList<Tree<T>> _xblockexpression = null;
    {
      final ArrayList<Tree<T>> l = CollectionLiterals.<Tree<T>>newArrayList();
      for (final Tree<T> node : t) {
        {
          final List<Tree<T>> cl = Tree.<T>toList(node);
          l.addAll(cl);
        }
      }
      l.add(t);
      _xblockexpression = l;
    }
    return _xblockexpression;
  }
  
  public String render() {
    return Tree.<T>render("  ", this);
  }
  
  private static <T extends Object> String render(final String offset, final Tree<T> t) {
    String _xblockexpression = null;
    {
      T _value = t.value();
      String _string = _value.toString();
      String res = (_string + "\n");
      int _size = t.children.size();
      boolean _equals = (_size == 0);
      if (_equals) {
        return res;
      }
      boolean isFirst = true;
      for (final Tree<T> node : t) {
        {
          if (isFirst) {
            String _res = res;
            int _length = offset.length();
            int _minus = (_length - 1);
            String _substring = offset.substring(0, _minus);
            String _plus = (_substring + "\\");
            String _render = Tree.<T>render((offset + "  "), node);
            String _plus_1 = (_plus + _render);
            res = (_res + _plus_1);
          } else {
            String _res_1 = res;
            String _render_1 = Tree.<T>render((offset + "  "), node);
            String _plus_2 = (offset + _render_1);
            res = (_res_1 + _plus_2);
          }
          isFirst = false;
        }
      }
      _xblockexpression = res;
    }
    return _xblockexpression;
  }
}
