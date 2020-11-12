package activity6;

import javafx.scene.Parent;
import javafx.scene.text.*;

public class StatusLogger extends Parent implements LibraryObserver
{
	private Library aModel;
	private TextFlow aDisplayer = new TextFlow();
	
    public StatusLogger(Library pModel)
    {
    	this.aModel = pModel;
    	getChildren().add(aDisplayer);
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
    @Override
    public void playableAdded(Playable pPlayable)
    {
    	Text newAction = newNode();
    	newAction.setText("The item: " + pPlayable + "\n has been added. \n");
    	aDisplayer.getChildren().add(newAction);
    }
    /**
     * Log the removing action to a text node and add the text node to the textflow (displayer)
     */
    @Override
    public void playableRemoved(Playable pPlayable)
    {
    	Text newAction = newNode();
        newAction.setText("The item: " + pPlayable + "\n has been removed. \n");
        aDisplayer.getChildren().add(newAction);
    }
}


