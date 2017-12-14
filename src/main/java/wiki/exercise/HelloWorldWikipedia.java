package wiki.exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import wiki.pageobject.WikiPag;

public class HelloWorldWikipedia {

	public static void main(String[] args) {

		/** define o caminho para o exe que faz a ponte entre a API do selenium e o browser */
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/chromedriver.exe");

		/** objeto responsável por definir algumas configurações do browser */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		/** objeto responsável pelo resgate dos elementos de uma página aberta no browser */
		WebDriver webdriver = new ChromeDriver(options);
		webdriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		/** acessa a página colocada como parâmetro */
		webdriver.get(WikiPag.url);

		/** objeto que representa um endereço de como chegar até um elemento */
		By byInputSearch = By.id("searchInput");

		/** objeto que representa um elemento presente na página */
		WebElement elementInputSearch = webdriver.findElement(byInputSearch);

		/** ação sobre o elemento em tela: preencher o elemento com o termo */
		elementInputSearch.sendKeys("Metallica");

		/** ação sobre o elemento em tela: clicar no botão pesquisar */
		webdriver.findElement(By.id("searchButton")).click();

		/** funções para finalizar o browser */
		webdriver.close();
		webdriver.quit();

	}

}
