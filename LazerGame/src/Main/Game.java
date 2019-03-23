package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Game implements Runnable{

	static int height = 725;
	static int width = 745;

	int x,y;
	KeyManager keyManager = new KeyManager();
	Levels lvl = new Levels();
	Window window;
	public static void main(String[] args) {
		new Game();
	}

	// Constructor for Game class, implementing the running method
	public Game() {
		window = new Window(height, width);
		run();
	}

	// Run method
	public void run() {
		render();
		KeyBindings();
	}
	
	// All Graphics goes here
	public void render() {
		window.getJFrame().add(lvl);
	}

	
//	Creating window GUI

	public void KeyBindings() {
		keyManager.addKeyBinding(lvl, KeyEvent.VK_UP, "moveUp", (evt) -> {
			lvl.player.moveUp();
		});
		keyManager.addKeyBinding(lvl, KeyEvent.VK_DOWN, "moveDown", (evt) -> {
			lvl.player.moveDown();
		});
		keyManager.addKeyBinding(lvl, KeyEvent.VK_LEFT, "moveLeft", (evt) -> {
			lvl.player.moveLeft();
		});
		keyManager.addKeyBinding(lvl, KeyEvent.VK_RIGHT, "moveRight", (evt) -> {
			lvl.player.moveRight();
		});
	}

}