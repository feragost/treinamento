package autopractice.pageobject;

import org.openqa.selenium.By;

public class ProductList {

	public static String xpathProductList = "//ul[contains(@class, 'product_list')]";
	public static String xpathProductContainer = "//div[@class='product-container']";

	public static By by() {
		return By.xpath(xpathProductList);
	}
	
	public static By byAllProductContainers() {
		String xpath = xpathProductList + xpathProductContainer;
		return By.xpath(xpath);
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
	
	public static By strongCompareVal() {
		String xpath = "//strong[@class='total-compare-val']";
		return By.xpath(xpath);
	}
	
	public static By imgLoading() {
		String xpath = xpathProductList + "//img[descending::*[contains(text(), 'Loading')]]";
		return By.xpath(xpath);
	}

}
