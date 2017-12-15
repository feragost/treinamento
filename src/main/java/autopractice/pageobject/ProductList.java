package autopractice.pageobject;

import org.openqa.selenium.By;

public class ProductList {

	public static String xpathProductList = "//ul[contains(@class, 'product_list')]";
	public static String xpathProductContainer = "//div[@class='product-container']";
	public static String xpathProductSort = "//select[@id='selectProductSort']";

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

	public static By divSort() {
		return By.id("uniform-selectProductSort");
	}
	
	public static By buttonCompare() {
		String xpath = "//button[contains(@class, 'bt_compare')]";
		return By.xpath(xpath);
	}
	
	public static By totalCompareValue() {
		String xpath = "//strong[@class='total-compare-val']";
		return By.xpath(xpath);
	}
	
	public static By divSort(String value) {
		return By.xpath("//div[@id='uniform-selectProductSort']//option[@value='"+ value +"']");
	}
	
	public static By showingItems() {
		String xpath = "//div[@class='product-count']";
		return By.xpath(xpath);
	}
}
