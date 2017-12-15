package autopractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import core.WebDriverManager;

public class ProductDetail {
	
	public static By incrementQuantity() {
		String xpath = "//a[@class='btn btn-default button-plus product_quantity_up']";
		return By.xpath(xpath);
	}
	
	public static Select selectSize() {
		Select dropdown = new Select(WebDriverManager.getWebDriver().findElement(By.id("group_1")));
		return dropdown;
	}
	
	public static By selectColor(String color) {
		String xpath = "//a[@name='"+ color +"']";
		return By.xpath(xpath);
	}
	
	public static By addToCart() {
		String xpath = "//p[@id='add_to_cart']";
		return By.xpath(xpath);
	}
	
	public static By getValorTotal() {
		String xpath = "//span[@class='ajax_block_cart_total']";
		return By.xpath(xpath);
	}
	
	public static By continueToShopping() {
		String xpath = "//span[@title='Continue shopping']";
		return By.xpath(xpath);
	}
	
	public static By proceedToCheckout() {
		String xpath = "//a[@title='Proceed to checkout']";
		return By.xpath(xpath);
	}

}
