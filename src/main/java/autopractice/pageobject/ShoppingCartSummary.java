package autopractice.pageobject;

import org.openqa.selenium.By;

public class ShoppingCartSummary {
	
	public static By getValorTotal() {
		String xpath = "//span[@id='total_price']";
		return By.xpath(xpath);
	}
	
	public static By continueShopping() {
		String xpath = "//a[@title='Continue shopping']";
		return By.xpath(xpath);
	}

}
