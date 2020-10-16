package prTikTakToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OnePlayerGame extends Bounds {
	protected static JFrame gameFrame = new JFrame("TicTacToe");
	protected static JPanel gamePanel = new JPanel();

	protected static JLabel gameBoard = new JLabel();
	protected static JLabel score = new JLabel("SCORE:");
	protected static JLabel nameOne = new JLabel();
	protected static JLabel nameTwo = new JLabel();
	protected static JLabel signs = new JLabel("SIGNS:");
	protected static JLabel playerOneSign = new JLabel();
	protected static JLabel playerTwoSign = new JLabel();
	protected static JLabel playerTurn = new JLabel();
	protected static JLabel win = new JLabel();

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

	protected static int turn = 1;
	private static int x[] = new int[9];
	private static boolean vector[] = new boolean[9];
	protected static int oneScore = 0;
	protected static int twoScore = 0;
	private int number = -1;
	private static int counter = 0;
	public int stopPosition = -1;
	public int winPosition = -1;
	protected static boolean playerWin = false;

	public OnePlayerGame() {
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
		score();
		signs();
		playerOneSign();
		playerTwoSign();
		nameOne();
		nameTwo();
		playerTurn();
		win();
		back();
		exit();
		for (int j = 0; j < 9; j++) {
			vector[j] = false;
		}
	}

	private void panel() {
		gamePanel.setLayout(null);
		gamePanel.setBackground(Color.lightGray);
		gamePanel.add(gameBoard);
		gamePanel.add(score);
		gamePanel.add(nameOne);
		gamePanel.add(nameTwo);
		gamePanel.add(signs);
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

		gamePanel.add(back);
		gamePanel.add(exit);
	}

	private void frame() {
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);
		gameFrame.add(gamePanel);
		setBounds(gameFrame, 600, 20, 640, 1000);
		try {
			gameFrame.setIconImage(ImageIO.read(new File("src\\Images\\icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void gameBoard() {
		gameBoard.setIcon(new ImageIcon("src\\Images\\board.png"));
		setBounds(gameBoard, 10, 110, 600, 600);
	}

	private void firstCell() {
		firstCell.setBackground(Color.white);
		setBounds(firstCell, 13, 113, 195, 195);
		firstCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(firstCell, 0);
			}
		});
	}

	private void secondCell() {
		secondCell.setBackground(Color.white);
		setBounds(secondCell, 213, 113, 195, 195);
		secondCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(secondCell, 1);
			}
		});
	}

	private void thirdCell() {
		thirdCell.setBackground(Color.white);
		setBounds(thirdCell, 413, 113, 195, 195);
		thirdCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(thirdCell, 2);
			}
		});
	}

	private void forthCell() {
		forthCell.setBackground(Color.white);
		setBounds(forthCell, 13, 313, 195, 195);
		forthCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(forthCell, 3);
			}
		});
	}

	private void fifthCell() {
		fifthCell.setBackground(Color.white);
		setBounds(fifthCell, 213, 313, 195, 195);
		fifthCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(fifthCell, 4);
			}
		});
	}

	private void sixthCell() {
		sixthCell.setBackground(Color.white);
		setBounds(sixthCell, 413, 313, 195, 195);
		sixthCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(sixthCell, 5);
			}
		});
	}

	private void seventhCell() {
		seventhCell.setBackground(Color.white);
		setBounds(seventhCell, 13, 513, 195, 195);
		seventhCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(seventhCell, 6);
			}
		});
	}

	private void eigthCell() {
		eigthCell.setBackground(Color.white);
		setBounds(eigthCell, 213, 513, 195, 195);
		eigthCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(eigthCell, 7);
			}
		});
	}

	private void ninthCell() {
		ninthCell.setBackground(Color.white);
		setBounds(ninthCell, 413, 513, 195, 195);
		ninthCell.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				put(ninthCell, 8);
			}
		});
	}

	private void switching(int var) {
		switch (var) {
		case 0:
			firstCell.setIcon(new ImageIcon("src\\Images\\0.png"));
			vector[0] = true;
			turn = 1;
			x[0] = 2;
			counter++;
			playerTurn.setText("Now it's " + OnePlayerPanel.name + "'s turn");
			playerTurn.setForeground(Color.red);
			break;
		case 1:
			secondCell.setIcon(new ImageIcon("src\\Images\\0.png"));
			vector[1] = true;
			turn = 1;
			x[1] = 2;
			counter++;
			playerTurn.setText("Now it's " + OnePlayerPanel.name + "'s turn");
			playerTurn.setForeground(Color.red);
			break;
		case 2:
			thirdCell.setIcon(new ImageIcon("src\\Images\\0.png"));
			turn = 1;
			vector[2] = true;
			x[2] = 2;
			counter++;
			playerTurn.setText("Now it's " + OnePlayerPanel.name + "'s turn");
			playerTurn.setForeground(Color.red);
			break;
		case 3:
			forthCell.setIcon(new ImageIcon("src\\Images\\0.png"));
			turn = 1;
			x[3] = 2;
			counter++;
			vector[3] = true;
			playerTurn.setText("Now it's " + OnePlayerPanel.name + "'s turn");
			playerTurn.setForeground(Color.red);
			break;
		case 4:
			fifthCell.setIcon(new ImageIcon("src\\Images\\0.png"));
			turn = 1;
			x[4] = 2;
			counter++;
			vector[4] = true;
			playerTurn.setText("Now it's " + OnePlayerPanel.name + "'s turn");
			playerTurn.setForeground(Color.red);
			break;
		case 5:
			sixthCell.setIcon(new ImageIcon("src\\Images\\0.png"));
			turn = 1;
			x[5] = 2;
			counter++;
			vector[5] = true;
			playerTurn.setText("Now it's " + OnePlayerPanel.name + "'s turn");
			playerTurn.setForeground(Color.red);
			break;
		case 6:
			seventhCell.setIcon(new ImageIcon("src\\Images\\0.png"));
			turn = 1;
			x[6] = 2;
			counter++;
			vector[6] = true;
			playerTurn.setText("Now it's " + OnePlayerPanel.name + "'s turn");
			playerTurn.setForeground(Color.red);
			break;
		case 7:
			eigthCell.setIcon(new ImageIcon("src\\Images\\0.png"));
			turn = 1;
			x[7] = 2;
			counter++;
			vector[7] = true;
			playerTurn.setText("Now it's " + OnePlayerPanel.name + "'s turn");
			playerTurn.setForeground(Color.red);
			break;
		case 8:
			ninthCell.setIcon(new ImageIcon("src\\Images\\0.png"));
			turn = 1;
			x[8] = 2;
			counter++;
			vector[8] = true;
			playerTurn.setText("Now it's " + OnePlayerPanel.name + "'s turn");
			playerTurn.setForeground(Color.red);
			break;
		}
	}

	private void put(JButton button, int i) {
		if (counter < 4) {
			if (!vector[i]) {
				button.setIcon(new ImageIcon("src\\Images\\x.png"));
				playerTurn.setForeground(Color.green);
				playerTurn.setText("Now it's Computer's turn");
				turn = 2;
				x[i] = 1;
				vector[i] = true;
				winCalculator();
				if (winAgainstPlayer() && !playerWin) {
					switching(winPosition);
					winCalculator();
				} else if (stopPlayer() && !playerWin) {
					switching(stopPosition);
					winCalculator();
				} else if (!playerWin) {
					number = random();
					while (vector[number]) {
						number = random();
					}
					switching(number);
					winCalculator();
				}
			}
		} else {
			button.setIcon(new ImageIcon("src\\Images\\x.png"));
			playerTurn.setForeground(Color.green);
			playerTurn.setText("Now it's Computer's turn");
			turn = 2;
			x[i] = 1;
			vector[i] = true;
			winCalculator();
		}

	}

	private int random() {
		Random rand = new Random();

		int number = rand.nextInt() % 9;
		if (number < 0)
			number += 9;
		return number;
	}

	private boolean stopPlayer() {
		if ((x[1] == 1 && x[2] == 1 && x[0] != 2) || ((x[3] == 1 && x[6] == 1 && x[0] != 2))
				|| (x[4] == 1 && x[8] == 1 && x[0] != 2)) {
			stopPosition = 0;
			return true;
		} else if ((x[0] == 1 && x[2] == 1 && x[1] != 2) || (x[4] == 1 && x[7] == 1 && x[1] != 2)) {
			stopPosition = 1;
			return true;
		} else if ((x[0] == 1 && x[1] == 1 && x[2] != 2) || (x[5] == 1 && x[8] == 1 && x[2] != 2)
				|| x[4] == 1 && x[6] == 1 && x[2] != 2) {
			stopPosition = 2;
			return true;
		} else if ((x[4] == 1 && x[5] == 1 && x[3] != 2) || x[0] == 1 && x[6] == 1 && x[3] != 2) {
			stopPosition = 3;
			return true;
		} else if ((x[3] == 1 && x[5] == 1 && x[4] != 2) || (x[1] == 1 && x[7] == 1 && x[4] != 2)
				|| (x[0] == 1 && x[8] == 1 && x[4] != 2) || (x[2] == 1 && x[6] == 1 && x[4] != 2)) {
			stopPosition = 4;
			return true;
		} else if ((x[3] == 1 && x[4] == 1 && x[5] != 2) || x[2] == 1 && x[8] == 1 && x[5] != 2) {
			stopPosition = 5;
			return true;
		} else if ((x[7] == 1 && x[8] == 1 && x[6] != 2) || (x[0] == 1 && x[3] == 1 && x[6] != 2)
				|| (x[2] == 1 && x[4] == 1 && x[6] != 2)) {
			stopPosition = 6;
			return true;
		} else if ((x[6] == 1 && x[8] == 1 && x[7] != 2) || (x[1] == 1 && x[4] == 1 && x[7] != 2)) {
			stopPosition = 7;
			return true;
		} else if ((x[6] == 1 && x[7] == 1 && x[8] != 2) || (x[2] == 1 && x[5] == 1 && x[8] != 2)
				|| (x[0] == 1 && x[4] == 1 && x[8] != 2)) {
			stopPosition = 8;
			return true;
		}
		return false;
	}

	private boolean winAgainstPlayer() {
		if ((x[1] == 2 && x[2] == 2 && x[0] != 1) || ((x[3] == 2 && x[6] == 2 && x[0] != 1))
				|| (x[4] == 2 && x[8] == 2 && x[0] != 1)) {
			winPosition = 0;
			return true;
		} else if ((x[0] == 2 && x[2] == 2 && x[1] != 1) || (x[4] == 2 && x[7] == 2 && x[1] != 1)) {
			winPosition = 1;
			return true;
		} else if ((x[0] == 2 && x[1] == 2 && x[2] != 1) || (x[5] == 2 && x[8] == 2 && x[2] != 1)
				|| x[4] == 2 && x[6] == 2 && x[2] != 1) {
			winPosition = 2;
			return true;
		} else if ((x[4] == 2 && x[5] == 2 && x[3] != 1) || x[0] == 2 && x[6] == 2 && x[3] != 1) {
			winPosition = 3;
			return true;
		} else if ((x[3] == 2 && x[5] == 2 && x[4] != 1) || (x[1] == 2 && x[7] == 2 && x[4] != 1)
				|| (x[0] == 2 && x[8] == 2 && x[4] != 1) || (x[2] == 2 && x[6] == 2 && x[4] != 1)) {
			winPosition = 4;
			return true;
		} else if ((x[3] == 2 && x[4] == 2 && x[5] != 1) || x[2] == 2 && x[8] == 2 && x[5] != 1) {
			winPosition = 5;
			return true;
		} else if ((x[7] == 2 && x[8] == 2 && x[6] != 1) || (x[0] == 2 && x[3] == 2 && x[6] != 1)
				|| (x[2] == 2 && x[4] == 2 && x[6] != 1)) {
			winPosition = 6;
			return true;
		} else if ((x[6] == 2 && x[8] == 2 && x[7] != 1) || (x[1] == 2 && x[4] == 2 && x[7] != 1)) {
			winPosition = 7;
			return true;
		} else if ((x[6] == 2 && x[7] == 2 && x[8] != 1) || (x[2] == 2 && x[5] == 2 && x[8] != 1)
				|| (x[0] == 2 && x[4] == 2 && x[8] != 1)) {
			winPosition = 8;
			return true;
		}
		return false;
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
			win.setText("CONGRATULATIONS, " + OnePlayerPanel.name + "!!! YOU WON!!!");
			win.setForeground(Color.red);
			new OnePlayerWin();
			oneScore++;
			playerWin = true;
		} else if ((x[0] == 2 && x[1] == 2 && x[2] == 2) || (x[0] == 2 && x[3] == 2 && x[6] == 2)
				|| (x[0] == 2 && x[4] == 2 && x[8] == 2) || (x[2] == 2 && x[5] == 2 && x[8] == 2)
				|| (x[3] == 2 && x[4] == 2 && x[5] == 2) || (x[6] == 2 && x[7] == 2 && x[8] == 2)
				|| (x[1] == 2 && x[4] == 2 && x[7] == 2) || (x[2] == 2 && x[4] == 2 && x[6] == 2)) {
			win.setText("CONGRATULATIONS, Computer!!! YOU WON!!!");
			win.setForeground(Color.green);
			new OnePlayerWin();
			twoScore++;
		} else if (draw()) {
			win.setText("DON'T WORRY , NO ONE LOSES , IT'S A DRAW");
			win.setForeground(Color.black);
			new OnePlayerWin();
		}

	}

	private void signs() {
		setBounds(signs, 300, 750, 200, 40);
		signs.setFont(new Font("ARIAL", Font.BOLD, 24));
	}

	private void playerOneSign() {
		setBounds(playerOneSign, 420, 740, 200, 20);
		playerOneSign.setText(OnePlayerPanel.name + " -> X");
		playerOneSign.setFont(new Font("ARIAL", Font.BOLD, 20));
		playerOneSign.setForeground(Color.red);
	}

	private void playerTwoSign() {
		setBounds(playerTwoSign, 420, 770, 200, 20);
		playerTwoSign.setText("Computer" + " -> 0");
		playerTwoSign.setFont(new Font("ARIAL", Font.BOLD, 20));
		playerTwoSign.setForeground(Color.green);
	}

	private void nameOne() {
		setBounds(nameOne, 130, 740, 200, 20);
		nameOne.setFont(new Font("ARIAL", Font.BOLD, 20));
		nameOne.setForeground(Color.red);
	}

	private void nameTwo() {
		setBounds(nameTwo, 130, 770, 200, 20);
		nameTwo.setFont(new Font("ARIAL", Font.BOLD, 20));
		nameTwo.setForeground(Color.green);
	}

	protected static void score() {
		score.setFont(new Font("ARIAL", Font.BOLD, 24));
		setBounds(score, 10, 750, 200, 40);
		nameOne.setText(OnePlayerPanel.name + ": " + oneScore);
		nameTwo.setText("Computer:" + twoScore);
	}

	protected static void again() {
		for (int j = 0; j < 9; j++) {
			x[j] = 0;
			vector[j] = false;
		}

		turn = 1;
		counter = 0;
		playerTurn.setText("Now it's " + OnePlayerPanel.name + "'s turn");
		playerTurn.setForeground(Color.red);
		playerWin = false;
		gameBoard.setIcon(new ImageIcon("src\\Images\\board.png"));

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

	private void playerTurn() {
		setBounds(playerTurn, 110, 25, 600, 35);
		playerTurn.setFont(new Font("ARIAL", Font.BOLD, 35));
		playerTurn.setText("Now it's " + OnePlayerPanel.name + "'s turn");
		playerTurn.setForeground(Color.red);
	}

	private void win() {
		setBounds(win, 10, 50, 600, 35);
		win.setFont(new Font("ARIAL", Font.BOLD, 23));
	}

	private void back() {
		setBounds(back, 80, 900, 200, 40);
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				gameFrame.setVisible(false);
				StartPanel.startFrame.setVisible(true);
			}
		});
	}

	private void exit() {
		setBounds(exit, 350, 900, 200, 40);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}

}
