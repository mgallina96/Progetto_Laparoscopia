package userInterface.GUIHandler;

import javafx.stage.*;

import java.util.Vector;

import content.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private static final double WINDOW_RESOLUTION_WIDTH = 1280;
	private static final double WINDOW_RESOLUTION_HEIGHT = 768;
	private static final String PATIENT_INFO_TITLE = "Informazioni del Paziente\n";
	
	private ObservableList<String> toolList = FXCollections.observableArrayList("Bisturi", "Pinza", "Aspiratore");
	
		
	public WindowHandler(Stage stage, Patient patient)
	{	
		stage.setTitle(WINDOW_TITLE);
		
		BorderPane mainWindow = new BorderPane();
		mainWindow.setId("main-window");
		
		VBox lateralWindow = new VBox();
		lateralWindow.setId("lateral-window");
		
			lateralWindow.getChildren().add(new Text(PATIENT_INFO_TITLE));
		
			HBox patientInfo = new HBox();
			patientInfo.setId("patient-info");
			
				VBox labels = new VBox();
				labels.setId("info-labels");
				
					labels.getChildren().add(new Label("Età"));
					labels.getChildren().add(new Label("Altezza"));
					labels.getChildren().add(new Label("Peso"));
					
				VBox data = new VBox();
				labels.setId("info-data");
				
					data.getChildren().add(new Text("65"));
					data.getChildren().add(new Text("1.70m"));
					data.getChildren().add(new Text("65Kg"));
		
			patientInfo.getChildren().addAll(labels, data);
			
			ChoiceBox toolSelector = new ChoiceBox();
			toolSelector.setItems(toolList);
		
		lateralWindow.getChildren().addAll(patientInfo, toolSelector);
		
		mainWindow.setRight(lateralWindow);
		
		Scene scene = new Scene(mainWindow, WINDOW_RESOLUTION_WIDTH, WINDOW_RESOLUTION_HEIGHT);
		
		scene.getStylesheets().add(WindowHandler.class.getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

	}
	
}
