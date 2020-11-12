package activity6;

import java.io.File;
import java.util.Optional;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Mock-up of a partial user interface for the music library.
 * 
 * This code makes a simplistic use of the JavaFX library
 * to limit the code comprehension efforts not directly related 
 * to the course objectives. 
 *
 */
public class LibraryUI extends Application
{
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	/**
	 * Launches the application.
	 * @param pArgs This program takes no argument.
	 */
	public static void main(String[] pArgs) 
	{
        launch(pArgs);
    }
    
    @Override
    public void start(Stage pStage) 
    {
    	Library library = new Library();
    	
    	BorderPane root = new BorderPane();
    	
    	// Create button to add files to the library
    	Button addButton = new Button("Add Song");
    	addButton.setMaxWidth(Double.MAX_VALUE);
    	root.setTop(addButton);
 	
    	// Create the view of all playables 
    	ListView<Playable> listView = createLibraryView(library);
    	root.setCenter(listView);
    	
    	// Create bottom panel
    	VBox bottom = new VBox();
    	Button deleteButton = new Button("Remove item");
    	deleteButton.setMaxWidth(Double.MAX_VALUE);
    	bottom.getChildren().add(deleteButton);
    	root.setBottom(bottom);
    	
		//Create Status Logging Display
    	root.setRight(library.getLoggerAsNode());
    	
        pStage.setScene(new Scene(root, WIDTH, HEIGHT));
        pStage.show();
    }
    
    /*
     * Encapsulates the view of a collection of Playable objects as a list
     * view. 
     */
    private static ListView<Playable> createLibraryView(Iterable<Playable> pPlayables)
    {
    	ObservableList<Playable> list = FXCollections.observableArrayList();
    	for( Playable playable : pPlayables )
    	{
    		list.add(playable);
    	}
    	return new ListView<>(list);
    }
    
    // Sample code to activate the file chooser
    private static Optional<File> selectFile(Stage pStage)
    {
    	FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(pStage);
		return Optional.ofNullable(selectedFile);
    }
    
    // Sample code to get the selected object from a ListView
    private static Playable getSelected(ListView<Playable> pView)
    {
    	return pView.getSelectionModel().getSelectedItem();
    }
}
