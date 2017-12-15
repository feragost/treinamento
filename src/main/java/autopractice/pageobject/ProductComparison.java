package autopractice.pageobject;

import org.openqa.selenium.By;

//Tela de comparação de produtos(PRODUCT COMPARISON)
public class ProductComparison {
	
	//Caminho para a lista de produtos
	public static String xpathProductList = "//td[contains(@class,'ajax_block_product comparison_infos product-block product-')]";
	
	//Retorna a lista de produtos
	public By getListProducts() {
		String xpath = xpathProductList;
		return By.xpath(xpath);
	}
	
	public static ProductComparisonContainer product(int order) {
		String xpath = xpathProductList + "[" + order + "]";
		return new ProductComparisonContainer(xpath);
	}

}
