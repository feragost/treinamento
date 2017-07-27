package exercise;

import java.util.List;
import java.util.Locale;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	public static final String dataInicial = "31 octobre 2007";
	public static final String dataFinal = "31 octobre 2008";

	@Test
	public void run() throws ParseException {
		// TODO Auto-generated method stub
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
		
		webdriver.findElement(By.id("searchInput")).sendKeys(termo);
		webdriver.findElement(By.id("searchButton")).click();
		webdriver.findElement(By.xpath("//a[@class='interlanguage-link-target' and contains(@title, '"+linguagem+"')]")).click();
		webdriver.findElement(By.xpath("//li[@id='ca-history']//a")).click();
		
		DateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.FRENCH);
		Date initialDate = sdf.parse(dataInicial);;
		Date finalDate = sdf.parse(dataFinal);
		
		By contributorsXPATH = By.xpath("//ul[@id='pagehistory']/li");
		List<WebElement> contributors = webdriver.findElements(contributorsXPATH);
		for (WebElement webElement : contributors) {
			By changeDate = By.xpath(".//a[@class='mw-changeslist-date']");
			String dateText = webElement.findElement(changeDate).getText();
			Date contribuitionDate = sdf.parse(dateText);

			if (contribuitionDate.after(initialDate) && contribuitionDate.before(finalDate)) {
				System.out.println(webElement.findElement(By.xpath(".//bdi")).getText());
			}
		}

	}

}
