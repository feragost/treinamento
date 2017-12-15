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

//Responsavel pela regra 2: Quando um item est� selecionado para compara��o o link ADD TO COMPARE deve possuir o s�mbolo "-".
@RunWith(WebDriverRunner.class)
public class CheckAddCompareSelected {
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {
		
		/*Verifica se ao clicar no bot�o ADD TO COMPARE ele fica com o "-"*/
		
		/*Acessa a p�gina, move o cursor para o menu WOMEN e clica na op��o SUMMER DRESSES*/
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiDresses());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();
		
		/*Clica na op��o de visualiza��o(VIEW) LIST*/
		WebDriverManager.waitVisibleElement(ProductList.viewList()).click();
		
		/*Adiciona o primeiro item da lista para comparacao*/
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		
		Delay.of(500);
		
		/*Salva o valor do atributo CLASS do bot�o ADD TO COMPARE*/
		String statusAddCompare = WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).getAttribute("class");
		
		/*Verifica se no atributo acima possui checked, se possuir esta selecionado(possui "-")*/
		collector.checkThat(statusAddCompare, Matchers.containsString("checked"));
		
		
	}

}
