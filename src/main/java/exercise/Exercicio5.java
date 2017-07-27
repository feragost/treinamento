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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By.ByXPath;

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
	WebDriver webdriver = WebDriverManager.getWebDriver();
	WebDriverWait wait = new WebDriverWait(webdriver, 5);
	
	private void teste() {
		webdriver.get("http://localhost:8080/esus/#/pec");
		
		By byLogin = ByXPath.xpath(".//input[@type='text']");
		WebElement elementLogin = webdriver.findElement(byLogin);
		elementLogin.sendKeys("44873232406");
		
		By byPassword = ByXPath.xpath(".//input[@type='password']");
		WebElement elementPassword = webdriver.findElement(byPassword);
		elementPassword.sendKeys("123456aa");
		
		By byButton = ByXPath.xpath(".//button[@type='button']");
		WebElement elementButton = webdriver.findElement(byButton);
		elementButton.click();
		
		By byButtonCDS = ByXPath.xpath(".//div[@peid='class br.gov.saude.esus.EsusUserMenuViewImpl.cds']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byButtonCDS));
		WebElement elementButtonCDS = webdriver.findElement(byButtonCDS);
		elementButtonCDS.click();
		
		By byCadastroInd = ByXPath.xpath(".//div[contains(@style, 'cadastro_individual')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byCadastroInd));
		WebElement elementCadastroInd = webdriver.findElement(byCadastroInd);
		elementCadastroInd.click();
		
		By byAdicionar = ByXPath.xpath(".//div[@peid='FichaCadastroIndividualListingViewImpl.Adicionar']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byAdicionar));
		WebElement elementAdicionar = webdriver.findElement(byAdicionar);
		elementAdicionar.click();
		
	}
	@Test
	public void semMsg() {
		teste();
		By byCancelar = ByXPath.xpath(".//div[@peid='CadastroIndividualDetailViewImpl.Cancelar']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byCancelar));
		WebElement elementCancelar = webdriver.findElement(byCancelar);
		elementCancelar.click();
		
		By byMessageBox = ByXPath.xpath(".//div[@peid='message-box']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byMessageBox));
		List<WebElement> elementMessageBox = webdriver.findElements(byMessageBox);
		this.collector.checkThat(elementMessageBox.isEmpty(), CoreMatchers.equalTo(true));
	}
	@Test
	public void comMsg() {
		teste();
		By byNome = ByXPath.xpath(".//div[@peid='IdentificacaoUsuarioCidadaoForm.nomeCidadao']/input");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byNome));
		WebElement elementNome = webdriver.findElement(byNome);
		elementNome.sendKeys("Felipe");
		
		By byCancelar = ByXPath.xpath(".//div[@peid='CadastroIndividualDetailViewImpl.Cancelar']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byCancelar));
		webdriver.findElement(byCancelar).click();
		
		By byMessageBox = ByXPath.xpath(".//div[@peid='message-box']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byMessageBox));
		List<WebElement> elementMessageBox = webdriver.findElements(byMessageBox);
		this.collector.checkThat(elementMessageBox.isEmpty(), CoreMatchers.equalTo(false));
	}
	

}
