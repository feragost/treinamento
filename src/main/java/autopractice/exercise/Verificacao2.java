package autopractice.exercise;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class Verificacao2 {
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void run() {
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();

		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		Delay.of(1000);
		String afterClick = WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).getAttribute("class");
		
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		
		String afterReload = WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).getAttribute("class");
		
		this.collector.checkThat(afterClick, CoreMatchers.equalTo("add_to_compare checked"));
		this.collector.checkThat(afterReload, CoreMatchers.equalTo("add_to_compare checked"));
	}
}
