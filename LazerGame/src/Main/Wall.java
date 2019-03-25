package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Wall extends GameItem {
		

	static ArrayList<Rectangle> wallList = new ArrayList<Rectangle>();
	
	int x;
	int y;
	int width;
	int height;
	Boolean visible;
	
	public Wall(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.visible = true;
	}

	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		
	}

//	Getters and Setters
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
	
	public void setVisisble(Boolean visible) {
		this.visible = visible;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
	
	public Rectangle setBounds(int x,int y,int width,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		return new Rectangle(x,y,width,height);
	}
	
}
