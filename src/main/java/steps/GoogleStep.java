package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobject.GooglePag;
import core.WebDriverManager;

public class GoogleStep {

	public static void search(String termo) {

		WebDriver webdriver = WebDriverManager.getWebDriver();
		
		webdriver.findElement(GooglePag.inputSearch()).sendKeys(termo);
		webdriver.findElement(GooglePag.buttonSearch()).click();

	}

	public static String wrongGetResultStats() {

		WebDriver webdriver = WebDriverManager.getWebDriver();
		WebElement label = webdriver.findElement(GooglePag.labelResultStats());
		return label.getText();

	}

	public static String getResultStats() {

		WebDriver webdriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, 5);

		WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePag.labelResultStats()));
		return label.getText();
	}

}
