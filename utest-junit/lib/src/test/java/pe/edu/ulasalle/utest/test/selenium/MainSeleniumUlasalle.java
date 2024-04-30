package pe.edu.ulasalle.utest.test.selenium;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainSeleniumUlasalle {

	public static void main(String[] args) {
		String pathDriver = "G:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathDriver);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
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
		while (it.hasNext()) {
			Element el = it.next();
			System.out.println(el.text());
			int ncarreras = el.childrenSize();
			for (int i = 0; i < ncarreras; i++) {
				Element divcarrera = el.child(i);
				Element eltexto = divcarrera.child(1).child(0);
				System.out.println(eltexto.text());
			}
		}
	}
}









