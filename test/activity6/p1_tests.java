package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import activity6.*;
import activity6.Song;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class p1_tests
{
	/*
	 * tests converting a selected file from the file dialog into a Song
	 * Song filepath should be the correct filepath
	 * Song name should be the filename without the extension
	 * Written by Alexander Felvinci
	 */
	@Test
	public void testSongFromFileSelection()
	{
		String filePath = "[CHANGE TO LOCAL FILEPATH]";
		Optional<File> selectedFile = Optional.of(new File(filePath));
		try
		{
			Method m = LibraryUI.class.getDeclaredMethod("songFromSelection", Optional.class);

			m.setAccessible(true);
			Song s = (Song) m.invoke(selectedFile);
			assertEquals(s.getFile().toString(), filePath);
			assertEquals(s.getTitle(), "[CHANGE TO FILE TITLE]");
		}
		catch(ReflectiveOperationException e) {e.printStackTrace();}
	}
	
	/*
	 * tests the method addSongToLibrary(..) in LibraryUI
	 * Written by Alexander Felvinci
	 */
	@Test
	public void testAddSongToLibrary()
	{
		Library library = new Library();
		//remove demonstration Playables
		for (Playable p : library)
		{
			library.removePlayable(p);
		}
		String filePath = "D:\\Music\\BestSongEver.mp3";
		Optional<File> selectedFile = Optional.of(new File(filePath));
		try
		{
			Method m = LibraryUI.class.getDeclaredMethod("addSongToLibrary", Library.class, Optional.class);

			m.setAccessible(true);
			m.invoke(null, library, selectedFile);
			
			Field playablesField = Library.class.getDeclaredField("aPlayables");
			playablesField.setAccessible(true);
			List<Playable> playables = (List<Playable>) playablesField.get(library);
			
			assertNotEquals(0, playables.size());
			assertEquals(Song.class, playables.get(0).getClass());
			
			Song s = (Song) playables.get(0);
			
			assertEquals(filePath, s.getFile().toString());
			assertEquals("BestSongEver", s.getTitle());
		}
		catch(ReflectiveOperationException e) {e.printStackTrace();}
	}
}