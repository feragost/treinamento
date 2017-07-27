package exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.ParameterizedTest;
import core.WebDriverManager;
import core.WebDriverRunner;
import pageobject.GooglePag;

/**
 * 1. Logar no PEC com um profissional que consiga criar novas fichas de cadastro individual.
 * 2. Ir até a página de adição do cadastro individual e CANCELAR o cadastro sem nenhum preenchimento.
 * 3. Verificar que o sistema não apresenta nenhuma mensagem de confirmação do cancelamento.
 * 4. Em outro teste, verificar se o sistema apresenta a mensagem de confirmação do cancelamento quando preenchemos algum valor no formulário.
 */

public class Exercicio5 extends ParameterizedTest {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private String cpf;
	private String senha;

	public Exercicio5 (String cpf, String senha) {
		this.cpf = cpf;
		this.senha = senha;
		
	}
	
			
	@Test
	public void run() {
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("http://localhost:8080/esus/#/pec");
		By login = By.xpath("//input[@type='text']");
		WebElement acessar_login = webdriver.findElement(login);
		acessar_login.sendKeys(cpf);
		By password = By.xpath("//input[@type='password']");
		WebElement acessar_password = webdriver.findElement(password);

		
		acessar_password.sendKeys(senha);		
		By botao = By.xpath("//button");
		WebElement click_botao = webdriver.findElement(botao);
		click_botao.click();

		By digitador = By.xpath("//div[contains(text(),'DIGITADOR')]");
		WebDriverWait wait = new WebDriverWait(webdriver, 5);

		WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(digitador));
		//WebElement acessar_digitador = webdriver.findElement(digitador);

		label.click();
		
		By cds = By.xpath("//div[@peid='class br.gov.saude.esus.EsusUserMenuViewImpl.cds']");
		WebDriverWait wait2 = new WebDriverWait(webdriver, 5);

		WebElement painel = wait2.until(ExpectedConditions.visibilityOfElementLocated(cds));
		
		painel.click();
	}
	
		@Parameters
	public static Collection primeNumbers() {

		//@formatter:off
		return Arrays.asList(new Object[][] {
				{ "04396629907", "123456aa" },
		});
	}
	

}
