package autopractice.exercise;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ProductComparison;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuWomenPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

//Responsavel pela regra 1: A ordem do produto que eu adiciono para comparacao deve ser a mesma ordem que aparece na pagina de comparacao.
//Primeiro produto 2 depois o produto 1.
@RunWith(WebDriverRunner.class)
public class OrdProdCompara21 {
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void run() {
		
		/*Verifica se ao adicionar o segundo produto da lista de Summer Dresses e depois o primeiro
		 * a ordem que aparece em COMPARE � primeiro o segundo produto e segundo o primeiro produto*/
		
		/*Acessa a p�gina, move o cursor para o menu WOMEN e clica na op��o SUMMER DRESSES*/
		WebDriverManager.acessar(AutomationPracticePag.url);
		WebDriverManager.moveMouseTo(TopMenuPag.byLiDresses());
		WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();
		
		/*Clica na op��o de visualiza��o(VIEW) LIST*/
		WebDriverManager.waitVisibleElement(ProductList.viewList()).click();
		
		/*Adiciona o segundo item da lista para comparacao*/
		WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonAddToCompare()).click();
		
		/*Espera que o segundo item seja adicionado para comparacao*/
		//ProductContainer.waitSelected(ProductList.product(2).byButtonAddToCompare());
		
		Delay.of(1000);
		
		/*Adiciona o primeiro item da lista para comparacao*/
		WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
		
		/*Salva o caminho da imagem 2 para comparar depois*/
		By byImage = ProductList.product(2).byImg();
		WebElement image = WebDriverManager.waitVisibleElement(byImage);
		String sourceImage2 = image.getAttribute("src");
		System.out.println(sourceImage2);
		
		/*Salva o caminho da imagem 1 para comparar depois*/
		byImage = ProductList.product(1).byImg();
		image = WebDriverManager.waitVisibleElement(byImage);
		String sourceImage1 = image.getAttribute("src");
		System.out.println(sourceImage1);
		
		/*Clica no bot�o Compare de cima*/
		WebDriverManager.waitVisibleElement(ProductList.topCompareButton()).click();
		
		/*Salva o caminha das imagens 1 e 2 na tela de compara��o*/
		byImage = ProductComparison.product(1).byImg();
		image = WebDriverManager.waitVisibleElement(byImage);
		String compareSourceImage1 = image.getAttribute("src");
		
		byImage = ProductComparison.product(2).byImg();
		image = WebDriverManager.waitVisibleElement(byImage);
		String compareSourceImage2 = image.getAttribute("src");
		
		collector.checkThat(compareSourceImage2, equalTo(sourceImage1));
		collector.checkThat(compareSourceImage1, equalTo(sourceImage2));
		
	}

}
