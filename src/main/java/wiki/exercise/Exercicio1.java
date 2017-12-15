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
 * A partir da página https://en.wikipedia.org/wiki/Main_Page, imprimir o nome das pessoas que morreram recentemente.
 */

@RunWith(WebDriverRunner.class)
public class Exercicio1 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {

		WebDriverManager.acessar(WikiPag.url);

		List<String> peopleRecentDeaths = WikiStep.getPeopleRecentDeaths();
		for (String person : peopleRecentDeaths) {
			System.out.println(person);
		}

	}

}
