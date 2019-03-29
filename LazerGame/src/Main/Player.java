package Main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Player extends GameItem{
	
	int velX, velY;
	int treasuresLevel1 = 0;
	int health = 5;
	int startPosY;
	int startPosX;
	
	KeyManager keyManager = new KeyManager(); 
	
	public Player(int x, int y, int width, int height, Game game) {
		super(x, y, width, height, game);
	}
	
	public void KeyBindings() {
		keyManager.addKeyBinding(game, KeyEvent.VK_UP, "moveUp", (evt) -> {
			moveUp(5);
		});
		keyManager.addKeyBinding(game, KeyEvent.VK_DOWN, "moveDown", (evt) -> {
			moveDown(5);
		});
		keyManager.addKeyBinding(game, KeyEvent.VK_LEFT, "moveLeft", (evt) -> {
			moveLeft(5);
		});
		keyManager.addKeyBinding(game, KeyEvent.VK_RIGHT, "moveRight", (evt) -> {
			moveRight(5);
		});
	}
	
	@Override
	public void update() {
		dead();
	}

//	Painting player
	@Override
	public void render(Graphics g) {
		g.fillRect(x, y, width, height);		
	}	
	
	public void dead() {
		if (health == 0) {
			System.out.println("Dead");
			health = 5;
			System.out.println("Health = " + health);
		}
	}
	
//	If player collision down
	public void collisionDown() {
		for (int i = 0; i < game.laserBlockList.size(); i++) {
			LaserBlock l1 = game.laserBlockList.get(i);
			if (((l1.x<x && l1.x+l1.width>x) || (x<l1.x && x+width>l1.x)) && ((y<l1.y && y+height+5>l1.y))){
				y = l1.y - l1.height-5;
			}
		}
		
		for (int i = 0; i < Wall.wallList.size(); i++) {
			Wall w1 = Wall.wallList.get(i);
			if (((w1.x<x && w1.x+w1.width>x) || (x<w1.x && x+width>w1.x)) && ((y<w1.y && y+height+5>w1.y))){
				y = w1.y - w1.height-5;
			}
		}	
	}
	
//	If player collision up
	public void collisionUp() {
		for (int i = 0; i < game.laserBlockList.size(); i++) {
			LaserBlock l1 = game.laserBlockList.get(i);
			if (((l1.x<x && l1.x+l1.width>x) || (x<l1.x && x+width>l1.x)) && ((l1.y<y && l1.y+l1.height+5>y))){
				y = l1.y + l1.height+5;
			}
		}
		
		for (int i = 0; i < Wall.wallList.size(); i++) {
			Wall w1 = Wall.wallList.get(i);
			if (((w1.x<x && w1.x+w1.width>x) || (x<w1.x && x+width>w1.x)) && ((w1.y<y && w1.y+w1.height+5>y))){
				y = w1.y + w1.height+5;
			}
		}
	}

//	If player collision left
	public void collisionLeft() {
		for (int i = 0; i < game.laserBlockList.size(); i++) {
			LaserBlock l1 = game.laserBlockList.get(i);
			if (((l1.x<x && l1.x+l1.width+5>x))&&  ((l1.y<y && l1.y+l1.height>y) || (y<l1.y && y+height>l1.y))){
				x = l1.x + l1.width+5;
			}
		}	
		
		for (int i = 0; i < Wall.wallList.size(); i++) {
			Wall w1 = Wall.wallList.get(i);
			if (((w1.x<x && w1.x+w1.width+5>x))&&  ((w1.y<y && w1.y+w1.height>y) || (y<w1.y && y+height>w1.y))){
				x = w1.x + w1.width+5;
			}
		}	
	}
	
//	If player collision right
	public void collisionRight() {
		for (int i = 0; i < game.laserBlockList.size(); i++) {
			LaserBlock l1 = game.laserBlockList.get(i);
			if (((x<l1.x && x+width+5>l1.x)) && ((l1.y<y && l1.y+l1.height>y) || (y<l1.y && y+height>l1.y))){
				x = l1.x - l1.width-5;
			}
		}
		
		for (int i = 0; i < Wall.wallList.size(); i++) {
			Wall w1 = Wall.wallList.get(i);
			if (((x<w1.x && x+width+5>w1.x)) && ((w1.y<y && w1.y+w1.height>y) || (y<w1.y && y+height>w1.y))){
				x = w1.x - w1.width-5;
			}
		}
	}
	
//	Movement functions
	public int moveUp(int velY) {
		collisionUp();
		y -= velY;
		return y;
	}
	
	public int moveDown(int velY) {
		collisionDown();
		y += velY;
		return y;
	}
	
	public int moveLeft(int velX) {
		collisionLeft();
		x -= velX;	
		return x;
	}
	
	public int moveRight(int velX) {
		collisionRight();
		x += velX;
		return x;
	}
	
	public Rectangle getOffsetBounds() {
		return new Rectangle(x, y, width, height);
	}
	
//	Setters and getters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getStartPosY() {
		return startPosY;
	}

	public void setStartPosY(int startPosY) {
		this.startPosY = startPosY;
	}

	public int getStartPosX() {
		return startPosX;
	}

	public void setStartPosX(int startPosX) {
		this.startPosX = startPosX;
	}
	
	
}