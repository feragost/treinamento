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
		WebDriver webDriver = WebDriverManager.getWebDriver();
		webDriver.get(WikiPag.url);
		WebElement divDeaths = webDriver.findElement(By.xpath("(.//div["
				+ "													descendant::b["
				+ "														descendant::a["
				+ "														@title='Deaths in 2017'"
				+ "													]"
				+ "												]"
				+ "											])[last()]"));

		List<WebElement> recentDeaths = divDeaths.findElements(By.xpath(".//li"));
		
		for(WebElement death: recentDeaths) {
			System.out.println(death.getText());
		}
	}

}
