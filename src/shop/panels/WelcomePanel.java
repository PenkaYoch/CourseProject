package shop.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {

	public WelcomePanel() {
		Color backgroundColor = new Color(224, 255, 255);
		this.setBackground(backgroundColor);
		JLabel welcomeLabel = new JLabel("Заповядайте, в нашия онлайн магазин!");
		Font welcomeLabelFont = new Font("Monotype Corsiva", Font.PLAIN, 30);
		welcomeLabel.setFont(welcomeLabelFont);

		BufferedImage firstPicture;
		try {
			firstPicture = ImageIO.read(new File("src/shop/images/fashionShop.png"));
			JLabel headerLabel = new JLabel(new ImageIcon(firstPicture));
			this.add(headerLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(welcomeLabel);
		this.setLayout(new GridLayout(2, 1));
	}
}
