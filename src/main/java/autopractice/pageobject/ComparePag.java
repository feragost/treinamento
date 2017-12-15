package autopractice.pageobject;

import org.openqa.selenium.By;

public class ComparePag {
	
	private static String xpathTable = "//table[@id='product_comparison']";
	private static String xpathButtonContinueShopping = "//*[@id='center_column']/ul[@class='footer_link']//a[descendant::span[text()='Continue Shopping']]";
	
	public static By nomesItensCompare() { //usar com findElements pra poder iterar nos itens 
		String xpath = xpathTable + "//td[contains(@class,'product-block')]//a[contains(@class,'product-name')]";
		return By.xpath(xpath);
	}
	
	public static By precosItensCompare() { //usar com findElements pra poder iterar nos itens
		String xpath = xpathTable + "//td[contains(@class,'product-block')]//div[@class='prices-container']//span[@class='price product-price']";
		return By.xpath(xpath);
	}
	
	public static By byButtonContinueShopping() {
		return By.xpath(xpathButtonContinueShopping);
	}
}
