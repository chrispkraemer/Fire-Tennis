package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class Game extends JPanel {

	public Game() {
		initUI();
	}

	private void initUI() {
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

		back_panel.add(new Background());

		game.add(top_panel);
		game.add(player_panel);
		game.add(back_panel);
	}

}
