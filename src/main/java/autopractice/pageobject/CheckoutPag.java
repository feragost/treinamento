package autopractice.pageobject;

import org.openqa.selenium.By;

public class CheckoutPag {

	
	public static By totalPrice() {
		String xpath = ".//span[@id = 'total_price']";
		return By.xpath(xpath);
	}
	
	public static By continueShopping() {
		String xpath = ".//a[@title = 'Continue shopping']";
		return By.xpath(xpath);
	}
}
