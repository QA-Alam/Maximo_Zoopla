package maximo.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import maximo.basepage.SupperClass;

public class Hooks extends SupperClass {

	@Before
	public void applicationStart() {
		//initializationMaximo();
		initializationZoopla();
	}

     @After
	public void tearDown() {
		driver.quit();
	}
}
