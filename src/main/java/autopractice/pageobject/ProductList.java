package autopractice.pageobject;

import org.openqa.selenium.By;

public class ProductList {

	public static String xpathProductList = "//ul[contains(@class, 'product_list')]";
	public static String xpathProductContainer = "//div[@class='product-container']";

	public static By by() {
		return By.xpath(xpathProductList);
	}

	public static ProductContainer product(int order) {
		String xpath = xpathProductList + xpathProductContainer;
		xpath = "(" + xpath + ")[" + order + "]";
		return new ProductContainer(xpath);
	}
	
	public static By getProductsPrice() {
		return By.xpath(xpathProductList + xpathProductContainer + "//span[@itemprop='price']");
	}

	public static By liList() {
		return By.id("list");
	}

	public static By buttonCompare() {
		String xpath = "//button[contains(@class, 'bt_compare')]";
		return By.xpath(xpath);
	}

	public static By buttonCompareNumber() {
		String xpath = "//button[contains(@class, 'bt_compare')]/span/strong";
		return By.xpath(xpath);
	}
	
	public static By sortSelect() {
		String xpath = "//div[@id='uniform-selectProductSort']";
		return By.xpath(xpath);
	}
	
	public static By sortOption(String sort) {
		String xpath = ".//select/option[text()='"+sort+"']";
		return By.xpath(xpath);
	}

}
