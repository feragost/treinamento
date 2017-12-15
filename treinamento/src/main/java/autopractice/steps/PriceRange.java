package autopractice.steps;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import autopractice.pageobject.CatalogPag;
import core.WebDriverManager;
import core.steps.Delay;

public class PriceRange {

	public static void rangeBetween(float left, float right) {

		WebElement spanPriceRange = WebDriverManager.waitVisibleElement(CatalogPag.bySpanPriceRange());
		WebDriverManager.scroolTo(spanPriceRange);

		moveLeftRangeUntil(left);

		moveRightRangeUntil(right);

	}

	public static void moveLeftRangeUntil(float left) {

		WebElement leftPriceRange = WebDriverManager.waitVisibleElement(CatalogPag.byLeftPriceRange());
		clickAndHold(leftPriceRange);
		float[] range = getRange();
		while (range[0] < left) {
			moveHorizontalMouse(2);
			Delay.of(20);
			range = getRange();
		}
		release();

	}

	public static void moveRightRangeUntil(float right) {

		WebElement rightPriceRange = WebDriverManager.waitVisibleElement(CatalogPag.byRightPriceRange());
		clickAndHold(rightPriceRange);
		float[] range = getRange();
		while (range[1] > right) {
			moveHorizontalMouse(-2);
			Delay.of(20);
			range = getRange();
		}
		release();

	}

	public static void clickAndHold(WebElement range) {
		WebDriver wd = WebDriverManager.getWebDriver();
		Actions move = new Actions(wd);
		Action action = move.clickAndHold(range).build();
		action.perform();
	}

	public static void moveHorizontalMouse(int x) {
		WebDriver wd = WebDriverManager.getWebDriver();
		Actions move = new Actions(wd);
		Action action = move.moveByOffset(x, 0).build();
		action.perform();
	}

	public static void release() {
		WebDriver wd = WebDriverManager.getWebDriver();
		Actions move = new Actions(wd);
		Action action = move.release().build();
		action.perform();
	}

	public static float[] getRange() {
		float[] range = new float[2];
		WebElement spanPriceRange = WebDriverManager.waitVisibleElement(CatalogPag.bySpanPriceRange());
		String rangeText = spanPriceRange.getText();

		Pattern pattern = Pattern.compile("\\d+\\.\\d+");
		Matcher m = pattern.matcher(rangeText);

		for (int i = 0; i < 2; i++) {
			m.find();
			String stringFloat = m.group();
			range[i] = Float.parseFloat(stringFloat);
		}

		return range;
	}

}
