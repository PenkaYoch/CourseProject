package shop.items;

import shop.enums.Category;
import shop.enums.ClothesSize;
import shop.enums.Subcategory;

public class Blouse extends Product {

	private ClothesSize blouseSize;

	public Blouse(String productName, Category productCategory, Subcategory productSubcategory, double price,
			String imageFilePath, ClothesSize blouseSize) {
		super(productName, productCategory, productSubcategory, price, imageFilePath);
		this.blouseSize = blouseSize;
	}

	public ClothesSize getBlouseSize() {
		return blouseSize;
	}

	public void setBlouseSize(ClothesSize blouseSize) {
		this.blouseSize = blouseSize;
	}
	
	public static class BlouseGenerator {
		public static Blouse make(Product product) {
			return new Blouse(product.productName, product.productCategory, product.productSubcategory, 
									product.price, product.imageFilePath, ClothesSize.L);
		}
	}
}
