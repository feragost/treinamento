package autopractice.pageobject;

import org.openqa.selenium.By;

public class TopMenuPag {

	public static String xpathTopMenu = "//div[@id='block_top_menu']";
//	public static String xpathWomenSubmenu = getXpathLi("Women");
//	public static String xpathDressesSubmenu = getXpathLi("Dresses");
//	public static String xpathTShirtSubmenu = getXpathLi("T-shirts");
	public static String xpathWomenSubmenu = "//*[@id='block_top_menu']/ul/li[1]";
	public static String xpathDressesSubmenu = "//*[@id='block_top_menu']/ul/li[2]";
	public static String xpathTShirtSubmenu = "//*[@id='block_top_menu']/ul/li[3]";

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
		return "//li[descendant::a[contains(@title, '" + text + "')]]";
	}

}
