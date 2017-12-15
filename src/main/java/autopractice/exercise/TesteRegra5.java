package autopractice.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import autopractice.dto.ProductDto;
import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.ProductPag;
import autopractice.parser.ProductParser;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class TesteRegra5 {
	// Ao selecionar uma ordenação, a lista de produtos apresentados devem estar ordenado de acordo.
	
	//Retona uma lista com os preços de todos os produtos na página de catálogo atual
	public static List<Float> productsPrices() {
		List<ProductDto> allPresentProducts = ProductParser.parseAllPresentProducts();
		List<Float> allPrices = new ArrayList<Float>();
		
		for (ProductDto product : allPresentProducts) {
			allPrices.add(product.getPrice());
		}
		return allPrices;
	}
	
	//Retona uma lista com os nomes de todos os produtos na página de catálogo atual
	public static List<String> productsNames() {
		List<ProductDto> allPresentProducts = ProductParser.parseAllPresentProducts();
		List<String> allNames = new ArrayList<String>();
		
		for (ProductDto product : allPresentProducts) {
			allNames.add(product.getName());
		}
		return allNames;
	}
	
	// Ordenação por preço: do produto mais barato ao mais caro
	@Test
	public void teste_priceLowestFirst() {

		TesteRegra1.acessarListaSummerDresses();
		Select selectSort = new Select(WebDriverManager.findElement(CatalogPag.bySelectProductSort()));
		selectSort.selectByValue("price:asc");
		Delay.of(1500);
		
		List<Float> prices = productsPrices();
		List<Float> sortedPrices = new ArrayList<Float>(prices);
		Collections.sort(sortedPrices);
	
		assertEquals(sortedPrices, prices);
	}
	
	// Ordenação por preço: do produto mais caro ao mais barato
	@Test
	public void teste_priceHighestFirst() {

		TesteRegra1.acessarListaSummerDresses();
		Select selectSort = new Select(WebDriverManager.findElement(CatalogPag.bySelectProductSort()));
		selectSort.selectByValue("price:desc");
		Delay.of(1500);
		
		List<Float> prices = productsPrices();
		List<Float> sortedPrices = new ArrayList<Float>(prices);
		
		Collections.sort(sortedPrices);
		Collections.reverse(sortedPrices);
		
		assertEquals(sortedPrices, prices);
	}
	
	// Ordenação por nome do produto: de A a Z
	@Test
	public void teste_nameAtoZ() {

		TesteRegra1.acessarListaSummerDresses();
		Select selectSort = new Select(WebDriverManager.findElement(CatalogPag.bySelectProductSort()));
		selectSort.selectByValue("name:asc");		
		Delay.of(1500);
		
		List<String> names = productsNames();
		List<String> sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
	
		assertEquals(sortedNames, names);
	}
	
	// Ordenação por nome do produto: de Z a A
	@Test
	public void teste_nameZtoA() {

		TesteRegra1.acessarListaSummerDresses();
		Select selectSort = new Select(WebDriverManager.findElement(CatalogPag.bySelectProductSort()));
		selectSort.selectByValue("name:desc");		
		Delay.of(1500);
		
		List<String> names = productsNames();
		List<String> sortedNames = new ArrayList<String>(names);
		
		Collections.sort(sortedNames);
		Collections.reverse(sortedNames);
		
		assertEquals(sortedNames, names);
	}

}
