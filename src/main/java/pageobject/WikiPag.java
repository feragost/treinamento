package pageobject;

import org.openqa.selenium.By;

/**
 * Conjunto de localizadores (By) para elementos da página da Wikipedia.
 * Um objeto By é utilizado por um SearchContext (WebDriver ou WebElement) para encontrar WebElement(s).
 */

public class WikiPag {

	public static final String url = "https://en.wikipedia.org/wiki/Main_Page";

	public static By inputSearch() {
		return By.id("searchInput");
	}

	public static By inputSearchSubmit() {
		return By.id("searchButton");
	}

	public static By titlePage() {
		return By.id("firstHeading");
	}
}
