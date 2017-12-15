package google.pageobject;

import org.openqa.selenium.By;

public class GooglePag {

	public static final String url = "https://www.google.com.br/";

	public static By inputSearch() {
		return By.id("lst-ib");
	}

	public static By buttonSearch() {
		return By.id("_fZl");
	}

	public static By labelResultStats() {
		return By.id("resultStats");
	}

}
