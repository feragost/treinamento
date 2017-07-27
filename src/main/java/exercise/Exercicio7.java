package exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.ParameterizedTest;
import core.WebDriverManager;
import steps.WikiStep;

/**
 * A partir da página https://en.wikipedia.org/wiki/Main_Page,
 * criar um teste parametrizado que verifica se para um determinado artigo em inglês a partir do termo,
 * existe ou não o mesmo artigo em outra linguagem.
 *
 * exemplos: (junit, pt, true), (rampart scandal, pt, false)
 *
 */

public class Exercicio7 extends ParameterizedTest {

	private String termo;
	private String outraLinguagem;
	private boolean existe;
	
	public Exercicio7(String termo, String outraLinguagem, boolean existe) {
		this.termo = termo;
		this.outraLinguagem = outraLinguagem;
		this.existe = existe;
	}
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Parameters
	public static Collection parameters() {

		//@formatter:off
		return Arrays.asList(new Object[][] {
				{ "junit", "pt", true },
				{ "rampart scandal", "pt", false },
				{ "avai fc", "fr", true },
		});
	}
	
	@Test
	public void run() {
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
		WikiStep.search(this.termo);
		String xpath = ".//a[@lang='pt']";
		
		List<WebElement> lista = webdriver.findElements(By.xpath(xpath));
		this.collector.checkThat(lista.isEmpty(), CoreMatchers.equalTo(!this.existe));
	}

}
