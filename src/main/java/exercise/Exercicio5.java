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
import pageobject.GooglePag;

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
		//cria webdriver
		WebDriver webdriver = WebDriverManager.getWebDriver();
		//entra no esus
		webdriver.get("http://localhost:8080/esus/#/pec");
		
		//pega os inputs de senha e login
		String xpathLogin = ".//input[@class='login-input'][@type='text']";
		String xpathSenha = ".//input[@class='login-input'][@type='password']";
		WebElement login = webdriver.findElement(By.xpath(xpathLogin));
		WebElement senha = webdriver.findElement(By.xpath(xpathSenha));
		
		//preenche com digitador
		login.sendKeys("27651127706");
		senha.sendKeys("123456aa");
		
		//aperta no acessar
		String xpathBotaoAcessar = ".//button";
		webdriver.findElement(By.xpath(xpathBotaoAcessar)).click();
		
		//aperta no cds
		String xpathBotaoCDS = ".//div[@peid='class br.gov.saude.esus.EsusUserMenuViewImpl.cds']";
		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathBotaoCDS))).click();
		
		//aperta no cadastro individual gambiarra
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='noselect nodrag']")));
//		List <WebElement> botaoCadastroIndivitual = webdriver.findElements(By.xpath(".//div[@class='noselect nodrag']"));
//		botaoCadastroIndivitual.get(0).click();
		
		//aperta no cadastro individual
		String xpathBotaoCadastroInduvidual = ".//div[contains (@style, 'cadastro_individual')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathBotaoCadastroInduvidual))).click();
		
		//apertar no adicionar cadastro individual
		String xpathBotaoAdicionarCadastroIndividual = ".//div[@peid='FichaCadastroIndividualListingViewImpl.Adicionar']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathBotaoAdicionarCadastroIndividual))).click();
		
		//apertar no cancelar
		String xpathCancelarCadastroIndividual = ".//div[@peid='CadastroIndividualDetailViewImpl.Cancelar']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathCancelarCadastroIndividual))).click();
				
	}

}
