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
 * * A partir da página https://en.wikipedia.org/wiki/Main_Page,
 * 1. fazer a pesquisa pelo termo definido.
 * 2. navegar até o artigo com a linguagem definida.
 * 3. entrar no histórico de revisões do artigo.
 * 2. imprimir o nome dos contribuidores que modificaram o artigo no período definido.
 */

@RunWith(WebDriverRunner.class)
public class Exercicio4 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	public static final String termo = "Economy of Jamaica";
	public static final String linguagem = "French";
	public static final String dataInicial = "11891492";
	public static final String dataFinal = "126629568";

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
		
		WebElement linkHistory = webDriver.findElement(By.xpath(".//a[@accesskey='h']"));
		linkHistory.click();
		List<WebElement> contributions = webDriver.findElements(By.xpath(".//li[@data-mw-revid > "+dataInicial+" and @data-mw-revid < "+dataFinal+"]")); 
		
		for(WebElement contribution: contributions) {
			WebElement contributor = contribution.findElement(By.xpath(".//bdi"));
			System.out.println(contributor.getText());
		}
	}

}
