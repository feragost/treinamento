package autopractice.parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sun.jna.platform.win32.Winspool.PRINTER_INFO_1;

import autopractice.dto.ProductDto;
import autopractice.dto.ViewDto;
import autopractice.pageobject.ProductContainer;
import autopractice.pageobject.ProductList;
import autopractice.pageobject.ViewItemContainer;
import autopractice.pageobject.ViewedProductsList;
import core.WebDriverManager;

public class ViewItemParser {

	public static List<ViewDto> parseAllItems() {
		ArrayList<ViewDto> itemList = new ArrayList<ViewDto>();
		
		WebElement viewItems = WebDriverManager.waitVisibleElement(ViewedProductsList.by());
		int elementsCount = viewItems.findElements(By.xpath(ViewedProductsList.xpathViewProducts + ViewItemContainer.productName)).size();
		
		System.out.println("elementsCount: " + elementsCount);
		
		for(int i= 1; i <= elementsCount; i++ ) {
			itemList.add( parse( ViewedProductsList.item(i) ) );
		}
		
		return itemList;
	}
	
	static ViewDto parse(ViewItemContainer container) {
		ViewDto dto = new ViewDto();
		
		dto.setName(WebDriverManager.waitVisibleElement(container.byProductName()).getText());
		dto.setHint(WebDriverManager.waitVisibleElement(container.byProductHint()).getAttribute("title"));
		
		return dto;

	}

}
