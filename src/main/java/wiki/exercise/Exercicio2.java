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

		WebDriverManager.acessar(WikiPag.url);

		WikiStep.search(termo);

		List<String> articleLanguages = WikiStep.getEnglishArticleLanguages();
		for (String lang : articleLanguages) {
			System.out.println(lang);
		}

	}

}
