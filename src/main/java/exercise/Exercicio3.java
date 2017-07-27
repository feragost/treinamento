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
import pageobject.WikiPag;

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
		webdriver.get(WikiPag.url);
		
		By byInputSearch = By.id("searchInput");

		WebElement elementInputSearch = webdriver.findElement(byInputSearch);
		elementInputSearch.sendKeys(termo);
		webdriver.findElement(By.id("searchButton")).click();
		
		By bySearchLink = ByXPath.xpath(".//li[@class='interlanguage-link interwiki-ar']/..//a[contains(@title, '"+linguagem+"')]");
		
		WebElement x = webdriver.findElement(bySearchLink);
		webdriver.get(x.getAttribute("href"));
		
		
		By bySearchReference = ByXPath.xpath(".//ol[@class='references']//a[@class='external text']");
		List<WebElement> findElements = webdriver.findElements(bySearchReference);
		
		for (WebElement element: findElements) {
			System.out.println(element.getAttribute("href"));
		}
		
	}

}
