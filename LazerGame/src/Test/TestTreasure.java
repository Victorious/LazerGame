package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Main.Game;
import Main.Treasure;

public class TestTreasure {

	Treasure t;
	Game game;
	
	@Before
	public void initClasses() {
		int x = 50, y = 50, width = 25, height = 25;
		game = new Game();
		t = new Treasure(x, y, width, height, game);
	}
	
	@Test
	public void testIfTreasureNotNull() {
		assertNotNull(t.getBounds());
	}

}
