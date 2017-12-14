package autopractice.pageobject;

import org.openqa.selenium.By;

public class TopMenuPag {

	public static String xpathTopMenu = "//div[@id='block_top_menu']";
	public static String xpathWomenSubmenu = xpathTopMenu + getXpathLi("Women");
	public static String xpathDressesSubmenu = xpathTopMenu + getXpathLi("Dresses");
	public static String xpathTShirtSubmenu = xpathTopMenu + getXpathLi("T-shirts");

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
		return "/ul/li/a[@title='"+ text +"']";
	}

}
