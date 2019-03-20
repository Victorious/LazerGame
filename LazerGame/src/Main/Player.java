package Main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Player extends JPanel implements KeyListener, ActionListener{

	Timer tm = new Timer(5, this);
	Graphics g;
	
	int x,y;
	int velX = 2, velY;
	
	public Player(int x, int y) {
		this.x = x +1;
		this.y = y;
	}

	public void paint(Graphics g) {
		g.fillRect(x, y, 30, 30);		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {	
			System.out.println("pressed");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (x < 0 || x > 400) {
			velX = -velX;
		}
		x = x + velX;
		
	}


}
