package autopractice.pageobject;

import org.openqa.selenium.By;

public class TopMenuDressesPag {
	
	public static By byLinkSummerDresses() {
		return By.xpath(getXpathLink("Summer Dresses"));
	}
	
	private static String getXpathLink(String text) {
		return TopMenuPag.xpathDressesSubmenu + "//a[text()='" + text + "']";
	}

}
