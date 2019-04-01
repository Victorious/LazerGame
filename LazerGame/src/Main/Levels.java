package Main;

import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Levels extends JComponent{
	
	
	/* 
	0 = spelyta
	1 = vägg
	2 = karaktär
	3 = skatt
	4 = dörr
	5 = laser
	9 = status
	*/
	
	// Variables
	int gameStarted = 1;
	int width = 30, height = 30;
	int x,y;
	int treasurCount = 0;
	int laserCount = 0;
	int numberLaserBlock = 3;
	int[][] level1;
	
	//Creating objects
	Game game;
	Wall w = new Wall(x, y, width, height,game);
	Treasure temptreasure;
	LaserBlock tempLaserBlock;
	Laser tempLaser;
	
	public Levels(Game game) {
		this.game = game;
	}

	public void render(Graphics g) {
		level1(g);
	}
	
	public void level1(Graphics g) {
		
		level1 = new int[][]{
				{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
				{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,3,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,3,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
			};
//		Loop for checking each pixel in the canvas and printing depended on which number each pixel precent

			for (int i = 0; i < level1.length; i++) {

				for (int j = 0; j < level1[i].length; j++) {
					
					if(level1[i][j]==1) {
					w = new Wall(j*25, i*25, width, height,game);
					w.render(g);
					Wall.wallList.add(w);
					}
					if (level1[i][j] == 2) {
						if (gameStarted == 1) {
						game.player.setX(j*25);
						game.player.setY(i*25);
						game.player.setStartPosX(j*25);
						game.player.setStartPosY(i*25);
						}
						gameStarted = 0;
					}
					if (level1[i][j] == 3) {
						if (treasurCount < 5) {
							treasurCount = treasurCount + 1;
							game.addTreasure(new Treasure(j*25, i*25, 15, 15, game));
						}
						for (int j2 = 0; j2 < game.treasureList.size(); j2++) {
							if (j2 <= 5) {
								temptreasure = game.treasureList.get(j2);
								temptreasure.render(game.g);
							}
						}	
					}
					if (level1[i][j] == 4) {
						// Code of Dorr
					}
					if (level1[i][j] == 5) {
						if (laserCount < numberLaserBlock) {
							game.addLaserBlock(new LaserBlock(j*25, i*25, width, height, game));
							game.addLaser(new Laser(j*25, i*25, 5, 25, game));
							laserCount = laserCount + 1;
						}

						for (int j2 = 0; j2 < game.laserBlockList.size(); j2++) {
							if (j2 <= 5) {
								tempLaserBlock = game.laserBlockList.get(j2);
								tempLaserBlock.render(game.g);
							}
						}	
					}		
				}
			}
		}
	public int[][] getLevel1() {
		return level1;
	}

	public void setLevel1(int[][] level1) {
		this.level1 = level1;
	}	
}