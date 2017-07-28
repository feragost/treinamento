package exercise;

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
import steps.PecStep;

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

	@Test
	public void run() {
		PecStep.loginAsTyper();
		WebDriver webDriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webDriver, 3);
		WebElement cdsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='noselect nodrag']")));
		cdsButton.click();
		
		WebElement individualRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@style, 'cadastro_individual.png')]")));
		individualRecord.click();
		WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Adicionar']")));
		addButton.click();
		
		WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[boolean(@disabled) and contains(@class, ' x-form-text x-form-field x-form-no-radius-right')]")));
		cityInput.click();
		
		PecStep.logout();
	}

}
