package wiki.pageobject;

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

	public static By linksRecentDeaths() {
		String xpath = "(//div[descendant::a[text()='Recent deaths']])[last()]/div[@class='hlist inline']//a";
		return By.xpath(xpath);
	}

	public static By linksLanguage() {
		String xpath = "//li[contains(@class, 'interlanguage-link')]//a";
		return By.xpath(xpath);
	}

	public static By linkLanguage(String lang) {
		String xpath = "//li[contains(@class, 'interlanguage-link')]//a[@lang='" + lang + "']";
		return By.xpath(xpath);
	}

	public static By linkHistoryRevisions() {
		return By.id("ca-history");
	}

	public static By revisionRegisters(long start, long end) {
		return By.xpath("//li[@data-mw-revid > " + start + " and @data-mw-revid < " + end + "]");
	}

	public static By linkReferences() {
		return By.xpath("//ol[@class='references']//a");
	}

}
