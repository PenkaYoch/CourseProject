package shop.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import shop.enums.Category;
import shop.enums.ClothesSize;
import shop.enums.Subcategory;
import shop.items.Blouse;
import shop.items.Product;
import shop.items.Trouser;
import shop.items.Wallet;

public class FileReader {

	private static final String FILE_EXTENSION = ".txt";
	private static final String FILE_NAME = "online_shop_database";
	private static final String FILE_PATH = "src/shop/database/";
	private static final String FULL_PATH = FILE_PATH + FILE_NAME + FILE_EXTENSION;
	
	private static ArrayList<Product> productsList = new ArrayList<>();
	
	public static void createPersonFile() {
		File file = new File(FULL_PATH);
		file.getParentFile().mkdirs();
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Файлът не може да бъде създаден!");
			e.printStackTrace();
		}
	}
	
	public static boolean isFileExists() {
		File file = new File(FULL_PATH);
		return file.exists();
	}
	
	@SuppressWarnings("resource")
	public static Product[] readPeople() {
		try {
			FileInputStream fileStream = new FileInputStream(FULL_PATH);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileStream));
			String stringLine;
			Category category = null;
			Subcategory subcategory = null;
			
			while((stringLine = bufferedReader.readLine()) != null) {
				if(stringLine.contains(">") && !stringLine.contains("/>")) {
				
					String categoryFromFile = stringLine.substring(1, stringLine.length() - 1);
					category = defineProductCategory(categoryFromFile);
				} else if(stringLine.contains("_")) {

					String subcategoryFromFile = stringLine.substring(2, stringLine.length());
					subcategory = defineProductSubcategory(subcategoryFromFile);
				} else if(stringLine.contains("*")) { 
					String[] data = stringLine.substring(3).split(",");
					addProduct(data, category, subcategory);					
				} else {
				// when close the category
					continue;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Product[] people = new Product[productsList.size()];
		return productsList.toArray(people);
	}
	
	private static void addProduct(String[] data, Category cat, Subcategory subcat) {
		Product newProduct;
		switch(cat) {
		case Blouses:
			newProduct = new Blouse(data[0], cat, subcat, Double.parseDouble(data[1]), data[2], ClothesSize.S);
			break;
		case Trousers:
			newProduct = new Trouser(data[0], cat, subcat, Double.parseDouble(data[1]), data[2], ClothesSize.XL);
			break;
		default:
			newProduct = new Wallet(data[0], cat, subcat, Double.parseDouble(data[1]), data[2], "PU");
			break;
		}
		productsList.add(newProduct);
	}
	
	private static Category defineProductCategory(String categoryFromFile) {
		switch (categoryFromFile) {
		case "blouses":
			return Category.Blouses;
		case "trousers":
			return Category.Trousers;
		case "watches":
			return Category.Watches;
		case "wallets":
			return Category.Wallets;
		}
		return null;
	}
	
	private static Subcategory defineProductSubcategory(String subcategory){
		switch (subcategory) {
		case "women":
			return Subcategory.Women;
		case "men":
			return Subcategory.Men;
		}
		return null;
	}

//	public static void writePeople(Product[] people) {
//		Writer writer = null;
//		
//		try {
//			writer = new BufferedWriter(new FileWriter(FULL_PATH, true)); // enable append
//			
//			for (Product person : people) {
//				writer.append(person.getName() + "\t");
//				writer.append(person.getAge() + "\t");
//				writer.append(person.getEgn() + "\t");
//				writer.append(person.getWeight() + "\t");
//				writer.append(person.getHeight() + "\t");
//				writer.append("\n");
//				
//				System.out.printf("%s е успешно добавен във файла! \n", person.getName());
//			}
//		} catch (IOException e) {
//			System.err.println("Записът не може да бъде добавен във файла!");
//			e.printStackTrace();
//		} finally {
//			if (writer != null) {
//				try {
//					writer.close();
//				} catch (IOException e) {
//					System.out.println("Записвачът не може да бъде затворен правилно!");
//					e.printStackTrace();
//				}
//			}
//		}
//	}
}
