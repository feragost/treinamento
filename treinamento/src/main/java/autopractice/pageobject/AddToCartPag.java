package autopractice.pageobject;

import org.openqa.selenium.By;

public class AddToCartPag {
	public static By proceedToCheckoutButton() {
		String xpath = ".//a[@title = 'Proceed to checkout']";
		return By.xpath(xpath);
	}

	public static By continueShopppingButton() {
		String xpath = ".//span[@title = 'Continue shopping']";
		return By.xpath(xpath);
	}
	
	public static By totalPrice() {
		String xpath = ".//span[@class = 'ajax_block_cart_total']";
		return By.xpath(xpath);
	}
}
