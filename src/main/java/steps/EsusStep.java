package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverManager;
import pageobject.EsusPag;

public class EsusStep {
	
	public static void login(String login, String password) {
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.findElement(EsusPag.login()).sendKeys(login);
		webdriver.findElement(EsusPag.password()).sendKeys(password);
		webdriver.findElement(EsusPag.loginButton()).click();
		
	}
	
	public static void logout() {
		WebDriver webdriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, 2);
		WebElement userMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(EsusPag.userMenu()));
		userMenu.click();
		
	}
	
	public static void selectLotacao(String local, String lotacao) {
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, 2);
		WebElement lotacaoDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(EsusPag.lotacao(local, lotacao)));
		lotacaoDiv.click();
		
	}
	
	public static void selectCDS() {
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, 2);
		WebElement cds = wait.until(ExpectedConditions.visibilityOfElementLocated(EsusPag.cds()));
		cds.click();
		
	}
	
	public static void selectCadastroIndividual() {
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, 2);
		WebElement cadastroIndividual = wait.until(ExpectedConditions.visibilityOfElementLocated(EsusPag.cadastroIndividual()));
		cadastroIndividual.click();

		
	}
	
	public static String addCadastroIndividual() {
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, 2);
		WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(EsusPag.cadastrosIndividualAddButton()));
		String oldURL = webdriver.getCurrentUrl();
		add.click();
		return oldURL;
		
	}
	
	public static String cancelCadastroIndividual() {
		
		WebDriver webdriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, 2);
		WebElement cancel = wait.until(ExpectedConditions.visibilityOfElementLocated(EsusPag.adicionarCadastroCancelButton()));
		cancel.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EsusPag.cadastrosIndividualAddButton()));
		return webdriver.getCurrentUrl();
		
	}

}
