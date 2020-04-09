package backend;


public class Deluxe extends Pizza{
	
	private final int SMALL = 14;
	
	public Deluxe(String style, String size) {
		super(style,size);

	}
	public int pizzaPrice() {
		return getCostFromSize(size);
	}
	public String toString() {
		return "Deluxe pizza " + size +" Toppings: Sausage, Pepperoni, Green Pepper, Onion, Mushroom  Price:$"+ pizzaPrice();
	}
	private int getCostFromSize(String size) {
		if (size.equals("small")) {
			return SMALL;
		}
		else if (size.equals("medium")) {
			return SMALL +2;
		}
		else {
			return SMALL +4;
		}
	}
}