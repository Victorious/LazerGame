package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Wall extends GameItem {
		

	static ArrayList<Wall> wallList = new ArrayList<Wall>();

	
	public Wall(int x, int y, int width, int height,Game game) {
		super(x,y,width,height,game);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		
	}
	
	@Override
	public void update() {
		
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
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}

}
