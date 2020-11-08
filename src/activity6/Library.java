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
	
	/**
	 * Creates a new empty library.
	 */
	public Library()
	{
		// Just for demonstration
		addItem(new Song(new File("A.mp3"), "Song A"));
		addItem(new Song(new File("B.mp3"), "Song B"));
		addItem(new Song(new File("C.mp3"), "Song C"));
	}
	
	public void addItem(Playable pPlayable)
	{
		aPlayables.add(pPlayable);
	}
	
	public void removeItem(Playable pPlayable)
	{
		aPlayables.remove(pPlayable);
	}

	@Override
	public Iterator<Playable> iterator()
	{
		return new ArrayList<>(aPlayables).iterator();
	}
}
