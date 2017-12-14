package autopractice.pageobject;

import org.openqa.selenium.By;

public class ShoppingCartSummaryPag {
	
	public static String xpathTotalPrice = "//span[@id='total_price']";
	public static String xpathContinueShopping = "//*[@id='center_column']/p[@class='cart_navigation clearfix']/a[@title='Continue shopping']";
	
	public static By byTotalPrice() {
		return By.xpath(xpathTotalPrice);
	}
	
	public static By byContinueShopping() {
		return By.xpath(xpathContinueShopping);
	}
}
