package exercise;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import core.WebDriverManager;
import core.WebDriverRunner;
import exception.NoRecentDeaths;
import pageobject.WikiPag;
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
		WebDriverManager.acessPage(WikiPag.url);
		try {
			List<WebElement> recentDeaths = WikiStep.getRecentDeaths();
			WebElementPrinter.printWebElements(recentDeaths);
		} catch (NoRecentDeaths e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
