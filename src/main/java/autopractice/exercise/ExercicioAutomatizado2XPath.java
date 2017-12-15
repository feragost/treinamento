package autopractice.exercise;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import autopractice.dto.ProductDto;
import autopractice.dto.ViewDto;
import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ProductContainer;
import autopractice.pageobject.ProductDetailPag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.ShoppingChartSummary;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuWomenPag;
import autopractice.parser.ProductParser;
import autopractice.parser.ViewItemParser;
import autopractice.steps.PriceRange;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class ExercicioAutomatizado2XPath {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {
		WebDriver webDriver = WebDriverManager.getWebDriver();
		WebDriverManager.acessar(AutomationPracticePag.url);

		add3GreenDressesToChart(webDriver);
		addTShirtToChart();

		Delay.of(12000);
	}

	private void addTShirtToChart() {
		// Clique em T-SHIRTS no meu principal
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkTShirts()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();

		// Clique em MORE para o terceiro item da lista.
		By moreButton = ProductList.product(1).byButtonMore();
		WebDriverManager.waitVisibleElement(moreButton).click();
		
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkTShirts()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();

		// Clique em ADD TO CART para o único produto da lista.
		By addToChart = ProductList.product(1).byButtonAddToChart();
		WebDriverManager.waitVisibleElement(addToChart).click();

		// Clique em PROCEED TO CHECKOUT
		WebDriverManager.waitVisibleElement(ProductDetailPag.byButtonProceedToCheckout()).click();

		// Imprima o valor total da compra.
		WebElement priceElement = WebDriverManager.waitVisibleElement(ShoppingChartSummary.byTotalPurchasePriceButton());
		System.out.println("T-Shirt price element: " + priceElement.getText());

		// Clique em CONTINUE TO SHOPPING.
		WebDriverManager.waitVisibleElement(ShoppingChartSummary.byContinueShoppingButton()).click();

		// Imprima os valores das hints dos dois produtos em VIEWED PRODUCTS
		List<ViewDto> allPresentViewItems = ViewItemParser.parseAllItems();
		System.out.println("Printing the elements...");

		for (ViewDto product : allPresentViewItems) {
			System.out.println(product.getName() + ": " + product.getHint());
		}
	}

	private void add3GreenDressesToChart(WebDriver webDriver) {
		// Selecione SUMMER DRESSES a partir do item DRESSES do menu principal.
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();

		// Clique em LIST para obter uma visualização dos itens em forma de lista.
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();

		// Clique em MORE para o terceiro item da lista.
		By moreButton = ProductList.product(3).byButtonMore();
		WebDriverManager.waitVisibleElement(moreButton).click();

		// Selecione a quantidade 3 a partir do botão +
		WebDriverManager.waitVisibleElement(ProductDetailPag.byPlusItemButton()).click();
		WebDriverManager.waitVisibleElement(ProductDetailPag.byPlusItemButton()).click();

		// Selecione o tamanho M na combo
		ProductDetailPag.dropdownSelectElement(webDriver, "M");

		// Selecione a cor VERDE.
		// Clique em ADD TO CART.
		WebDriverManager.waitVisibleElement(ProductDetailPag.byGreenColorButton()).click();
		WebDriverManager.waitVisibleElement(ProductDetailPag.byAddToCartButton()).click();

		// Imprima o preço total da compra.
		WebElement priceElement = WebDriverManager.waitVisibleElement(ProductDetailPag.byTotalPurchasePriceButton());
		System.out.println("Green dresses price element: " + priceElement.getText());

		// Clique em CONTINUE TO SHOPPING.
		WebDriverManager.waitVisibleElement(ProductDetailPag.byContinueShoppingButton()).click();
	}

}
