package exercise;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.WebDriverManager;
import core.WebDriverRunner;
import steps.WikiStep;

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
		
		
		By byInputSearch = By.xpath("//div/b/a[text()='Recent deaths']/../..//li");
		List<WebElement> findElements = webdriver.findElements(byInputSearch);
		
		for(WebElement we:findElements) {
			
			String x=we.getText();
			
			System.out.println(x);
			
	
		}
			
			
		
		// TODO Auto-generated method stub

	}

}
