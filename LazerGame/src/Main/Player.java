package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Player extends GameItem{
	
	int  x,y;
	int velX, velY;
	int colX, colY;
	int width, height;
	
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

//	Painting player
	public void paint(Graphics g) {
		g.fillRect(x, y, width, height);
		
	}	
	
	public void collisionDown() {
		for (int i = 0; i < Wall.wallList.size(); i++) {
			Rectangle w1 = Wall.wallList.get(i);
			if (((w1.x<x && w1.x+w1.width>x) || (x<w1.x && x+width>w1.x)) && ((y<w1.y && y+height+5>w1.y))){
				y = w1.y - w1.height-5;
			}
		}
	}
	
	public void collisionUp() {
		
		for (int i = 0; i < Wall.wallList.size(); i++) {
			Rectangle w1 = Wall.wallList.get(i);
			if (((w1.x<x && w1.x+w1.width>x) || (x<w1.x && x+width>w1.x)) && ((w1.y<y && w1.y+w1.height+5>y))){
				y = w1.y + w1.height+5;
			}
		}
	}
	
	public void collisionLeft() {
		System.out.println(x);
		for (int i = 0; i < Wall.wallList.size(); i++) {
			Rectangle w1 = Wall.wallList.get(i);
			if (((w1.x<x && w1.x+w1.width+5>x))&&  ((w1.y<y && w1.y+w1.height>y) || (y<w1.y && y+height>w1.y))){
				x = w1.x + w1.width+5;
			}
		}
	}
	
	public void collisionRight() {
		System.out.println(x);
		for (int i = 0; i < Wall.wallList.size(); i++) {
			Rectangle w1 = Wall.wallList.get(i);
			if (((x<w1.x && x+width+5>w1.x)) && ((w1.y<y && w1.y+w1.height>y) || (y<w1.y && y+height>w1.y))){
				x = w1.x - w1.width-5;
			}
		}
	}
	
//	Movement functions
	public int moveUp(int velY) {
		collisionUp();
		y -= velY;
		return y;
	}
	
	public int moveDown(int velY) {
		collisionDown();
		y += velY;
		return y;
	}
	
	public int moveLeft(int velX) {
		collisionLeft();
		x -= velX;	
		return x;
	}
	
	public int moveRight(int velX) {
		collisionRight();
		x += velX;
		return x;
	}
	
	public Rectangle getOffsetBounds() {
		return new Rectangle(x, y, width, height);
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

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	
	
}
