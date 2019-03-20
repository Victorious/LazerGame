package Main;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Levels extends Canvas {
	
	/* 
	0 = spelyta
	1 = vägg
	2 = karaktär
	3= skatt
	4 = dörr
	5 = laser
	*/
	
	public void paint(Graphics g) {
		level1(g);
	}
	
	
	
	public void level1(Graphics g) {
		Player p = new Player(10,10);
		p.paint(g);
		int[][] level1 = {
				{1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1}
			};
		
		for (int i = 0; i < level1.length; i++) {
			for (int j = 0; j < level1[i].length; j++) {
				System.out.print(level1[i][j]);
			}
			System.out.println();
		}

	}
	
}
