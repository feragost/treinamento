package autopractice.exercise;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ComparePag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class Verificacao3 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void run() {
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		//parte 1
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		Delay.of(500);
		WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonAddToCompare()).click();
		Delay.of(500);
		WebDriverManager.waitVisibleElement(ProductList.product(3).byButtonAddToCompare()).click();
		
		Delay.of(2000);
		String n = WebDriverManager.waitVisibleElement(ProductList.buttonCompareNumber()).getText();
		WebDriverManager.waitVisibleElement(ProductList.buttonCompare()).click();
		List<WebElement> l = WebDriverManager.waitVisibleElements(ComparePag.getProducts());
		System.out.println(l.get(1).getText());
		
		this.collector.checkThat(3, CoreMatchers.equalTo(Integer.parseInt(n)));
		this.collector.checkThat(3, CoreMatchers.equalTo(l.size()));
		
	}
}
