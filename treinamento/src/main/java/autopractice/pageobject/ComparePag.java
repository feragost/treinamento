package autopractice.pageobject;

import org.openqa.selenium.By;

public class ComparePag {
	private static String getProduct(int n) {
		String xpath = "//td[contains(@class,'ajax_block_product')]["+n+"]";
		return xpath;
	}
	
	public static By getProducts() {
		String xpath = "//td[contains(@class,'ajax_block_product')]";
		return By.xpath(xpath);
	}
	
	public static By getName(int n) {
		String xpath = getProduct(n) + "//h5/a";
		return By.xpath(xpath);
	}
	
	public static By getPrice(int n) {
		String xpath = getProduct(n) + "//span[@class='price product-price']";
		return By.xpath(xpath);
	}
	
	public static By getDescription(int n) {
		String xpath = getProduct(n) + "//div[@class='product_desc]";
		return By.xpath(xpath);
	}
	
	public static By buttonAddToCart(int n) {
		String xpath = getProduct(n) + "//div[@class='button-container']/a[@title='Add to cart]";
		return By.xpath(xpath);
	}
	
	public static By buttonView(int n) {
		String xpath = getProduct(n) + "//div[@class='button-container']/a[@title='View]";
		return By.xpath(xpath);
	}

	public static By continueShoppingButton() {
		String xpath = ".//span[text()='Continue Shopping']";
		return By.xpath(xpath);
	}

	public static By remove(int n) {
		String xpath = getProduct(n) + "//i[@class='icon-trash']";
		return By.xpath(xpath);
	}
	
	
}

