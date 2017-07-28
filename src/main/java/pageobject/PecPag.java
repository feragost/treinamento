package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverManager;

public class PecPag {

	public static final String url = "http://150.162.196.244:8080/esus/#/pec";
	
	public static WebElement inputCPF() {
		return WebDriverManager.getWebDriver().findElement(By.xpath(".//input[@type='text']"));
	}
	
	public static WebElement inputPassword() {
		return WebDriverManager.getWebDriver().findElement(By.xpath(".//input[@type='password']"));
	}
	
	public static WebElement inputAcess() {
		return WebDriverManager.getWebDriver().findElement(By.xpath(".//button[contains(@class, 'simple-btn round shadow azul login-acessar')]"));
	}
}
