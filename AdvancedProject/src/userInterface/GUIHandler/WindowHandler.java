package userInterface.GUIHandler;

import javafx.stage.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.*;

/**
 * @author Manuel Gallina
 */

public class WindowHandler 
{
	
	private static final String WINDOW_TITLE = "Laparoscopy";
	private static final double WINDOW_RESOLUTION_WIDTH = 800;
	private static final double WINDOW_RESOLUTION_HEIGHT = 800;
	
		
	public WindowHandler(Stage stage)
	{	
		stage.setTitle(WINDOW_TITLE);
		
		BorderPane window = new BorderPane();
		
		GridPane grid = new GridPane();		
		HBox hbox = new HBox();
		Text message = new Text("Prova");
		
		grid.add(message, 0, 0);
		
		hbox.setPadding(new Insets(10, 10, 10, 10));
		hbox.setSpacing(10);
		
		grid.getChildren().add(hbox);
		
		window.setCenter(grid);
		
		Scene scene = new Scene(window, WINDOW_RESOLUTION_WIDTH, WINDOW_RESOLUTION_HEIGHT);
		stage.setScene(scene);
		stage.show();

	}
	
}
