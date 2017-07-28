package exercise;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import core.ParameterizedTest;
import core.WebDriverManager;
import pageobject.WikiPag;
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
	public static Collection pageLanguage() {
		//@formatter:off
		return Arrays.asList(new Object[][] {
				{ "junit", "pt", true},
				{ "rampart scandal", "pt", false},
		});
	}
	
	@Test
	public void testPageLanguage() {
		WebDriver webDriver = WebDriverManager.getWebDriver();
		webDriver.get(WikiPag.url);
		WikiStep.search(this.termo);
		this.collector.checkThat(WikiStep.existLanguage(this.outraLinguagem), CoreMatchers.equalTo(this.existe));
	}
}
