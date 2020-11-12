package activity6;

import java.io.File;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

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
    	
    	Parent logger = new StatusLogger(library);
    	Parent libraryView = new LibraryView(library);
    	
    	library.addLibraryObserver((LibraryObserver) logger);
    	library.addLibraryObserver((LibraryObserver) libraryView);
    	
    	BorderPane root = new BorderPane();
    	
    	// Create button to add files to the library
    	Button addButton = new Button("Add Song");
    	addButton.setMaxWidth(Double.MAX_VALUE);
    	root.setTop(addButton);
    	
    	// Create the view of all playables 
    	ListView<Playable> listView = ((LibraryView) libraryView).getListView();
    	root.setCenter(listView);
    	
    	//Add playable
    	addButton.setOnAction(new EventHandler<ActionEvent>() 
    	{
			@Override
			public void handle(ActionEvent pActionEvent)
			{
				//open file dialog
				Optional<File> selected = selectFile(pStage);
				Song fileSong = songFromSelection(selected); 
				library.addPlayable(fileSong);
				
			}
    	});

 	
    	
    	
    	// Create bottom panel
    	VBox bottom = new VBox();
    	Button deleteButton = new Button("Remove item");
    	deleteButton.setMaxWidth(Double.MAX_VALUE);
    	bottom.getChildren().add(deleteButton);
    	root.setBottom(bottom);
    	
    	/* Remove a selected playable if the remove button is clicked */
    	deleteButton.setOnAction(new EventHandler<ActionEvent>(){
    		@Override
    		public void handle(ActionEvent pActionEvent)
    		{
    			library.removePlayable(getSelected(listView));
    		}
    	});
    	
    	root.setRight(logger);
    	
        pStage.setScene(new Scene(root, WIDTH, HEIGHT));
        pStage.show();
    }
    
    /*
     * Returns a Song from the selected file from a file chooser
     * Uses the filename without the last extension as the song title
     */
    private static Song songFromSelection(Optional<File> pSelected)
    {
    	File f = pSelected.get();
		String title = f.getName();
		
		//get filename without extension
		int lastIndex = title.lastIndexOf('.');
		if (lastIndex != -1)
			title = title.substring(0, lastIndex);
		return new Song(f, title);
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

