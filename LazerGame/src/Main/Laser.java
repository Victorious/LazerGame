package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;



public class Laser extends GameItem {
	int end = y+55;
	int start = y;
	Timer t;
	public Laser(int x, int y, int width, int height, Game game) {
		super(x, y, width, height, game);
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(x+12, y+10, x+12, y+30);
		laserHitPlayer();
		
	}

	@Override
	public void update() {
		if (y == end) {
			y = start;
		}else {
			y += 1;
		}	

		
	}
	
	public void laserHitPlayer() {
		Rectangle r = game.player.getOffsetBounds();
		for (int i = 0; i < game.laserList.size(); i++) {
			Laser l = game.laserList.get(i);
			Rectangle r1 = l.getBounds();
			if (r.intersects(r1)) {
				game.player.health -= 1;
				System.out.println("Health = " + game.player.health);
				game.player.setX(game.player.startPosX);
				game.player.setY(game.player.startPosY);
				return;
			}
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x+12,y+10,5,25);
	}
}
