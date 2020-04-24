import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteJanelaEWindowHandler {
	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		
		System.setProperty("webdriver.chrome.driver", 
				"/Users/Bruno/Desktop/Projetos/Testes Funcionais com Selenium WebDriver/course-functional-tests-udemy/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		
		driver.quit();
	}

	@Test
	public void deveInteragirComJanelas() {
		
		/* driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");		
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.close();		
		driver.switchTo().window("");		
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?"); */
		
		dsl.clicarBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		driver.close();
		dsl.trocarJanela("");
		dsl.escrever(By.tagName("textarea"), "e agora?");
	}
	
	@Test
	public void deveInteragirComWindowHandler() {
		
		/* driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());		
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]); 
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");		
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]); 		
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?"); */
		
		dsl.clicarBotao("buttonPopUpHard");
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
		dsl.escrever(By.tagName("textarea"), "e agora?");
	}
}
