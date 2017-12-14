package autopractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import core.WebDriverManager;

public class ProductDetailPag {

	public static String xpathProductDetail = "TODO";
	public static String xpathProductContainer = "//div[@class='product-container']";

	public static By by() {
		return By.xpath(xpathProductDetail);
	}

	public static By byPlusItemButton() {
		return By.xpath("//*[@class='icon-plus']");
	}

	public static void dropdownSelectElement(WebDriver webDriver, String visibleText) {
		Select dropdown = new Select(webDriver.findElement(By.xpath("//*[@class='form-control attribute_select no-print']")));
		dropdown.selectByVisibleText(visibleText);
	}

	public static By byGreenColorButton() {
		return By.xpath("//*[@name='Green' and contains(@class, 'color_pick')]");
	}

	public static By byAddToCartButton() {
		return By.xpath("//*[text()='Add to cart']");
	}

	public static By byTotalPurchasePriceButton() {
		return By.xpath("//*[@class='ajax_block_cart_total']");
	}

	public static By byContinueShoppingButton() {
		return By.xpath("//*[@class='continue btn btn-default button exclusive-medium']");
	}
}
