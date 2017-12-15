package wiki.exercise;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.Parameterized.Parameters;

import wiki.pageobject.WikiPag;
import wiki.steps.WikiStep;
import core.ParameterizedTest;
import core.WebDriverManager;

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
	public void teste() {

		WebDriverManager.acessar(WikiPag.url);

		WikiStep.search(this.termo);

		this.collector.checkThat(WikiStep.existsLanguage(this.outraLinguagem), CoreMatchers.equalTo(this.existe));

	}

}
