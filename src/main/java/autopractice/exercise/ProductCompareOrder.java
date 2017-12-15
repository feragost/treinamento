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

/**
 * Identificador: A ordem do produto que eu adiciono para comparação deve ser a
 * mesma ordem que aparece na página de comparação.
 */
@RunWith(WebDriverRunner.class)
public class ProductCompareOrder {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {
		WebDriver webDriver = WebDriverManager.getWebDriver();
		WebDriverManager.acessar(AutomationPracticePag.url);

		// 1. Selecione SUMMER DRESSES a partir do item DRESSES do menu principal.
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();

		// 2. Clique em LIST para obter uma visualização dos itens em forma de lista.
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();

		// 3. Clique em ADD TO comparison nos dois primeiros items
		String product1Description = clickOnAddToComparission(1);
		String product2Description = clickOnAddToComparission(2);

		System.out.println("product1Description: " + product1Description);
		System.out.println("product2Description: " + product2Description);

		// 4. Clicar no botão Compare(2)
		WebDriverManager.waitVisibleElement(ProductList.buttonCompare()).click();

		Delay.of(12000);
	}

	private String clickOnAddToComparission(int order) {
		By byButtonAddToCompare = ProductList.product(order).byButtonAddToCompare();
		WebElement addToCompareElement = WebDriverManager.waitVisibleElement(byButtonAddToCompare);

		addToCompareElement.click();
		WebDriverManager.waitCheckedElement(addToCompareElement);

		By byButtonProductDescription = ProductList.product(order).byProductDescription();
		return WebDriverManager.waitVisibleElement(byButtonProductDescription).getText();
	}
}
