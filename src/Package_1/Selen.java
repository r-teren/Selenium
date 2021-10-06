package Package_1;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class Selen {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Roman Teren\\Desktop\\Selenium\\chromedriver.exe");
        WebDriver chromedriver=new ChromeDriver();
        chromedriver.manage().window().maximize();
        chromedriver.navigate().to("http://www.google.com");

        //create elements for google search
        WebElement searchField = chromedriver.findElement(By.name("q"));
        WebElement searchBut = chromedriver.findElement(By.name("btnK"));

        //insert criteria
        searchField.sendKeys("Selenium");
        //searchField.submit();

        // Waiting
        WebDriverWait loadWait = new WebDriverWait(chromedriver,3);
        loadWait.until (ExpectedConditions.elementToBeClickable(searchBut));

        searchBut.click();

           // Wait till page fully loaded:

        loadWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) chromedriver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
       // Assert.


        List<WebElement> selCount = chromedriver.findElements(By.xpath("//*[contains (text(),'Selenium')]"));

        String title = chromedriver.getTitle();
        String titleExp = "Selenium - Пошук Google";
        Assert.assertEquals(title, titleExp);
        String result = ("The amount of webElements which contains text 'Selenium' at page " + "'" + title + "'" +" is " + selCount.size());


        chromedriver.quit();

        System.out.println(result);



    }
}
