package activity5;

import java.io.File;
import java.util.Random;

/**
 * Stub for a media player. Accessible as a singleton.
 */
public class Player
{
	private static final Player INSTANCE = new Player();
	private static final Random RANDOM = new Random();
	
	public static Player instance()
	{
		return INSTANCE;
	}
	
	public void playSong(Song pSong) {}
	public void playSilence(int pTime) {}
	public int duration(File pSong) { return RANDOM.nextInt(10); }
}
