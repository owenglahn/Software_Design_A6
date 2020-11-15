package activity6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

public class LibraryView extends Parent implements LibraryObserver
{
	private final ObservableList<Playable> aObservablePlayables = FXCollections.observableArrayList();
	private ListView<Playable> aListView;
	private final Library aModel;
	
	public LibraryView(Library pModel)
	{
		aModel = pModel;
		aModel.addLibraryObserver(this);
		for ( Playable pPlayable : pModel )
		{
			aObservablePlayables.add(pPlayable);
		}
		aListView = new ListView<>(aObservablePlayables);
	}
	
	@Override
	public void playableAdded(Playable pPlayable)
	{
		aObservablePlayables.add(pPlayable);

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
