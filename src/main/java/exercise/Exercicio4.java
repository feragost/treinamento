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
	public static final int dataInicial = 130190719;
	public static final int dataFinal = 123291993;

	@Test
	public void run() {
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
		
		By byInputSearch = By.id("searchInput");
		WebElement elementInputSearch = webdriver.findElement(byInputSearch);
		elementInputSearch.sendKeys(termo);
		webdriver.findElement(By.id("searchButton")).click();
//		webdriver.findElement(By.xpath(".//a[@lang='fr']")).click();
		webdriver.findElement(By.xpath(".//div[@id='p-lang']//a[contains(@title, 'French')]")).click();
		
		webdriver.findElement(By.xpath(".//li[@id='ca-history']")).click();
		
		
		
		List<WebElement> list = webdriver.findElements(By.xpath("(.//ul[@id='pagehistory']/li)"));		
		
		for(WebElement we : list) {
			String a = we.getAttribute("data-mw-revid");
			int i = Integer.parseInt(a);
			if(i <= dataInicial && i >= dataFinal) {
				System.out.println(we.findElement(By.xpath(".//span[@class='history-user']/a/bdi")).getText());
			}
		}
		
		
	}

}
