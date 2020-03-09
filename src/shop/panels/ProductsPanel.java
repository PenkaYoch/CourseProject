package shop.panels;

import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import shop.mainPackage.OnlineShopGUI;

public class ProductsPanel extends JPanel {

	public ProductsPanel() {
		
		JLabel nameProduct1 = new JLabel(OnlineShopGUI.productsOnScreen.get(0).getProductName());
		JLabel nameProduct2 = new JLabel(OnlineShopGUI.productsOnScreen.get(1).getProductName());	
		
		this.add(nameProduct1);
		this.add(nameProduct2);
		
		BufferedImage firstPicture = null;
		BufferedImage secondPicture = null;
		
		try {
			firstPicture = ImageIO.read(new File(OnlineShopGUI.productsOnScreen.get(0).getImageFilePath()));
			JLabel pic1Label = new JLabel(new ImageIcon(setImageSize(firstPicture, 100, 100)));
			this.add(pic1Label);
			
			secondPicture = ImageIO.read(new File(OnlineShopGUI.productsOnScreen.get(1).getImageFilePath()));
			JLabel pic2Label = new JLabel(new ImageIcon(setImageSize(secondPicture, 100, 100)));
			this.add(pic2Label);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel productPrice1 = new JLabel(String.valueOf(OnlineShopGUI.productsOnScreen.get(0).getPrice()));
		JLabel productPrice2 = new JLabel(String.valueOf(OnlineShopGUI.productsOnScreen.get(1).getPrice()));
		
		this.add(productPrice1);
		this.add(productPrice2);
		
		JLabel numberLabel1 = new JLabel("Брой: ");
		JLabel numberLabel2 = new JLabel("Брой: ");
		String[] nums = {"1", "2", "3"};
		JComboBox product1Number = new JComboBox(nums);
		JComboBox product2Number = new JComboBox(nums);
	
		this.add(numberLabel1);
		this.add(numberLabel2);
		this.add(product1Number);
		this.add(product2Number);
		JButton addCart1Button = new JButton("Добави към количката");
		JButton addCart2Button = new JButton("Добави към количката");
		this.add(addCart1Button);
		this.add(addCart2Button);
		
		BufferedImage cartPicture;
		try {
			firstPicture = ImageIO.read(new File("src/shop/images/shoppingCart.jpg"));
			JLabel pic3Label = new JLabel(new ImageIcon(setImageSize(firstPicture, 100, 100)));
			this.add(pic3Label);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton viewButton = new JButton("Виж количката");
		this.add(viewButton);
		this.setLayout(new GridLayout(7, 2));
	}
	
	private Image setImageSize(BufferedImage image, int width , int height)
	{
	    return new ImageIcon(image).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}
}
