package autopractice.pageobject;

import org.openqa.selenium.By;

public class ViewedProductList {

	//Retorna o produto na posição "order" na lista de produtos vistos(VIEWED PRODUCTS)
	public static ViewedProductContainer viewedProduct(int order) {
		String xpath = ProductList.xpathViewedProductList + "//li";
		xpath = xpath + "[" + order + "]";
		return new ViewedProductContainer(xpath);
	}

	//Retorna todos os nomes dos produtos da lista de produtos vistos(VIEWED PRODUCTS)
	public static By viewedProductsNameList() {
		String xpath = ProductList.xpathViewedProductList + "//li//a[@class='product-name']";
		return By.xpath(xpath);
	}

}
