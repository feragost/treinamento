package wiki.exercise;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

import wiki.pageobject.WikiPag;
import wiki.steps.WikiStep;
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

		WebDriverManager.acessar(WikiPag.url);

		WikiStep.search(termo);

		WikiStep.selectLanguageByEnglishLanguage(linguagem);

		List<String> urlReferences = WikiStep.getUrlReferences();
		for (String url : urlReferences) {
			System.out.println(url);
		}

	}

}
