package autopractice.pageobject;

import org.openqa.selenium.By;

public class ComparePag {
	
	private static String xpathTable = "//*[@id='product_comparison']";
	
	public static By nomesItensCompare() { //usar com findElements pra poder iterar nos itens li
		String xpath = xpathTable + "//td[contains(@class,'product-block')]//a[contains(@class,'product-name')]";
		return By.xpath(xpath);
	}
	
	public static By precosItensCompare() { //usar com findElements pra poder iterar nos itens li
		String xpath = xpathTable + "//td[contains(@class,'product-block')]//span[contains(@class,'product-price')]";
		return By.xpath(xpath);
	}
}
