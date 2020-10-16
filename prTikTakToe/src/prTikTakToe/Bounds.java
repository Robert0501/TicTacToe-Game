package prTikTakToe;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bounds {

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public void setBounds(JPanel panel, int a, int b, int c, int d) {
		panel.setBounds(screenSize.width * a / 1920 + screenSize.width * a % 1920,
				screenSize.height * b / 1080 + screenSize.height * b % 1080, c, d);
	}

	public void setBounds(JFrame frame, int a, int b, int c, int d) {
		frame.setBounds(screenSize.width * a / 1920 + screenSize.width * a % 1920,
				screenSize.height * b / 1080 + screenSize.height * b % 1080, c, d);
	}

	public void setBounds(JButton button, int a, int b, int c, int d) {
		button.setBounds(screenSize.width * a / 1920 + screenSize.width * a % 1920,
				screenSize.height * b / 1080 + screenSize.height * b % 1080, c, d);
	}

	public static void setBounds(JLabel label, int a, int b, int c, int d) {
		label.setBounds(screenSize.width * a / 1920 + screenSize.width * a % 1920,
				screenSize.height * b / 1080 + screenSize.height * b % 1080, c, d);
	}

	public void setBounds(JTextField textField, int a, int b, int c, int d) {
		textField.setBounds(screenSize.width * a / 1920 + screenSize.width * a % 1920,
				screenSize.height * b / 1080 + screenSize.height * b % 1080, c, d);
	}
}
