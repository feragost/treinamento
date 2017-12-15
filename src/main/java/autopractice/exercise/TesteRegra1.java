package autopractice.exercise;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.ComparePag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuWomenPag;
import core.WebDriverManager;
import core.WebDriverRunner;

@RunWith(WebDriverRunner.class)
public class TesteRegra1 {
	// A ordem do produto que eu adiciono para comparação deve ser a mesma ordem que aparece na página de comparação.

	public static List<String> getTextElementos(List<WebElement> lista) {
		List<String> listaRetorno = new ArrayList<String>();
		
		for(WebElement elemento: lista) {
			System.out.println(elemento.getText());
			listaRetorno.add(elemento.getText());
		}
		return listaRetorno;
	}
	
	public static void acessarListaSummerDresses() {
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
	}
	
	@Test
	public void teste_DoisElementos() {
		// Dois elementos são adicionados ao Compare e seus nomes e respectivos preços são usados para o assert
		
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		
		
		List<WebElement> listaWebElement_nomeProdutosAdicionados = new ArrayList<WebElement>();
		List<WebElement> listaWebElement_precoProdutosAdicionados = new ArrayList<WebElement>();

		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		WebDriverManager.waitPresenceElement(ProductList.product(1).byButtonRemoveToCompare());
		listaWebElement_nomeProdutosAdicionados.add(WebDriverManager.getWebDriver().findElement(ProductList.product(1).byLinkName())); //pega o nome do produto
		listaWebElement_precoProdutosAdicionados.add(WebDriverManager.getWebDriver().findElement(ProductList.product(1).bySpanPrice())); //pega o preço do produto
		
		WebDriverManager.waitVisibleElement(ProductList.product(3).byButtonAddToCompare()).click();
		WebDriverManager.waitPresenceElement(ProductList.product(3).byButtonRemoveToCompare());
		listaWebElement_nomeProdutosAdicionados.add(WebDriverManager.getWebDriver().findElement(ProductList.product(3).byLinkName()));
		listaWebElement_precoProdutosAdicionados.add(WebDriverManager.getWebDriver().findElement(ProductList.product(3).bySpanPrice()));
		
		List<String> listaString_nomeProdutosAdicionados = getTextElementos(listaWebElement_nomeProdutosAdicionados);	
		List<String> listaString_precoProdutosAdicionados = getTextElementos(listaWebElement_precoProdutosAdicionados);
		
		
		WebDriverManager.waitVisibleElement(CatalogPag.byButtonCompare()).click();
		WebDriverManager.waitInvisibleElement(CatalogPag.byButtonCompare());
		List<WebElement> listaWebElement_nomeProdutosComparePag = WebDriverManager.getWebDriver().findElements(ComparePag.nomesItensCompare());
		List<WebElement> listaWebElement_precoProdutosComparePag = WebDriverManager.getWebDriver().findElements(ComparePag.precosItensCompare());
		
		List<String> listaString_nomeProdutosComparePag = getTextElementos(listaWebElement_nomeProdutosComparePag);
		List<String> listaString_precoProdutosComparePag = getTextElementos(listaWebElement_precoProdutosComparePag);
		
		
		assertArrayEquals(listaString_nomeProdutosAdicionados.toArray(), listaString_nomeProdutosComparePag.toArray());
		assertArrayEquals(listaString_precoProdutosAdicionados.toArray(), listaString_precoProdutosComparePag.toArray());
	}
	
	@Test
	public void teste_TresElementos() {
		// Três elementos são adicionados ao Compare e seus nomes e respectivos preços são usados para o assert
		
		acessarListaSummerDresses();
		
		List<WebElement> listaWebElement_nomeProdutosAdicionados = new ArrayList<WebElement>();
		List<WebElement> listaWebElement_precoProdutosAdicionados = new ArrayList<WebElement>();
		
		for (int i = 1; i <= 3; i++) {
			WebDriverManager.waitVisibleElement(ProductList.product(i).byButtonAddToCompare()).click();
			WebDriverManager.waitPresenceElement(ProductList.product(i).byButtonRemoveToCompare());
			listaWebElement_nomeProdutosAdicionados.add(WebDriverManager.findElement(ProductList.product(i).byLinkName())); //pega o nome do produto
			listaWebElement_precoProdutosAdicionados.add(WebDriverManager.findElement(ProductList.product(i).bySpanPrice())); //pega o preço do produto
		}
		
		// Os textos dos elementos devem ser pegos antes de sair da página
		List<String> listaString_nomeProdutosAdicionados = getTextElementos(listaWebElement_nomeProdutosAdicionados);	
		List<String> listaString_precoProdutosAdicionados = getTextElementos(listaWebElement_precoProdutosAdicionados);
		
		
		WebDriverManager.waitVisibleElement(CatalogPag.byButtonCompare()).click();
		WebDriverManager.waitInvisibleElement(CatalogPag.byButtonCompare());
		List<WebElement> listaWebElement_nomeProdutosComparePag = WebDriverManager.findElements(ComparePag.nomesItensCompare());
		List<WebElement> listaWebElement_precoProdutosComparePag = WebDriverManager.findElements(ComparePag.precosItensCompare());
		
		List<String> listaString_nomeProdutosComparePag = getTextElementos(listaWebElement_nomeProdutosComparePag);
		List<String> listaString_precoProdutosComparePag = getTextElementos(listaWebElement_precoProdutosComparePag);
		
		
		assertArrayEquals(listaString_nomeProdutosAdicionados.toArray(), listaString_nomeProdutosComparePag.toArray());
		assertArrayEquals(listaString_precoProdutosAdicionados.toArray(), listaString_precoProdutosComparePag.toArray());
		
		
		// Sai da página com CONTINUE SHOPPING e depois retorna para a página de Compare
		WebDriverManager.findElement(ComparePag.byButtonContinueShopping()).click();
		acessarListaSummerDresses();
		
		WebDriverManager.waitVisibleElement(CatalogPag.byButtonCompare()).click();
		WebDriverManager.waitInvisibleElement(CatalogPag.byButtonCompare());
		listaWebElement_nomeProdutosComparePag = WebDriverManager.findElements(ComparePag.nomesItensCompare());
		listaWebElement_precoProdutosComparePag = WebDriverManager.findElements(ComparePag.precosItensCompare());
		
		listaString_nomeProdutosComparePag = getTextElementos(listaWebElement_nomeProdutosComparePag);
		listaString_precoProdutosComparePag = getTextElementos(listaWebElement_precoProdutosComparePag);
		
		
		assertArrayEquals(listaString_nomeProdutosAdicionados.toArray(), listaString_nomeProdutosComparePag.toArray());
		assertArrayEquals(listaString_precoProdutosAdicionados.toArray(), listaString_precoProdutosComparePag.toArray());
	}

}
