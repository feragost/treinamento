package autopractice.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import autopractice.pageobject.ProductList;
import core.WebDriverManager;
import core.WebDriverRunner;

@RunWith(WebDriverRunner.class)
public class TesteRegra8 {
	// As cores disponíveis no catálogo devem ser as cores que aparecem nos itens presentes na lista.
	
	@Test
	public void teste_corFiltrada() {
		//Uma cor selecionada no filtro
		
		//TesteRegra1.acessarListaSummerDresses();
		
	}
	
	@Test
	public void teste_nenhumaCorFiltrada() {
		//Nenhuma cor selecionada no filtro
				
	}
	
}
