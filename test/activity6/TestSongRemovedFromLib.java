package activity6;

public class TestSongRemovedFromLib
{
	private static final Library LIBRARY = new Library();
	
	private TestSongRemovedFromLib()
	{
		LIBRARY.addPlayable(Util.SONG0);
		LIBRARY.addPlayable(Util.SONG1);
		LIBRARY.addPlayable(Util.SONG2);
		LIBRARY.addPlayable(Util.SONG3);
		LIBRARY.addPlayable(Util.SONG4);
		LIBRARY.addPlayable(Util.SONG5);
		LIBRARY.addPlayable(Util.SONG6);
		LIBRARY.addPlayable(Util.SONG7);
		LIBRARY.addPlayable(Util.SONG8);
		LIBRARY.addPlayable(Util.SONG9);
		LIBRARY.addPlayable(Util.SONG10);
	}
	
	
	private static boolean libraryIsEmpty()
	{
		return Util.getPlayables(LIBRARY).isEmpty();
	}
	
	public static void main(String[] args)
	{
		while ( ! libraryIsEmpty() )
		{
			
		}
	}
	
}
