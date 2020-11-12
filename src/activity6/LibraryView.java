package activity6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

public class LibraryView extends Parent implements LibraryObserver
{
	private final ObservableList<Playable> aObservablePlayables = FXCollections.observableArrayList();
	private final ListView<Playable> aListView;
	
	public LibraryView(Library pModel)
	{
		for ( Playable pPlayable : pModel )
		{
			aObservablePlayables.add(pPlayable);
		}
		aListView = new ListView<>(aObservablePlayables);
	}
	
	@Override
	public void playableAdded(Playable pPlayable)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void playableRemoved(Playable pPlayable)
	{
		aObservablePlayables.remove(pPlayable);
	}

	public ListView<Playable> getListView()
	{
		return aListView;
	}
}
