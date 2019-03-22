package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Player extends GameItem{

	Graphics g;
	int x,y;
	int width, height;
	
	public Player(int x, int y, int width, int height) {
		super(x,y,width,height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	/*public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(x, y, 25, 25);
	}

	public void moveUp() {
		y -= 10;
		repaint();
	}
	public void moveDown() {
		y += 10;
		repaint();
	}
	public void moveLeft() {
		x -= 10;
		repaint();
	}
	public void moveRight() {
		x += 10;
		repaint();
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			moveUp();
		}
		if (key == KeyEvent.VK_DOWN) {
			moveDown();
		}
		if (key == KeyEvent.VK_LEFT) {
			moveLeft();
		}
		if (key == KeyEvent.VK_RIGHT) {
			moveRight();
		}	
	}*/

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
}
