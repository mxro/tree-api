package delight.tree.tests

import de.mxro.tree.Tree
import org.junit.Assert
import org.junit.Test

class TestTreeRendering {
	
	@Test
	def void test() {
		
		val t = new Tree<String>("root")
		
		val child1 = new Tree<String>("child1")
		t.add(child1)
		
		val child2 = new Tree<String>("child2")
		t.add(child2)
		child2.add(new Tree<String>("subchild"))
		
		val child3 = new Tree<String>("child3")
		t.add(child3)
		
		Assert.assertTrue(t.render != null)
		
		
	}
	
}