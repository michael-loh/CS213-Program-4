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

	public Hawaiian(String style, String size) {
		super(style,size);

	}
	public int pizzaPrice() {
		return getCostFromSize(size);
	}
	public String toString() {
		return super.toString() +", Toppings: [Ham, Pineapple]";
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