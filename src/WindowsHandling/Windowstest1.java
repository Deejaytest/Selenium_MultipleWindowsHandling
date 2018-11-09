package WindowsHandling;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowstest1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\c-deepak.jindal\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.google.com");
		driver.findElement(By.linkText("Help")).click();
		System.out.println(driver.getTitle()); // By-default, control is on parent window, so parent window title is fetched
		Set<String> ids = driver.getWindowHandles(); // Store window handle IDs into the set data structure
		Iterator<String> handles = ids.iterator(); // We use iterator to parse each id in the set data structure
		String parent = handles.next(); //Store first window handle id, which is the id of the parent window
		String child = handles.next(); //Store second window handle id, which is the id of the first child window
		driver.switchTo().window(child); //Switching control from parent to child window
		System.out.println(driver.getTitle()); // Now that control is on child window, so child window title will be fetched here. 
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
	}

}