package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

import backend.BuildYourOwn;
import backend.Deluxe;
import backend.Hawaiian;
import backend.Pizza;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The controller class for the Pizza Store UI.
 * @author Michael Loh and Varun Vasudevan
 *
 */
public class PizzaStoreController {
	
	public ComboBox<String> pizza;
	public ComboBox<String> size;
	
	public ImageView image;
	
	public ListView<String> toppings;
	public ListView<String> selectedToppings;
	
	public Button addTopping;
	public Button removeTopping;
	public Button clearSelection;
	public Button addToOrder;
	
	public AnchorPane toppingPane;
	
	public TextArea textArea;
	
	static ArrayList<Pizza> pizzas;
	
	private Stage newStage;
	
	private String[] pizzaTypes = {"Build Your Own", "Deluxe", "Hawaiian"};
	private String[] sizes = {"Small", "Medium", "Large"};
	
	private Hashtable<String, Integer> pizzaHt = new Hashtable<>();
	
	private String[] toppingTypes = {"Beef", "Cheese", "Green Pepper", "Ham", 
			"Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage"};
	
	private Image byo;
	private Image deluxe;
	private Image hawaiian;
	
	private final int BUILDYOUROWN = 1;
	private final int DELUXE = 2;
	private final int HAWAIIAN = 3;
	
	/**
	 * This method loads in the images, sets up the combo boxes, and initializes a Pizza List
	 */
	public void initialize() {
		File f1 = new File("src/images/BYO.jpg");
		File f2 = new File("src/images/Deluxe.jpg");
		File f3 = new File("src/images/Hawaiian.jpg");
		
		byo = new Image(f1.toURI().toString());
		deluxe = new Image(f2.toURI().toString());
		hawaiian = new Image(f3.toURI().toString());
		
		pizza.setItems(FXCollections.observableArrayList(pizzaTypes));
		
		size.setItems(FXCollections.observableArrayList(sizes));
		
		toppings.setItems(FXCollections.observableArrayList(toppingTypes));
		
		resetUI();
		
		pizzaHt.put("Build Your Own", BUILDYOUROWN);
		pizzaHt.put("Deluxe", DELUXE);
		pizzaHt.put("Hawaiian", HAWAIIAN);
		
		pizzas = new ArrayList<>();
		
	}
	
	/**
	 * This method moves a topping from the toppings ListView to the selectedToppings ListView
	 */
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
	
	/**
	 * This method removes a topping from the selectedToppings ListView and moves it to the toppings ListView
	 */
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
	
	/**
	 * This method resets the two ListViews
	 */
	public void clearSelection() {
		String[] emptyList = {};
		selectedToppings.setItems(FXCollections.observableArrayList(emptyList));
		toppings.setItems(FXCollections.observableArrayList(toppingTypes));
	}
	
	/**
	 * This method disables toppings when BuildYourOwn pizza is not selected, and it displays the correct image of a pizza
	 */
	public void selectPizza() {
		disableToppings();
		showImage();
	}
	
	/**
	 * This method disables the selection of toppings
	 */
	private void disableToppings() {
		String pizzaType = pizza.getSelectionModel().getSelectedItem(); 
		
		if(pizzaHt.get(pizzaType) != BUILDYOUROWN) {
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
	
	/**
	 * This method shows an image corresponding to its pizza.
	 */
	private void showImage() {
		String pizzaType = pizza.getSelectionModel().getSelectedItem();
		
		switch(pizzaHt.get(pizzaType)) {
			case BUILDYOUROWN:
				image.setImage(byo);
				break;
			case DELUXE:
				image.setImage(deluxe);
				break;
			case HAWAIIAN:
				image.setImage(hawaiian);
				break;
		}
	}
	
	/**
	 * This method opens a new scene that displays the pizzas in the current pizza list.
	 */
	public void showOrder() {
		if(newStage != null && newStage.isShowing()) {
			newStage.toFront();
			return;
		}
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Orders.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			newStage = new Stage();
			newStage.setScene(scene);
			newStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This button adds a pizza to the pizza list.
	 */
	public void addToOrder() {
		if(newStage != null && newStage.isShowing()) {
			textArea.appendText("Cannot add: Cannot add order when \"Show Order\" is open\n");
			return;
		}
		
		String pizzaType = pizza.getSelectionModel().getSelectedItem();
		String pizzaSize = size.getSelectionModel().getSelectedItem();
		
		Pizza p = null;
		
		switch(pizzaHt.get(pizzaType)) {
			case BUILDYOUROWN:
				if(selectedToppings.getItems().size() < 1) {
					textArea.appendText("Cannot add: Must have at least 1 topping\n");
					return;
				}
				if(selectedToppings.getItems().size() > 6) {
					textArea.appendText("Cannot add: Cannot have more than 6 toppings\n");
					return;
				}
				ArrayList<String> toppings = new ArrayList<>(selectedToppings.getItems());
				p = new BuildYourOwn(pizzaType, pizzaSize, toppings);
				break;
			case DELUXE:
				p = new Deluxe(pizzaType, pizzaSize);
				break;
			case HAWAIIAN:
				p = new Hawaiian(pizzaType, pizzaSize);
				break;
		}
		
		pizzas.add(p);
		
		textArea.appendText(p.toString() + " has been added to your order\n");
		
		resetUI();
		
	}
	
	/**
	 * This method resets the UI to its initial state
	 */
	private void resetUI() {
		pizza.getSelectionModel().select(0);
		size.getSelectionModel().select(0);
		clearSelection();
		
		image.setImage(byo);
	}
	
}
