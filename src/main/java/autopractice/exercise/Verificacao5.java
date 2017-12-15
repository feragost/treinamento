package autopractice.exercise;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class Verificacao5 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void run() {
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		WebDriverManager.waitVisibleElement(ProductList.sortSelect()).click();
		WebDriverManager.waitVisibleElement(ProductList.sortOption("Price: Lowest first")).click();
		
		List<WebElement> l1 = new ArrayList<WebElement>();
		for (int i = 1;i<=7;i++) {
			l1.add(WebDriverManager.waitVisibleElement(ProductList.product(i).bySpanPrice()));
		}
		
		WebDriverManager.waitVisibleElement(ProductList.sortSelect()).click();
		WebDriverManager.waitVisibleElement(ProductList.sortOption("Price: Highest first")).click();
		
		List<WebElement> l2 = new ArrayList<WebElement>();
		for (int i = 1;i<=7;i++) {
			l2.add(WebDriverManager.waitVisibleElement(ProductList.product(i).bySpanPrice()));
		}
		
		this.collector.checkThat(l1, CoreMatchers.not(CoreMatchers.equalTo(l2)));
	}
}
