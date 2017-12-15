package autopractice.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.ProductList;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@RunWith(WebDriverRunner.class)
public class TesteRegra6 {
	// Ao selecionar o item em estoque, a lista de produtos apresentados devem possuir somente os itens em estoque.
	
	private List<Float> getFloatElementos(List<WebElement> lista) {
		List<Float> listaRetorno = new ArrayList<Float>();
		
		for(WebElement elemento: lista) {
			listaRetorno.add(Float.parseFloat(elemento.getText())); //tirar simbolo
		}
		return listaRetorno;
	}
	
	// Seleciona a opção de itens em estoque em uma página em que há 3 produtos em estoque
	@Test
	public void teste_tresProdutosInStock() {

		TesteRegra1.acessarListaSummerDresses();
		
		// Guarda em uma lista o nome dos produtos em estoque antes de selecionar a opção
		List<WebElement> elementosInStock = WebDriverManager.findElements(ProductList.byNamesProductsInStock());
		List<String> namesBeforeSelect_produtosInStock = TesteRegra1.getTextElementos(elementosInStock);
		// Guarda em uma lista o preço dos produtos em estoque antes de selecionar a opção
		elementosInStock = WebDriverManager.findElements(ProductList.byPricesProductsInStock());
		List<Float> pricesBeforeSelect_produtosInStock = getFloatElementos(elementosInStock);
		
		Select selectSort = new Select(WebDriverManager.findElement(CatalogPag.bySelectProductSort()));
		selectSort.selectByValue("quantity:desc");
		Delay.of(1500);
		
		// Após a seleção, é verificado se todos os produtos em estoque estão na lista
		List<String> namesAfterSelect_produtosInStock = TesteRegra5.productsNames();
		List<Float> pricesAfterSelect_produtosInStock = TesteRegra5.productsPrices();
		
		assertEquals(namesBeforeSelect_produtosInStock.size(), namesAfterSelect_produtosInStock.size());
		assertThat(namesBeforeSelect_produtosInStock, containsInAnyOrder(namesAfterSelect_produtosInStock.toArray()));
		assertThat(pricesBeforeSelect_produtosInStock, containsInAnyOrder(pricesAfterSelect_produtosInStock.toArray()));
	}
	
}
