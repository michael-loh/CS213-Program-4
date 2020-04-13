package backend;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Varun Vasudevan and Michael Loh
 *
 */
public class BuildYourOwnTest {

	/**
	 * Test method for {@link backend.BuildYourOwn#pizzaPrice()}.
	 */
	@Test
	public void testPizzaPrice() {
		//test price for pizza with different sizes
		ArrayList<String> a = new ArrayList<String>();
		a.add("Chicken");
		a.add("Ham");
		a.add("Mushroom");
		Pizza s1 = new BuildYourOwn("BuildYourOwn","Small",a);
		assertEquals(11,s1.pizzaPrice());
		Pizza s2 = new BuildYourOwn("BuildYourOwn","Medium",a);
		assertEquals(13,s2.pizzaPrice());
		Pizza s3 = new BuildYourOwn("BuildYourOwn","Large",a);
		assertEquals(15,s3.pizzaPrice());
		
		//test price for pizza with different number of toppings 
		ArrayList<String> b = new ArrayList<String>();
		b.add("Chicken");
		Pizza t1 = new BuildYourOwn("BuildYourOwn","Small",b);
		assertEquals(7, t1.pizzaPrice());
		b.add("Cheese");
		Pizza t2 = new BuildYourOwn("BuildYourOwn", "Small",b);
		assertEquals(9, t2.pizzaPrice());
		
		
	}

}