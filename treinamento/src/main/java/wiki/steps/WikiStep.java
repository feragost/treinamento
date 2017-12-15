package wiki.steps;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverManager;
import wiki.pageobject.WikiPag;

/**
 * Passos (parametrizáveis ou não) realizados sobre a Wikipedia.
 *
 */

public class WikiStep {

	/**
	 * Realiza uma pesquisa partir de um termo.
	 */
	public static void search(String termSeach) {

		WebDriver webdriver = WebDriverManager.getWebDriver();
		WebDriverWait wait = new WebDriverWait(webdriver, 5);

		wait.until(ExpectedConditions.visibilityOfElementLocated(WikiPag.inputSearch())).sendKeys(termSeach);
		webdriver.findElement(WikiPag.inputSearchSubmit()).click();

	}

	/**
	 * Retorna o valor do título do artigo aberto.
	 */
	public static String getPageHeader() {

		WebDriver webdriver = WebDriverManager.getWebDriver();
		return webdriver.findElement(WikiPag.titlePage()).getText();

	}

	public static List<String> getPeopleRecentDeaths() {

		return WebDriverManager.getTextOfVisibleElementsWith(WikiPag.linksRecentDeaths());

	}

	public static List<String> getArticleLanguages() {

		return WebDriverManager.getTextOfVisibleElementsWith(WikiPag.linksLanguage());

	}

	public static List<String> getEnglishArticleLanguages() {

		LinkedList<String> lista = new LinkedList<String>();

		List<WebElement> visibleElements = WebDriverManager.waitVisibleElements(WikiPag.linksLanguage());
		for (WebElement we : visibleElements) {
			lista.add(getEnglishLanguage(we));
		}

		return lista;

	}

	private static String getEnglishLanguage(WebElement linkLanguageElement) {
		return linkLanguageElement.getAttribute("title").split("–")[1].trim();
	}

	public static void selectLanguageByEnglishLanguage(String englishLanguage) {

		List<WebElement> languageElements = WebDriverManager.waitVisibleElements(WikiPag.linksLanguage());
		for (WebElement e : languageElements) {
			if (getEnglishLanguage(e).equals(englishLanguage)) {
				e.click();
				break;
			}
		}

	}

	public static boolean existsLanguage(String lang) {
		return !WebDriverManager.getWebDriver().findElements(WikiPag.linkLanguage(lang)).isEmpty();
	}

	public static void clickHistoryRevision() {
		WebDriverManager.waitVisibleElement(WikiPag.linkHistoryRevisions()).click();
	}

	public static List<WebElement> getPageRevisions(long start, long end) {
		return WebDriverManager.waitVisibleElements(WikiPag.revisionRegisters(start, end));
	}

	public static String getRevisionAuthor(WebElement revision) {
		return revision.findElement(By.xpath(".//bdi")).getText();
	}

	public static List<String> getUrlReferences() {
		List<WebElement> linkReferences = WebDriverManager.waitVisibleElements(WikiPag.linkReferences());
		List<String> urlReferences = new LinkedList<String>();
		for (WebElement we : linkReferences) {
			urlReferences.add(we.getAttribute("href"));
		}

		return urlReferences;
	}

}
