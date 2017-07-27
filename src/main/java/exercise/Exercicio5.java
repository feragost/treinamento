package exercise;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverManager;
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
	
	public static final String cpf = "10268599998";
	public static final String password = "123456aa";

	@Test
	public void run() {
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("http://150.162.196.140:8080/esus/#/pec");
		
		By byLoginInput = By.className("login-input");
		WebElement elementLoginInput = webdriver.findElement(byLoginInput);
		elementLoginInput.sendKeys(cpf);
		
		WebElement elementPasswordInput = webdriver.findElement(By.xpath(".//input[@type='password']"));
		elementPasswordInput.sendKeys(password);
		elementPasswordInput.sendKeys(Keys.RETURN);
		
		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@peid='SECRETARIAMUNICIPALDESAUDEDEFLORIANOPOLIS.DIGITADOR']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@peid='class br.gov.saude.esus.EsusUserMenuViewImpl.cds']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains (@style, 'cadastro_individual')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@peid='FichaCadastroIndividualListingViewImpl.Adicionar']"))).click();

		
		
	}

}
