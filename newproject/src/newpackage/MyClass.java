package newpackage;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

//addition
public class MyClass {
	public static void main(String args[]) {
System.setProperty("webdriver.chrome.driver","F:\\Personal\\Selenium_essentials\\chrome\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		
		WebDriver driver = new ChromeDriver(options);
		
		String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Thank you for Loggin.";
        String actualTitle = "";
        String getUrl = "";
        driver.get(baseUrl);
        
        actualTitle = driver.getTitle();
        WebElement txt = driver.findElement(By.name("userName"));
        WebElement psw = driver.findElement(By.name("password"));
        WebElement sub = driver.findElement(By.name("submit"));
        //WebElement partial = driver.findElement(By.linkText("SIGN-OFF")); NW
        txt.sendKeys("user");
        psw.sendKeys("pass");
        sub.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //partial.click(); NW for line no. 30
        String wel = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")).getText();
        System.out.println(wel);
        System.out.println(actualTitle);
        getUrl = driver.getCurrentUrl();
        System.out.println("Current url:"+getUrl);
        driver.navigate().back();
        getUrl = driver.getCurrentUrl();
        System.out.println("Current url:"+getUrl);
        if(wel.contentEquals(expectedTitle)) {
        	System.out.println("Pass!");}
        	else {
        	System.out.println("Fail!");
        	}
        
        //Frame
        /*String frameUrl = "http://demo.guru99.com/selenium/deprecated.html";
        
        driver.get(frameUrl);
        
        driver.switchTo().frame("classFrame");
        driver.findElement(By.linkText("Deprecated")).click();
        */
        //alert handler
        String alert = "http://output.jsbin.com/usidix/1";
        
        driver.get(alert);
        
        driver.findElement(By.cssSelector("body > input[type=\"button\"]")).click();
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        
        System.out.println(alertText); 
        
        //get page source
        //String ps = driver.getPageSource();
        //System.out.println(ps);
        
        //PART 2
        
        driver.get("http://demo.guru99.com/test/radio.html");
        WebElement cb = driver.findElement(By.id("vfb-6-0"));
        //cb.click();
        if(cb.isSelected()) {
        	System.out.println("Pass");
        }
        else {
        	System.out.println("Fail");
        }
        
        // PART 3
        driver.get("http://demo.guru99.com/test/newtours/register.php");
        Select dd = new Select(driver.findElement(By.name("country")));
        
        //dd.selectByIndex(7);
        dd.selectByVisibleText("ARMENIA");
        
        String ddText = dd.getFirstSelectedOption().getText();        
        System.out.println(ddText);
        
        driver.get("https://www.guru99.com/accessing-links-tables-selenium-webdriver.html");
        WebElement lnk = driver.findElement(By.linkText("Exact Match"));
        String lnkText = lnk.getText();
        System.out.println(lnkText);
        lnk.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
        // Find all the links in page
        driver.get("http://demo.guru99.com/test/newtours/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
        //Store in string of srrsy
        String[] allLinks = new String[links.size()];
        int i = 0;
        
        for(WebElement linkText: links) {
        	allLinks[i] = linkText.getText();
        	System.out.println("Link "+i+" :" +allLinks[i]);
        	i++;
        }
        
        for(String t : allLinks) {
        	driver.findElement(By.linkText(t)).click();
        	System.out.println(driver.getTitle());
        	driver.get("http://demo.guru99.com/test/newtours/");
            
        }
        
        //driver.close();
        
        }
}