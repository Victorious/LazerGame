package Main;

import java.awt.Color;
import java.awt.Graphics;

public class Treasure extends GameItem {
	
	private int treasureCounter;
	
	public Treasure(int x, int y,int width,int height) {
		super(x,y,width,height);
	}
	
	public void render (Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	
}
