package Main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Player extends JComponent{


	int x,y;
	int velX = 10, velY = 10;
	int width = 25, height = 25;
	
	public Player(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

//	Painting player
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(x, y, width, height);
		repaint();
	}

//	Movement functions
	public void moveUp() {
		if(y==25) {
		}
		else {
		y -= velY;
		}
	}
	public void moveDown() {
		if(y==625) {
		}
		else {
		y += velY;
		}
	}
	public void moveLeft() {
		if(x==25) {
		}
		else {
			x -= velX;
		}
	}
	public void moveRight() {
		if(x==675) {
		}
		else {
			x += velX;
		}
	}
	
//	Setters and getters
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
