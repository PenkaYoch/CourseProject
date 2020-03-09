package shop.mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import shop.enums.Category;
import shop.enums.Subcategory;
import shop.items.Blouse;
import shop.items.Blouse.BlouseGenerator;
import shop.items.Product;
import shop.items.Trouser;
import shop.items.Trouser.TrouserGenerator;
import shop.items.Wallet;
import shop.items.Wallet.WalletGenerator;
import shop.panels.ProductsPanel;
import shop.panels.WelcomePanel;
import shop.util.FileReader;

public class OnlineShopGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	static Product[] allProducts;
	public static ArrayList<Product> productsOnScreen = null;
	
	public static void main(String[] args) {
		
		allProducts = FileReader.readPeople();
		
//		for(Product pro : allProducts) {
//			System.out.println(pro.getProductName());
//			System.out.println(pro.getProductCategory());
//			System.out.println(pro.getProductSubcategory());
//			System.out.println(pro.getPrice());
//			System.out.println(pro.getImageFilePath());
//		}

		OnlineShopGUI myShop = new OnlineShopGUI();
		myShop.setTitle("Fashion Shop");
	}
	
	public OnlineShopGUI() {

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new GridLayout(4, 0));

		JMenu blouseCategory = new JMenu("Блузи");
		JMenuItem womenBlouses = new JMenuItem("За жени");
		JMenuItem menBlouses = new JMenuItem("За мъже");
		blouseCategory.add(womenBlouses);
		blouseCategory.add(menBlouses);
		menuBar.add(blouseCategory);

		JMenu trouserCategory = new JMenu("Панталони");
		JMenuItem womenTrousers = new JMenuItem("За жени");
		JMenuItem menTrousers = new JMenuItem("За мъже");
		trouserCategory.add(womenTrousers);
		trouserCategory.add(menTrousers);
		menuBar.add(trouserCategory);

		JMenu walletCategory = new JMenu("Портфейли");
		JMenuItem womenWallets = new JMenuItem("За жени");
		JMenuItem menWallets = new JMenuItem("За мъже");
		walletCategory.add(womenWallets);
		walletCategory.add(menWallets);
		menuBar.add(walletCategory);

//		JMenu watchCategory = new JMenu("Часовници");
//		JMenuItem womenWatches = new JMenuItem("За жени");
//		JMenuItem menWatches = new JMenuItem("За мъже");
//		watchCategory.add(womenWatches);
//		watchCategory.add(menWatches);
//		menuBar.add(watchCategory);

		JPanel footer = new JPanel();
		Color backgroundColor = new Color(135, 206, 250);
		footer.setBackground(backgroundColor);

		JPanel header = new JPanel();
		header.add(menuBar);
		JPanel welcomePanel = new WelcomePanel();
//		JPanel productsPanel = new ProductsPanel();
		header.add(welcomePanel);
		header.setLayout(new GridLayout(1, 2));
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(header, BorderLayout.CENTER);
		container.add(footer, BorderLayout.AFTER_LAST_LINE);
		this.setSize(1000, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		womenBlouses.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getOnlyProductsFromThisCategory(Category.Blouses, Subcategory.Women);
				createChangePanel(container, menuBar, footer);
			}
		});

		menBlouses.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getOnlyProductsFromThisCategory(Category.Blouses, Subcategory.Men);		
				createChangePanel(container, menuBar, footer);
	}
		});
		
		womenTrousers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getOnlyProductsFromThisCategory(Category.Trousers, Subcategory.Women);
				createChangePanel(container, menuBar, footer);	
			}
		});
		
		menTrousers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getOnlyProductsFromThisCategory(Category.Trousers, Subcategory.Men);
				createChangePanel(container, menuBar, footer);	
			}
		});
		
		womenWallets.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getOnlyProductsFromThisCategory(Category.Wallets, Subcategory.Women);	
				createChangePanel(container, menuBar, footer);
			}
		});
		
		menWallets.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createChangePanel(container, menuBar, footer);
				getOnlyProductsFromThisCategory(Category.Wallets, Subcategory.Men);		
			}
		});
	}

	public void createChangePanel(Container contentPane, JMenuBar menuBar, JPanel footer) {
//		setVisible(false);
		contentPane.removeAll();
		JPanel productsPanel = new ProductsPanel();
		JPanel header = new JPanel();
		header.add(menuBar);
		header.add(productsPanel);
		header.setLayout(new GridLayout(1, 2));
		contentPane.setLayout(new BorderLayout());
		contentPane.add(header, BorderLayout.CENTER);
		contentPane.add(footer, BorderLayout.AFTER_LAST_LINE);
//		validate();
		repaint();
		setVisible(true);
	}
	
	private void getOnlyProductsFromThisCategory(Category cat, Subcategory subcat) {
		productsOnScreen = new ArrayList<Product>();
		
		for(Product product : allProducts) {
			if(product.getProductCategory() == Category.Blouses && product.getProductSubcategory() == subcat) {
				Product newProduct = BlouseGenerator.make(product);
				productsOnScreen.add(newProduct);
			} else if(product.getProductCategory() == Category.Trousers && product.getProductSubcategory() == subcat) {
				Product newProduct = TrouserGenerator.make(product);
				productsOnScreen.add(newProduct);
			} else if(product.getProductCategory() == Category.Wallets && product.getProductSubcategory() == subcat) {
				Product newProduct = WalletGenerator.make(product);
				productsOnScreen.add(newProduct);
			}
		}
	}
}
