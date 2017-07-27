package exercise;

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
	public static final String dataInicial = "130190719";
	public static final String dataFinal = "128519443";

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
		
		
		By byHistoric = ByXPath.xpath(".//li[@id='ca-history']//a");
		webdriver.findElement(byHistoric).click();
		
		By byDataInicial = ByXPath.xpath(".//li[@data-mw-revid=130190719]/span[@class='history-user']/a/bdi");
		By byDataFinal = ByXPath.xpath(".//li[@data-mw-revid=128519443]/span[@class='history-user']/a/bdi");
		
		WebElement dataI = webdriver.findElement(byDataInicial);
		WebElement dataF = webdriver.findElement(byDataFinal);
		
		System.out.println(dataI.getText());
		System.out.println(dataF.getText());
				
	}

}
