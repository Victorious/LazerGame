package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Window extends Canvas{
//	This class is not in use for the moment.
//	Window is beeing implemented directly in game class
	int height, width;
	
	JFrame frame;
	Canvas canvas;
	Graphics g;
	
	public Window(int height, int width) {
		this.height = height;
		this.width = width;
		
		createWindow();
	}
	
	
	public void createWindow() {
		Levels lvl = new Levels();
		frame = new JFrame("Title");
		frame.setSize(width, height);
		frame.show();

		frame.pack();
	}
	
	public JFrame getJFrame() {
		return frame;
	}
}
