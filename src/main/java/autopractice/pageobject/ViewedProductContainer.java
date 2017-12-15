package autopractice.pageobject;

import org.openqa.selenium.By;

public class ViewedProductContainer {
	
	public String startXpath;
	
	public ViewedProductContainer(String xpath) {
		this.startXpath = xpath;
	}
	
	public By productName() {
		String xpath = startXpath + "//a[@class='product-name']";
		return By.xpath(xpath);
	}

}
