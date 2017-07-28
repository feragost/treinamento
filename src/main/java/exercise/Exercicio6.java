package exercise;

import java.util.List;

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

/**
 * 1. Logar no PEC com um profissional que consiga criar novas fichas de cadastro individual.
 * 2. Ir até a página de adição do cadastro individual.
 * 3. Verificar que:
 * 3.1: quando a NACIONALIDADE não está selecionada, os combos "Município e UF de nascimento" e "Data de entrada no Brasil" estão inativos.
 * 3.2: quando a NACIONALIDADE é Brasileira, o combo "Município e UF de nascimento" fica ativo e o combo "Data de entrada no Brasil" fica inativo.
 * 3.3: quando a NACIONALIDADE é Naturalizada, os combos "Município e UF de nascimento" e "Data de entrada no Brasil" estão inativos.
 * 3.4: quando a NACIONALIDADE é Estrangeiro, o combo "Município e UF de nascimento" fica inativo e o combo "Data de entrada no Brasil" fica ativo.
 */

@RunWith(WebDriverRunner.class)
public class Exercicio6 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	private String cpf;
	private String senha;
	
	@Test
	public void run() {
		cpf="04396629907";
		senha="123456aa";
		// TODO Auto-generated method stub
		 WebDriver webdriver = WebDriverManager.getWebDriver();

			webdriver.get("http://localhost:8080/esus/#/pec");

			By login = By.xpath("//input[@type='text']");
			WebElement acessar_login = webdriver.findElement(login);
			acessar_login.sendKeys(cpf);
			By password = By.xpath("//input[@type='password']");
			WebElement acessar_password = webdriver.findElement(password);

			
			acessar_password.sendKeys(senha);	
//			fazer Login
			mudarTela(webdriver,  "//button"); 
//			Se houver mais de um perfil, escolher Digitador
			mudarTela(webdriver,"//div[contains(text(),'DIGITADOR')]"); 
			
//			Acessar Modulo CDS
			mudarTela(webdriver, "//div[@peid='class br.gov.saude.esus.EsusUserMenuViewImpl.cds']"); 
//			Acessar Modulo cadastro individual
			mudarTela(webdriver, ("//div[@style='background-image: url(\"images/principal/cadastro_individual.png\"); "
												+ "user-select: none; position: absolute; z-index: 10; background-position: 0px 0px; "
												+ "width: 225px; height: 94px; left: 0px; top: 0px;']"));
	;
			
//			Acessar Adicionar Ficha
			mudarTela(webdriver, "//div[@peid='FichaCadastroIndividualListingViewImpl.Adicionar']");
			if(radioChecked(webdriver,"//label[contains(text(),'Brasileira')]/../input[@checked]")) {
				System.out.println("radiobutton ativo");
			}
			if(campoDisabled(webdriver,"//label[contains(text(),'Munic�pio e UF de nascimento')]/../input[@disabled]")) {
				System.out.println("campo desabilitado");

			}
	}
	public static void mudarTela(WebDriver webdriver,String xpath) {
		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		By botao = By.xpath(xpath);
		WebElement painel = wait.until(ExpectedConditions.visibilityOfElementLocated(botao));
		painel.click();

		

	}
	public static boolean radioChecked(WebDriver webdriver,String xpath) {
		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		By radio = By.xpath(xpath);
    	List<WebElement> findElements = webdriver.findElements(radio);
		if(findElements.isEmpty()) {
			return false;
		}
		return true;
	}
	public static boolean campoDisabled(WebDriver webdriver,String xpath) {
		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		By radio = By.xpath(xpath);
    	List<WebElement> findElements = webdriver.findElements(radio);
    	if(findElements.isEmpty()) {
			return false;
		}
		return true;
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

}
