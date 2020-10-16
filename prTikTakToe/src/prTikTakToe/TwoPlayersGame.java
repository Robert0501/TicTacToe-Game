package prTikTakToe;

import java.awt.Color;
import java.awt.Font;
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

public class TwoPlayersGame {
	protected static JFrame gameFrame = new JFrame("TicTacToe");
	protected static JPanel gamePanel = new JPanel();

	protected static JLabel gameBoard = new JLabel();
	protected static JLabel score = new JLabel("SCORE:");
	protected static JLabel playerTurn = new JLabel();
	protected static JLabel playerOneSign = new JLabel();
	protected static JLabel playerTwoSign = new JLabel();
	protected static JLabel nameOne = new JLabel();
	protected static JLabel nameTwo = new JLabel();
	protected static JLabel win = new JLabel();
	protected static JLabel signs = new JLabel("SIGNS:");

	private static JButton firstCell = new JButton();
	private static JButton secondCell = new JButton();
	private static JButton thirdCell = new JButton();
	private static JButton forthCell = new JButton();
	private static JButton fifthCell = new JButton();
	private static JButton sixthCell = new JButton();
	private static JButton seventhCell = new JButton();
	private static JButton eigthCell = new JButton();
	private static JButton ninthCell = new JButton();

	private static JButton back = new JButton("Back");
	private static JButton exit = new JButton("Exit");

	private static int turn = 1;
	private static int x[] = new int[9];
	private static boolean vector[] = new boolean[9];
	private static int oneScore = 0;
	private static int twoScore = 0;

	public TwoPlayersGame() {
		panel();
		frame();
		gameBoard();
		firstCell();
		secondCell();
		thirdCell();
		forthCell();
		fifthCell();
		sixthCell();
		seventhCell();
		eigthCell();
		ninthCell();
		playerTurn();
		score();
		signs();
		nameOne();
		nameTwo();
		playerOneSign();
		playerTwoSign();
		win();
		back();
		exit();
		for (int j = 0; j < 9; j++)
			vector[j] = false;
	}

	private void panel() {
		gamePanel.setLayout(null);
		gamePanel.setBackground(Color.lightGray);
		gamePanel.add(gameBoard);
		gamePanel.add(score);
		gamePanel.add(nameOne);
		gamePanel.add(nameTwo);
		gamePanel.add(firstCell);
		gamePanel.add(secondCell);
		gamePanel.add(thirdCell);
		gamePanel.add(forthCell);
		gamePanel.add(fifthCell);
		gamePanel.add(sixthCell);
		gamePanel.add(seventhCell);
		gamePanel.add(eigthCell);
		gamePanel.add(ninthCell);
		gamePanel.add(playerTurn);
		gamePanel.add(playerOneSign);
		gamePanel.add(playerTwoSign);
		gamePanel.add(signs);
		gamePanel.add(back);
		gamePanel.add(exit);
	}

	private void frame() {
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);
		gameFrame.add(gamePanel);
		gameFrame.setBounds(600, 20, 640, 1000);
		try {
			gameFrame.setIconImage(ImageIO.read(new File("src\\Images\\icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void gameBoard() {
		gameBoard.setIcon(new ImageIcon("src\\Images\\board.png"));
		gameBoard.setBounds(10, 110, 600, 600);
	}

	private void firstCell() {
		firstCell.setBackground(Color.white);
		firstCell.setBounds(13, 113, 195, 195);
		firstCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(firstCell, 0);
			}
		});
	}

