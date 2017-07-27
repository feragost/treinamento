package exercise;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

import core.WebDriverManager;
import core.WebDriverRunner;

/**
 * A partir da página https://en.wikipedia.org/wiki/Main_Page, imprimir o nome das pessoas que morreram recentemente.
 */

@RunWith(WebDriverRunner.class)
public class Exercicio1 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
		By byRecentDeaths = ByXPath.xpath(".//a[contains(title(), 'Recent deaths')]/../../div]");
		WebElement elementRecentDeaths = webdriver.findElement(byRecentDeaths);
		System.out.println(elementRecentDeaths.getText());
		//List<WebElement> elementRecentDeaths = webdriver.findElements(byRecentDeaths);
		
		//for (WebElement webElement : elementRecentDeaths) {
			//System.out.println(webElement.getAttribute("title"));
		//}
	}

}
