package autopractice.pageobject;

import org.openqa.selenium.By;

public class CatalogPag {
	public static String xpathForm = "//form[@id='layered_form']";
	public static String xpathLayeredFilter = "/div[@id='layered_filter']";
	public static String xpathEnabledFilter = "/div[@id='enabled_filters']";
	public static String xpathPriceRangeContainer = "//div[@class='layered_slider_container']";
	
	/*
	public static By byDisableFilter(String name) {
		String xpath = xpathForm + "//span[text() = '"+name+"']/..";
		return By.xpath(xpath);
	}*/
	
	public static By byEnableFilter(String name) {
		String xpath = xpathForm + "//a[text() = '"+name+"']";
		return By.xpath(xpath);
	}
	
	public static By byColorFilter(String n) {
		String xpath = "(" + xpathForm + "//label[@class='layered_color']/../input)["+n+"]";
		return By.xpath(xpath);
	}

	public static By bySpanPriceRange() {
		return By.id("layered_price_range");
	}

	public static By byLeftPriceRange() {
		String xpath = xpathPriceRangeContainer + "//a[1]";
		return By.xpath(xpath);
	}

	public static By byRightPriceRange() {
		String xpath = xpathPriceRangeContainer + "//a[2]";
		return By.xpath(xpath);
	}

}
