package exercise;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverManager;
import core.WebDriverRunner;
import pageobject.GooglePag;
import pageobject.WikiPag;

/**
 * 1. Logar no PEC com um profissional que consiga criar novas fichas de cadastro individual.
 * 2. Ir até a página de adição do cadastro individual e CANCELAR o cadastro sem nenhum preenchimento.
 * 3. Verificar que o sistema não apresenta nenhuma mensagem de confirmação do cancelamento.
 * 4. Em outro teste, verificar se o sistema apresenta a mensagem de confirmação do cancelamento quando preenchemos algum valor no formulário.
 * 
 */

@RunWith(WebDriverRunner.class)
public class Exercicio5 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	public WebDriver webdriver = WebDriverManager.getWebDriver();
	public WebDriverWait wait = new WebDriverWait(webdriver, 5);
	
	public void reuso() {
		webdriver.get("http://localhost:8080/esus/#/pec");
		
		By byInputLogin = ByXPath.xpath(".//input[@type ='text']");
		WebElement elementInputLogin = webdriver.findElement(byInputLogin);
		elementInputLogin.sendKeys("53138619215");
		
		By byInputSenha = ByXPath.xpath(".//input[@type='password']");
		WebElement elementInputSenha = webdriver.findElement(byInputSenha);
		elementInputSenha.sendKeys("123456aa");
		
		By byAcessar = ByXPath.xpath(".//button[@class='simple-btn round shadow azul login-acessar']");
		webdriver.findElement(byAcessar).click();
		
		By byCDS = ByXPath.xpath(".//div[@peid='class br.gov.saude.esus.EsusUserMenuViewImpl.cds']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byCDS));
		webdriver.findElement(byCDS).click();
				
		By byCadInd = ByXPath.xpath(".//div[contains(@style,'cadastro_individual.png')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byCadInd));
		webdriver.findElement(byCadInd).click();
		
		By byCadAdd = ByXPath.xpath(".//div[@peid='FichaCadastroIndividualListingViewImpl.Adicionar']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byCadAdd));
		webdriver.findElement(byCadAdd).click();
		
	}
	
	@Test
	public void semMensagem() {
		
		// TODO Auto-generated method stub
		reuso();	
		
		By byCancelar = ByXPath.xpath(".//div[@peid='CadastroIndividualDetailViewImpl.Cancelar']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byCancelar));
		webdriver.findElement(byCancelar).click();
		
		By bySearchMB = ByXPath.xpath(".//div[@peid='message-box']");
		List<WebElement> x = webdriver.findElements(bySearchMB);
		this.collector.checkThat(x.isEmpty(), CoreMatchers.equalTo(true));	
	}
	
	@Test
	public void comMensagem() {
		
		reuso();
		
		By byPreencher = ByXPath.xpath(".//div[@peid='IdentificacaoUsuarioCidadaoForm.numeroCartaoSus']/input");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byPreencher));
		WebElement elementPreencher = webdriver.findElement(byPreencher);
		elementPreencher.sendKeys("asdasdasdasdasdasdas");
		
		By byCancelar = ByXPath.xpath(".//div[@peid='CadastroIndividualDetailViewImpl.Cancelar']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byCancelar));
		webdriver.findElement(byCancelar).click();
	
		By bySearchMB = ByXPath.xpath(".//div[@peid='message-box']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(bySearchMB));
		List<WebElement> x = webdriver.findElements(bySearchMB);
		this.collector.checkThat(x.isEmpty(), CoreMatchers.equalTo(false));	
	}

}
