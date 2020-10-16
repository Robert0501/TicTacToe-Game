package prTikTakToe;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel {
	protected static JFrame startFrame = new JFrame("TicTacToe");
	private static JPanel startPanel = new JPanel();

	private static JLabel welcome = new JLabel();

	private static JButton onePlayer = new JButton("One Player");
	private static JButton twoPlayers = new JButton("Two Players");
	private static JButton exit = new JButton("Exit");

	public StartPanel() {
		panel();
		frame();
		welcome();
		onePlayer();
		twoPlayers();
		exit();
	}

	private void panel() {
		startPanel.setLayout(null);
		startPanel.setBackground(Color.black);
		startPanel.add(welcome);
		startPanel.add(onePlayer);
		startPanel.add(twoPlayers);
		startPanel.add(exit);
	}

	private void frame() {
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setLocationRelativeTo(null);
		startFrame.setVisible(true);
		startFrame.add(startPanel);
		startFrame.setBounds(550, 20, 800, 1000);
		try {
			startFrame.setIconImage(ImageIO.read(new File("src\\Images\\icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void welcome() {
		welcome.setBounds(0, 0, 1000, 500);
		welcome.setIcon(new ImageIcon("src\\Images\\welcome.png"));
	}

	private void onePlayer() {
		onePlayer.setBounds(300, 600, 200, 40);
		onePlayer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new OnePlayerPanel();
			}
		});
	}

	private void twoPlayers() {
		twoPlayers.setBounds(300, 650, 200, 40);
		twoPlayers.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new TwoPlayersPanel();
			}
		});
	}

	private void exit() {
		exit.setBounds(300, 700, 200, 40);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
