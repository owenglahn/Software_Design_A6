package activity6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a collection of songs, playlists, and albums.
 */
public class Library implements Iterable<Playable>
{
	private final List<Playable> aPlayables = new ArrayList<>();
	private final List<LibraryObserver> aLibraryObservers = new ArrayList<>();

	/**
	 * Creates a new empty library.
	 */
	public Library()
	{
		// Just for demonstration
		addPlayable(new Song(new File("A.mp3"), "Song A"));
		addPlayable(new Song(new File("B.mp3"), "Song B"));
		addPlayable(new Song(new File("C.mp3"), "Song C"));
	}

	public void addLibraryObserver(LibraryObserver pLibraryObserver)
	{
		aLibraryObservers.add(pLibraryObserver);
	}

	public void removeLibraryObserver(LibraryObserver pLibraryObserver)
	{
		aLibraryObservers.remove(pLibraryObserver);
	}

	public void addPlayable(Playable pPlayable)
	{
		aPlayables.add(pPlayable);
		System.out.println("The item: " + pPlayable + " has been added.");
		for (LibraryObserver libObs : aLibraryObservers)
		{
			libObs.playableAdded(pPlayable);
		}
	}

	public void removePlayable(Playable pPlayable)
	{
		aPlayables.remove(pPlayable);
		System.out.println("The item: " + pPlayable + " has been removed.");
		for (LibraryObserver libObs : aLibraryObservers)
		{
			libObs.playableRemoved(pPlayable);
		}
	}

	@Override
	public Iterator<Playable> iterator()
	{
		return new ArrayList<>(aPlayables).iterator();
	}
}
