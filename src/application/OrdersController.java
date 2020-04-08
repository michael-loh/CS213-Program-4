package application;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OrdersController {

	public Button back;
	
	public void initialize() {
		System.out.println("init");
	}
	
	public void goBack() {
		Stage stage = (Stage) back.getScene().getWindow();
		
		stage.close();
	}
	
}
