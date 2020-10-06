package activity3;

import java.util.HashMap;
import java.util.Map;

public class Library
{
	public static final Library INSTANCE = new Library();
	
	private final Map<String, Song> aSongs = new HashMap<>();
	
	private Library() {}
}
