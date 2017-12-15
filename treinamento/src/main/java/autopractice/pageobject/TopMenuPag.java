package autopractice.pageobject;

import org.openqa.selenium.By;

public class TopMenuPag {

	public static String xpathTopMenu = "//div[@id='block_top_menu']";
	public static String xpathWomenSubmenu = getXpathLi("Women");
	public static String xpathDressesSubmenu = getXpathLi("Dresses");
	public static String xpathTShirtSubmenu = getXpathLi("T-shirts");

	public static By byLiWomen() {
		return By.xpath(xpathWomenSubmenu);
	}

	public static By byLiDresses() {
		return By.xpath(xpathDressesSubmenu);
	}

	public static By byLiTShirt() {
		return By.xpath(xpathTShirtSubmenu);
	}

	private static String getXpathLi(String text) {
		return xpathTopMenu + "/ul/li/a[text()='" + text + "']";
	}

}
