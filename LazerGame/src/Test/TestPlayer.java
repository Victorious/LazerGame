package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Main.Game;
import Main.Player;

public class TestPlayer {
	int x = 20 ,y = 20;
	Game game;
	@Before
	public void getClasses() {
		game = new Game();
	}
	
	@Test
	public void testPlayerMoveUp() {
		Player p = new Player(x, y, 10, 10,game);
		p.moveUp(10);
		int yActual = p.getY();
		assertEquals(yActual, 10);
	}
	

	@Test
	public void testPlayerMoveDown() {
		Player p = new Player(x, y, 10, 10,game);
		p.moveDown(10);
		int yActual = p.getY();
		assertEquals(yActual, 30);
	}
	
	@Test
	public void testPlayerMoveLeft() {
		Player p = new Player(x, y, 10, 10,game);
		p.moveLeft(10);
		int yActual = p.getX();
		assertEquals(yActual, 10);
	}
	
	@Test
	public void testPlayerMoveRight() {
		Player p = new Player(x, y, 10, 10,game);
		p.moveRight(10);
		int yActual = p.getX();
		assertEquals(yActual, 30);
	}
	
	@Test
	public void testPlayerCollisionWall() {
		
	}


}
