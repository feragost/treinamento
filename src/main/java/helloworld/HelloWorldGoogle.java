package helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import pageobject.GooglePag;
import steps.GoogleStep;
import core.WebDriverManager;
import core.WebDriverRunner;

@RunWith(WebDriverRunner.class)
public class HelloWorldGoogle {

	@Test
	public void run() {

		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get(GooglePag.url);

		GoogleStep.search("teste");
		String resultStats = GoogleStep.wrongGetResultStats();

		System.out.println(resultStats);

	}

}
