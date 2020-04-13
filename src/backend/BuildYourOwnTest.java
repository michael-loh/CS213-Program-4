/**
 * 
 */
package backend;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Varun Vasudevan
 *
 */
public class BuildYourOwnTest {

	/**
	 * Test method for {@link backend.BuildYourOwn#pizzaPrice()}.
	 */
	@Test
	public void testPizzaPrice() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("Chicken");
		a.add("Ham");
		a.add("Mushroom");
		Pizza s = new BuildYourOwn("BuildYourOwn","Small",a);
		assertEquals(11,s.pizzaPrice());
		Pizza m = new BuildYourOwn("BuildYourOwn","Medium",a);
		assertEquals(13,m.pizzaPrice());
		Pizza l = new BuildYourOwn("BuildYourOwn","Large",a);
		assertEquals(15,l.pizzaPrice());
		a.add("Green Pepper");
		a.add("Pepperoni");
		Pizza s2 = new BuildYourOwn("BuildYourOwn","Small",a);
		assertEquals(15,s2.pizzaPrice());
		ArrayList<String> b = new ArrayList<String>();
		b.add("Chicken");
		Pizza s3 = new BuildYourOwn("BuildYourOwn","Small",b);
		assertEquals(7,s3.pizzaPrice());
		//fail("Not yet implemented");
	}

}
