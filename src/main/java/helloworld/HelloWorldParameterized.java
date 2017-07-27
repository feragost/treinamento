package helloworld;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import core.ParameterizedTest;
import core.WebDriverManager;
import steps.WikiStep;

public class HelloWorldParameterized extends ParameterizedTest {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	private String searchTerm;
	private String expectedTitle;

	public HelloWorldParameterized(String searchTerm, String expectedTitle) {
		this.searchTerm = searchTerm;
		this.expectedTitle = expectedTitle;
	}

	@Parameters
	public static Collection primeNumbers() {

		//@formatter:off
		return Arrays.asList(new Object[][] {
				{ "metallica", "Metallica" },
				{ "junit", "JUnit" },
		});
	}

	@Test
	public void testPrimeNumberChecker() {

		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("https://en.wikipedia.org/wiki/Main_Page");
		WikiStep.search(this.searchTerm);
		this.collector.checkThat(WikiStep.getPageHeader(), CoreMatchers.equalTo(this.expectedTitle));

	}

}
