package Main;

import java.awt.Color;
import java.awt.Graphics;

public class Wall {
	
	int x;
	int y;
	


	public Wall(int x, int y) {
		this.x = x;
		this.y = y;
	}



	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, 25, 25);
		
	}

}
