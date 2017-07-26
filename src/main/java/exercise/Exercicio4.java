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
	public static final String dataInicial = "25/03/2017";
	public static final String dataFinal = "01/07/2017";

	@Test
	public void run() {
		// TODO Auto-generated method stub
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
		
		webdriver.findElement(By.id("searchInput")).sendKeys(termo);
		webdriver.findElement(By.id("searchButton")).click();
		webdriver.findElement(By.xpath("//a[@class='interlanguage-link-target' and @lang='fr']")).click();
		webdriver.findElement(By.xpath("//li[@id='ca-history']//a")).click();
		
		
		//Getting all contributors, do not know how to handle the date
		By contributorsXPATH = By.xpath("//bdi");
		List<WebElement> references = webdriver.findElements(contributorsXPATH);
		for (WebElement webElement : references) {
			System.out.println(webElement.getText());
		}

	}

}
