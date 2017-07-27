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
import steps.WikiStep;

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
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
		WikiStep.search(termo);
		By xpath = By.xpath("//div[@id='p-lang']//li/a");
        List<WebElement> findElements = webdriver.findElements(xpath);
		
		for(WebElement we:findElements) {
			
		String x =we.getAttribute("title");
		
		System.out.println(x);
		
		}
		

	}

}
