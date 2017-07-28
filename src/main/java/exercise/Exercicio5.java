package exercise;

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

import core.WebDriverManager;
import core.WebDriverRunner;
import pageobject.PecPag;
import steps.PecStep;
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
		PecStep.loginAsTyper();
		WebDriver webDriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webDriver, 3);
		WebElement cdsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='noselect nodrag']")));
		cdsButton.click();
		
		WebElement individualRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@style, 'cadastro_individual.png')]")));
		individualRecord.click();
		
		WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Adicionar']")));
		String urlAdd = webDriver.getCurrentUrl();
		addButton.click();
		
		WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Cancelar']")));
		cancelButton.click();
		
		addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Adicionar']")));
		String newUrl = webDriver.getCurrentUrl();
		PecStep.logout();
		this.collector.checkThat(urlAdd, CoreMatchers.equalTo(newUrl));
	}
	
	@Test
	public void cancelMessage() {
		PecStep.loginAsTyper();
		WebDriver webDriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webDriver, 3);
		WebElement cdsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='noselect nodrag']")));
		cdsButton.click();
		
		WebElement individualRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@style, 'cadastro_individual.png')]")));
		individualRecord.click();
		
		WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Adicionar']")));
		addButton.click();
		
		WebElement inputName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[preceding::label[contains(text(), 'Nome')]]")));
		inputName.sendKeys("FULANO DE TAL");
		
		WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Cancelar']")));
		cancelButton.click();
		WebElement confirmCancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Sim']")));
		confirmCancelButton.click();
		PecStep.logout();
	}
}
