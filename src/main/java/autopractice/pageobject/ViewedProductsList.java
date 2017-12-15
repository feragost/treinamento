package autopractice.pageobject;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import core.WebDriverManager;

public class ViewedProductsList {

	public static String xpathViewProducts = "//*[contains(@id, 'viewed-products')]";

	public static ViewItemContainer item(int order) {
		String xpath = xpathViewProducts + ViewItemContainer.productName;
		xpath = "(" + xpath + ")[" + order + "]";
		return new ViewItemContainer(xpath);
	}
	
	public static By by() {
		return By.xpath(xpathViewProducts);
	}
}
