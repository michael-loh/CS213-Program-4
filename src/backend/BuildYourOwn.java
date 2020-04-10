package backend;

import java.util.ArrayList;

/**
 * This class is the pizza subclass for a build your own pizza
 * @author Michael Loh and Varun Vasudevan
 *
 */
public class BuildYourOwn extends Pizza{
	
	private final int TOPPINGPRICE = 2;
	private final int SMALL = 5;
	private final int MEDIUM = 7;
	private final int LARGE = 9;

	public BuildYourOwn(String style, String size, ArrayList<String> toppings) {
		super(style,size,toppings);

	}
	public int pizzaPrice() {
		return getCost();
	}
	public String toString() {
		
		return super.toString() + ", Toppings: " + toppings.toString();
	}
	private String toppingsToString() {
		String s = "";
		for(int i=0; i<toppings.size();i++) {
			s+= toppings.get(i)+ ", ";
		}
		return s;
	}
	
	private int getCost() {
		if (size.equals("Small")) {
			return SMALL + (TOPPINGPRICE * toppings.size());
		}
		else if (size.equals("Medium")) {
			return MEDIUM + (TOPPINGPRICE * toppings.size());
		}
		else {
			return LARGE + (TOPPINGPRICE * toppings.size());
		}
	}
}