package exercise;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
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

	public static final String termo = "ava� � fc";

	@Test
	public void run() {
		// TODO Auto-generated method stub

	}

}
