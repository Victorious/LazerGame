package Test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Main.Game;
import Main.Levels;

public class TestLevels {

	Game game = new Game();
	
	@Test
	public void testLevel1Graphic() {
		Levels lvl = new Levels(game);
		assertNotNull(lvl.getLevel1());
	}
}