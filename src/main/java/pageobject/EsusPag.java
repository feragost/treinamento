package pageobject;

import org.openqa.selenium.By;

public class EsusPag {

	public static final String url = "http://150.162.196.140:8080/esus/#/pec";
	public static final String cadastroIndividualUrl = "http://150.162.196.140:8080/esus/#/pec/user/cds/cadastroIndividual";
	
	public static By loginField() {
		return By.xpath(".//input[@class='login-input'][@type='text']");
	}
	
	public static By passwordField() {
		return By.xpath(".//input[@class='login-input'][@type='password']");
	}

	public static By buttonAccess() {
		return By.xpath(".//button");
	}

	public static By cdsButton() {
		return By.xpath(".//div[@peid='class br.gov.saude.esus.EsusUserMenuViewImpl.cds']");
	}
	
	public static By cadastroIndividualButton() {
		return By.xpath(".//div[@class='noselect nodrag']");
	}
	
	public static By adicionarButton() {
		return By.xpath(".//div[@peid='FichaCadastroIndividualListingViewImpl.Adicionar']");
	}
	
	public static By cancelarButton() {
		return By.xpath(".//div[@peid='CadastroIndividualDetailViewImpl.Cancelar']");
	}
}
