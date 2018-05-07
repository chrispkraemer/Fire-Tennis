package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Player extends JPanel implements ActionListener {
	
	private Timer timer;
	private PlayerMovement player;
	private final int DELAY = 10;
	
	public Player(){
		initPlayer();
	}

	private void initPlayer() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		//setDoubleBuffered(true);
		setOpaque(false);
		
		
		this.player = new PlayerMovement();
		
		timer = new Timer(DELAY, this);
		timer.start();
		
			
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		doDrawing(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		player.move();
		repaint();
	}

	private class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e){
			player.keyReleased(e);
		}
		@Override
		public void keyPressed(KeyEvent e){
			player.keyPressed(e);
			System.out.println(player.getX());
		}
	}
}
