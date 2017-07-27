package exercise;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

import core.WebDriverRunner;

/**
 * 1. Logar no PEC com um profissional que consiga criar novas fichas de cadastro individual.
 * 2. Ir até a página de adição do cadastro individual e CANCELAR o cadastro sem nenhum preenchimento.
 * 3. Verificar que o sistema não apresenta nenhuma mensagem de confirmação do cancelamento.
 * 4. Em outro teste, verificar se o sistema apresenta a mensagem de confirmação do cancelamento quando preenchemos algum valor no formulário.
 */

@RunWith(WebDriverRunner.class)
public class Exercicio5 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
