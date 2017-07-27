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
import org.openqa.selenium.By.ByXPath;
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

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private String termo;
	private String outraLinguagem;
	private boolean existe;
	
	public Exercicio7(String termo, String outraLinguagem, boolean existe) {
		this.termo = termo;
		this.outraLinguagem = outraLinguagem;
		this.existe = existe;
	}
	
	@Parameters
	public static Collection primeNumbers() {

		//@formatter:off
		return Arrays.asList(new Object[][] {
				{ "junit", "pt", true },
				{ "rampart scandal", "pt", false },
		});
	}

	@Test
	public void testPrimeNumberChecker() {

		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
		WikiStep.search(this.termo);
		By byTeste = ByXPath.xpath(".//h3[@id='p-lang-label']/../div//a[contains(@lang,'"+outraLinguagem+"')]");
		List<WebElement> elementsTeste = webdriver.findElements(byTeste);
		this.collector.checkThat(!elementsTeste.isEmpty(), CoreMatchers.equalTo(existe));

	}
}
