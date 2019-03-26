package Main;

import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class GameItem extends JComponent {

	int x,y;
	int width, height;
	
	public GameItem(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}	
}
