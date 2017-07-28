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
import steps.WikiStep;

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
	public void nacionalidadeVazia() {
		reuso();
		By byPreencherNac = ByXPath.xpath(".//div[@peid='FieldSetPanel.nacionalidade']/../../..//input");
		List<WebElement> radios = webdriver.findElements(byPreencherNac);
		
		for (WebElement element: radios) {
			this.collector.checkThat(element.isSelected(), CoreMatchers.equalTo(false));
		}
		
		By byMunicipio = ByXPath.xpath(".//div[@peid='IdentificacaoUsuarioCidadaoForm.localidadeSelectDto']/input[@disabled]");
		this.collector.checkThat(webdriver.findElement(byMunicipio).isEnabled(), CoreMatchers.equalTo(false));
				
		By byData = ByXPath.xpath(".//div[@peid='IdentificacaoUsuarioCidadaoForm.dtEntradaBrasil']/input[@disabled]");
		this.collector.checkThat(webdriver.findElement(byData).isEnabled(), CoreMatchers.equalTo(false));				
	
	}
	
	@Test
	public void nacionalidadeBrasileira() {
		reuso();
		
		By byPreencherNac = ByXPath.xpath(".//div[@peid='FieldSetPanel.nacionalidade']/../../..//input");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byPreencherNac));
		List<WebElement> radios = webdriver.findElements(byPreencherNac);
		
		radios.get(0).click();

		By byMunicipio = ByXPath.xpath(".//div[@peid='IdentificacaoUsuarioCidadaoForm.localidadeSelectDto']//input");
		this.collector.checkThat(webdriver.findElement(byMunicipio).isEnabled(), CoreMatchers.equalTo(true));
				
		By byData = ByXPath.xpath(".//div[@peid='IdentificacaoUsuarioCidadaoForm.dtEntradaBrasil']/input[@disabled]");
		this.collector.checkThat(webdriver.findElement(byData).isEnabled(), CoreMatchers.equalTo(false));	
	}

	@Test
	public void nacionalidadeNaturalizado() {
		reuso();
		
		By byPreencherNac = ByXPath.xpath(".//div[@peid='FieldSetPanel.nacionalidade']/../../..//input");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byPreencherNac));
		List<WebElement> radios = webdriver.findElements(byPreencherNac);
		
		radios.get(1).click();

		By byMunicipio = ByXPath.xpath(".//div[@peid='IdentificacaoUsuarioCidadaoForm.localidadeSelectDto']/input[@disabled]");
		this.collector.checkThat(webdriver.findElement(byMunicipio).isEnabled(), CoreMatchers.equalTo(false));
				
		By byData = ByXPath.xpath(".//div[@peid='IdentificacaoUsuarioCidadaoForm.dtEntradaBrasil']/input[@disabled]");
		this.collector.checkThat(webdriver.findElement(byData).isEnabled(), CoreMatchers.equalTo(false));	
	}
	
	@Test
	public void nacionalidadeEstrangeiro() {
		reuso();
		
		By byPreencherNac = ByXPath.xpath(".//div[@peid='FieldSetPanel.nacionalidade']/../../..//input");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byPreencherNac));
		List<WebElement> radios = webdriver.findElements(byPreencherNac);
		
		radios.get(2).click();

		By byMunicipio = ByXPath.xpath(".//div[@peid='IdentificacaoUsuarioCidadaoForm.localidadeSelectDto']/input[@disabled]");
		this.collector.checkThat(webdriver.findElement(byMunicipio).isEnabled(), CoreMatchers.equalTo(false));
				
		By byData = ByXPath.xpath(".//div[@peid='IdentificacaoUsuarioCidadaoForm.dtEntradaBrasil']//input");
		this.collector.checkThat(webdriver.findElement(byData).isEnabled(), CoreMatchers.equalTo(true));	
	}

}
