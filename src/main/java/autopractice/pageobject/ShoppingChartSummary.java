package autopractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import core.WebDriverManager;

public class ShoppingChartSummary {

	public static String xpathShoppingChartSummary = "//*[@id='cart_title']/..";
	
	public static By by() {
		return By.xpath(xpathShoppingChartSummary);
	}

	public static By byTotalPurchasePriceButton() {
		return By.xpath(xpathShoppingChartSummary + "//*[@id='total_price']");
	}

	public static By byContinueShoppingButton() {
		return By.xpath(xpathShoppingChartSummary + "//*[@title='Continue shopping' and @class='button-exclusive btn btn-default']");
	}
}
