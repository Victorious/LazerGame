package Main;

import java.awt.Graphics;

public abstract class GameItem {

	int x,y;
	int width, height;
	
	public GameItem(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
}
