package core;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {

	private static WebDriver webdriver;

	public static WebDriver getWebDriver() {
		if (webdriver == null) {
			throw new RuntimeException("WebDriver não iniciado.");
		}

		return webdriver;
	}

	public static void acessar(String url) {
		getWebDriver().get(url);
	}

	public static WebDriverWait getWebDriverWait() {
		WebDriver webdriver = WebDriverManager.getWebDriver();
		return new WebDriverWait(webdriver, 10);
	}

	public static WebElement waitVisibleElement(By locator) {
		WebDriverWait wait = getWebDriverWait();
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static Boolean waitInvisibleElement(By locator) {
		WebDriverWait wait = getWebDriverWait();
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static List<WebElement> waitVisibleElements(By locator) {
		WebDriverWait wait = getWebDriverWait();
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public static List<String> getTextOfVisibleElementsWith(By locator) {

		LinkedList<String> lista = new LinkedList<String>();

		List<WebElement> visibleElements = WebDriverManager.waitVisibleElements(locator);
		for (WebElement we : visibleElements) {
			lista.add(we.getText());
		}

		return lista;

	}

	public static void moveMouseTo(By by) {
		WebDriver wd = getWebDriver();
		Actions builder = new Actions(wd);
		WebElement visibleElement = waitVisibleElement(by);
		builder.moveToElement(visibleElement).build().perform();
	}

	public static void scroolTo(WebElement element) {
		WebDriver wd = getWebDriver();
		((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	protected static WebDriver create() {

		String file = "/chromedriver.exe";
		if (System.getProperty("os.name").equals("Linux")) {
			file = "/chromedriverlinux";
		}

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + file);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		options.addArguments("--disable-breakpad");
		options.addArguments("--disable-gpu");
		options.addArguments("--incognito");

		Map<String, Object> preferences = new Hashtable<String, Object>();
		options.setExperimentalOption("prefs", preferences);
		preferences.put("plugins.always_open_pdf_externally", Boolean.TRUE);

		webdriver = new ChromeDriver(options);
		webdriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		webdriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		return webdriver;

	}

	protected static void close() {
		webdriver.close();
		webdriver.quit();
		webdriver = null;
	}

}
