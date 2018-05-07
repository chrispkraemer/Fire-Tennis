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

public class Ball extends JPanel {

	private final int B_WIDTH = 1200;
	private final int B_HEIGHT = 900;
	private final int INIT_X = -40;
	private final int INIT_Y = -40;
	private final int INIT_DELAY = 10;
	private final int PERIOD_INTRVL = 2;

	private Image ball;
	private Image background;
	private Image background2;
	private Timer timer;
	private Timer backTimer;
	private int x, y;
	private double BackX;
	int increment = -400;
	int position = -400;
	int counter = -400;
	int origin = -400;
	int ox = 0;
	int px = 0;
	int cx = 0;
	int ix = 0;

	public Ball() {
		initBall();
		setOpaque(false);
	}

	private void loadImage() {
		ImageIcon ball = new ImageIcon(getClass().getResource("TennisBallGlow_FT.png"));
		this.ball = ball.getImage();
	}

	private void initBall() {
		setBackground(new Color(Color.TRANSLUCENT));
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);
		

		loadImage();

		x = INIT_X;
		y = INIT_Y;
		
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), INIT_DELAY, PERIOD_INTRVL);

	}

	private void drawBall(Graphics g) {

		g.drawImage(ball, x, y, this);
		Toolkit.getDefaultToolkit().sync();

	}

	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBall(g);
	}

	private class ScheduleTask extends TimerTask {
		int deltaX = 1;
		int deltaY = 1;
		double deltaBackX = -0.50;

		@Override
		public void run() {
			// TODO Auto-generated method stub

			BackX += deltaBackX;
			x += deltaX;
			y += deltaY;

			if (y > B_HEIGHT) {
				deltaY = -1;
			}
			if (x > B_WIDTH) {
				deltaX = -1;
			}
			if (y < 0) {
				deltaY = 1;
			}
			if (x < 0) {
				deltaX = 1;
			}

			repaint();
		}

	}

}
