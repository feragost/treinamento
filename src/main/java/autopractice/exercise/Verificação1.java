package autopractice.exercise;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ComparePag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class Verificação1 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	
//1.1 Mandar para o compare em ordem, depois verificar a ordem no compare
//1.2 Mandar para o compare em ordem aleatoria, depois verificar a ordem no compare
	
	@Test
	public void run() {
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		//parte 1
		WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonAddToCompare()).click();
		Delay.of(500);
		WebDriverManager.waitVisibleElement(ProductList.product(3).byButtonAddToCompare()).click();
		Delay.of(500);
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		
		String p1 = WebDriverManager.waitVisibleElement(ProductList.product(2).byLinkName()).getText();
		String p2 = WebDriverManager.waitVisibleElement(ProductList.product(3).byLinkName()).getText();
		String p3 = WebDriverManager.waitVisibleElement(ProductList.product(1).byLinkName()).getText();
		
		Delay.of(1000);
		
		WebDriverManager.waitVisibleElement(ProductList.buttonCompare()).click();
		
		String c1 = WebDriverManager.waitVisibleElement(ComparePag.getName(1)).getText();
		String c2 = WebDriverManager.waitVisibleElement(ComparePag.getName(2)).getText();
		String c3 = WebDriverManager.waitVisibleElement(ComparePag.getName(3)).getText();
		

		WebDriverManager.waitVisibleElement(ComparePag.remove(1)).click();
		WebDriverManager.waitVisibleElement(ComparePag.remove(1)).click();
		WebDriverManager.waitVisibleElement(ComparePag.remove(1)).click();
		
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();

		//parte 2
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		Delay.of(500);
		WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonAddToCompare()).click();
		Delay.of(500);
		WebDriverManager.waitVisibleElement(ProductList.product(3).byButtonAddToCompare()).click();

		
		Delay.of(2000);
		
		WebDriverManager.waitVisibleElement(ProductList.buttonCompare()).click();
		
		Delay.of(1000);
		
		String c4 = WebDriverManager.waitVisibleElement(ComparePag.getName(1)).getText();
		String c5 = WebDriverManager.waitVisibleElement(ComparePag.getName(2)).getText();
		String c6 = WebDriverManager.waitVisibleElement(ComparePag.getName(3)).getText();
		
		Delay.of(1000);

		
		this.collector.checkThat(p1, CoreMatchers.equalTo(c1));
		this.collector.checkThat(p2, CoreMatchers.equalTo(c2));
		this.collector.checkThat(p3, CoreMatchers.equalTo(c3));
		
		this.collector.checkThat(p3, CoreMatchers.equalTo(c4));
		this.collector.checkThat(p1, CoreMatchers.equalTo(c5));
		this.collector.checkThat(p2, CoreMatchers.equalTo(c6));
	}
	
	
	
}
