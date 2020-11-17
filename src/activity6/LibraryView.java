package activity6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

public class LibraryView extends Parent implements LibraryObserver
{
	private final ObservableList<Playable> aObservablePlayables = FXCollections.observableArrayList();
	private final Library aModel;
	
	/*
	 * Instantiates a LibraryView Object
	 */
	public LibraryView(Library pModel)
	{
		aModel = pModel;
		aModel.addLibraryObserver(this);
		for ( Playable pPlayable : pModel )
		{
			aObservablePlayables.add(pPlayable);
		}
	}
	
	/*
	 * Callback method for when a Playable has been added to a library
	 * 
	 * @param pPlayable the playable to add
	 * @pre pPlayable != null
	 */
	@Override
	public void playableAdded(Playable pPlayable)
	{
		assert pPlayable != null;
		aObservablePlayables.add(pPlayable);
	}

	/*
	 * Callback method for when a playable has been removed from a library
	 * 
	 * @param pPlayable the Playable to remove
	 */
	@Override
	public void playableRemoved(Playable pPlayable)
	{
		aObservablePlayables.remove(pPlayable);
	}

	/*
	 * @return ListView of the playables
	 */
	public ListView<Playable> getListView()
	{
		return new ListView<Playable>(aObservablePlayables);
	}
}
