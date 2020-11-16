package activity6;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.lang.reflect.Field;

import org.junit.Test;

import activity6.Library;
import activity6.Song;
import activity6.StatusLogger;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class p3_tests_addremove_statuslogger
{
	@Test
	public void testStatusLoggerAddPlayable()
	{
		Library lib = new Library();
		Song song = new Song(new File("D:\\Music\\Song.mp3"), "Song 1");
		StatusLogger logger = new StatusLogger(lib);
		try
		{
			Field f = StatusLogger.class.getDeclaredField("aDisplayer");
			f.setAccessible(true);
			TextFlow textF = (TextFlow) f.get(logger);
			assertEquals(0, textF.getChildren().size());
			lib.addPlayable(song);
			assertEquals(1, textF.getChildren().size());
			
			Text text = (Text)(textF.getChildren().get(0));
			assertEquals ("The item: Song 1 by <undefined artist>\n has been added. \n", text.getText());
		}
		catch (ReflectiveOperationException e) {e.printStackTrace();}
	}
	
	@Test
	public void testStatusLoggerRemovePlayable()
	{
		Library lib = new Library();
		Song song = new Song(new File("D:\\Music\\Song.mp3"), "Song 1");
		lib.addPlayable(song);
		StatusLogger logger = new StatusLogger(lib);
		lib.removePlayable(song);
		try
		{
			Field f = StatusLogger.class.getDeclaredField("aDisplayer");
			f.setAccessible(true);
			TextFlow textF = (TextFlow) f.get(logger);
			
			Text text = (Text)(textF.getChildren().get(0));
			assertEquals ("The item: Song 1 by <undefined artist>\n has been removed. \n", text.getText());
		}
		catch (ReflectiveOperationException e) {e.printStackTrace();}
	}

	@Test
	public void testAddAndRemoveMultiplePlayables()
	{
		Library lib = new Library();
		Song song1 = new Song(new File("D:\\Music\\Song1.mp3"), "Song 1");
		Song song2 = new Song(new File("C:\\Music\\Song2.mp3"), "Song 2");
		StatusLogger logger = new StatusLogger(lib);
		try
		{
			lib.addPlayable(song1);
			lib.addPlayable(song2);
			lib.removePlayable(song1);

			Field f = StatusLogger.class.getDeclaredField("aDisplayer");
			f.setAccessible(true);
			TextFlow textF = (TextFlow) f.get(logger);
			
			Text text = (Text)(textF.getChildren().get(0));
			Text text1 = (Text)(textF.getChildren().get(1));
			Text text2 = (Text)(textF.getChildren().get(2));
			
			assertEquals ("The item: Song 1 by <undefined artist>\n has been added. \n", text.getText());
			assertEquals ("The item: Song 2 by <undefined artist>\n has been added. \n", text.getText());
			assertEquals ("The item: Song 1 by <undefined artist>\n has been removed. \n", text.getText());
		}
		catch (ReflectiveOperationException e) {e.printStackTrace();}
	}
}

