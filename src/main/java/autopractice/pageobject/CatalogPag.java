package autopractice.pageobject;

import org.openqa.selenium.By;

public class CatalogPag {

	public static String xpathPriceRangeContainer = "//div[@class='layered_slider_container']";
	public static String xpathButtonCompare = "//*[@id='center_column']/div[contains(@class,'content_sortPagiBar')]/div[contains(@class,'top-pagination-content')]/form/button";
	public static String xpathViewedProductsFirstItem = "//*[@id='viewed-products_block_left']/div[contains(@class,'products-block')]/ul/li[contains(@class,'first_item')]/a";
	public static String xpathViewedProductsLastItem = "//*[@id='viewed-products_block_left']/div[contains(@class,'products-block')]/ul/li[contains(@class,'last_item')]/a";
	
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

	public static By byButtonCompare() {
		return By.xpath(xpathButtonCompare);
	}
	
	public static By byCounterButtonCompare() {
		String xpath = xpathButtonCompare + "//strong[contains(@class,'total-compare-val')]";
		return By.xpath(xpath);
	}
	
	public static By byViewedProductsFirstItem() {
		return By.xpath(xpathViewedProductsFirstItem);
	}
	
	public static By byViewedProductsLastItem() {
		return By.xpath(xpathViewedProductsLastItem);
	}
	
	public static By itensColor() { //usar com findElements pra poder iterar nos itens li
		String xpath = "//*[@id='ul_layered_id_attribute_group_3']/li";
		return By.xpath(xpath);
	}
	
	public static By byCounterProducts() {
		String xpath = "//*[@id=\"center_column\"]//span[contains(@class,'heading-counter')]";
		return By.xpath(xpath);
	}
	
	public static By bySelectProductSort() {
		String xpath = "//select[@id='selectProductSort']";
		return By.xpath(xpath);
	}
}
