package autopractice.pageobject;

import org.openqa.selenium.By;

public class ProductContainer {

	private String startXpath;
	private String leftBlock;
	private String centerBlock;
	private String rightBlock;

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

	public By byButtonMore() {
		String xpath = this.rightBlock + "//a[contains(@class, 'lnk_view')]";
		return By.xpath(xpath);
	}

	public By byButtonAddToCompare() {
		String xpath = this.rightBlock + "//a[@class='add_to_compare']";
		return By.xpath(xpath);
	}

	public By byButtonAddToCart() {
		String xpath = this.rightBlock + "//a[@class='button ajax_add_to_cart_button btn btn-default']";
		return By.xpath(xpath);
	}

}
