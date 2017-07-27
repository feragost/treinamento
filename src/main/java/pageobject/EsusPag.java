package pageobject;

import org.openqa.selenium.By;

public class EsusPag {
	
	public static final String url = "http://150.162.196.244:8080/esus";
	
	public static By login() {
		return By.xpath("//input[@class='login-input' and @type='text']");
	}
	
	public static By password() {
		return By.xpath("//input[@class='login-input' and @type='password']");
	}
	
	public static By confirmLogin() {
		return By.xpath("//div[@peid='EsusMe']");
	}
	
	public static By loginButton() {
		return By.xpath("//button[@type='button' and text()='Acessar']");
	}
	
	public static By lotacao(String local, String lotacao) {
		return By.xpath("//div[@peid='"+local+"."+lotacao+"']");
	}
	
	public static By cds() {
		return By.xpath("//div[@peid='class br.gov.saude.esus.EsusUserMenuViewImpl.cds']");
	}
	
	public static By cadastroIndividual() {
		return By.xpath("//div[contains(@style, 'cadastro_individual')]");
	}
	
	public static By cadastrosIndividualAddButton() {
		return By.xpath("//button[@type='button' and text()='Adicionar']");
	}
	
	public static By adicionarCadastroCancelButton() {
		return By.xpath("//button[@type='button' and text()='Cancelar']");
	}
	
	public static By userMenu() {
		return By.xpath("//div[@class='user-menu-button']");
	}
	
	public static By logout() {
		return By.xpath("//button[text()='Sair']");
	}
	

}
