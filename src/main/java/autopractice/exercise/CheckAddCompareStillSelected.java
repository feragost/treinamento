package autopractice.exercise;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuWomenPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

//Responsavel pela regra 2: Quando um item esta selecionado para comparacao o link ADD TO COMPARE deve possuir o simbolo "-".
@RunWith(WebDriverRunner.class)
public class CheckAddCompareStillSelected {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {
		
		/*Verifica se ao clicar no botão ADD TO COMPARE ele fica com o "-"*/
		
		/*Acessa a página, move o cursor para o menu WOMEN e clica na opção SUMMER DRESSES*/
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiDresses());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();
		
		/*Clica na opção de visualização(VIEW) LIST*/
		WebDriverManager.waitVisibleElement(ProductList.viewList()).click();
		
		/*Adiciona o primeiro item da lista para comparacao*/
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		
		/*Printa o valor do atributo class para verificar se ele foi selecionado antes do procedimento seguinte*/
		Delay.of(1000);
		System.out.println(WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).getAttribute("class"));
		
		/*Novamente move o cursor para o menu WOMEN e clica na opção SUMMER DRESSES*/
		WebDriverManager.moveMouseTo(TopMenuPag.byLiDresses());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();
		
		/*Salva o valor do atributo CLASS do botão ADD TO COMPARE*/
		String statusAddCompare = WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).getAttribute("class");
		
		/*Verifica se no atributo acima possui checked, se possuir esta selecionado(possui "-")*/
		collector.checkThat(statusAddCompare, Matchers.containsString("checked"));
		
		
	}
	
}
