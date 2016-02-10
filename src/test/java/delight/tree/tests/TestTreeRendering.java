package delight.tree.tests;

import com.google.common.base.Objects;
import de.mxro.tree.Tree;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestTreeRendering {
  @Test
  public void test() {
    final Tree<String> t = new Tree<String>("root");
    final Tree<String> child1 = new Tree<String>("child1");
    t.add(child1);
    final Tree<String> child2 = new Tree<String>("child2");
    t.add(child2);
    Tree<String> _tree = new Tree<String>("subchild");
    child2.add(_tree);
    final Tree<String> child3 = new Tree<String>("child3");
    t.add(child3);
    String _render = t.render();
    boolean _notEquals = (!Objects.equal(_render, null));
    Assert.assertTrue(_notEquals);
  }
}
