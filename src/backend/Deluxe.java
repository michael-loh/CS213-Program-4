package backend;

/**
 * This class is the pizza subclass for a deluxe pizza
 * @author Michael Loh and Varun Vasudevan
 *
 */
public class Deluxe extends Pizza{
	
	private final int SMALL = 14;
	private final int MEDIUM = 16;
	private final int LARGE = 18;
	
	public Deluxe(String style, String size) {
		super(style,size);

	}
	public int pizzaPrice() {
		return getCostFromSize(size);
	}
	public String toString() {
		return super.toString()+ ", Toppings: [Sausage, Pepperoni, Green Pepper, Onion, Mushroom]";
	}
	private int getCostFromSize(String size) {
		if (size.equals("Small")) {
			return SMALL;
		}
		else if (size.equals("Medium")) {
			return MEDIUM;
		}
		else {
			return LARGE;
		}
	}
}