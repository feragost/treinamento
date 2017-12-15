package autopractice.exercise;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.ProductList;
import core.WebDriverManager;
import core.WebDriverRunner;

@RunWith(WebDriverRunner.class)
public class TesteRegra3 {
	// O botão COMPARE deve apresentar a quantidade de itens selecionados para serem comparados.
	
	// Nenhum produto no Compare
	@Test
	public void teste_nenhumItemCompare() {
		TesteRegra1.acessarListaSummerDresses();	
		
		WebElement counter = WebDriverManager.waitVisibleElement(CatalogPag.byCounterButtonCompare());
		
		assertEquals("0", counter.getText());
	}
	
	// Dois produtos no Compare
	@Test
	public void teste_doisItensCompare() {
		TesteRegra1.acessarListaSummerDresses();
		
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		WebDriverManager.waitPresenceElement(ProductList.product(1).byButtonRemoveToCompare());
		WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonAddToCompare()).click();
		WebDriverManager.waitPresenceElement(ProductList.product(2).byButtonRemoveToCompare());
		
		WebElement counter = WebDriverManager.waitVisibleElement(CatalogPag.byCounterButtonCompare());
		
		assertEquals("2", counter.getText());
	}

}
