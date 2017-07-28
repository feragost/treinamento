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
 * 1. fazer a pesquisa pelo termo definido
 * 2. imprimir o nome das demais linguagens (em inglês) que possuem artigo para o mesmo termo.
 */

@RunWith(WebDriverRunner.class)
public class Exercicio2 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	public static final String termo = "Avai Futebol Clube";

	@Test
	public void run() {
		WebDriver webDriver = WebDriverManager.getWebDriver();
		webDriver.get(WikiPag.url);
		WebElement inputSearch = webDriver.findElement(WikiPag.inputSearch());
		WebElement inputButton = webDriver.findElement(WikiPag.inputSearchSubmit());
		inputSearch.sendKeys(termo);
		inputButton.click();
		
		List<WebElement> liLanguages = webDriver.findElements(By.xpath(".//li["
				+ "																contains(@class, 'interlanguage-link interwiki')"
				+ "															]"));
		
		for(WebElement language: liLanguages) {
			System.out.println(language.getText());
		}
	}

}