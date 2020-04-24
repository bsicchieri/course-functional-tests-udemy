import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteAjax {
	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		
		System.setProperty("webdriver.chrome.driver", 
				"/Users/Bruno/Desktop/Projetos/Testes Funcionais com Selenium WebDriver/course-functional-tests-udemy/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		
		driver.quit();
	}
	
	@Test
	public void testeAjax() {
		dsl.escrever("j_idt721:name", "Bruno");
		dsl.clicarBotao("j_idt721:j_idt724");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.textToBe(By.id("j_idt721:display"), "Bruno"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt793")));
		Assert.assertEquals("Bruno", dsl.obterTexto("j_idt721:display"));
	}
}
