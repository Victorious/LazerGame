package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Treasure extends GameItem {
	
	static ArrayList<Treasure> treasureList = new ArrayList<Treasure>();
	
	private int treasureCounter;
	
	Boolean isVisible;
	int x,y;
	int width, height;
	Graphics g;
	public Treasure(int x, int y,int width,int height) {
		super(x,y,width,height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void render (Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);	
	}
	
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void isVisible(Graphics g) {	
	}
	
	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
	
}
