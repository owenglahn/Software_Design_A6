package activity6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class problem1_and_2_tests

{
	private Library aModel;
	private LibraryObserver aView;
	private Playable a;
	private Playable b;
	private Playable c;
	private Playable d;
	private Playlist p;
	
	@BeforeAll
	public static void setupClass() {
		JavaFXLoader.load();
	}
	
	@BeforeEach
	public void setup() {
		aModel = new Library();
		aView = new LibraryView(aModel);

		a = new Song(new File("A.mp3"), "Song A");
		b = new Song(new File("B.mp3"), "Song B");
		c = new Song(new File("C.mp3"), "Song C");
		d = new Song(new File("D.mp3"), "Song D");
	}
	
	
	@Test
	public void TestAddSong() {
		aModel.addPlayable(a);
		aModel.addPlayable(b);
		aModel.addPlayable(c);
		assertTrue(((LibraryView)aView).getListView().getItems().contains(a));
		assertTrue(((LibraryView)aView).getListView().getItems().contains(b));
		assertTrue(((LibraryView)aView).getListView().getItems().contains(c));
		assertFalse(((LibraryView)aView).getListView().getItems().contains(d));
	}
	
	@Test
	public void TestAddAndRemovePlayable() {
		p = new Playlist("test");
		aModel.addPlayable(p);
		assertTrue(((LibraryView)aView).getListView().getItems().contains(p));
		aModel.removePlayable(p);
		assertFalse(((LibraryView)aView).getListView().getItems().contains(p));
	}
	
}
