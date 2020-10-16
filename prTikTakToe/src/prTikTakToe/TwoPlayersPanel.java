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

public class TwoPlayersPanel {
	private static JPanel twoPlayersPanel = new JPanel();
	private static JFrame twoPlayersFrame = new JFrame("Two Players");

	private static JLabel fail = new JLabel();

	private static JLabel playerOneName = new JLabel("Insert player one name");
	private static JTextField playerOneNameIn = new JTextField(20);
	private static JLabel playerTwoName = new JLabel("Insert player two name");
	private static JTextField playerTwoNameIn = new JTextField(20);

	private static JButton back = new JButton("Back");
	private static JButton start = new JButton("Start Game");

	protected static String nameOne = "";
	protected static String nameTwo = "";

	public TwoPlayersPanel() {
		frame();
		panel();
		insertName();
		fail();
		startGame();
		back();
	}

	private void frame() {
		twoPlayersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		twoPlayersFrame.setLocationRelativeTo(null);
		twoPlayersFrame.setVisible(true);
		twoPlayersFrame.add(twoPlayersPanel);
		twoPlayersFrame.setBounds(650, 400, 600, 300);
		try {
			twoPlayersFrame.setIconImage(ImageIO.read(new File("src\\Images\\icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void panel() {
		twoPlayersPanel.setLayout(null);
		twoPlayersPanel.add(fail);
		twoPlayersPanel.add(playerOneName);
		twoPlayersPanel.add(playerOneNameIn);
		twoPlayersPanel.add(playerTwoName);
		twoPlayersPanel.add(playerTwoNameIn);
		twoPlayersPanel.add(start);
		twoPlayersPanel.add(back);
	}

	private void insertName() {
		playerOneName.setBounds(40, 60, 220, 20);
		playerOneName.setFont(new Font("ARIAL", Font.BOLD, 20));
		playerOneNameIn.setBounds(300, 62, 220, 20);

		playerTwoName.setFont(new Font("ARIAL", Font.BOLD, 20));
		playerTwoName.setBounds(40, 100, 220, 20);
		playerTwoNameIn.setBounds(300, 102, 220, 20);
	}

	private void startGame() {
		start.setBounds(350, 200, 200, 30);
		start.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				nameOne = playerOneNameIn.getText();
				nameTwo = playerTwoNameIn.getText();
				if (nameOne.equals("")) {
					fail.setText("Player one name can not be empty");
				} else if (nameTwo.equals("")) {
					fail.setText("Player two name can not be empty");
				} else if (nameOne.equals(nameTwo)) {
					fail.setText("Both players name are the same");
				} else {
					new TwoPlayersGame();
					StartPanel.startFrame.setVisible(false);
					twoPlayersFrame.setVisible(false);
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
				twoPlayersFrame.setVisible(false);
				twoPlayersPanel.remove(playerOneNameIn);
				twoPlayersPanel.remove(playerTwoNameIn);
			}
		});
	}
}
