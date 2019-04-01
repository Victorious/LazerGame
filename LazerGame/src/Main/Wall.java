package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

@SuppressWarnings("serial")
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

	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}

}
