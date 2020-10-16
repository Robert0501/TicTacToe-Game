package prTikTakToe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TwoPlayersWin {
	protected static JFrame winFrame = new JFrame();
	protected static JPanel winPanel = new JPanel();

	protected static JButton ok = new JButton("OK");

	public TwoPlayersWin() {
		panel();
		frame();
		ok();
	}

	private void panel() {
		winPanel.setLayout(null);
		winPanel.add(ok);
		winPanel.add(TwoPlayersGame.win);
	}

	private void frame() {
		winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winFrame.setLocationRelativeTo(null);
		winFrame.setVisible(true);
		winFrame.add(winPanel);
		winFrame.setBounds(650, 400, 550, 200);
		try {
			winFrame.setIconImage(ImageIO.read(new File("src\\Images\\icon.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ok() {
		ok.setBounds(200, 110, 120, 30);
		ok.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				winFrame.setVisible(false);
				TwoPlayersGame.score();
				TwoPlayersGame.again();
			}
		});
	}
}
