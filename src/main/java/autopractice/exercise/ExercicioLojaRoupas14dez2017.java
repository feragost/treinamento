package autopractice.exercise;

import java.util.Iterator;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.CompraPag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.ProductPag;
import autopractice.pageobject.ShoppingCartSummaryPag;
import autopractice.pageobject.TopMenuDressesPag;
import autopractice.pageobject.TopMenuPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class ExercicioLojaRoupas14dez2017 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	private int counterProducts() {
		String texto = WebDriverManager.waitVisibleElement(CatalogPag.byCounterProducts()).getText();
		return Integer.parseInt(texto.split(" ")[2]);
	}

	// $x("xpath") -> achar elemento pelo xpath no console do chrome (em "inspecionar")
	@Test
	public void exercicio() {
		
		// 1. Selecione SUMMER DRESSES a partir do item DRESSES do menu principal.
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiDresses());
		WebDriverManager.waitVisibleElement(TopMenuDressesPag.byLinkSummerDresses()).click();

		// 2. Clique em LIST para obter uma visualização dos itens em forma de lista.
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		
		/*List<WebElement> lista = WebDriverManager.getWebDriver().findElements(ProductList.precosProdutosCatalogo());
		for(WebElement elemento : lista) {
			System.out.println(elemento.getText());
		}*/
		
		// 3. Clique em MORE para o terceiro item da lista.
		WebDriverManager.waitVisibleElement(ProductList.product(3).byButtonMore()).click();
		
		
		// 4. Selecione a quantidade 3 a partir do botão +.
		WebDriverManager.waitVisibleElement(ProductPag.byButtonPlus()).click();
		WebDriverManager.waitVisibleElement(ProductPag.byButtonPlus()).click();
		
		// 5. Selecione o tamanho M na combo.
		Select selectSize = new Select(WebDriverManager.findElement(ProductPag.bySelectSize()));
		selectSize.selectByVisibleText("M");
		
		// 6. Selecione a cor VERDE.
		WebDriverManager.waitVisibleElement(ProductPag.byColorGreen()).click();
		
		// 7. Clique em ADD TO CART.
		WebDriverManager.waitVisibleElement(ProductPag.byButtonAddToCart()).click();
		
		
		// 8. Imprima o preço total da compra.
		System.out.println("Preço total da compra: " + WebDriverManager.waitVisibleElement(CompraPag.byTotalPrice()).getText());
		
		// 9. Clique em CONTINUE TO SHOPPING.		
		WebDriverManager.waitVisibleElement(CompraPag.byContinueShopping()).click();
		WebDriverManager.waitInvisibleElement(CompraPag.byContinueShopping()); // espera sumir este botão, o que indica que a página fechou
		
		// 10. Clique em T-SHIRTS no meu principal.
		WebDriverManager.moveMouseTo(TopMenuPag.byLiTShirt());
		WebDriverManager.waitVisibleElement(TopMenuPag.byButtonTShirt()).click();
		
		// 11. Clique em ADD TO CART para o único produto da lista.
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToChart()).click();
		
		// 12. Clique em PROCEED TO CHECKOUT
		WebDriverManager.waitVisibleElement(CompraPag.byProceedToCheckOut()).click();
		
		
		// 13. Imprima o valor total da compra.
		System.out.println("Preço total da compra: " + WebDriverManager.waitVisibleElement(ShoppingCartSummaryPag.byTotalPrice()).getText());
	
		// 14. Clique em CONTINUE TO SHOPPING.		
		WebDriverManager.waitVisibleElement(ShoppingCartSummaryPag.byContinueShopping()).click();
		
		// 15. Imprima os valores das hints dos dois produtos em VIEWED PRODUCTS
		//System.out.println("Hint do primeiro produto: " + WebDriverManager.waitVisibleElement(CatalogPag.byViewedProductsFirstItem()).getAttribute("title"));
		System.out.println("Hint do primeiro produto: " + WebDriverManager.waitVisibleElement(CatalogPag.byViewedProductsLastItem()).getAttribute("title"));
		
		Delay.of(1200);
	}
}
