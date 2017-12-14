package autopractice.pageobject;

import org.openqa.selenium.By;

import autopractice.component.CheckBox;

public class CatalogPag {

	public static String xpathPriceRangeContainer = "//div[@class='layered_slider_container']";

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
	
	public static CheckBox checkInStock() {
		return new CheckBox("//*[@id='uniform-layered_quantity_1']/..");
	}

	//Retorna o componente de filtro de cores do catalogo
	public static By getCatalogColors() {
		String xpath = "//ul[@id='ul_layered_id_attribute_group_3']";
		return By.xpath(xpath);
	}

	//Retorna o componente PRICE RANGE
	public static By getPriceRange() {
		String xpath = "//div[@class='layered_price']";
		return By.xpath(xpath);
	}

}
