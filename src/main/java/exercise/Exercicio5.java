package exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverManager;
import core.WebDriverRunner;
import pageobject.EsusPag;
import pageobject.GooglePag;
import steps.WikiStep;

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
		WebDriver webdriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		
		webdriver.get(EsusPag.url);
		
		WebElement login = webdriver.findElement(EsusPag.loginField());
		WebElement senha = webdriver.findElement(EsusPag.passwordField());
		
		login.sendKeys("57445829679");
		senha.sendKeys("123456aa");

		webdriver.findElement(EsusPag.buttonAccess()).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EsusPag.cdsButton())).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EsusPag.cadastroIndividualButton()));
	
		List<WebElement> lista = webdriver.findElements(EsusPag.cadastroIndividualButton());
		WebElement botaoCadastroIndividual = lista.get(0);
		botaoCadastroIndividual.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EsusPag.adicionarButton())).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EsusPag.cancelarButton())).click();
		
//		wait.until(new ExpectedCondition<Boolean>() {
//	        public Boolean apply(WebDriver driver) {
//	            String value = element.getAttribute("value");
//
//	            if(!value.equals("")) {
//	                return true;
//	            }
//
//	            return false;
//	        }
//	    });
		
		this.collector.checkThat(webdriver.getCurrentUrl(), CoreMatchers.equalTo(EsusPag.cadastroIndividualUrl));
	}

}
