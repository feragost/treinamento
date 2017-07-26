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

	public static final String termo = "avaí fc";

	@Test
	public void run() {
		// TODO Auto-generated method stub

		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get(WikiPag.url);

		WebElement elementInputSearch = webdriver.findElement(WikiPag.inputSearch());
		elementInputSearch.sendKeys(termo);
		
		webdriver.findElement(WikiPag.inputSearchSubmit()).click();
		
		String xpath = ".//div[@id='p-lang']/div/ul";
		
		List<WebElement> list = webdriver.findElements(By.xpath(xpath));

		for (WebElement item: list) {
			System.out.println(item.getText());
		}
	}

}
