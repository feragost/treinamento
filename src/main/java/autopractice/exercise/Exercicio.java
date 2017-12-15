package autopractice.exercise;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.ProductDetail;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.ShoppingCartSummary;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuWomenPag;
import autopractice.pageobject.ViewedProductList;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class Exercicio {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {

		//Exercicio 1
		/*Acessa a página, move o cursor para o menu WOMEN e clica na opção SUMMER DRESSES*/
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiDresses());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();
		
		//Exercicio 2
		/*Clica na opção de visualização(VIEW) LIST*/
		WebDriverManager.waitVisibleElement(ProductList.viewList()).click();
		
		//Exercicio 3
		/*Clica no botão more do terceiro item*/
		WebDriverManager.waitVisibleElement(ProductList.product(3).byButtonMore()).click();
		
		//Exercicio 4
		/*Incrementa duas vezes a quantidade*/
		WebDriverManager.waitVisibleElement(ProductDetail.incrementQuantity()).click();
		WebDriverManager.waitVisibleElement(ProductDetail.incrementQuantity()).click();
		
		//Exercicio 5
		/*Seleciona o tamanho M*/
		ProductDetail.selectSize().selectByIndex(1);
		
		//Exercicio 6
		/*Seleciona a cor verde*/
		WebDriverManager.waitVisibleElement(ProductDetail.selectColor("Green")).click();
		
		//Exercicio 7
		/*Clica na opção adicionar ao carrinho(ADD TO CART)*/
		WebDriverManager.waitVisibleElement(ProductDetail.addToCart()).click();
		
		//Exercicio 8
		/*Imprime na saída o valor total da compra*/
		System.out.println(WebDriverManager.waitVisibleElement(ProductDetail.getValorTotal()).getText());
		
		//Exercicio 9
		/*Clica na opção CONTINUE TO SHOPPING*/
		WebDriverManager.waitVisibleElement(ProductDetail.continueToShopping()).click();
		
		//Exercicio 10
		/*Move o cursor para o menu WOMEN e clica na opção T-SHIRTS*/
		WebDriverManager.moveMouseTo(TopMenuPag.byLiTShirt());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkTShirts()).click();
		
		//Exercicio 11
		/*Clica no botão ADD TO CART do primeiro produto da lista*/
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCart()).click();
		
		//Exercicio 12
		/*Clica no botão PROCEED TO CHECKOUT*/
		WebDriverManager.waitVisibleElement(ProductDetail.proceedToCheckout()).click();
		
		//Exercicio 13
		/*Imprime na saída o valor total de todas as comprar*/
		System.out.println(WebDriverManager.waitVisibleElement(ShoppingCartSummary.getValorTotal()).getText());
		
		//Exercicio 14
		/*Clica no botão CONTINUE TO SHOPPING*/
		WebDriverManager.waitVisibleElement(ShoppingCartSummary.continueShopping()).click();
		
		//Exercicio 15
		/*Imprime o nome do primeiro(e nesse caso único) produto da lista de produtos vistos(VIEWED PRODUCTS)*/
		//System.out.println(WebDriverManager.waitVisibleElement(ProductList.viewedProduct(1).productName()).getText());
		
		//Exercicio SS15 Otimizado
		/*Imprime o nome de todos os produtos da lista de produtos vistos(VIEWED PRODUCTS)*/
		System.out.println(WebDriverManager.waitVisibleElement(ViewedProductList.viewedProductsNameList()).getText());

		//Teste do novo modelo
		//Checa a quantidade de itens da lista que estão em estoque no Catalago
		System.out.println(CatalogPag.checkInStock().getQuantidade());

		Delay.of(3000);
	}
	
}
