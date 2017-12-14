package autopractice.exercise;

import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
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
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class TesteCompare {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void run() {

		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiWomen());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();

		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		
		/*Select selectSort = new Select(WebDriverManager.getWebDriver().findElement(CatalogPag.bySelectProductSort()));
		selectSort.selectByValue("price:desc");
		Delay.of(2000);*/
		
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		WebDriverManager.waitPresenceElement(ProductList.product(1).byButtonRemoveToCompare());
		String texto = WebDriverManager.waitVisibleElement(CatalogPag.byCounterButtonCompare()).getText();
		System.out.println(texto);
		
		
		WebDriverManager.waitVisibleElement(ProductList.product(3).byButtonAddToCompare()).click();
		WebDriverManager.waitPresenceElement(ProductList.product(3).byButtonRemoveToCompare());
		texto = WebDriverManager.waitVisibleElement(CatalogPag.byCounterButtonCompare()).getText();
		System.out.println(texto);
		
		WebDriverManager.waitVisibleElement(CatalogPag.byButtonCompare()).click();
		
		List<WebElement> lista = WebDriverManager.getWebDriver().findElements(ComparePag.nomesItensCompare());
		for(WebElement elemento : lista) {
			System.out.println(elemento.getText());
		}
		
		Delay.of(1000);
	}

}
