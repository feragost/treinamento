package autopractice.pageobject;

import org.openqa.selenium.By;

public class CompraPag {
	
	public static String xpathTotalPrice = "//*[@id='layer_cart']/div[1]/div[2]/div[3]/span";
	public static String xpathContinueShopping = "//*[@id='layer_cart']//span[@title='Continue shopping']";
	public static String xpathProceedToCheckOut = "//*[@id='layer_cart']/div/div[contains(@class,'layer_cart_cart')]/div[@class='button-container']/a";
	
	public static By byTotalPrice() {
		return By.xpath(xpathTotalPrice);
	}
	
	public static By byContinueShopping() {
		return By.xpath(xpathContinueShopping);
	}
	
	public static By byProceedToCheckOut() {
		return By.xpath(xpathProceedToCheckOut);
	}

}
