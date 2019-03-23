package Main;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Player extends JComponent{

	int x,y;
	int velX = 10, velY = 10;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
//	Painting player
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(x, y, 25, 25);
	}

//	Movement functions
	public void moveUp() {
		if(y==25 || y==350 && x<275 || y==475 && x>225 && x<275) {
		}
		else {
		y -= velY;
		}
	}
	public void moveDown() {
		if(x>660 || y==300 && x<275 ) {
			
		}
		else {
		y += velY;
		}
	}
	public void moveLeft() {
		if(x==25 || (x==275 && y>300 && y<475)) {
		}
		else {
			x -= velX;
		}
	}
	public void moveRight() {
		if(y==625 || (x==225 && y>300 && y<475)) {
		}
		else {
			x += velX;
		}
	}
	
//	Setters and Getters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
