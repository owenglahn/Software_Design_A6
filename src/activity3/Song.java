package activity3;

import java.util.HashMap;
import java.util.Map;

public class Song
{
	private String aTitle;
	private int aDuration;
	private final String aFile;
	private Artist aArtist;
	private String aGenre;
	
	private Map<String, String> aTags = new HashMap<>();
	
	public Song(String pFile)
	{
		aFile = pFile;
	}
	
	public String getFile()
	{
		return aFile;
	}
	
	public void editTag(String pTag, String pValue)
	{
		aTags.put(pTag, pValue);
	}
}
