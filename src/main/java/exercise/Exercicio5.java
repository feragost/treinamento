package exercise;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.WebDriverManager;
import core.WebDriverRunner;
import exception.NoCancelMessageReceived;
import exception.UnexpectedErrorMessage;
import pageobject.PecPag;
import steps.PecStep;

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
		PecStep.loginAsTyper();
		try {
			PecStep.cancelRecord();
		} catch (UnexpectedErrorMessage e) {
			e.printStackTrace();
			System.exit(1);
		}
		PecStep.logout();
	}
	
	@Test
	public void cancelMessage() {
		PecStep.loginAsTyper();
		try {
			PecStep.cancelRecordAlreadyChanged();
		} catch (NoCancelMessageReceived e) {
			e.printStackTrace();
			System.exit(1);
		}
		PecStep.logout();
	}
}
