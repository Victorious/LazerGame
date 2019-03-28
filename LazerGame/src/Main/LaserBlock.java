package Main;

import java.awt.Color;
import java.awt.Graphics;

public class LaserBlock extends GameItem {

	public LaserBlock(int x, int y, int width, int height, Game game) {
		super(x, y, width, height, game);
	}

	@Override
	public void render(Graphics g) {		
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
