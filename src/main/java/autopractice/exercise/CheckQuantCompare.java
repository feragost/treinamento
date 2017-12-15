package autopractice.exercise;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuWomenPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

//Responsavel pela regra 3: O botão COMPARE deve apresentar a quantidade de itens selecionados para serem comparados.
@RunWith(WebDriverRunner.class)
public class CheckQuantCompare {
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {
		
		/*Verifica se ao adicionar dois itens da lista para comparar o valor no botao COMPARE é igual a dois*/
		
		/*Acessa a página, move o cursor para o menu WOMEN e clica na opção SUMMER DRESSES*/
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiDresses());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();
		
		/*Clica na opção de visualização(VIEW) LIST*/
		WebDriverManager.waitVisibleElement(ProductList.viewList()).click();
		
		/*Adiciona o primeiro item da lista para comparacao*/
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		
		Delay.of(1000);
		
		/*Adiciona o segundo item da lista para comparacao*/
		WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonAddToCompare()).click();
		
		Delay.of(1000);
		
		/*Pega a quantidade que aparece no botão COMPARE*/
		String quantity = ProductList.getQuantCompare();
		
		collector.checkThat(quantity, equalTo("2"));
		
	}

}
