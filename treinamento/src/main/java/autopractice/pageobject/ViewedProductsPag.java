package autopractice.pageobject;

import org.openqa.selenium.By;

public class ViewedProductsPag {
	
	
	public static By firstProduct() {
		return By.xpath(".//li[@class = 'clearfix first_item']/div/h5/a");
	}
	
	public static By lastProduct() {
		return By.xpath(".//li[@class = 'clearfix last_item']/div/h5/a");
	}
}
