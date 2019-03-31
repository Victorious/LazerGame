package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import Main.Game;
import Main.LaserBlock;
import Main.Player;

@RunWith (MockitoJUnitRunner.class)
public class TestPlayer {
	int x = 20 ,y = 20;
    Player p;
	
	// in order to be able to test
	// collision functions we need to create a mock
	//we need to inject laserblock list into game 
	// BUT we are doing smth wrong or
	// missing smth because laserblock list size is still 0
	// So this micking part is not working
	
	//inject mock into game object
	@InjectMocks
	Game game = new Game();
	
	//creating mock that should be injected
	@Mock
	ArrayList<LaserBlock> mockedlaserBlockList = new ArrayList<LaserBlock>();
	LaserBlock lb = new LaserBlock(99, 98, 3, 4,game);
	
	@Test
	public void testPlayerMoveUp() {
		Player p = new Player(x, y, 10, 10,game);
		p.moveUp(10);
		int yActual = p.getY();
		assertEquals(yActual, 10);
	}
	
	@Test
	public void testPlayerMoveDown() {
		p = new Player(x, y, 10, 10,game);
		p.moveDown(10);
		int yActual = p.getY();
		assertEquals(yActual, 30);
	}
	
	@Test
	public void testPlayerMoveLeft() {
		p = new Player(x, y, 10, 10,game);
		p.moveLeft(10);
		int yActual = p.getX();
		assertEquals(yActual, 10);
	}
	
	@Test
	public void testPlayerMoveRight() {
		p = new Player(x, y, 10, 10,game);
		p.moveRight(10);
		int yActual = p.getX();
		assertEquals(yActual, 30);
	}
	
	@Test
	public void testPlayerCollisionUp() {
		p = new Player(100,100, 10, 10,game);
		p.moveUp(10);
		int yActual = p.getX();
		assertEquals(yActual, 107);
	}
	
	
		@Test
	public void CollisionInWallLeft() {
		Player p = new Player(30, 80, 25, 25, game);
		p.collisionLeft();
		int Actual = p.getX();
		assertEquals(Actual, 30);
		}
	
	@Test
	public void CollisionInWallRight() {
		Player p = new Player(670, 80, 25, 25, game);
		p.collisionRight();
		int Actual = p.getX();
		assertEquals(Actual, 670);
		}
	
	@Test
	public void CollisionInWallDown() {
		Player p = new Player(30, 675, 25, 25, game);
		p.collisionDown();
		int Actual = p.getY();
		assertEquals(Actual, 675);
		}
	
	@Test
	public void CollisionInWallUp() {
		Player p = new Player(30, 80, 25, 25, game);
		p.collisionLeft();
		int Actual = p.getY();
		assertEquals(Actual, 80);
		}


}
