package Main;


import java.awt.Graphics;
import java.awt.PopupMenu;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JComponent implements Runnable{

	int height = 780;
	int width = 745;

	int itemHeight = 25;
	int itemWidth = 25;
	
	int x,y;
//	Item lists
	ArrayList<Treasure> treasureList = new ArrayList<Treasure>();
	ArrayList<Laser> laserList = new ArrayList<Laser>();
	ArrayList<LaserBlock> laserBlockList = new ArrayList<LaserBlock>();
	
//	Creating objects	
	Levels lvl = new Levels(this);
	Laser tempLaser = new Laser(x, y, itemWidth, height, this);
	Player player = new Player(x, y, itemWidth, itemHeight, this);
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
		init();
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
	}
	
//	Game Loop
	public void run() {
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
				render();
				update(); 	
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}
		}
	}
//	Updating the game
	public void update() {
		player.KeyBindings();
		player.update();
//		Updating each laser
		for (int i = 0; i <laserList.size(); i	++) {
			tempLaser = laserList.get(i);	
			tempLaser.update();
		}
	
	}
	
//	All Graphics goes here
	public void render() {
		window.getJFrame().add(this);
		bs = window.getCanvas().getBufferStrategy();
		if (bs == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		player.render(g);
		lvl.level1(g);
		
//		Drawing each laser
		for (int i = 0; i < laserList.size(); i	++) {
			tempLaser = laserList.get(i);	
			tempLaser.render(g);
		}
		bs.show();
		g.dispose();
		
	}
	
	public void addTreasure(Treasure block) {
		treasureList.add(block);
	}

	public void removeTreasure(Treasure block) {
		treasureList.remove(block);
		player.treasuresLevel1 += 1;
		System.out.println("You got " + player.treasuresLevel1 + " treasures");
		if (player.treasuresLevel1 == 5) {
			System.out.println("Congrats you cleared level1");
		}
	}
	
	public void addLaser(Laser block) {
		laserList.add(block);
	}
	
	public void removeLaser(Laser block) {
		laserList.remove(block);
	}

	public void addLaserBlock(LaserBlock block) {
		laserBlockList.add(block);
	}

}