package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Levels extends Canvas {
	
	
	/* 
	0 = spelyta
	1 = vägg
	2 = karaktär
	3= skatt
	4 = dörr
	5 = laser
	*/
	int x,y;
	public void paint(Graphics g) {
		Player p = new Player(x,y);
		p.paintComponent(g);
	}
	
	
	
	public void level1(Graphics g) {

		int[][] level1 = {
				{1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,1},
				{1,0,2,0,3,0,0,0,0,1},
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
