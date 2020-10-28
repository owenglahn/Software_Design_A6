package activity5;

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
	{}
	
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
