package pe.edu.ulasalle.utest.test.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSeleniumUlasalle {

	private static final String pathDriver = "G:\\chromedriver.exe";
	
	private static WebDriver driver;
	
	@BeforeAll
	public static void iniciar() {
		ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", pathDriver);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
	}

	@Test
	public void testCarreras() {
		String[] salida = new String[] {
				"Derecho", "Administración y Negocios Internacionales",
				"Ingeniería de Software", "Ciencias de la Comunicación", 
				"Ingeniería Comercial"};
		String url = "https://www.ulasalle.edu.pe/";
		driver.navigate().to(url);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String html = driver.getPageSource();
		//System.out.println(html);
		Document doc = Jsoup.parse(html);
		Elements els = doc.getElementsByClass("et_pb_row et_pb_row_3 et_pb_equal_columns et_pb_gutters2 et_pb_row_5col");
		Iterator<Element> it = els.iterator();
		List<String> lst = new ArrayList<String>();
		while (it.hasNext()) {
			Element el = it.next();
			System.out.println(el.text());
			int ncarreras = el.childrenSize();
			for (int i = 0; i < ncarreras; i++) {
				Element divcarrera = el.child(i);
				Element eltexto = divcarrera.child(0);
				lst.add(eltexto.text());
			}
		}
		for (int i = 0; i < salida.length; i++) {
			assertEquals(salida[i], lst.get(i));
			
		}
	}
}


