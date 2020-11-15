package activity6;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class Util {

	public static Song SONG0;
	public static Song SONG1;
	public static Song SONG2;
	public static Song SONG3;
	public static Song SONG4;
	public static Song SONG5;
	public static Song SONG6;
	public static Song SONG7;
	public static Song SONG8;
	public static Song SONG9;
	public static Song SONG10;

	public static void init() {
		SONG0 = new Song(new File("./songs/invalidExt.notLegit"), "Song0");
		SONG1 = new Song(new File("./songs/song1.mp3"), "Song1");
		SONG2 = new Song(new File("./songs/song2.wav"), "Song2");
		SONG3 = new Song(new File("./songs/song3.aac"), "Song3");
		SONG4 = new Song(new File("./songs/song4.flac"), "Song4");
		SONG5 = new Song(new File("./songs/song5.flac"), "Song5");
		SONG6 = new Song(new File("./songs/song6.flac"), "Song6");
		SONG7 = new Song(new File("./songs/song7.flac"), "Song7");
		SONG8 = new Song(new File("./songs/song8.flac"), "Song8");
		SONG9 = new Song(new File("./songs/song9.flac"), "Song9");
		SONG10 = new Song(new File("./songs/song10.flac"), "Song10");
	}
	
	static Object getField(Object pObject, String pFieldName)
	{
		try
		{
			Field field = pObject.getClass().getDeclaredField(pFieldName);
			field.setAccessible(true);
			return field.get(pObject);
		}
		catch (ReflectiveOperationException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	static List<Playable> getPlayables(Library pLibrary)
	{
		return (List<Playable>) getField(pLibrary, "aPlayables");
	}

}