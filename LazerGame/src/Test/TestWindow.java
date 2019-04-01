package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Main.Window;

public class TestWindow {
	Window w;
	
	@Before
	public void initClasses() {
		w = new Window(200, 200);	
	}
	
//	Testing if canvas or JFrame is null, if they are not null GUI works
	@Test
	public void testFrameNotNull() {
		assertNotNull(w.getJFrame());
	}
	
	@Test
	public void testCanvasNotNull() {
		assertNotNull(w.getCanvas());
	}
}
