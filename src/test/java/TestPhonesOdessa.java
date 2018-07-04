import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestPhonesOdessa {
    public WebDriver driver= null;
    String urlOdessa="https://odessa.ithillel.ua/contact";

    ArrayList<String> phoneNumbersOdessa;
    ArrayList<String> phoneMobilesOdessa;

    @Before
    public void launchBrowser()  {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(urlOdessa);
        phoneNumbersOdessa = new ArrayList<String>();
        phoneNumbersOdessa.add("+38 (048) 793 23 54");
        phoneNumbersOdessa.add("+38 (048) 793 23 52");
        phoneNumbersOdessa.add("+38 (048) 793 23 51");
        phoneNumbersOdessa.add("+38 (048) 793 23 47");
        phoneNumbersOdessa.add("+38 (048) 793 23 56");
        phoneNumbersOdessa.add("+38 (048) 793 23 57");
        phoneNumbersOdessa.add("+38 (048) 738 98 90");
        phoneNumbersOdessa.add("+38 (048) 793 23 48");
        phoneNumbersOdessa.add("+38 (048) 793 23 49");
        phoneNumbersOdessa.add("+38 (048) 772 23 92");
        phoneMobilesOdessa = new ArrayList<String>();
        phoneMobilesOdessa.add("+38 (067) 103 31 94");
        phoneMobilesOdessa.add("+38 (067) 103 31 64");
        phoneMobilesOdessa.add("+38 (067) 103 31 72");
        phoneMobilesOdessa.add("+38 (067) 103 31 75");
        phoneMobilesOdessa.add("+38 (067) 103 32 12");
        phoneMobilesOdessa.add("+38 (097) 156 58 27");
        phoneMobilesOdessa.add("+38 (067) 200 95 73");
        phoneMobilesOdessa.add("+38 (067) 200 98 54");
        phoneMobilesOdessa.add("+38 (067) 235 87 51");
        phoneMobilesOdessa.add("+38 (067) 235 87 52");

        System.out.println(driver.getTitle());
    }

    @Test
    public void testTitleOdessaContactPage()
    {
        assertEquals("Контакты Компьютерной школы Hillel в Одессе",driver.getTitle());
    }

    @Test
    public void testPhoneOdessaContactPage()
    {
        WebElement element1 = driver.findElement(By.cssSelector("a.item_tel.binct-phone-number-1"));
        System.out.println(element1.getText());
        assertTrue(phoneNumbersOdessa.contains(element1.getText()) );
    }

    @Test
    public void testPhonesOdessaTopBar()
    {
        WebElement element3 = driver.findElement(By.cssSelector("a.text_label.binct-phone-number-1"));
        System.out.println(element3.getText());
        assertTrue(phoneNumbersOdessa.contains(element3.getText()) );
    }

    @Test
    public void testMobileOdessaContactPage()
    {
        WebElement element2 = driver.findElement(By.cssSelector("a.item_tel.binct-phone-number-2"));
        System.out.println(element2.getText());
        assertTrue(phoneMobilesOdessa.contains(element2.getText()) );
    }

    @Test
    public void testMobileTopBar()
    {
        WebElement element3 = driver.findElement(By.cssSelector("a.text_label.binct-phone-number-1"));
        Actions action = new Actions(driver);
        action.moveToElement(element3).build().perform();
        WebElement element4 = driver.findElement(By.cssSelector("a.text_tel.binct-phone-number-2"));
        System.out.println(element4.getText());
        assertTrue(phoneMobilesOdessa.contains(element4.getText()) );
    }

    @After
    public void downBrowser() {
        if (driver != null)
            driver.quit();}
}
