package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PizzaStoreController {
	
	public ComboBox<String> pizza;
	public ComboBox<String> size;
	
	public ListView<String> toppings;
	public ListView<String> selectedToppings;
	
	public Button addTopping;
	public Button removeTopping;
	public Button clearSelection;
	
	public AnchorPane toppingPane;
	
	//protected ArrayList<Pizza> pizzas;
	
	private String[] pizzaTypes = {"Build Your Own", "Deluxe", "Hawaiian"};
	private String[] sizes = {"Small (10\")", "Medium (12\")", "Large (14\")"};
	
	private String[] toppingTypes = {"Beef", "Cheese", "Green Pepper", "Ham", 
			"Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage"};
	
	public void initialize() {
		pizza.setItems(FXCollections.observableArrayList(pizzaTypes));
		pizza.getSelectionModel().selectFirst();
		
		size.setItems(FXCollections.observableArrayList(sizes));
		size.getSelectionModel().selectFirst();
		
		toppings.setItems(FXCollections.observableArrayList(toppingTypes));
		
		//pizzas = new ArrayList<>();
	}
	
	public void addTopping() {
		String topping = (String) toppings.getSelectionModel().getSelectedItem();
		if(topping == null) {
			return;
		}
		
		toppings.getItems().remove(topping);
		
		selectedToppings.getItems().add(topping);
		selectedToppings.getItems().sort( (a,b) -> a.compareTo(b) );
		toppings.getSelectionModel().clearSelection();
	}
	
	public void removeTopping() {
		String topping = (String) selectedToppings.getSelectionModel().getSelectedItem();
		if(topping == null) {
			return;
		}
		
		selectedToppings.getItems().remove(topping);
		
		toppings.getItems().add(topping);
		toppings.getItems().sort( (a,b) -> a.compareTo(b) );
		selectedToppings.getSelectionModel().clearSelection();
	}
	
	public void clearSelection() {
		String[] emptyList = {};
		selectedToppings.setItems(FXCollections.observableArrayList(emptyList));
		toppings.setItems(FXCollections.observableArrayList(toppingTypes));
	}
	
	public void disableToppings() {
		if(!pizza.getSelectionModel().getSelectedItem().equals("Build Your Own")) {
			toppings.setDisable(true);
			selectedToppings.setDisable(true);
			addTopping.setDisable(true);
			removeTopping.setDisable(true);
			clearSelection.setDisable(true);
		}
		else {
			clearSelection();
			toppings.setDisable(false);
			selectedToppings.setDisable(false);
			addTopping.setDisable(false);
			removeTopping.setDisable(false);
			clearSelection.setDisable(false);
		}
	}
	
	public void showOrder() {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Orders.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			System.out.println(stage.isShowing());
			stage.close();
			System.out.println(stage.isShowing());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
