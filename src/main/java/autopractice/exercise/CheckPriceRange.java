package autopractice.exercise;

import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuWomenPag;
import autopractice.steps.PriceRange;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

//Ao selecionar um price range, a lista de produtos apresentados devem possuir o preço dentro do range.
@RunWith(WebDriverRunner.class)
public class CheckPriceRange {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {
		
		/**/
		
		/*Acessa a página, move o cursor para o menu WOMEN e clica na opção SUMMER DRESSES*/
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiDresses());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();
		
		/*Clica na opção de visualização(VIEW) LIST*/
		WebDriverManager.waitVisibleElement(ProductList.viewList()).click();
		
		/*Pega o preco do primeiro produto*/
		String price = WebDriverManager.waitVisibleElement(ProductList.product(1).bySpanPrice()).getText();
		/*Pega o src da foto do primeiro produto*/
		String foto = WebDriverManager.waitVisibleElement(ProductList.product(1).byImg()).getAttribute("src");
		
		price = price.replace("$", "");
		
		Float left, right;
		left = Float.parseFloat(price);
		left = left - 0.16f;
		right = Float.parseFloat(price);
		PriceRange.rangeBetween(left, right);;
		Delay.of(1500);
		
		String fotoAfter = WebDriverManager.waitVisibleElement(ProductList.product(1).byImg()).getAttribute("src");
		
		collector.checkThat(fotoAfter, equalTo(foto));;
		
	}
	
}
