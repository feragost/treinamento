package helloworld;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import core.WebDriverManager;
import core.WebDriverRunner;
import steps.WikiStep;

@RunWith(WebDriverRunner.class)
public class HelloWorldExercicios {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {

		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
		WikiStep.search("metallica");

		this.collector.checkThat(WikiStep.getPageHeader(), CoreMatchers.equalTo("Metallica"));
		this.collector.checkThat(webdriver.getCurrentUrl(), CoreMatchers.containsString("Metallica"));

	}

}
