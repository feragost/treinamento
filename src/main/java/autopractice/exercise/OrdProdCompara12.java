package autopractice.exercise;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autopractice.pageobject.AutomationPracticePag;
import autopractice.pageobject.ProductComparison;
import autopractice.pageobject.ProductComparisonContainer;
import autopractice.pageobject.ProductContainer;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.TopMenuPag;
import autopractice.pageobject.TopMenuWomenPag;
import core.WebDriverManager;
import core.WebDriverRunner;
import core.steps.Delay;

//Responsavel pela regra 1: A ordem do produto que eu adiciono para comparacao deve ser a mesma ordem que aparece na pagina de comparacao.
//Primeiro produto 1 depois o produto 2.
@RunWith(WebDriverRunner.class)
public class OrdProdCompara12 {
	

		@Rule
		public ErrorCollector collector = new ErrorCollector();

		@Test
		public void run() {
			
			/*Verifica se ao adicionar o primeiro produto da lista de Summer Dresses e depois o segundo
			 * a ordem que aparece em COMPARE é primeiro o primeiro produto e segundo o segundo produto*/
			
			/*Acessa a página, move o cursor para o menu WOMEN e clica na opção SUMMER DRESSES*/
			WebDriverManager.acessar(AutomationPracticePag.url);
			WebDriverManager.moveMouseTo(TopMenuPag.byLiDresses());
			WebDriverManager.waitVisibleElement(TopMenuWomenPag.byLinkSummerDresses()).click();
			
			/*Clica na opção de visualização(VIEW) LIST*/
			WebDriverManager.waitVisibleElement(ProductList.viewList()).click();
			
			/*Adiciona o primeiro item da lista para comparacao*/
			WebDriverManager.waitVisibleElement(ProductList.product(1).byButtonAddToCompare()).click();
			
			/*Espera que o primeiro item seja adicionado para comparacao*/
			//ProductContainer.waitSelected(ProductList.product(1).byButtonAddToCompare());
			
			Delay.of(1000);
			
			/*Adiciona o segundo item da lista para comparacao*/
			WebDriverManager.waitVisibleElement(ProductList.product(2).byButtonAddToCompare()).click();
			
			/*Salva o caminho da imagem 1 para comparar depois*/
			By byImage = ProductList.product(1).byImg();
			WebElement image = WebDriverManager.waitVisibleElement(byImage);
			String sourceImage1 = image.getAttribute("src");
			
			/*Salva o caminho da imagem 2 para comparar depois*/
			byImage = ProductList.product(2).byImg();
			image = WebDriverManager.waitVisibleElement(byImage);
			String sourceImage2 = image.getAttribute("src");
			
			/*Clica no botão Compare de cima*/
			WebDriverManager.waitVisibleElement(ProductList.topCompareButton()).click();
			
			/*Salva o caminha das imagens 1 e 2 na tela de comparação*/
			byImage = ProductComparison.product(1).byImg();
			image = WebDriverManager.waitVisibleElement(byImage);
			String compareSourceImage1 = image.getAttribute("src");
			
			byImage = ProductComparison.product(2).byImg();
			image = WebDriverManager.waitVisibleElement(byImage);
			String compareSourceImage2 = image.getAttribute("src");
			
			collector.checkThat(compareSourceImage1, equalTo(sourceImage1));
			collector.checkThat(compareSourceImage2, equalTo(sourceImage2));
			
		}

}
