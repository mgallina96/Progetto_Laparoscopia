package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import userInterface.graphic3DHandler.Transform;
import userInterface.graphic3DHandler.View;
import userInterface.userInputsHandlers.KeyboardInputsHandler;
import userInterface.userInputsHandlers.MouseInputsHandler;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;


public class Main extends Application 
{
	private static final String WINDOW_TITLE = "Laparoscopy";

	private static final double WINDOW_RESOLUTION_WIDTH = 800;

	private static final double WINDOW_RESOLUTION_HEIGHT = 600;

	private static final double AXES_RADIUS = 1;

	private static final double AXES_LENGTH = 250;

	final Group root = new Group();
    final Transform world = new Transform();
    final Transform axis = new Transform();
    
    final View camera = new View();
    final Scene scene = new Scene(root, WINDOW_RESOLUTION_WIDTH, WINDOW_RESOLUTION_HEIGHT, true);
    final KeyboardInputsHandler keyboard = new KeyboardInputsHandler(world);
    final MouseInputsHandler mouse = new MouseInputsHandler();
    
    private static final ArrayList<Core> threads = new ArrayList<Core>();

    @Override
	public void start(Stage window) 
    {
		try 
		{
			root.getChildren().add(world);
			
	        camera.buildCamera(root);
	        
	        //////////////////////////Awake
	        
	        if(threads.size() > 0)
	        {
	        	for(Core thread : threads)
		        {
		        	thread.awake();
		        }
	        }
	        
	        //////////////////////////
			
	        root.setDepthTest(DepthTest.ENABLE);
			
			buildAxes();
			
		    keyboard.handleKeyboard(scene);
		    mouse.handleMouse(scene, camera);
	        
	        scene.setCamera(camera.getCamera());
			
			window.setScene(scene);
			window.setTitle(WINDOW_TITLE);
			window.show();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			//////////////////////////Terminate
			
			if(threads.size() > 0)
			{
				for(Core thread : threads)
				{
					thread.terminate();
				}
			}
			
			//////////////////////////
		}
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override	
	public void stop()
	{
		Platform.exit();
	}
	
    private void buildAxes() 
    {
        System.out.println("buildAxes()");
        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.RED);
        redMaterial.setSpecularColor(Color.RED);

        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.GREEN);
        greenMaterial.setSpecularColor(Color.GREEN);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        blueMaterial.setSpecularColor(Color.BLUE);

        final Box xAxis = new Box(AXES_LENGTH, AXES_RADIUS, AXES_RADIUS);
        final Box yAxis = new Box(AXES_RADIUS, AXES_LENGTH, AXES_RADIUS);
        final Box zAxis = new Box(AXES_RADIUS, AXES_RADIUS, AXES_LENGTH);
        
        final Box xAxisEnd = new Box(AXES_RADIUS * 2, AXES_RADIUS * 2, AXES_RADIUS * 2);
        final Box yAxisEnd = new Box(AXES_RADIUS * 2, AXES_RADIUS * 2, AXES_RADIUS * 2);
        final Box zAxisEnd = new Box(AXES_RADIUS * 2, AXES_RADIUS * 2, AXES_RADIUS * 2);

        xAxis.setMaterial(redMaterial);
        yAxis.setMaterial(greenMaterial);
        zAxis.setMaterial(blueMaterial);

        xAxisEnd.setMaterial(redMaterial);
        yAxisEnd.setMaterial(greenMaterial);
        zAxisEnd.setMaterial(blueMaterial);
        
        xAxisEnd.setTranslateX(-AXES_LENGTH / 2);
        yAxisEnd.setTranslateY(-AXES_LENGTH / 2);
        zAxisEnd.setTranslateZ(-AXES_LENGTH / 2);
        
        axis.getChildren().addAll(xAxis, yAxis, zAxis, xAxisEnd, yAxisEnd, zAxisEnd);
        axis.setVisible(true);
        world.getChildren().addAll(axis);
    }
}
