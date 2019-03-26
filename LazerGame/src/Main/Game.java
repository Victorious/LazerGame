package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	static int height = 725;
	static int width = 745;

	int x,y;
	KeyManager keyManager = new KeyManager();
	Levels lvl = new Levels();
	Window window;
	Boolean isRunning = false;
	Thread thread;
	BufferStrategy bs;
	Graphics g;
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

	// Constructor for Game class, implementing the running method
	public Game() {
		run();
	}

//	Starting thread
	public synchronized void start() {
		if(isRunning)
			return;
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
//	Stopping thread
	public synchronized void stop() {
		if(!isRunning)
			return;
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	Initilizing startup
	public void init() {
		window = new Window(height, width);
		KeyBindings();
	}
	
//	Game Loop
	public void run() {
		init();
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		long ticks = 0;
		
		while (isRunning) {
		now = System.nanoTime();
		delta += (now - lastTime) / timePerTick;
		timer += now - lastTime;
		lastTime = now;
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
	}
	
	public void treasureCollect(Graphics g) {
		Rectangle r = lvl.player.getOffsetBounds();
		for (int i = 0; i < Treasure.treasureList.size(); i++) {
			Treasure t = Treasure.treasureList.get(i);
			Rectangle r1 = t.getBounds();
			if (r.intersects(r1)) {
				System.out.println("tres");
				g.setColor(Color.green);
				g.fillRect(t.x, t.y, t.width, t.height);
				g.clearRect(t.x, t.y, t.width, t.height);

				repaint();
				
				
			}
		}
	}
//	Updating the game
	public void update() {

	}
	
	// All Graphics goes here
	public void render() {
		window.getJFrame().add(lvl);
		bs = window.getCanvas().getBufferStrategy();
		if (bs == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		treasureCollect(g);
		lvl.paint(g);
		lvl.level1(g);
		
		bs.show();
		g.dispose();
		
	}
	
//	KeyBindings for movement
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