package autopractice.pageobject;

import org.openqa.selenium.By;

public class ProductList {

	public static String xpathProductList = "//ul[contains(@class, 'product_list')]";
	public static String xpathProductContainer = "//div[@class='product-container']";

	public static By by() {
		return By.xpath(xpathProductList);
	}

	public static ProductContainer product(int order) {
		String xpath = xpathProductList + xpathProductContainer;
		xpath = "(" + xpath + ")[" + order + "]";
		return new ProductContainer(xpath);
	}

	public static By liList() {
		return By.id("list");
	}

	public static By buttonCompare() {
		String xpath = "//button[contains(@class, 'bt_compare')]";
		return By.xpath(xpath);
	}
	
	public static By produtosCatalogo() { //usar com findElements pra poder iterar nos itens da lista
		String xpath = "//*[@id='center_column']/ul[contains(@class,'product_list')]//div[@class='row']";
		return By.xpath(xpath);
	}
	
	public static By precosProdutosCatalogo() { //usar com findElements pra poder iterar nos itens da lista
		String xpath = "//*[@id='center_column']/ul[contains(@class,'product_list')]//div[@class='row']/div[contains(@class,'right-block')]//span[@itemprop='price']";
		return By.xpath(xpath);
	}
	
	public static By nomesProdutosCatalogo() { //usar com findElements pra poder iterar nos itens da lista
		String xpath = "//*[@id='center_column']/ul[contains(@class,'product_list')]//div[@class='row']/div[contains(@class,'center-block')]//a[@itemprop='url']";
		return By.xpath(xpath);
	}
	
	public static By inStockProdutosCatalogo() { //usar com findElements pra poder iterar nos itens da lista
		String xpath = "//*[@id='center_column']/ul[contains(@class,'product_list')]//div[@class='row']/div[contains(@class,'center-block')]//span[contains(@class,'available-now')]";
		return By.xpath(xpath);
	}
}
