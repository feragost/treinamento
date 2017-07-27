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
	public static final String linguagem = "Frech";
	public static final String dataInicial = "25/03/2017";
	public static final String dataFinal = "01/07/2017";

	@Test
	public void run() {
		
	    
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/w/index.php?title=Roosevelt_dime&action=history");
		
		
		
		By xpath = By.xpath("//ul[@id='pagehistory']//li[@data-mw-revid<=792558985 and @data-mw-revid>=792543110]//bdi");
		
        List<WebElement> findElements = webdriver.findElements(xpath);
		
		for(WebElement we:findElements) {
			
		String x =we.getText();
		
		System.out.println(x);
		
		}
		
		
		// TODO Auto-generated method stub

	}

}
