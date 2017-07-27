package exercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import core.WebDriverManager;
import core.WebDriverRunner;
import pageobject.WikiPag;

/**
 * A partir da página https://en.wikipedia.org/wiki/Main_Page, imprimir o nome das pessoas que morreram recentemente.
 */

@RunWith(WebDriverRunner.class)
public class Exercicio1 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {
		// TODO Auto-generated method stub
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get(WikiPag.url);
		
		String xpath = "//div[@id='mp-itn']/div[2]/div[2]";
		List<WebElement> list = webdriver.findElements(By.xpath(xpath));

		for (WebElement item: list) {
			System.out.println(item.getText());
		}
	}

}
