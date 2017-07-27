package exercise;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.WebDriverManager;
import core.WebDriverRunner;

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
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
		By byInputSearch = By.id("searchInput");
		WebElement elementInputSearch = webdriver.findElement(byInputSearch);
		elementInputSearch.sendKeys("Economy of Jamaica");
		webdriver.findElement(By.id("searchButton")).click();
		By byFrench = ByXPath.xpath(".//h3[@id='p-lang-label']/../div//a[contains(@title,'"+linguagem+"')]");
		WebElement elementFrench = webdriver.findElement(byFrench);
		elementFrench.click();
		By byLinks = ByXPath.xpath(".//ol[@class='references']//a[@rel='nofollow']");
		List<WebElement> elementsLinks = webdriver.findElements(byLinks);
		for (WebElement webElement : elementsLinks) {
			System.out.println(webElement.getAttribute("href"));
		}
	}

}
