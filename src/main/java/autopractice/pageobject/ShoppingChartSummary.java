package autopractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import core.WebDriverManager;

public class ShoppingChartSummary {

	public static String xpatShoppingChartSummary = "//*[@id='cart_title']/..";
	
	public static By by() {
		return By.xpath(xpatShoppingChartSummary);
	}

	public static By byTotalPurchasePriceButton() {
		return By.xpath(xpatShoppingChartSummary + "//*[@id='total_price']");
	}

	public static By byContinueShoppingButton() {
		return By.xpath(xpatShoppingChartSummary + "//*[@title='Continue shopping' and @class='button-exclusive btn btn-default']");
	}
}
