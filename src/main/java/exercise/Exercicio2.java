package exercise;

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

	public static final String termo = "avaí fc";

	@Test
	public void run() {
		// TODO Auto-generated method stub
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get(WikiPag.url);
		
		//pesquisa pelo termo
		By byInputSearch = By.id("searchInput");
		WebElement elementInputSearch = webdriver.findElement(byInputSearch);
		elementInputSearch.sendKeys(termo);
		webdriver.findElement(By.id("searchButton")).click();
		
		String xpath = "(.//div[@id='p-lang']/div/ul)";
		System.out.println(webdriver.findElement(By.xpath(xpath)).getText());
		
		
	}

}
