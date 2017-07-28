package exercise;

import java.util.List;

import org.openqa.selenium.WebElement;

public class WebElementPrinter {
	public static void printWebElement(WebElement webElement) {
		System.out.println(webElement.getText());
	}
	
	public static void printWebElements(List<WebElement> webElements) {
		for(WebElement webElement: webElements) {
			System.out.println(webElement.getText());
		}
	}
}
