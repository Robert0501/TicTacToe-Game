package prTikTakToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OnePlayerPanel {
	private static JPanel onePlayerPanel = new JPanel();
	protected static JFrame onePlayerFrame = new JFrame("One Player");

	private static JLabel fail = new JLabel();
	private static JLabel playerName = new JLabel("Insert player name");
	private static JTextField playerNameIn = new JTextField(20);

	private static JButton back = new JButton("Back");
	private static JButton start = new JButton("Start Game");

	protected static String name = "";

	public OnePlayerPanel() {
		frame();
		panel();
		insertName();
		fail();
		startGame();
		back();
	}

	private void frame() {
		onePlayerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		onePlayerFrame.setLocationRelativeTo(null);
		onePlayerFrame.setVisible(true);
		onePlayerFrame.add(onePlayerPanel);
		onePlayerFrame.setBounds(650, 400, 600, 300);
		try {
			onePlayerFrame.setIconImage(ImageIO.read(new File("src\\Images\\icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void panel() {
		onePlayerPanel.setLayout(null);
		onePlayerPanel.add(fail);
		onePlayerPanel.add(playerName);
		onePlayerPanel.add(playerNameIn);
		onePlayerPanel.add(start);
		onePlayerPanel.add(back);
	}

	private void insertName() {
		playerName.setBounds(40, 60, 220, 20);
		playerName.setFont(new Font("ARIAL", Font.BOLD, 20));
		playerNameIn.setBounds(300, 62, 220, 20);
	}

	private void startGame() {
		start.setBounds(350, 200, 200, 30);
		start.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				name = playerNameIn.getText();
				if (name.equals("")) {
					fail.setText("Player's name can not be empty");
				} else {
						new OnePlayerGame();
						StartPanel.startFrame.setVisible(false);
						onePlayerFrame.setVisible(false);
				}
			}
		});
	}

	private void fail() {
		fail.setBounds(110, 150, 400, 30);
		fail.setFont(new Font("ARIAL", Font.BOLD, 24));
		fail.setForeground(Color.red);
	}

	private void back() {
		back.setBounds(20, 200, 200, 30);
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				onePlayerFrame.setVisible(false);
				onePlayerPanel.remove(playerNameIn);
			}
		});
	}
}
