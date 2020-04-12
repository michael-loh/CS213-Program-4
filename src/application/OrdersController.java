package application;

import java.util.Hashtable;

import backend.Pizza;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * The Controller class for the Orders Window
 * @author Michael Loh and Varun Vasudevan
 *
 */
public class OrdersController {

	public Button back;
	public Button remove;
	
	public ListView<String> pizzas;
	public ListView<Integer> prices;
	
	public Label totalPrice;
	
	private Hashtable<Integer, Pizza> pizzaTable;
	private int price;
	
	public void initialize() {
		
		loadPizzasAndPrices();
		
	}
	
	public void goBack() {
		Stage stage = (Stage) back.getScene().getWindow();
		stage.close();
	}
	
	public void removePizza() {
		int index = pizzas.getSelectionModel().getSelectedIndex();
		
		if(index == -1) {
			return;
		}
		
		PizzaStoreController.pizzas.remove(index);
		loadPizzasAndPrices();
	}
	
	private void loadPizzasAndPrices() {
		
		pizzas.getItems().clear();
		prices.getItems().clear();
		
		pizzaTable = new Hashtable<>();
		
		price = 0;
		for(int i = 0; i < PizzaStoreController.pizzas.size(); i++) {
			Pizza pizza = PizzaStoreController.pizzas.get(i);
			pizzaTable.put(i, pizza);
			pizzas.getItems().add(pizza.toString());
			prices.getItems().add(pizza.pizzaPrice());
			price += pizza.pizzaPrice();
		}
		updateTotalPrice();

	}
	
	private void updateTotalPrice() {
		totalPrice.setText("$" + price);
	}
	
}
