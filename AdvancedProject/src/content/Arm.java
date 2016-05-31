package content;

import javafx.scene.transform.Translate;

/**
 * @author Michele Franceschetti
 */

public class Arm 
{	
	private Tool tool;
	private Translate target;
	
	public Tool getTool() 
	{
		return tool;
	}
	
	public void setTool(Tool tool) 
	{
		this.tool = tool;
	}
	
	public Translate getTargetPosition() 
	{
		return target;
	}
	
	public void setTargetPosition(Translate target) 
	{
		this.target = target;
	}
}
