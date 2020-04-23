import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrame {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/Bruno/Desktop/Projetos/Testes Funcionais com Selenium WebDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		
		driver.quit();
	}

	@Test
	public void deveInteragirComFrames() {
		
		/* driver.switchTo().frame("frame1");		
		driver.findElement(By.id("frameButton")).click();		
		Alert alert = driver.switchTo().alert();		
		String texto = alert.getText();		
		Assert.assertEquals("Frame OK!", texto);		
		alert.accept();		
		driver.switchTo().defaultContent();		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto); */
		
		dsl.entrarFrame("frame1");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
		dsl.sairFrame();
		dsl.escrever("elementosForm:nome", msg);
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		
		/* WebElement frame = driver.findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		
		//dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		//String msg = dsl.alertaObterTextoEAceita();
		//Assert.assertEquals("Frame OK!", msg); */
		
		WebElement frame = driver.findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
	}
}

