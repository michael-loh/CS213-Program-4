package backend;
import java.util.ArrayList;

/**
 * This is the superclass for all the pizza types
 * @author Michael Loh and Varun Vasdevan
 *
 */
public abstract class Pizza {
	protected String style;
	protected String size;
	protected ArrayList<String> toppings;
	public Pizza(String style, String size, ArrayList<String> toppings) {
		this.style= style;
		this.size= size;
		this.toppings= toppings;
	}
	public Pizza(String style, String size) {
		this.style= style;
		this.size= size;
	}
	public abstract int pizzaPrice();
	public  String toString() {
		return size + " " + style + " Pizza";
	};
}