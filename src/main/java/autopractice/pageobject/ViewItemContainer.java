package autopractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.WebDriverManager;

public class ViewItemContainer {

	private String startXpath;
	public static String productName = "//a[@class='product-name']";

	public ViewItemContainer(String xpath) {
		this.startXpath = xpath;
	}

	public By by() {
		return By.xpath(this.startXpath.replace(productName, ""));
	}
	
	public By byProductName() {
		return By.xpath(this.startXpath);
	}

	public By byProductHint() {
		return this.byProductName();
	}
}
