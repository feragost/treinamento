package autopractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import core.WebDriverManager;

public class ProductDetailPag {

    public static WebDriver driver = WebDriverManager.getWebDriver();
    public static String xpathProductDetail = "TODO";
    public static String xpathProductContainer = "//div[@class='product-container']";

    public static By by() {
	return By.xpath(xpathProductDetail);
    }

    public static By byPlusItemButton() {
	return By.xpath("//*[@class='icon-plus']");
    }

    public static void dropdownSelectElement(String visibleText) {
	Select dropdown = new Select(driver.findElement(By.xpath("//*[@class='form-control attribute_select no-print']")));
	dropdown.selectByVisibleText(visibleText);
    }
}
