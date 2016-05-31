package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import userInterface.graphic3DHandler.Transform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application 
{
	private static final String WINDOW_TITLE = "Laparoscopy";

	private static final double WINDOW_RESOLUTION_WIDTH = 400;

	private static final double WINDOW_RESOLUTION_HEIGHT = 400;

	private Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init()
	{
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		try 
		{			
			window = primaryStage;
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, WINDOW_RESOLUTION_WIDTH, WINDOW_RESOLUTION_HEIGHT);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Transform anchor = new Transform();
			
			System.out.print(anchor.toString());
			
			window.setScene(scene);
			window.setTitle(WINDOW_TITLE);
			window.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop()
	{
		Platform.exit();
	}
}
