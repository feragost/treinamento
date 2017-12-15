package autopractice.pageobject;

import org.openqa.selenium.By;

public class ProductComparisonContainer {
	
	public String startXpath;

	public ProductComparisonContainer(String xpath) {
		this.startXpath = xpath;
	}
	
	public By byImg() {
		String xpath = startXpath + "//img[@class='img-responsive']";
		return By.xpath(xpath);
	}

}
