package autopractice.exercise;

import java.util.List;

import org.hamcrest.CoreMatchers;
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
import autopractice.steps.PriceRange;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class Verificacao4 {

	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void run() {
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiWomen()).click();
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		
		String range = WebDriverManager.waitVisibleElement(CatalogPag.bySpanPriceRange()).getText();
		range = range.replaceAll("\\$", "");
		range = range.replaceAll(" ", "");
		String[] numbers = range.split("-");
		float leftRange = Float.parseFloat(numbers[0]);
		float rightRange = Float.parseFloat(numbers[1]);
		
		for (int i = 1;i<=7;i++) {
			String price = WebDriverManager.waitVisibleElement(ProductList.product(i).bySpanPrice()).getText();
			price = price.replaceAll("\\$", "");
			float fprice = Float.parseFloat(price);
			this.collector.checkThat(true, CoreMatchers.equalTo(fprice > leftRange));
			this.collector.checkThat(true, CoreMatchers.equalTo(fprice < rightRange));
		}
		
		Float v1 = 19.52f;
		Float v2 = 29.44f;
		PriceRange.rangeBetween(v1, v2);
		Delay.of(1500);

		
		for (int i = 1;i<=3;i++) {
			String price = WebDriverManager.waitVisibleElement(ProductList.product(i).bySpanPrice()).getText();
			price = price.replaceAll("\\$", "");
			float fprice = Float.parseFloat(price);
			this.collector.checkThat(true, CoreMatchers.equalTo(fprice > leftRange));
			this.collector.checkThat(true, CoreMatchers.equalTo(fprice < rightRange));
		}
	}
}
