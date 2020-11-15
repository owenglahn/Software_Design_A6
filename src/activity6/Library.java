package activity6;

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

	/*
	 * Adds pLibraryObserver to aLibraryObservers
	 * 
	 * @param pLibraryObserver the LibraryObserver to add
	 * 
	 * @pre pLibraryObserver != null
	 */
	public void addLibraryObserver(LibraryObserver pLibraryObserver)
	{
		assert pLibraryObserver != null;

		if (!aLibraryObservers.contains(pLibraryObserver))
			aLibraryObservers.add(pLibraryObserver);
	}

	/*
	 * Removes a LibraryObserver from aLibraryObservers
	 * 
	 * @param pLibraryObserver the LibraryObserver to remove
	 */
	public void removeLibraryObserver(LibraryObserver pLibraryObserver)
	{
		assert pLibraryObserver != null;
		if (aLibraryObservers.contains(pLibraryObserver))
			aLibraryObservers.remove(pLibraryObserver);
	}

	/*
	 * Adds pPlayable to aPlayables
	 * 
	 * @param pPlayable the Playable to add
	 * 
	 * @pre pPlayable != null
	 */
	public void addPlayable(Playable pPlayable)
	{
		assert pPlayable != null;
		aPlayables.add(pPlayable);
		System.out.println("The item: " + pPlayable + " has been added.");
		for (LibraryObserver libObs : aLibraryObservers)
		{
			libObs.playableAdded(pPlayable);
		}
	}

	/*
	 * Removes pPlayable from aPlayables
	 * 
	 * @param pPlayable the Playable to remove
	 */
	public void removePlayable(Playable pPlayable)
	{
		assert pPlayable != null;
		aPlayables.remove(pPlayable);
		System.out.println("The item: " + pPlayable + " has been removed.");
		for (LibraryObserver libObs : aLibraryObservers)
		{
			libObs.playableRemoved(pPlayable);
		}
	}

	/*
	 * @return reused Iterator<Playable> from aPlayables
	 */
	@Override
	public Iterator<Playable> iterator()
	{
		return new ArrayList<>(aPlayables).iterator();
	}
}
