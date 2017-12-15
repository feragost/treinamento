package autopractice.pageobject;

import org.openqa.selenium.By;

public class MorePag {

	public static By addItem() {
		String xpath = ".//i[@class = 'icon-plus']/../..";
		return By.xpath(xpath);
	}
	
	public static By selectSize(String size) {
		String xpath = ".//select[@id = 'group_1']/option[@title = '"+size+"']";
		return By.xpath(xpath);
	}
	
	public static By sizeSelector() {
		String xpath = ".//div[@class = 'selector']";
		return By.xpath(xpath);
	}

	public static By selectColor(String color) {
		String xpath = ".//a[@title = '"+color+"']";
		return By.xpath(xpath);
	}
	
	public static By addToCartButton() {
		String xpath = ".//span[text() = 'Add to cart']/..";
		return By.xpath(xpath);
	}
	
	
	
	
}
