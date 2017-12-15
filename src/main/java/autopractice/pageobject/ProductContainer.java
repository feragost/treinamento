package autopractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.WebDriverManager;

public class ProductContainer {

	private String startXpath;
	private String leftBlock;
	private String centerBlock;
	private String rightBlock;
	
	public static String vPlus = "add_to_compare";
	public static String vMinus = "add_to_compare checked";

	public ProductContainer(String xpath) {
		this.startXpath = xpath;
		this.leftBlock = xpath + "//div[contains(@class, 'left-block')]";
		this.centerBlock = xpath + "//div[contains(@class, 'center-block')]";
		this.rightBlock = xpath + "//div[contains(@class, 'right-block')]";
	}

	public By by() {
		return By.xpath(this.startXpath);
	}

	public By byImg() {
		String xpath = this.leftBlock + "//img";
		return By.xpath(xpath);
	}

	public By byLinkName() {
		String xpath = this.centerBlock + "//h5[@itemprop='name']/a";
		return By.xpath(xpath);
	}
	
	public By byProductDesc() {
		String xpath = this.centerBlock + "//p[@class='product-desc']";
		return By.xpath(xpath);
	}

	public By bySpanPrice() {
		String xpath = this.rightBlock + "//span[@itemprop='price']";
		return By.xpath(xpath);
	}

	public By bySpanOldPrice() {
		String xpath = this.rightBlock + "//span[contains(@class,'old-price')]";
		return By.xpath(xpath);
	}

	public By bySpanPricePercentReduction() {
		String xpath = this.rightBlock + "//span[@class='price-percent-reduction']";
		return By.xpath(xpath);
	}
	
	public By byButtonAddToCart() {
		String xpath = this.rightBlock + "//a[contains(@class, 'add_to_cart')]";
		return By.xpath(xpath);
	}

	public By byButtonMore() {
		String xpath = this.rightBlock + "//a[contains(@class, 'lnk_view')]";
		return By.xpath(xpath);
	}

	public By byButtonAddToCompare() {
		String xpath = this.rightBlock + "//a[@class='add_to_compare']";
		return By.xpath(xpath);
	}

}
