package core.steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverManager;

public class DocumentReady {

	/**
	 * Aguarda o carregamento completo de uma página.
	 */
	public static void max(int sec) {

		final WebDriver driver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}

	/**
	 * Aguarda a mudança da url.
	 */
	public static void mudancaUrl(final String urlAtual) {
		final WebDriver driver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return !wdriver.getCurrentUrl().equals(urlAtual);
			}
		});
	}

}
