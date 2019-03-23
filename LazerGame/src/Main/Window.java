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
	
		frame.pack();
	}
	
	public JFrame getJFrame() {
		return frame;

	}	
}
