package google.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import core.WebDriverManager;
import core.WebDriverRunner;
import google.pageobject.GooglePag;
import google.steps.GoogleStep;

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
