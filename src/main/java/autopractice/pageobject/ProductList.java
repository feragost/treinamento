package autopractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.WebDriverManager;

public class ProductList {

	public static String xpathProductList = "//ul[contains(@class, 'product_list')]";
	public static String xpathProductContainer = "//div[@class='product-container']";
	public static String xpathViewedProductList = "//div[@id='viewed-products_block_left']";
	//Caminho para o componente de visualização em modo LIST
	public static String xpathViewList = "//li[@id='list']";
	//Caminho para o componente de visualização em modo GRID
	public static String xpathViewGrid = "//li[@id='list']";

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

	public static By buttonCompare() {
		String xpath = "//button[contains(@class, 'bt_compare')]";
		return By.xpath(xpath);
	}
	
	//Retorna o botão da opção de view LIST
	public static By viewList() {
		String xpath = xpathViewList;
		return By.xpath(xpath);
	}
	
	//Retorna o botão da opção de view GRID
		public static By viewGrid() {
			String xpath = xpathViewGrid;
			return By.xpath(xpath);
		}
	
	//Retorna o botão COMPARE de cima
	public static By topCompareButton() {
		String xpath = "//button[@class='btn btn-default button button-medium bt_compare bt_compare']";
		return By.xpath(xpath);
	}
	
	//Retorna a quantidade do botao COMPARE
	public static String getQuantCompare() {
		WebElement botaoCompare = WebDriverManager.waitVisibleElement(ProductList.topCompareButton());
		return botaoCompare.findElement(By.xpath(".//strong")).getText();
	}
	
	//Retorna o botão COMPARE de baixo
	public static By bottomCompareButton() {
		String xpath = "//button[@class='btn btn-default button button-medium bt_compare bt_compare_bottom']";
		return By.xpath(xpath);
	}
	
	//Retorna o componente de ordenação
	public static By getSortBy() {
		String xpath = "//form[@id='productsSortForm']";
		return By.xpath(xpath);
	}
	
}
