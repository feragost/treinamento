package autopractice.parser;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autopractice.dto.ProductDto;
import autopractice.pageobject.ProductContainer;
import autopractice.pageobject.ProductList;
import core.WebDriverManager;

public class ProductParser {

	public static List<ProductDto> parseAllPresentProducts() {

		List<ProductDto> productDtolist = new LinkedList<ProductDto>();

		WebElement productList = WebDriverManager.waitVisibleElement(ProductList.by());
		int presentContainersNumber = productList.findElements(By.xpath("." + ProductList.xpathProductContainer)).size();
		for (int i = 0; i < presentContainersNumber; i++) {
			productDtolist.add(parse(ProductList.product(i + 1)));
		}

		return productDtolist;

	}

	public static ProductDto parse(ProductContainer container) {

		ProductDto dto = new ProductDto();

		dto.setName(WebDriverManager.waitVisibleElement(container.byLinkName()).getText());

		String stringPrice = WebDriverManager.waitVisibleElement(container.bySpanPrice()).getText();
		stringPrice = stringPrice.replace("$", "");
		dto.setPrice(Float.parseFloat(stringPrice));

		return dto;

	}

}