	private void secondCell() {
		secondCell.setBackground(Color.white);
		secondCell.setBounds(213, 113, 195, 195);
		secondCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(secondCell, 1);
			}
		});
	}

	private void thirdCell() {
		thirdCell.setBackground(Color.white);
		thirdCell.setBounds(413, 113, 195, 195);
		thirdCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(thirdCell, 2);
			}
		});
	}

	private void forthCell() {
		forthCell.setBackground(Color.white);
		forthCell.setBounds(13, 313, 195, 195);
		forthCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(forthCell, 3);
			}
		});
	}

	private void fifthCell() {
		fifthCell.setBackground(Color.white);
		fifthCell.setBounds(213, 313, 195, 195);
		fifthCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(fifthCell, 4);
			}
		});
	}

	private void sixthCell() {
		sixthCell.setBackground(Color.white);
		sixthCell.setBounds(413, 313, 195, 195);
		sixthCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(sixthCell, 5);
			}
		});
	}

	private void seventhCell() {
		seventhCell.setBackground(Color.white);
		seventhCell.setBounds(13, 513, 195, 195);
		seventhCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(seventhCell, 6);
			}
		});
	}

	private void eigthCell() {
		eigthCell.setBackground(Color.white);
		eigthCell.setBounds(213, 513, 195, 195);
		eigthCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(eigthCell, 7);
			}
		});
	}

	private void ninthCell() {
		ninthCell.setBackground(Color.white);
		ninthCell.setBounds(413, 513, 195, 195);
		ninthCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(ninthCell, 8);
			}
		});
	}

	private void put(JButton button, int i) {

		switch (turn) {
		case 1:
			if (!vector[i]) {
				button.setIcon(new ImageIcon("src\\Images\\x.png"));
				playerTurn.setForeground(Color.green);
				playerTurn.setText("Now it's " + TwoPlayersPanel.nameTwo + "'s turn");
				turn = 2;
				x[i] = 1;
				vector[i] = true;
			}
			break;

		case 2:
			if (!vector[i]) {
				button.setIcon(new ImageIcon("src\\Images\\0.png"));
				playerTurn.setForeground(Color.red);
				playerTurn.setText("Now it's " + TwoPlayersPanel.nameOne + "'s turn");
				turn = 1;
				x[i] = 2;
				vector[i] = true;
			}
			break;
		}
		winCalculator();
	}

	private void signs() {
		signs.setBounds(300, 750, 200, 40);
		signs.setFont(new Font("ARIAL", Font.BOLD, 24));
	}

	private void playerOneSign() {
		playerOneSign.setBounds(420, 740, 200, 20);
		playerOneSign.setText(TwoPlayersPanel.nameOne + " -> X");
		playerOneSign.setFont(new Font("ARIAL", Font.BOLD, 20));
		playerOneSign.setForeground(Color.red);
	}

	private void playerTwoSign() {
		playerTwoSign.setBounds(420, 770, 200, 20);
		playerTwoSign.setText(TwoPlayersPanel.nameTwo + " -> 0");
		playerTwoSign.setFont(new Font("ARIAL", Font.BOLD, 20));
		playerTwoSign.setForeground(Color.green);
	}

	private void playerTurn() {
		playerTurn.setBounds(110, 25, 600, 35);
		playerTurn.setFont(new Font("ARIAL", Font.BOLD, 35));
		playerTurn.setText("Now it's " + TwoPlayersPanel.nameOne + "'s turn");
		playerTurn.setForeground(Color.red);
	}

	protected static void score() {
		score.setFont(new Font("ARIAL", Font.BOLD, 24));
		score.setBounds(10, 750, 200, 40);
		nameOne.setText(TwoPlayersPanel.nameOne + ": " + oneScore);
		nameTwo.setText(TwoPlayersPanel.nameTwo + ": " + twoScore);

	}

	private void nameOne() {
		nameOne.setBounds(130, 740, 200, 20);
		nameOne.setFont(new Font("ARIAL", Font.BOLD, 20));
		nameOne.setForeground(Color.red);
	}

	private void nameTwo() {
		nameTwo.setBounds(130, 770, 200, 20);
		nameTwo.setFont(new Font("ARIAL", Font.BOLD, 20));
		nameTwo.setForeground(Color.green);
	}

	private boolean draw() {
		if ((x[0] == 1 || x[0] == 2) && (x[1] == 1 || x[1] == 2) && (x[2] == 1 || x[2] == 2) && (x[3] == 1 || x[3] == 2)
				&& (x[4] == 1 || x[4] == 2) && (x[5] == 1 || x[5] == 2) && (x[6] == 1 || x[6] == 2)
				&& (x[7] == 1 || x[7] == 2) && (x[8] == 1 || x[8] == 2)) {
			return true;
		} else
			return false;
	}

	private void winCalculator() {

		if ((x[0] == 1 && x[1] == 1 && x[2] == 1) || (x[0] == 1 && x[3] == 1 && x[6] == 1)
				|| (x[0] == 1 && x[4] == 1 && x[8] == 1) || (x[2] == 1 && x[5] == 1 && x[8] == 1)
				|| (x[3] == 1 && x[4] == 1 && x[5] == 1) || (x[6] == 1 && x[7] == 1 && x[8] == 1)
				|| (x[1] == 1 && x[4] == 1 && x[7] == 1) || (x[2] == 1 && x[4] == 1 && x[6] == 1)) {
			win.setText("CONGRATULATIONS, " + TwoPlayersPanel.nameOne + "!!! YOU WON!!!");
			win.setForeground(Color.red);
			new TwoPlayersWin();
			oneScore++;
		} else if ((x[0] == 2 && x[1] == 2 && x[2] == 2) || (x[0] == 1 && x[3] == 2 && x[6] == 2)
				|| (x[0] == 2 && x[4] == 2 && x[8] == 2) || (x[2] == 2 && x[5] == 2 && x[8] == 2)
				|| (x[3] == 2 && x[4] == 2 && x[5] == 2) || (x[6] == 2 && x[7] == 2 && x[8] == 2)
				|| (x[1] == 2 && x[4] == 2 && x[7] == 2) || (x[2] == 2 && x[4] == 2 && x[6] == 2)) {
			win.setText("CONGRATULATIONS, " + TwoPlayersPanel.nameTwo + "!!! YOU WON!!!");
			win.setForeground(Color.green);
			new TwoPlayersWin();
			twoScore++;
		} else if (draw()) {
			win.setText("DON'T WORRY , NO ONE LOSES , IT'S A DRAW");
			new TwoPlayersWin();

		}
	}

	protected static void again() {
		for (int j = 0; j < 9; j++) {
			x[j] = 0;
			vector[j] = false;
		}

		turn = 1;
		playerTurn.setText("Now it's " + TwoPlayersPanel.nameOne + "'s turn");
		playerTurn.setForeground(Color.red);

		firstCell.setIcon(new ImageIcon());
		secondCell.setIcon(new ImageIcon());
		thirdCell.setIcon(new ImageIcon());
		forthCell.setIcon(new ImageIcon());
		fifthCell.setIcon(new ImageIcon());
		sixthCell.setIcon(new ImageIcon());
		seventhCell.setIcon(new ImageIcon());
		eigthCell.setIcon(new ImageIcon());
		ninthCell.setIcon(new ImageIcon());
	}

	private void back() {
		back.setBounds(80, 900, 200, 40);
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				gameFrame.setVisible(false);
				StartPanel.startFrame.setVisible(true);
			}
		});
	}

	private void exit() {
		exit.setBounds(350, 900, 200, 40);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}

	private void win() {
		win.setBounds(10, 50, 600, 35);
		win.setFont(new Font("ARIAL", Font.BOLD, 23));
	}
}
