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
import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;
@RunWith(WebDriverRunner.class)
public class Verificacao6 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void run() {
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		List<Boolean> l1 = new ArrayList<Boolean>();
		for (int i = 1;i<=7;i++) {
			if (WebDriverManager.waitVisibleElement(ProductList.product(i).byInStock()).getAttribute("class").equals("available-now"))
				l1.add(true);
		}
		WebDriverManager.waitVisibleElement(CatalogPag.byEnableFilter("In stock")).click();
		Delay.of(4000);
		System.out.println(l1.size());
		List<Boolean> l2 = new ArrayList<Boolean>();
		for (int i = 1;i<=l1.size();i++) {
			if (WebDriverManager.waitVisibleElement(ProductList.product(i).byInStock()).getAttribute("class").equals("available-now"))
				l2.add(true);
			else
				this.collector.checkThat(false, CoreMatchers.equalTo(true));
		}
		System.out.println(l2.size());
		this.collector.checkThat(l2.size(), CoreMatchers.equalTo(l1.size()));
	}
}
