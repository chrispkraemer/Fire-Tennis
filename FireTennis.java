package game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;

public class FireTennis extends JFrame {
	
	private Image background;
	private JFrame game;
	public FireTennis(){
		//initUI();
	}

	private void initUI() {
		
//		game.add(new Background());
//		game.add(new Ball());
//		
//		game.setResizable(false);
//		game.pack();
//		game.setTitle("FIRE TENNIS");
//		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		add(game);
		
	}
	
	public static void main(String[] args){
		
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Fire Tennis");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(1200, 900);
		main_frame.setLayout(new BorderLayout());
		
//		JPanel game = new JPanel();
//		game.add(new Game());
		
		JPanel game = new JPanel();
		game.setLayout(new OverlayLayout(game));

		JPanel back_panel = new JPanel();
		JPanel top_panel = new JPanel();
		JPanel player_panel = new JPanel();
		player_panel.setLayout(new OverlayLayout(player_panel));

		top_panel.add(new Ball());
		top_panel.setOpaque(false);

		player_panel.add(new Player());

		player_panel.setOpaque(false);
		player_panel.setDoubleBuffered(true);

		back_panel.add(new Background());

		game.add(top_panel);
		game.add(player_panel);
		game.add(back_panel);
		game.setDoubleBuffered(true);
		
		
		//main_frame.setContentPane(game);
		main_frame.add(game);
		//main_frame.add(new Player());
		main_frame.setPreferredSize(new Dimension(1200, 900));
		//main_frame.setResizable(false);
		main_frame.setLocationRelativeTo(null);
		main_frame.setIgnoreRepaint(true);
		//main_frame.setResizable(resizable);
		
		main_frame.pack();
		main_frame.setVisible(true);
		

	}
	
			
	

}
