package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Main.Player;

public class TestPlayer {
	int x = 20 ,y = 20;
	@Test
	public void testPlayerMoveUp() {
		Player p = new Player(x, y, 10, 10);
		p.moveUp(10);
		int yActual = p.getY();
		assertEquals(yActual, 10);
		
	}
	
	@Test
	public void testPlayerMoveUp2() {
		Player p = new Player(x, 40, 10, 10);
		p.moveUp(10);
		int yActual = p.getY();
		assertEquals(yActual, 30);
		
	}
	
	@Test
	public void testPlayerMoveDown() {
		
	}
	
	@Test
	public void testPlayerMoveLeft() {
		
	}
	
	@Test
	public void testPlayerMoveRight() {
		
	}
	
	@Test
	public void testPlayerCollisionWall() {
		
	}


}
