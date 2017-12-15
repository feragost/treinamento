package autopractice.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import core.WebDriverManager;
import core.WebDriverRunner;

@RunWith(WebDriverRunner.class)
public class Verificacao8 {
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void run() {
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		List<String> lCores = new ArrayList<String>();
		for (int i = 1; i <= 8; i++) {
			String cor = WebDriverManager.waitVisibleElement(CatalogPag.byColorFilter(String.valueOf(i))).getAttribute("style");
			cor = cor.replaceAll("background: ", "");
			lCores.add(cor);
		}
		
		Set<String> sCoresProd = new TreeSet<String>();
		for (int i = 1; i<=7;i++) {
			List<WebElement> lista = WebDriverManager.waitVisibleElements(ProductList.product(i).byColorsAvailale());
			for (WebElement webElement : lista) {
				String cor = webElement.getAttribute("style");
				cor = cor.replaceAll("background: ", "");
				sCoresProd.add(cor);
			}
		}
		
		this.collector.checkThat(sCoresProd.size(), CoreMatchers.equalTo(lCores.size()));
	}
}
