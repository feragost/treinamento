package exercise;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverManager;
import core.WebDriverRunner;
import pageobject.EsusPag;
import steps.EsusStep;

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
	
	public static final String login = "07769153980";
	public static final String password = "123456aa";

	@Test
	public void run() {
		// TODO Auto-generated method stub
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get(EsusPag.url);
		
		EsusStep.login(login, password);
		EsusStep.selectLotacao("SECRETARIAMUNICIPALDESAUDEDEFLORIANOPOLIS", "DIGITADOR");
		EsusStep.selectCDS();
		EsusStep.selectCadastroIndividual();
		EsusStep.addCadastroIndividual();
		EsusStep.cancelCadastroIndividual();
		String newURL = webdriver.getCurrentUrl();
		this.collector.checkThat(oldURL, CoreMatchers.equalTo(newURL));
		EsusStep.logout();

	}

}
