package Main;

public class Game implements Runnable {
	
	int height = 725, width = 725;
	public static void main(String[] args) {
		new Game();
	}
	
	// Constructor for Game class, implementing the running method
	public Game() {
		run();
	}
	
	// Run method
	@Override
	public void run() {
		new Window(height, width);	
	}
	
	

}
