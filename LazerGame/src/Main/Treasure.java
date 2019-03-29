package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Treasure extends GameItem {
	
	Graphics g;
	
	public Treasure(int x, int y,int width,int height,Game game) {
		super(x,y,width,height, game);
	}
	
	public void render (Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(x, y, width, height);
		treasureCollect();
	}
	
	public void update() {
	}
	
	public void treasureCollect() {
		Rectangle r = game.player.getOffsetBounds();
		for (int i = 0; i < game.treasureList.size(); i++) {
			Treasure t = game.treasureList.get(i);
			Rectangle r1 = t.getBounds();
			if (r.intersects(r1)) {
				game.removeTreasure(t);
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
	
}
