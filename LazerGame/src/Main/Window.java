package Main;

import javax.swing.JFrame;

public class Window {

	int height, width;
	
	JFrame frame;
	
	
	public Window(int height, int width) {
		this.height = height;
		this.width = width;
		
		createWindow();
	}
	
	public void createWindow() {
		frame = new JFrame("Title");
		frame.setSize(width, height);
		frame.show();
	}
	
}
