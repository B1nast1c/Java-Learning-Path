package pe.edu.ulasalle.utest.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainSelenium {

	public static void main(String[] args) {
		int delay = 2000;
		String pathDriver = "G:\\chromedriver.exe";
		ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", pathDriver);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        String url = "https://www.falabella.com.pe/falabella-pe";
		driver.navigate().to(url);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		url = "https://www.falabella.com.pe/falabella-pe/static/staticContent1.jsp?active=11&id=cat510493";
		driver.navigate().to(url);
		delay = 4000;
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		url = "https://www.falabella.com.pe/falabella-pe/page/Cyber-Falabella?staticPageId=15400001";
		driver.navigate().to(url);
		driver.close();
		driver.quit();
	}
}
