package autopractice.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import autopractice.pageobject.ProductList;
import core.WebDriverManager;
import core.WebDriverRunner;

@RunWith(WebDriverRunner.class)
public class TesteRegra2 {
	// Quando um item está selecionado para comparação o link ADD TO COMPARE deve possuir o símbolo "-".
	
	@Test
	public void teste_produtoAdicionadoAoCompare() {
		//Um produto no catálogo é adiciona ao Compare
		TesteRegra1.acessarListaSummerDresses();	
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		WebElement remove = WebDriverManager.waitPresenceElement(ProductList.product(1).byButtonRemoveToCompare());
		assertNotNull(remove);
	}
	
	@Test
	public void teste_produtoRemovidoDoCompare() {
		//Um produto no catálogo é adiciona ao Compare e depois removido
		
		TesteRegra1.acessarListaSummerDresses();	
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		WebDriverManager.waitPresenceElement(ProductList.product(1).byButtonRemoveToCompare());	
		
		// Remove o produto do Compare
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonRemoveToCompare()).click();
		WebElement add = WebDriverManager.waitPresenceElement(ProductList.product(1).byButtonAddToCompare());	
		
		assertNotNull(add);
	}

}
