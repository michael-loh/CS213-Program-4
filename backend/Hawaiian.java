package backend;


public class Hawaiian extends Pizza{
	
	private final int SMALL = 8;

	public Hawaiian(String style, String size) {
		super(style,size);

	}
	public int pizzaPrice() {
		return getCostFromSize(size);
	}
	public String toString() {
		return "Hawaiian pizza " + size +" Toppings: Ham, Pineapple  Price:$"+ pizzaPrice();
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