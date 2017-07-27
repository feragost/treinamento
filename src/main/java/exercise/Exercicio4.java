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
		By busca = By.id("searchInput");
		WebElement elementInputSearch = webdriver.findElement(busca);
		elementInputSearch.sendKeys(termo);
		webdriver.findElement(By.id("searchButton")).click();;
		By localizar_linguagem = By.xpath("//h3[@id='p-lang-label']/../div//a[contains(@title,'"+linguagem+"')]");

		WebElement acessar_linguagem = webdriver.findElement(localizar_linguagem);
		acessar_linguagem.click();
		
		By localizar_historico = By.xpath("//li[@id='ca-history']");
		WebElement acessar_historico = webdriver.findElement(localizar_historico);
		acessar_historico.click();

		
		
	}

}
