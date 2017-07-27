package exercise;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import core.WebDriverManager;
import core.WebDriverRunner;
import pageobject.GooglePag;
import pageobject.WikiPag;

/**
 * A partir da página https://en.wikipedia.org/wiki/Main_Page, imprimir o nome das pessoas que morreram recentemente.
 */

@RunWith(WebDriverRunner.class)
public class Exercicio1 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {
		// TODO Auto-generated method stub
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get(WikiPag.url);
		
//		String xpath = "(.//div[2]/b)";
//		System.out.println(webdriver.findElement(By.xpath(xpath)).getText());
//		
//		String xpath1 = "(.//div[2]/div/ul/li/a)";
//		System.out.println(webdriver.findElement(By.xpath(xpath1)).getText());
		
		String xpath2 = "(.//div[2]/b/a[text()='Recent deaths']/../..//div)";
		System.out.println(webdriver.findElement(By.xpath(xpath2)).getText());
	}

}
