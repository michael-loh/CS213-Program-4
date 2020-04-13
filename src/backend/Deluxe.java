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
	
	/**
	 * This is the constructor
	 * @param style specifies the pizza type
	 * @param size specifies the size of the pizza
	 */
	public Deluxe(String style, String size) {
		super(style,size);

	}
	
	/**
	 * This method calls getCost() to get the price of the pizza
	 */
	public int pizzaPrice() {
		return getCostFromSize(size);
	}
	
	/**
	 * This returns the object with its fields as a string
	 */
	public String toString() {
		return super.toString()+ ", Toppings: [Sausage, Pepperoni, Green Pepper, Onion, Mushroom]";
	}
	
	/**
	 * This method calculates the cost of the pizza.
	 * @return an int value specifying the cost.
	 */
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