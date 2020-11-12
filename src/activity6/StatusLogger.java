package activity6;

import javafx.scene.Parent;
import javafx.scene.text.*;

public class StatusLogger extends Parent implements ActionLogger
{
	private Library model;
	private TextFlow displayer = new TextFlow(); 
    public StatusLogger(Library pmodel)
    {
    	this.model = pmodel;
    	getChildren().add(displayer);
    }

    /**
     * Return a formatted text node to log a new action
     */
    public Text newNode()
    {
    	Text ptext = new Text();
    	ptext.setFont(new Font(10));
    	ptext.setWrappingWidth(200);
    	ptext.setTextAlignment(TextAlignment.JUSTIFY);
    	return ptext;
    }
    /**
     * Log the adding action to a text node and add the text node to the textflow (displayer)
     */
    public void PlayableAdded(Playable pPlayable)
    {
    	Text newAction = newNode();
    	newAction.setText("The item: " + pPlayable + "\n has been added. \n");
    	displayer.getChildren().add(newAction);
    }
    /**
     * Log the removing action to a text node and add the text node to the textflow (displayer)
     */
    public void PlayableRemoved(Playable pPlayable)
    {
    	Text newAction = newNode();
        newAction.setText("The item: " + pPlayable + "\n has been removed. \n");
        displayer.getChildren().add(newAction);
    }
}

}
