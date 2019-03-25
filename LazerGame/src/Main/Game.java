package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Game implements Runnable{

	private static final long serialVersionUID = 1L;
	
	int height = 725;
	int width = 745;
	KeyManager keyManager;
	Levels lvl = new Levels();
	Window window;
	Thread thread;
	
	Graphics g;
	
	boolean isRunning = false;
	
	public Game() {
		keyManager = new KeyManager();
	}
		
//	Initilizing startup entitys
	public void init() {
		window = new Window(height, width);
		window.getJFrame().add(lvl);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}



//	Running the game loop
	public void run() {
		init();
		
//		Game Loop timer
		int fps = 60;
		double timePerTick = 1000000000/ fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
			
		
		while (isRunning) {
			now = System.nanoTime();
			delta += (now - lastTime)/ timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
//			keep fps to 60fps
			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}
	
		}
		stop();
	}
	
//	Starting the thread
	public synchronized void start() {
		if (isRunning) {
			return;
		}
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
//	Stopping the thread
	public synchronized void stop() {
		if(!isRunning) {
			return;
		}
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void render() {
		BufferStrategy bs = window.getCanvas().getBufferStrategy();
		if (bs == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		lvl.paint(g);
		lvl.level1(g);

		g.dispose();
		bs.show();
		
	}

	public void update() {
		KeyBindings();
	}
	
	// All Graphics goes here

//	public void collisionUp() {
//		boolean colide = false;
//		Rectangle r3 = lvl.player.getOffsetBounds();
//		for (int i = 0; i < lvl.list.size(); i++) {
//			Rectangle w1 = lvl.list.get(i);
//			if (r3.intersects(w1)) {
//				System.out.println("Player y = " + lvl.player.y + " Player x = " + lvl.player.x);
//				lvl.player.y += 5;
//				colide = false;
//				break;
//			}
//		}	
//	}
//
//	public void collisionDown() {
//		Rectangle r3 = lvl.player.getOffsetBounds();
//		for (int i = 0; i < lvl.list.size(); i++) {
//			Rectangle w1 = lvl.list.get(i);
//			if (r3.intersects(w1)) {
//				System.out.println("Player y = " + lvl.player.y + " Player x = " + lvl.player.x);
//				System.out.println(w1);
//				lvl.player.y -= 5;
//				break;
//			}
//		}
//	}
//	public void collisionLeft() {
//		Rectangle r3 = lvl.player.getOffsetBounds();
//		for (int i = 0; i < lvl.list.size(); i++) {
//			Rectangle w1 = lvl.list.get(i);
//			if (r3.intersects(w1)) {
//
//			}
//		}
//	}
//	public void collisionRight() {
//		Rectangle r3 = lvl.player.getOffsetBounds();
//		for (int i = 0; i < lvl.list.size(); i++) {
//			Rectangle w1 = lvl.list.get(i);
//			if (r3.intersects(w1)) {
//
//			}
//		}
//	}
	
//	Getting key Bindings
	public void KeyBindings() {
		keyManager.addKeyBinding(lvl, KeyEvent.VK_UP, "moveUp", (evt) -> {

			lvl.player.moveUp(5);
		});
		keyManager.addKeyBinding(lvl, KeyEvent.VK_DOWN, "moveDown", (evt) -> {

			lvl.player.moveDown(5);
		});
		keyManager.addKeyBinding(lvl, KeyEvent.VK_LEFT, "moveLeft", (evt) -> {

			lvl.player.moveLeft(5);
		});
		keyManager.addKeyBinding(lvl, KeyEvent.VK_RIGHT, "moveRight", (evt) -> {
		
			lvl.player.moveRight(5);
		});
	}



}