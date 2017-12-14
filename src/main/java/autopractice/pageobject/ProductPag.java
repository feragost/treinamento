package autopractice.pageobject;

import org.openqa.selenium.By;

public class ProductPag {
	
	public static String xpathButtonPlus = "//p[@id='quantity_wanted_p']/a[2]";
	public static String xpathSelectSize = "//select[@id='group_1\']";
	public static String xpathColorGreen = "//a[@id='color_15']";
	public static String xpathAddToCart = "//p[@id='add_to_cart']/button";
	
	public static By byButtonPlus() {
		return By.xpath(xpathButtonPlus);
	}
	
	public static By bySelectSize() {
		return By.xpath(xpathSelectSize);
	}
	
	public static By byColorGreen() {
		return By.xpath(xpathColorGreen);
	}
	
	public static By byButtonAddToCart() {
		return By.xpath(xpathAddToCart);
	}

}
