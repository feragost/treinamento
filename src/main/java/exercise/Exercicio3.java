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

/**
 * A partir da página https://en.wikipedia.org/wiki/Main_Page,
 * 1. fazer a pesquisa pelo termo definido.
 * 2. navegar até o artigo com a linguagem definida.
 * 3. Imprimir todas as urls dos links que aparecem nas referências do artigo.
 */

@RunWith(WebDriverRunner.class)
public class Exercicio3 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	public static final String termo = "Economy of Jamaica";
	public static final String linguagem = "French";

	@Test
	public void run() {
		// TODO Auto-generated method stub
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
		
		By byInputSearch = By.id("searchInput");
		WebElement elementInputSearch = webdriver.findElement(byInputSearch);
		elementInputSearch.sendKeys(termo);
		webdriver.findElement(By.id("searchButton")).click();
		webdriver.findElement(By.xpath("//a[@class='interlanguage-link-target' and contains(@title, '"+linguagem+"')]")).click();
		
		By referencesXPATH = By.xpath("//span[@class='reference-text']//a[@class='external text']");
		List<WebElement> references = webdriver.findElements(referencesXPATH);
		for (WebElement webElement : references) {
			System.out.println(webElement.getAttribute("href"));
		}

	}

}
