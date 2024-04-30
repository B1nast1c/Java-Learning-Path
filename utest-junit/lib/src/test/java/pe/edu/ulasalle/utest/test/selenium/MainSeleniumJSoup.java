package pe.edu.ulasalle.utest.test.selenium;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainSeleniumJSoup {

	public static void main(String[] args) {
		int delay = 4000;
		String pathDriver = "G:\\chromedriver.exe";
		ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", pathDriver);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        String url = "https://www.ulasalle.edu.pe/admision/";
		driver.navigate().to(url);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String html = driver.getPageSource();
		//System.out.println(html);
		Document doc = Jsoup.parse(html);
		Elements els = doc.getElementsByClass("et_pb_row et_pb_row_5 et_pb_equal_columns et_pb_gutters2 et_pb_row_5col");
		Iterator<Element> it = null;
		it = els.iterator();
		while (it.hasNext()) {
			Element divtodos = it.next();
			System.out.println(divtodos.childrenSize());
			for (int i = 0; i < divtodos.childrenSize(); i++) {
				Element elcarrera = divtodos.child(i);
				Element el = elcarrera.child(1).child(0);
				System.out.println(el.text());
			}
		}
	}
}
