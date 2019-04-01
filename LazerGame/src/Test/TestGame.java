package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Main.Game;
import Main.Laser;
import Main.LaserBlock;
import Main.Player;
import Main.Treasure;

public class TestGame {

	Game game;
	
	@Before
	public void initVarAndClasses() {
		game = new Game();
	}
	
	@Test
	public void testAddTreasure() {
		Treasure t = new Treasure(25, 50, 25, 25, game);
		ArrayList<Treasure> treasureList = game.getTreasureList();
		game.addTreasure(t);
		assertEquals(1, treasureList.size());
	}
	
	@Test
	public void testRemoveTreasure() {
		Treasure t = new Treasure(25, 50, 25, 25, game);
		ArrayList<Treasure> treasureList = game.getTreasureList();
		treasureList.add(t);
		treasureList.add(t);
		game.removeTreasure(t);
		assertEquals(1, treasureList.size());
	}
	
	@Test
	public void testAddLaser() {
		Laser l = new Laser(25, 50, 5, 10, game);
		ArrayList<Laser> laserList = game.getLaserList();
		game.addLaser(l);
		assertEquals(1, laserList.size());
	}
	
	@Test
	public void testRemoveLaser() {
		Laser l = new Laser(25, 50, 5, 10, game);
		ArrayList<Laser> laserList = game.getLaserList();
		laserList.add(l);
		laserList.add(l);
		game.removeLaser(l);
		assertEquals(1, laserList.size());
	}
	
	@Test
	public void testAddLaserBlock() {
		LaserBlock lb = new LaserBlock(25, 50, 5, 10, game);
		ArrayList<LaserBlock> laserBlockList = game.getLaserBlockList();
		game.addLaserBlock(lb);
		assertEquals(1, laserBlockList.size());
	}
	
	@Test
	public void testIfPlayerGotTreasure() {
		Treasure t = new Treasure(50, 80, 10, 10, game);
		Player p = new Player(50, 80, 25, 25, game, 5);
		
		int treasureCount = p.getTreasuresLevel1();
		game.removeTreasure(t);
		assertEquals(1, treasureCount);
	}
}
