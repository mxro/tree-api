package de.mxro.tree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class TreeExtension {
  public <T extends Object, R extends Object> void forEachNode(final Tree<T> tree, final /* Closure<Tree<T>> */Object operation) {
    throw new Error("Unresolved compilation problems:"
      + "\napply cannot be resolved");
  }
  
  public <T extends Object> List<Tree<T>> toList(final Tree<T> t) {
    ArrayList<Tree<T>> _xblockexpression = null;
    {
      final ArrayList<Tree<T>> l = CollectionLiterals.<Tree<T>>newArrayList();
      for (final Tree<T> node : t) {
        {
          final List<Tree<T>> cl = this.<T>toList(node);
          l.addAll(cl);
        }
      }
      l.add(t);
      _xblockexpression = l;
    }
    return _xblockexpression;
  }
}
