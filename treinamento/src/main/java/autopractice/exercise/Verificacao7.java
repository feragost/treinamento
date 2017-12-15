package autopractice.exercise;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuDressesPag;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.ViewedProductsPag;
import core.WebDriverManager;
import core.WebDriverRunner;

@RunWith(WebDriverRunner.class)
public class Verificacao7 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void run() {
		acessarMore(1);
		acessarMore(2);
		acessarMore(3);
		
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		
		WebElement first = WebDriverManager.waitVisibleElement(ViewedProductsPag.firstProduct());
		WebElement last = WebDriverManager.waitVisibleElement(ViewedProductsPag.lastProduct());
		
		WebElement product1 = WebDriverManager.waitVisibleElement(ProductList.product(2).byLinkName());
		WebElement product2 = WebDriverManager.waitVisibleElement(ProductList.product(3).byLinkName());
		System.out.println(product1.getText() + last.getText());
		this.collector.checkThat(product1.getText(), CoreMatchers.equalTo(first.getText()));
		this.collector.checkThat(product2.getText(), CoreMatchers.equalTo(last.getText()));
		
	}
	
	private void acessarMore(int n) {
		WebDriverManager.acessar(AutomationPracticePag.url);
		
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		
		
		WebDriverManager.waitVisibleElement(ProductList.product(n).byButtonMore()).click();
	}
}
