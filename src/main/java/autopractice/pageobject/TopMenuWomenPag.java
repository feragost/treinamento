package autopractice.pageobject;

import org.openqa.selenium.By;

public class TopMenuWomenPag {

	public static By byLinkCasualDresses() {
		return By.xpath(getXpathLink("Casual Dresses"));
	}

	public static By byLinkEveningDresses() {
		return By.xpath(getXpathLink("Evening Dresses"));
	}

	public static By byLinkSummerDresses() {
		return By.xpath(getXpathLink("Summer Dresses"));
	}

	private static String getXpathLink(String text) {
		return TopMenuPag.xpathDressesSubmenu + "/..//a[text()='" + text + "']";
	}

}
