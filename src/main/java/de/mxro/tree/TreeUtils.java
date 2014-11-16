package de.mxro.tree;

import de.mxro.tree.Tree;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class TreeUtils {
  private static <T extends Object> void traverse(final Tree<T> tree, final /* Closure2<T, T> */Object operation) {
    throw new Error("Unresolved compilation problems:"
      + "\napply cannot be resolved");
  }
  
  private static <T extends Object> /* List<Tree<T>> */Object toList(final Tree<T> t) {
    ArrayList<T> _xblockexpression = null;
    {
      final ArrayList<T> l = CollectionLiterals.<T>newArrayList();
      for (final Tree<T> node : t) {
        {
          final List cl = TreeUtils.<T>toList(node);
          l.addAll(cl);
        }
      }
      T _root = t.root();
      l.add(_root);
      _xblockexpression = l;
    }
    return _xblockexpression;
  }
}
