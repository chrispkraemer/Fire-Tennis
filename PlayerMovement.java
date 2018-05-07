package game;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class PlayerMovement {

	
	private int dx;
	private int dy;
	private int x;
	private int y;
	private Image player;
	
	public PlayerMovement(){
		initPlayerMove();
	}

	private void initPlayerMove() {
		ImageIcon player = new ImageIcon(getClass().getResource("PlayerB_FT.png"));
		this.player = player.getImage();
		x = 40;
		y = 60;
	}
	
	public void move(){
		x += dx;
		y += dy;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Image getImage(){
		return this.player;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		
		if(key == KeyEvent.VK_LEFT){
			dx = -10;
		}
		if(key == KeyEvent.VK_RIGHT){
			dx = 10;
		}
		if(key == KeyEvent.VK_UP){
			dy = -10;
			
			
		}
		if(key == KeyEvent.VK_DOWN){
			dy = 10;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			dx = 0;
		}
		if(key == KeyEvent.VK_RIGHT){
			dx = 0;
		}
		if(key == KeyEvent.VK_UP){
			dy = 0;
		}
		if(key == KeyEvent.VK_DOWN){
			dy = 0;
		}
	}
}





