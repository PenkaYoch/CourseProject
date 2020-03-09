package shop.items;

import shop.enums.Category;
import shop.enums.ClothesSize;
import shop.enums.Subcategory;

public class Wallet extends Product {

	private String typeOfLeather;

	public Wallet(String product_Name, Category productCategory, Subcategory productSubcategory, double price,
			String imageFilePath, String typeOfLeather) {
		super(product_Name, productCategory, productSubcategory, price, imageFilePath);
		this.typeOfLeather = typeOfLeather;
	}

	public String getTypeOfLeather() {
		return typeOfLeather;
	}

	public void setTypeOfLeather(String typeOfLeather) {
		this.typeOfLeather = typeOfLeather;
	}
	
	public static class WalletGenerator {
		public static Wallet make(Product product) {
			return new Wallet(product.productName, product.productCategory, product.productSubcategory, 
									product.price, product.imageFilePath, "PU");
		}
	}
}
