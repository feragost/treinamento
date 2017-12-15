package wiki.exercise;

import java.text.ParseException;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import wiki.pageobject.WikiPag;
import wiki.steps.WikiStep;
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
	public static final long dataInicial = 123550263;
	public static final long dataFinal = 126629568;

	@Test
	public void run() throws ParseException {

		WebDriverManager.acessar(WikiPag.url);

		WikiStep.search(termo);

		WikiStep.selectLanguageByEnglishLanguage(linguagem);

		WikiStep.clickHistoryRevision();

		List<WebElement> revisionsBetweenDates = WikiStep.getPageRevisions(dataInicial, dataFinal);
		for (WebElement revision : revisionsBetweenDates) {
			String revisionAuthor = WikiStep.getRevisionAuthor(revision);
			System.out.println(revisionAuthor);
		}

	}

}
