package backend;

/**
 * This is the pizza subclass for a hawaiian pizza
 * @author Michael Loh and Varun Vasudevan
 *
 */
public class Hawaiian extends Pizza{
	
	private final int SMALL = 8;
	private final int MEDIUM = 10;
	private final int LARGE = 12;

	/**
	 * This is the constructor
	 * @param style specifies the pizza type
	 * @param size specifies the size of the pizza
	 */
	public Hawaiian(String style, String size) {
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
		return super.toString() +", Toppings: [Ham, Pineapple]";
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