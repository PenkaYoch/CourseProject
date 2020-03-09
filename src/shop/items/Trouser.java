package shop.items;

import shop.enums.Category;
import shop.enums.ClothesSize;
import shop.enums.Subcategory;

public class Trouser extends Product {

	private ClothesSize trouserSize;

	public Trouser(String product_Name, Category productCategory, Subcategory productSubcategory, double price,
			String imageFilePath, ClothesSize trouserSize) {
		super(product_Name, productCategory, productSubcategory, price, imageFilePath);
		this.trouserSize = trouserSize;
	}

	public ClothesSize getTrouserSize() {
		return trouserSize;
	}

	public void setTrouserSize(ClothesSize trouserSize) {
		this.trouserSize = trouserSize;
	}
	
	public static class TrouserGenerator {
		public static Trouser make(Product product) {
			return new Trouser(product.productName, product.productCategory, product.productSubcategory, 
									product.price, product.imageFilePath, ClothesSize.L);
		}
	}
}
