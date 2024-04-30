package pe.edu.ulasalle.utest.test.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class TestDoctavio {

	private static final String pathDriver = "G:\\chromedriver.exe";
	
	private static WebDriver driver;
	
	@BeforeAll
	public static void iniciar() {
		ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", pathDriver);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
	}
	
	@AfterAll
	public static void finalizar() {
//		driver.close();
//		driver.quit();
	}
	
	//@Test
	void testDoctorNombre() {
		String url = "https://doctavio.pe/";
		By by = null;
		WebElement wel = null;
		driver.navigate().to(url);
		by = By.id("k");
		wel = driver.findElement(by);
		wel.sendKeys("Pediatr?a");
		by = By.id("ubigeo_name");
		wel = driver.findElement(by);
		wel.sendKeys("Miraflores");
		by = By.id("global_search");
		wel = driver.findElement(by);
		wel.click();
		by = By.xpath("//*[@id=\"doctors\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a");
		wel = driver.findElement(by);
		wel.click();
		by = By.xpath("//*[@id=\"doctor_profile\"]/div[2]/div/div/div[2]/div[1]");
		wel = driver.findElement(by);
		System.out.println("wel.getText(): " + wel.getText());
		assertEquals("Dra. Mar?a Luisa Stiglich Watson", wel.getText());
	}
	
	//@Test
	void testDoctores() {
		String url = "https://doctavio.pe/";
		By by = null;
		WebElement wel = null;
		driver.navigate().to(url);
		by = By.id("k");
		wel = driver.findElement(by);
		wel.sendKeys("Pediatr?a");
		by = By.id("ubigeo_name");
		wel = driver.findElement(by);
		wel.sendKeys("Miraflores");
		by = By.id("global_search");
		wel = driver.findElement(by);
		wel.click();
		Document doc = Jsoup.parse(driver.getPageSource());
		Elements els = doc.getElementsByClass("doctors_list");
		Iterator<Element> it = null;
		it = els.iterator();
		int nResultados = 0;
		while (it.hasNext()) {
			Element el = it.next();
			//System.out.println(el.html());
			el = el.child(1);
			Elements elsResult = el.children();
			Iterator<Element> itResult = elsResult.iterator();
			while (itResult.hasNext()) {
				Element elResult = itResult.next();
				String tag = elResult.tag().getName().toUpperCase();
				String className = elResult.className();
				if (tag.equals("DIV") && className.equals("block_item")) {
					nResultados++;
				}
			}
		}
		assertEquals(3, nResultados);
	}

	@Test
	void testSolicitarDatos() {
		String url = "https://doctavio.pe/";
		By by = null;
		WebElement wel = null;
		driver.navigate().to(url);
		sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "document.getElementById(arguments[0]).remove();";
		js.executeScript(script, new Object[] {"chatIframe"});
		by = By.id("k");
		wel = driver.findElement(by);
		wel.sendKeys("Pediatr?a");
		by = By.id("ubigeo_name");
		wel = driver.findElement(by);
		wel.sendKeys("Miraflores");
		by = By.id("global_search");
		wel = driver.findElement(by);
		wel.click();
		sleep(3000);
		by = By.xpath("//*[@id=\"doctors\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a");
		wel = driver.findElement(by);
		wel.click();
		sleep(3000);
		by = By.xpath("//*[@id=\"doctor_profile\"]/div[2]/div/div/div[3]/a");
		wel = driver.findElement(by);
		wel.click();
		sleep(2000);
		by = By.id("first_name");
		wel = driver.findElement(by);
		wel.sendKeys("UTEST");
		by = By.id("email");
		wel = driver.findElement(by);
		wel.sendKeys("UTEST@GMAIL.COM");
		by = By.id("phone");
		wel = driver.findElement(by);
		wel.sendKeys("959789987");
//		by = By.id("terms_and_conditions");
//		wel = driver.findElement(by);
//		wel.click();
		script = "document.getElementById(arguments[0]).click();";
		js.executeScript(script, new Object[] {"terms_and_conditions"});
	}
	
	public void sleep(long milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
