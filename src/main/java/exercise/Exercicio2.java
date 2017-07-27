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

/**
 * A partir da página https://en.wikipedia.org/wiki/Main_Page,
 * 1. fazer a pesquisa pelo termo definido
 * 2. imprimir o nome das demais linguagens (em inglês) que possuem artigo para o mesmo termo.
 */

@RunWith(WebDriverRunner.class)
public class Exercicio2 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	public static final String termo = "avai�fc";

	@Test
	public void run() {
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
	//	By teste = By.xpath(".//a[contains(text(),'Recent deaths')]/../../div");
		By busca = By.id("searchInput");
		WebElement elementInputSearch = webdriver.findElement(busca);
		elementInputSearch.sendKeys(termo);
		By teste = By.xpath("//h3[@id='p-lang-label']/../div");
		WebElement texto = webdriver.findElement(teste);

		System.out.println(texto.getText());

	}

}
