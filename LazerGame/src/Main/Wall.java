package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Wall extends GameItem {
	
	ArrayList<Integer> wallPositionList = new ArrayList<Integer>();
	
	int x;
	int y;
	int width;
	int height;
	
	public Wall(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		
	}
}
