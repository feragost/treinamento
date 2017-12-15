package autopractice.exercise;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import autopractice.pageobject.AddToCartPag;
import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.CatalogPag;
import autopractice.pageobject.CheckoutPag;
import autopractice.pageobject.ComparePag;
import autopractice.pageobject.MorePag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuDressesPag;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuWomenPag;
import autopractice.pageobject.ViewedProductsPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

@RunWith(WebDriverRunner.class)
public class AehoWordXablau {
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void run() {
		WebDriverManager.acessar(AutomationPracticePag.url);
		
		//1
		WebDriverManager.moveMouseTo(TopMenuPag.byLiDresses());
		WebDriverManager.waitVisibleElement(TopMenuDressesPag.byLinkSummerDresses()).click();
		
		//2
		WebDriverManager.waitVisibleElement(ProductList.liList()).click();
		
		//Extra test
		//WebDriverManager.waitVisibleElement(CatalogPag.byEnableFilter("White")).click();
		//Delay.of(2000);
		
		//Compare test
		//WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonAddToCompare()).click();
		//Delay.of(1000);
		//System.out.println(WebDriverManager.waitVisibleElement(ProductList.buttonCompareNumber()).getText());
		//WebDriverManager.waitVisibleElement(ProductList.buttonCompare()).click();
		//System.out.println(WebDriverManager.waitVisibleElement(ComparePag.getPrice(1)).getText());
		//WebDriverManager.waitVisibleElement(ComparePag.continueShoppingButton()).click();
		
		//3
		WebDriverManager.waitVisibleElement(ProductList.product(3).byButtonMore()).click();
		
		
		
		
		//4
		WebDriverManager.waitVisibleElement(MorePag.addItem()).click();
		WebDriverManager.waitVisibleElement(MorePag.addItem()).click();
		
		//5

		WebDriverManager.waitVisibleElement(MorePag.sizeSelector());
		WebDriverManager.waitVisibleElement(MorePag.selectSize("M")).click();

		//6
		WebDriverManager.waitVisibleElement(MorePag.selectColor("Green")).click();
		
		//7
		WebDriverManager.waitVisibleElement(MorePag.addToCartButton()).click();
		
		//8
		System.out.println(WebDriverManager.waitVisibleElement(AddToCartPag.totalPrice()).getText());
		
		//9
		WebDriverManager.waitVisibleElement(AddToCartPag.continueShopppingButton()).click();
		WebDriverManager.waitInvisibleElement(AddToCartPag.continueShopppingButton());
		
		//10
		WebDriverManager.waitVisibleElement(TopMenuPag.byLiTShirt()).click();
		
		//11
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCart()).click();
		
		//12
		WebDriverManager.waitVisibleElement(AddToCartPag.proceedToCheckoutButton()).click();
		
		//13
		System.out.println(WebDriverManager.waitVisibleElement(CheckoutPag.totalPrice()).getText());
		
		//14
		WebDriverManager.waitVisibleElement(CheckoutPag.continueShopping()).click();
		
		//15
		System.out.println(WebDriverManager.waitVisibleElement(ViewedProductsPag.lastProduct()).getAttribute("title"));
		
		
		
	}
	
	
}
