package application;
	
import content.Patient;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import userInterface.GUIHandler.WindowHandler;
import userInterface.graphic3DHandler.Transform;

public class Main extends Application 
{	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void init()
	{
		
	}
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{	
			Patient patient = new Patient();
			
			WindowHandler window = new WindowHandler(primaryStage, patient);
			
			Transform anchor = new Transform();
			
			System.out.print(anchor.toString());
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop()
	{
		Platform.exit();
	}
}
