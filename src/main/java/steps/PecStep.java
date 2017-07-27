package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverManager;
import exception.NoCancelMessageReceived;
import exception.UnexpectedErrorMessage;
import pageobject.PecPag;

public class PecStep {
	public static void loginAsTyper() {
		WebDriver webDriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webDriver, 3);
		webDriver.get(PecPag.url);
		WebElement login = PecPag.inputCPF();
		WebElement password = PecPag.inputPassword();
		WebElement acessButton = PecPag.inputAcess();
		
		login.sendKeys("09991356940");
		password.sendKeys("123456aa");
		acessButton.click();
		WebElement buttonTyper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='DIGITADOR']")));
		buttonTyper.click();
	}
	
	public static void cancelRecord() throws UnexpectedErrorMessage {
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
		if (!(urlAdd.equals(newUrl))) {
			throw new UnexpectedErrorMessage();
		}
	}
	
	public static void cancelRecordAlreadyChanged() throws NoCancelMessageReceived {
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
		
		try {
			addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Adicionar']")));
		} catch (Exception e) {
			return;
		}
		throw new NoCancelMessageReceived();
	}
	
	public static void logout() {
		WebDriver webDriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webDriver, 3);
		WebElement userButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='user-menu-button']")));
		userButton.click();
		WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Sair']")));
		logoutButton.click();
	}
}
