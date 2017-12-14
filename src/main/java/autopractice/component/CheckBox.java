package autopractice.component;

import org.openqa.selenium.By;

import core.WebDriverManager;

public class CheckBox {
	
	private By input;
	private By label;
	
	public CheckBox(String xpathInicial) {
		input = By.xpath(xpathInicial + "//input");
		label = By.xpath(xpathInicial + "//label/a");
	}
	
	public void clicar() {
		WebDriverManager.waitVisibleElement(input).click();
	}
	
	public String getQuantidade() {
		String numComParenteses = WebDriverManager.waitVisibleElement(label).findElement(By.xpath(".//span")).getText();
		return numComParenteses.replaceFirst("\\(", "").replaceFirst("\\)", "");
	}

}
