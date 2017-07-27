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
		WebDriver webDriver = WebDriverManager.getWebDriver();
		webDriver.get(WikiPag.url);
		WebElement inputSearch = webDriver.findElement(WikiPag.inputSearch());
		WebElement buttonSearch = webDriver.findElement(WikiPag.inputSearchSubmit());
		inputSearch.sendKeys(termo);
		buttonSearch.click();
		
		WebElement linkLanguage = webDriver.findElement(By.xpath(".//a["
				+ "														contains(@title, '"+linguagem+"')"
				+ "														and ancestor::li["
				+ "															contains(@class, 'interlanguage-link interwiki')"
				+ "															]"
				+ "													]"));
		linkLanguage.click();
		
		WebElement orderedList = webDriver.findElement(By.xpath(".//ol ["
				+ "								contains(@class, 'references')"
				+ "							]"));
		List<WebElement> listLinks = orderedList.findElements(By.xpath(".//a"));
		
		for (WebElement link: listLinks) {
			System.out.println(link.getAttribute("href"));
		}
	}

}
