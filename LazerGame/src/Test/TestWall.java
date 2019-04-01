package Test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import Main.Game;
import Main.Wall;

public class TestWall {
	Wall w;
	Game game;
	
	@Before
	public void initClasses() {
		int x = 50,y = 50,width = 25 ,height = 25;
		game = new Game();
		w = new Wall(x, y, width, height, game);
	}
	
	@Test
	public void testIfWallNotNull() {
		assertNotNull(w.getBounds());
	}
}
