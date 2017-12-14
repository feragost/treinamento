package autopractice.pageobject;

import org.openqa.selenium.By;

public class TopMenuPag {

	public static String xpathTopMenu = "//div[@id='block_top_menu']";
	public static String xpathWomenSubmenu = getXpathLi("Women");
	public static String xpathDressesSubmenu = getXpathLiDresses("Dresses");
	public static String xpathTShirtSubmenu = getXpathLiTShirt("T-shirts");
	public static String xpathTShirtButton = xpathTShirtSubmenu + "/a";

	public static By byLiWomen() {
		return By.xpath(xpathWomenSubmenu);
	}

	public static By byLiDresses() {
		return By.xpath(xpathDressesSubmenu);
	}
	
	public static By byLiTShirt() {
		return By.xpath(xpathTShirtSubmenu);
	}
	
	public static By byButtonTShirt() {
		return By.xpath(xpathTShirtButton);
	}

	private static String getXpathLi(String text) {
		return "//li[descendant::a[text()='" + text + "']]";
	}
	
	private static String getXpathLiDresses(String text) {
		return "(//li[descendant::a[text()='" + text + "']])[3]";
	}
	
	private static String getXpathLiTShirt(String text) {
		return "(//li[descendant::a[text()='" + text + "']])[4]";
	}

}
