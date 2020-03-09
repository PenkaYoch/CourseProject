package shop.items;

import shop.enums.Category;
import shop.enums.Subcategory;

public abstract class Product {
	protected String productName;
	protected Category productCategory;
	protected Subcategory productSubcategory;
	protected double price;
	protected String imageFilePath;
	
	public Product() {
		
	}
	
	public Product(String productName, Category productCategory, Subcategory productSubcategory, double price,
			String imageFilePath) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.productSubcategory = productSubcategory;
		this.price = price;
		this.imageFilePath = imageFilePath;
	}

	public String getProductName() {
		return productName;
	}

	public void setProduct_Name(String productName) {
		this.productName = productName;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	public Subcategory getProductSubcategory() {
		return productSubcategory;
	}

	public void setProductSubcategory(Subcategory productSubcategory) {
		this.productSubcategory = productSubcategory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	
	
}
