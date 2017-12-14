package autopractice.pageobject;

import org.openqa.selenium.By;

import core.WebDriverManager;

public class CatalogPag {

	public static String xpathSizeContainer = genContainerXPath("Size");
	public static String xpathColorContainer = genContainerXPath("Color");
	public static String xpathCompositionsContainer = genContainerXPath("Compositions");
	public static String xpathStylesContainer = genContainerXPath("Styles");
	public static String xpathPropertiesContainer = genContainerXPath("Properties");
	public static String xpathAvailabilityContainer = genContainerXPath("Availability");
	public static String xpathManufacturerContainer = genContainerXPath("Manufacturer");
	public static String xpathConditionContainer = genContainerXPath("Condition");
	public static String xpathPriceRangeContainer = "//div[@class='layered_slider_container']";
	
	private static String genContainerXPath(String name) {
		return "//div[@class='layered_filter' and descendant::span[text()=' + name + ']]";
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
