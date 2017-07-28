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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverManager;
import core.WebDriverRunner;
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
	
	public Exercicio5() {
	}

	@Test
	public void run() {
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("http://localhost:8080/esus/#/pec");
		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		
		By bt = By.xpath("//input[@type='text']");
		WebElement login = webdriver.findElement(bt);
		login.sendKeys("77257556164");
		
		By bt1 = By.xpath("//input[@type='password']");
		WebElement senha = webdriver.findElement(bt1);
		senha.sendKeys("123456aa");
	
		By bt2 = By.xpath("//button[@type='button']");
		WebElement botaoAcessar = webdriver.findElement(bt2);
		botaoAcessar.click();
		
		By bt3 = By.xpath("//div[@peid='class br.gov.saude.esus.EsusUserMenuViewImpl.cds']/div");
		WebElement botaoCds = wait.until(ExpectedConditions.visibilityOfElementLocated(bt3));
		botaoCds.click();
		
		By bt4 = By.xpath("//div[@peid='EsusCdsMainViewImpl']/div/div/div");
		WebElement botaoCadInd = wait.until(ExpectedConditions.visibilityOfElementLocated(bt4));
		botaoCadInd.click();
		
		By bt5 = By.xpath("//div[@peid='FichaCadastroIndividualListingViewImpl.Adicionar']/button");
		WebElement botaoAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(bt5));
		botaoAdd.click();
		
		By bt6 = By.xpath("//div[@peid='CadastroIndividualDetailViewImpl.Cancelar']/button");
		WebElement botaoCancelar = wait.until(ExpectedConditions.visibilityOfElementLocated(bt6));
		botaoCancelar.click();
		
		webdriver.close();
		
	}
	
	@Test
	public void run2() {
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("http://localhost:8080/esus/#/pec");
		WebDriverWait wait = new WebDriverWait(webdriver, 5);
		
		By bt = By.xpath("//input[@type='text']");
		WebElement login = webdriver.findElement(bt);
		login.sendKeys("77257556164");
		
		By bt1 = By.xpath("//input[@type='password']");
		WebElement senha = webdriver.findElement(bt1);
		senha.sendKeys("123456aa");
	
		By bt2 = By.xpath("//button[@type='button']");
		WebElement botaoAcessar = webdriver.findElement(bt2);
		botaoAcessar.click();
		
		By bt3 = By.xpath("//div[@peid='class br.gov.saude.esus.EsusUserMenuViewImpl.cds']/div");
		WebElement botaoCds = wait.until(ExpectedConditions.visibilityOfElementLocated(bt3));
		botaoCds.click();
		
		By bt4 = By.xpath("//div[@peid='EsusCdsMainViewImpl']/div/div/div");
		WebElement botaoCadInd = wait.until(ExpectedConditions.visibilityOfElementLocated(bt4));
		botaoCadInd.click();
		
		By bt5 = By.xpath("//div[@peid='FichaCadastroIndividualListingViewImpl.Adicionar']/button");
		WebElement botaoAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(bt5));
		botaoAdd.click();
		
		By bt6 = By.xpath("//div[@peid='IdentificacaoUsuarioCidadaoForm.nomeCidadao']/input");
		WebElement nome = wait.until(ExpectedConditions.visibilityOfElementLocated(bt6));
		nome.sendKeys("Gisele");
		
		By bt7 = By.xpath("//div[@peid='CadastroIndividualDetailViewImpl.Cancelar']/button");
		WebElement botaoCancelar = wait.until(ExpectedConditions.visibilityOfElementLocated(bt7));
		botaoCancelar.click();
		
		By bt8 = By.xpath("//div[@peid='EsusMessages.Sim']/button");
		WebElement botaoSim = wait.until(ExpectedConditions.visibilityOfElementLocated(bt8));
		botaoSim.click();
		
		webdriver.close();
	}

}
