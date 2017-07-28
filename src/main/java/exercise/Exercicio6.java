package exercise;

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
	WebDriver webdriver = WebDriverManager.getWebDriver();
	WebDriverWait wait = new WebDriverWait(webdriver, 5);
	@Test
	public void run() {
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

}
