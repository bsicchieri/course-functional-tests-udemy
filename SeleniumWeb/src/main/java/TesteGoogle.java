import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
	
	private WebDriver driver;

	@Before
	public void inicializa() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/Bruno/Desktop/Projetos/Testes Funcionais com Selenium WebDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza() {
		
		driver.quit();
	}
	
	@Test
	public void teste() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/Bruno/Desktop/Projetos/Udemy Testes Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
	}	
}
