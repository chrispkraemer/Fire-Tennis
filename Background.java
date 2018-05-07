package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;




public class Background extends JPanel {
	private static final int B_WIDTH = 1200;
	private static final int B_HEIGHT = 900;
	private static final int INIT_X = 0;
	private static final int INIT_Y = 0;
	private int x = 0;
	private int y = 0;
	private Image background;
	private Timer backTimer;
	private int BackX1 = 0;
	private int BackX2 = 1600;
	private int BackX3 = 3200;
	private int X1count = 1;
	private int X2count = 2;
	
	public Background(){
		loadback();
		initback();
		setOpaque(true);
	}

	private void initback() {
		setBackground(new Color(Color.TRANSLUCENT));
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);

		

		//x = INIT_X;
		//y = INIT_Y;
		
		backTimer = new Timer();
		backTimer.scheduleAtFixedRate(new ScheduleTask(), 0, 60);

		
		
	}

	private void loadback() {
		ImageIcon back = new ImageIcon(getClass().getResource("background_FT.png"));
		this.background = back.getImage();
		
		
	}
	private void drawBack(Graphics g) {
		
		if(BackX2 <= 2 && BackX2 >-1){
			
			BackX1 = 1600;
			
		}
		//System.out.println(BackX2);
		g.drawImage(background, x+(int)BackX1,0, this);
		Toolkit.getDefaultToolkit().sync();

	}
	private void drawBack2(Graphics g) {
		if(BackX1 <= 2 && BackX1 > -1){
			
			BackX2 = 1600;
			
		}
		g.drawImage(background, x+(int)BackX2,0, this);
		Toolkit.getDefaultToolkit().sync();

	}
	private void drawBack3(Graphics g) {

		g.drawImage(background, x+(int)BackX3,0, this);
		Toolkit.getDefaultToolkit().sync();

	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBack(g);
		drawBack2(g);
		//drawBack3(g);
	}


private class ScheduleTask extends TimerTask{
	
	@Override
	public void run() {
		BackX1 +=-1;
		BackX2 +=-1;
		BackX3 +=-1;
		repaint();
	}
	
}
	
}