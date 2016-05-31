package userInterface.userInputsHandlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Michele Franceschetti
 */

public class KeyboardInputsHandler implements KeyListener
{
	//Left arm
	private int LeftHorizontalAxis;
	private int LeftVerticalAxis;
	
	//Right arm
	private int RightHorizontalAxis;
	private int RightVerticalAxis;
	
	//Other commands
	
	private boolean escape;
	
	@Override
	public void keyPressed(KeyEvent e)
	{	
		int KeyCode = e.getKeyCode();
		
		e.consume();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int KeyCode = e.getKeyCode();
		
		e.consume();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		e.consume();
	}
}
