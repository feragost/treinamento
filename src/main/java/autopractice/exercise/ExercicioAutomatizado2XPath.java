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
import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ProductContainer;
import autopractice.pageobject.ProductDetailPag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuWomenPag;
import autopractice.parser.ProductParser;
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
	}

	private void add3GreenDressesToChart(WebDriver webDriver) {
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());

		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();

		// WebDriverManager.getWebDriver().findElement(moreButton).click();
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
		System.out.println("Price element: " + priceElement.getText());

		// Clique em CONTINUE TO SHOPPING.
		WebDriverManager.waitVisibleElement(ProductDetailPag.byContinueShoppingButton()).click();
	}

}
