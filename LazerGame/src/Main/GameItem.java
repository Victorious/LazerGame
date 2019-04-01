package Main;

import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public abstract class GameItem extends JComponent {

	int x,y;
	int width, height;
	Game game;
	
	public GameItem(int x, int y, int width, int height, Game game) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.game = game;
	}	
	
	abstract public void render(Graphics g);
	abstract public void update();
}
