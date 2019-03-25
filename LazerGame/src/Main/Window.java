package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Window extends Canvas{

	int height, width;
	JFrame frame;
	Canvas canvas;
	
	public Window(int height, int width) {
		this.height = height;
		this.width = width;
		createWindow();
	}
	
	
	public void createWindow() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	
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
