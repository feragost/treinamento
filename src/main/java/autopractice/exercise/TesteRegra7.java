package autopractice.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.ProductList;
import core.WebDriverManager;
import core.WebDriverRunner;

@RunWith(WebDriverRunner.class)
public class TesteRegra7 {
	// Os últimos dois produtos visualizados devem ser listados por ordem inversa de visita em VIEWED PRODUCTS
	
	/*@Test
	public void teste_nenhumProdutoVisualizado() {
		// Nenhum produto foi visualizado. A lista de VIEWED PRODUCTS deve estar vazia
		TesteRegra1.acessarListaSummerDresses();	
		
		List<WebElement> elementos = WebDriverManager.findElements(CatalogPag.byViewedProductsFirstItem());
		elementos.addAll(WebDriverManager.findElements(CatalogPag.byViewedProductsLastItem()));
		assertEquals(0, elementos.size());
	}*/
	
	/*@Test
	public void teste_umProdutoVisualizado() {
		// Um produto foi visualizado. A lista de VIEWED PRODUCTS deve mostrá-lo
		TesteRegra1.acessarListaSummerDresses();
		String linkProdutoCatalogo = WebDriverManager.waitVisibleElement(ProductList.product(1).byLinkName()).getAttribute("href");
		String id_product = "id_product=";
		int offset = id_product.length();
		
		int indexAntesId = linkProdutoCatalogo.indexOf(id_product);
		int indexDepoisId = linkProdutoCatalogo.indexOf("&", indexAntesId);
		String idProdutoCatalogo = linkProdutoCatalogo.substring(indexAntesId+offset, indexDepoisId);
		
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonMore()).click();
		TesteRegra1.acessarListaSummerDresses();
		List<WebElement> elementos = WebDriverManager.findElements(CatalogPag.byViewedProductsFirstItem());
		elementos.addAll(WebDriverManager.findElements(CatalogPag.byViewedProductsLastItem()));
		
		assertEquals(1, elementos.size());
		
		String linkProdutoViewed =  elementos.get(0).getAttribute("href");
		indexAntesId = linkProdutoViewed.indexOf(id_product);
		indexDepoisId = linkProdutoViewed.indexOf("&", indexAntesId);
		String idProdutoViewed = linkProdutoViewed.substring(indexAntesId+offset, indexDepoisId);
		
		assertEquals(idProdutoCatalogo, idProdutoViewed);
	}*/
	
	@Test
	public void teste_tresProdutosVisualizados() {
		// Três produtos foram visualizados. A lista de VIEWED PRODUCTS deve mostrar os dois últimos.
		List<String> idProdutosCatalog = new ArrayList<String>();
		
		TesteRegra1.acessarListaSummerDresses();
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonMore()).click();
		
		TesteRegra1.acessarListaSummerDresses();
		String linkProduto = WebDriverManager.waitVisibleElement(ProductList.product(2).byLinkName()).getAttribute("href");
		idProdutosCatalog.add(getIdFromLink(linkProduto));
		WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonMore()).click();
		
		TesteRegra1.acessarListaSummerDresses();
		linkProduto = WebDriverManager.waitVisibleElement(ProductList.product(3).byLinkName()).getAttribute("href");
		idProdutosCatalog.add(getIdFromLink(linkProduto));
		WebDriverManager.waitVisibleElement(ProductList.product(3).byButtonMore()).click();
		
		TesteRegra1.acessarListaSummerDresses();
		List<WebElement> elementos = WebDriverManager.findElements(CatalogPag.byViewedProductsFirstItem());
		elementos.addAll(WebDriverManager.findElements(CatalogPag.byViewedProductsLastItem()));
		
		assertEquals(2, elementos.size());
		
		List<String> idViewedProducts = new ArrayList<String>();
		for(WebElement elemento : elementos) {
			linkProduto =  elemento.getAttribute("href");
			idViewedProducts.add(getIdFromLink(linkProduto));
		}
		
		Collections.reverse(idViewedProducts);
		assertEquals(idProdutosCatalog, idViewedProducts);
	}
	
	private String id_product = "id_product=";
	private int offset = id_product.length();
	
	private String getIdFromLink(String link) {
		int indexAntesId = link.indexOf(id_product);
		int indexDepoisId = link.indexOf("&", indexAntesId);
		return link.substring(indexAntesId+offset, indexDepoisId);
	}
}
