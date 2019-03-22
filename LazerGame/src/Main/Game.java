package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game implements Runnable{

	static int height = 710;
	static int width = 730;

	int x,y;

	Levels lvl = new Levels();
	JFrame frame = new JFrame();
	
	Graphics g;
	public static void main(String[] args) {
		new Game();
	}

	// Constructor for Game class, implementing the running method
	public Game() {
		createWindow();
		run();
	}

	// Run method
	public void run() {
		render();
	}
	
	// All Graphics goes here
	public void render() {
		frame.add(lvl);
	}
	
	
//	Creating window GUI
	public void createWindow() {
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
		frame.addKeyListener(lvl);
	}
}