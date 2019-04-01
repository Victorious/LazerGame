package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import Main.Game;
import Main.Laser;
import Main.LaserBlock;
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
		Player p = new Player(x, y, 10, 10,game,5);
		p.moveUp(10);
		int yActual = p.getY();
		assertEquals(yActual, 10);
	}
	

	@Test
	public void testPlayerMoveDown() {
		Player p = new Player(x, y, 10, 10,game,5);
		p.moveDown(10);
		int yActual = p.getY();
		assertEquals(yActual, 30);
	}
	
	@Test
	public void testPlayerMoveLeft() {
		Player p = new Player(x, y, 10, 10,game,5);
		p.moveLeft(10);
		int yActual = p.getX();
		assertEquals(yActual, 10);
	}
	
	@Test
	public void testPlayerMoveRight() {
		Player p = new Player(x, y, 10, 10,game,5);
		p.moveRight(10);
		int yActual = p.getX();
		assertEquals(yActual, 30);
	}
	
	@Test
	public void testPlayerCollisionWall() {
		
	}
	
	@Test
	public void testPlayerCollisionLaser() {
		Game game = new Game();
		Laser laser = new Laser(50, 80, 5, 10, game);
		Player p = new Player(0, 80, 25, 25, game, 5);
		int s = 0;
		if (laser.getX() == 50) {
			s = 2;
		}

		assertEquals(s, 2);			
	}




}
