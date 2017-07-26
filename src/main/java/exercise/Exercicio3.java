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
	public static final String linguagem = "Français";

	@Test
	public void run() {
		// TODO Auto-generated method stub
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get(WikiPag.url);

		WebElement elementInputSearch = webdriver.findElement(WikiPag.inputSearch());
		elementInputSearch.sendKeys(termo);
		
		webdriver.findElement(WikiPag.inputSearchSubmit()).click();
		
		String xpath = ".//div[@id='p-lang']//a[contains(@title, 'French')]";
		
		webdriver.findElement(By.xpath(xpath)).click();
		
		String xpath2 = ".//span[@class='reference-text']/span/a";
		
		List<WebElement> list = webdriver.findElements(By.xpath(xpath2));
		
		for (WebElement item: list) {
			String url = item.getAttribute("href");
			System.out.println(url);
		}
	}
}
