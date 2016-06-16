package userInterface.userInputsHandlers;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import userInterface.graphic3DHandler.View;

/**
 * @author Michele Franceschetti
 */

public class MouseInputsHandler
{
	//Mouse buttons
	
	private boolean leftMouseButton;
	private boolean rightMouseButton;
	
	//Mouse position
	
	private double[] mousePosition = new double[2];
	private double[] lastMousePosition = new double[2];
	private double[] deltaMousePosition = new double[2];
	
	public boolean isLeftButtonPressed()
	{
		return leftMouseButton;
	}

	public void setLeftButtonPressed(boolean leftMouseButton)
	{
		this.leftMouseButton = leftMouseButton;
	}

	public boolean isRightButtonPressed()
	{
		return rightMouseButton;
	}

	public void setRightButtonPressed(boolean rightMouseButton) 
	{
		this.rightMouseButton = rightMouseButton;
	}
	
	public double getX()
	{
		return mousePosition[0];
	}
	
	public double getY()
	{
		return mousePosition[1];
	}

	public void handleMouse(Scene scene, View camera) 
	{
        scene.setOnMousePressed(new EventHandler<MouseEvent>() 
        {
            @Override 
            public void handle(MouseEvent event) 
            {
                updateInputs(event, scene);
            }
        });
        
        /*scene.setOnMouseDragged(new EventHandler<MouseEvent>() 
        {
            @Override 
            public void handle(MouseEvent event) 
            {
                updateInputs(event, scene);
            }
        });*/
        
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() 
        {
            @Override 
            public void handle(MouseEvent event) 
            {
                updateInputs(event, scene);
                
                camera.translateCamera(deltaMousePosition[0]);
                camera.rotateCamera(deltaMousePosition[1]);
            }
        });
    }
	
	private void updateInputs(MouseEvent event, Scene scene)
	{
		lastMousePosition[0] = mousePosition[0];
		lastMousePosition[1] = mousePosition[1];
		
        mousePosition[0] = scene.getWidth() / 2 - event.getSceneX();
        mousePosition[1] = event.getSceneY() - scene.getHeight() / 2;
        
        deltaMousePosition[0] = (mousePosition[0] - lastMousePosition[0]); 
        deltaMousePosition[1] = (mousePosition[1] - lastMousePosition[1]);
        
        //if(deltaMousePosition[0] != 0)
        	//System.out.println("Mouse moved horizontally");

        //if(deltaMousePosition[1] != 0)
        	//System.out.println("Mouse moved vertically");

        if(event.isPrimaryButtonDown())
		{
			setLeftButtonPressed(true);
			System.out.println("Left Pressed");
		}
        else
        {
        	setLeftButtonPressed(false);
        	System.out.println("Left Released");
        }
		
		if(event.isSecondaryButtonDown())
		{
			setRightButtonPressed(true);
			System.out.println("Right Pressed");
		}
		else
		{
			setRightButtonPressed(false);
        	System.out.println("Right Released");
		}
	}
}
