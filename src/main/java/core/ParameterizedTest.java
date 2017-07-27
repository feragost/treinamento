package core;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParameterizedTest {

	@Before
	public void initializeWebDriver() {
		WebDriverManager.create();
	}

	@After
	public void finalizeWebDriver() {
		WebDriverManager.close();
	}

}
