package backend;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza{
	
	private final int SMALL = 5;

	public BuildYourOwn(String style, String size, ArrayList<String> toppings) {
		super(style,size,toppings);

	}
	public int pizzaPrice() {
		return getCost();
	}
	public String toString() {
		
		return "Build Your Own Pizza " + size + " " + toppingsToString() + " Price:$"+ pizzaPrice();
	}
	private String toppingsToString() {
		String s = "";
		for(int i=0; i<toppings.size();i++) {
			s+= toppings.get(i)+ ", ";
		}
		return s;
	}
	
	private int getCost() {
		if (size.equals("small")) {
			return SMALL + (2 * toppings.size());
		}
		else if (size.equals("medium")) {
			return SMALL +2 + (2 * toppings.size());
		}
		else {
			return SMALL +4 + (2 * toppings.size());
		}
	}
}