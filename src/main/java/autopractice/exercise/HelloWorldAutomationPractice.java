package autopractice.exercise;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

import autopractice.dto.ProductDto;
import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuWomenPag;
import autopractice.parser.ProductParser;
import autopractice.steps.PriceRange;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class HelloWorldAutomationPractice {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {

		WebDriverManager.acessar(AutomationPracticePag.url);
		//WebDriverManager.waitVisibleElement(TopMenuPag.byLiDresses()).click();
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiTShirt()).click();
		
		
		//WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();

		WebDriverManager.waitVisibleElement(ProductList.liList()).click();

		Float v1 = 19.52f;
		Float v2 = 29.44f;
		PriceRange.rangeBetween(v1, v2);
		Delay.of(1500);

		List<ProductDto> allPresentProducts = ProductParser.parseAllPresentProducts();

		for (ProductDto product : allPresentProducts) {
			System.out.println(product.getName() + " : " + product.getPrice());
		}

		Delay.of(1500);
	}

}
