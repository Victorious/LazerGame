package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import Main.Game;
import Main.Laser;
import Main.Player;

public class TestPlayer {
    Player p;
	int x,y,width,height;
	Game game;
	
	@Before
	public void initClasses() {
		x = 20; 
		y = 20; 
		width = 25; 
		height = 25;
		game = new Game();
		p = new Player(x, y, width, height, game, 5);
	}
	
	@Test
	public void testIfPlayerNotNull() {
		assertNotNull(p.getBounds());
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
		p = new Player(x, y, 10, 10,game,5);
		p.moveDown(10);
		int yActual = p.getY();
		assertEquals(yActual, 30);
	}
	
	@Test
	public void testPlayerMoveLeft() {
		Player p = new Player(x, y, 10, 10,game,5);

		p = new Player(x, y, 10, 10,game,5);
		p.moveLeft(10);
		int yActual = p.getX();
		assertEquals(yActual, 10);
	}
	
	@Test
	public void testPlayerMoveRight() {
		Player p = new Player(x, y, 10, 10,game,5);
		p = new Player(x, y, 10, 10,game,5);
		p.moveRight(10);
		int yActual = p.getX();
		assertEquals(yActual, 30);
	}
	
	@Test
	public void testPlayerCollisionUp() {
		int x = 100 ,y = 100;
		p = new Player(x,y, 10, 10,game,5);
		p.moveUp(10);
		int yActual = p.getY();
		assertEquals(yActual, 90);
	}
	
	@Test
	public void testPlayerCollisionLaser() {
		int x = 40,y = 80;
		Game game = new Game();
		Laser laser = new Laser(50, 80, 5, 10, game);
		Player p = new Player(y, x, 25, 25, game, 5);
		p.moveRight(10);
		int collision = 1;
		if (laser.getX() == p.getX() && laser.getY() == p.getY()) {
			collision = 1;
		}
		assertEquals(collision, 1);			
	}
	
	@Test
	public void CollisionInWallLeft() {
		Player p = new Player(30, 80, 25, 25, game,5);
		p.collisionLeft();
		int Actual = p.getX();
		assertEquals(Actual, 30);
		}
	
	@Test
	public void CollisionInWallRight() {
		Player p = new Player(670, 80, 25, 25, game,5);
		p.collisionRight();
		int Actual = p.getX();
		assertEquals(Actual, 670);
		}
	
	@Test
	public void CollisionInWallDown() {
		Player p = new Player(30, 675, 25, 25, game,5);
		p.collisionDown();
		int Actual = p.getY();
		assertEquals(Actual, 675);
		}
	
	@Test
	public void CollisionInWallUp() {
		Player p = new Player(30, 80, 25, 25, game,5);
		p.collisionUp();
		int Actual = p.getY();
		assertEquals(Actual, 80);
		}
	
	@Test
	public void testPlayerDead() {
		Player p = new Player(50, 90, 25, 25, game, 0);
		p.dead();
		assertEquals(0, p.getHealth());
	}
	
	
}
