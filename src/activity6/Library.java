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
	private final ActionLogger aStatusLogger = new StatusLogger();
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
	
	public void addPlayable(Playable pPlayable)
	{
		aPlayables.add(pPlayable);
		System.out.println("The item: " + pPlayable + "has been added.");
		aStatusLogger.PlayableAdded(pPlayable);
	}
	
	public void removePlayable(Playable pPlayable)
	{
		aPlayables.remove(pPlayable);
		System.out.println("The item: " + pPlayable + "has been removed.");
		aStatusLogger.PlayableRemoved(pPlayable);
	}

	@Override
	public Iterator<Playable> iterator()
	{
		return new ArrayList<>(aPlayables).iterator();
	}
}
