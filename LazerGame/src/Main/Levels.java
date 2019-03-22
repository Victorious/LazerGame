package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Levels extends JPanel implements KeyListener{
	
	
	
	/* 
	0 = spelyta
	1 = vägg
	2 = karaktär
	3 = skatt
	4 = dörr
	5 = laser
	*/

	int x=25,y=25;

	
	// Variables

	int playerX, playerY;
	int width = 25, height = 25;
	
	//Creating player and walls
	Player player = new Player(playerX, playerY ,25,25);
	Wall w = new Wall(x, y, width, height);
	
	//method for painting to canvas

	public void paint(Graphics g) {
		super.paintComponent(g);
		player = new Player(playerX, playerY, 25, 25);
		level1(g);
	}
	
	

	public void level1(Graphics g) {

		int[][] level1 = {

				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
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

				//System.out.print(level1[i][j]);
				
				if(level1[i][j]==1) {
				
				w = new Wall(j*25, i*25, width, height);
				w.paint(g);
				}
				if (level1[i][j] == 2) {
					if (playerX == 0 || playerY == 0) {
						playerX = j*25;
						playerY = i*25;	
					}
					player = new Player(playerX, playerY,25,25);
					player.paintComponent(g);
				}
				if (level1[i][j] == 3) {
					// Code of treasures
				}
				if (level1[i][j] == 4) {
					// Code of Dorr
				}
				if (level1[i][j] == 5) {
					// Code of Lazer
				}
			}

			//System.out.println();
		}
}
	
	
	
	public void moveUp() {
		if(y==25 || y==350 && x<275 || y==475 && x>225 && x<275) {
			
		}
		else {
		y -= 5;
		repaint();
		//System.out.println("y="+y);

		}
	}

	public void moveDown() {
		if(y==625 || y==300 && x<275 ) {
			
		}
		else {
		y += 5;
		repaint();
		//System.out.println("y="+y);
		}
	}
	public void moveLeft() {
		if(x==25 || (x==275 && y>300 && y<475)) {
			
		}
		else {
		x -= 5;
		repaint();
		//System.out.println("x="+x);
		}
	}
	public void moveRight() {
		if(x==675 || (x==225 && y>300 && y<475)) {
			
		}
		else {
		x += 5;
		repaint();
		//System.out.println("x="+x);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			moveUp();
		}
		if (key == KeyEvent.VK_DOWN) {
			moveDown();
		}
		if (key == KeyEvent.VK_LEFT) {
			moveLeft();
		}
		if (key == KeyEvent.VK_RIGHT) {
			moveRight();
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
