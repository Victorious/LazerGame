package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Timer;

public class Laser extends GameItem {
	int end = y+50;
	Timer t;
	public Laser(int x, int y, int width, int height, Game game) {
		super(x, y, width, height, game);
	}

	@Override
	public void render(Graphics g) {
		repaint();
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(x+12, y+30, x+12, y+25);		

		
	}

	@Override
	public void update() {

	
		if (y == end) {
	
		}else {
			y += 2;
		}	
	}
}
