package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Window extends Canvas{

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
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public JFrame getJFrame() {
		return frame;
	}
	
	
	public Canvas getCanvas() {
		return canvas;
	}
	
}
