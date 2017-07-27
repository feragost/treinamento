package core;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * Runner do JUnit criado com o propósito de controlar o ciclo de vida do browser a cada teste.
 * Os testes que utilizarem a annotation @RunWith na classe, estarão sob o controle deste runner.
 */

public class WebDriverRunner extends BlockJUnit4ClassRunner {

	public WebDriverRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected void runChild(final FrameworkMethod method, RunNotifier notifier) {

		this.beforeTest();

		try {
			super.runChild(method, notifier);
		} finally {
			this.afterTest();
		}

	}

	private void beforeTest() {

		WebDriverManager.create();

	}

	private void afterTest() {

		//WebDriverManager.close();

	}

}
