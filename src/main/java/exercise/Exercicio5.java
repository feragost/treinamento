package exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hamcrest.CoreMatchers;
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
import org.w3c.dom.Text;

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
//		fazer Login
		mudarTela(webdriver,  "//button"); 
//		Se houver mais de um perfil, escolher Digitador
		mudarTela(webdriver,"//div[contains(text(),'DIGITADOR')]"); 
//		Acessar Modulo CDS
		mudarTela(webdriver, "//div[@peid='class br.gov.saude.esus.EsusUserMenuViewImpl.cds']"); 
//		Acessar Modulo cadastro individual
		mudarTela(webdriver, ("//div[@style='background-image: url(\"images/principal/cadastro_individual.png\"); "
											+ "user-select: none; position: absolute; z-index: 10; background-position: 0px 0px; "
											+ "width: 225px; height: 94px; left: 0px; top: 0px;']"));
;
		
//		Acessar Adicionar Ficha
		mudarTela(webdriver, "//div[@peid='FichaCadastroIndividualListingViewImpl.Adicionar']");
//		Cancelar sem preencher nenhum campo
		mudarTela(webdriver,"//div[@peid='CadastroIndividualDetailViewImpl.Cancelar']");
		
		if (TelaExiste(webdriver,"//div[@peid='message-box']//div[contains(text(),'Deseja cancelar a inclus�o?')]")) {
			System.out.print(" Apareceu a tela");
		}
		else {
			System.out.print("N�o apareceu a tela");

		}
		

	}
	
	
	@Test
	public void run2() {
		run();
//		Acessar Adicionar Ficha
		 WebDriver webdriver = WebDriverManager.getWebDriver();

		//webdriver.get("http://localhost:8080/esus/#/pec");
		mudarTela(webdriver, "//div[@peid='FichaCadastroIndividualListingViewImpl.Adicionar']");
		preencherCampo(webdriver, "//label[contains(text(),'Nome completo')]/../input", "Fabio");
		mudarTela(webdriver,"//div[@peid='CadastroIndividualDetailViewImpl.Cancelar']");
		if (TelaExiste(webdriver,"//div[@peid='message-box']//div[contains(text(),'Deseja cancelar a inclus�o?')]")) {
			System.out.print("Apareceu a tela");
		}
		else {
			System.out.print("N�o apareceu a tela");

		}

	}
	
	public static void mudarTela(WebDriver webdriver,String xpath) {
		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		By botao = By.xpath(xpath);
		WebElement painel = wait.until(ExpectedConditions.visibilityOfElementLocated(botao));
		painel.click();

		

	}
	
	public static void preencherCampo(WebDriver webdriver,String xpath, String dados) {
		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		By botao = By.xpath(xpath);

		WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(botao));
		campo.sendKeys(dados);
	}
	
	public static  boolean TelaExiste(WebDriver webdriver,String xpath) {
		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		By tela = By.xpath(xpath);
		 List<WebElement> findElements = webdriver.findElements(tela);
		 if(findElements.isEmpty()) {
			 return false;
		 }
		 	return true;


		

	}
	
	
		@Parameters
	public static Collection primeNumbers() {

		//@formatter:off
		return Arrays.asList(new Object[][] {
				{ "04396629907", "123456aa" },
		});
	}
	

}
