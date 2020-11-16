package activity6;

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
		String filePath = "D:\\Music\\Test.mp3";
		Optional<File> selectedFile = Optional.of(new File(filePath));
		try
		{
			Method m = LibraryUI.class.getDeclaredMethod("songFromSelection", Optional.class);

			m.setAccessible(true);
			Song s = (Song) m.invoke(null, selectedFile);
			assertEquals(s.getFile().toString(), filePath);
			assertEquals(s.getTitle(), "D:\\Music\\Test");
		}
		catch(ReflectiveOperationException e) {e.printStackTrace();}
	}
}
