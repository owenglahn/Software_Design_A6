/*
 * This tests whether the method removePlayable(Playable pPlayable) properly updates the observers.
 */

package activity6;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TestSongRemovedFromLib
{
	public static final Library LIBRARY = new Library();
	public static final LibraryView VIEWER = new LibraryView(LIBRARY);
	
	@Test @SuppressWarnings("unchecked")
	public void testSongRemovedFromObserver()
	{
		for (int i = 0; i < Util.SONGS.length; i++)
		{
			LIBRARY.addPlayable(Util.SONGS[i]);
		}
		List<Playable> libPlayables = (List<Playable>)Util.getField(LIBRARY, "aPlayables");
		List<Playable> obsPlayables = (List<Playable>) Util.getField(VIEWER, "aObservablePlayables");
		assertTrue(libPlayables.contains(Util.SONG0));
		assertTrue(obsPlayables.contains(Util.SONG0));
		LIBRARY.removePlayable(Util.SONG0);
		assertFalse(libPlayables.contains(Util.SONG0));
		assertFalse(obsPlayables.contains(Util.SONG0));	
	}
}
