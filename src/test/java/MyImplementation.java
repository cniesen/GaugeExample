import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyImplementation {
    WebDriver driver = new ChromeDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    @Step("Navigate to <https://google.com>")
    public void navigateTo(String url){
        driver.get(url);
    }

    @Step("Enter <foobar> in search field")
    public void searchForString(String searchString) throws InterruptedException {
        WebElement searchField = driver.findElement(By.name("q"));
        wait.until(d -> searchField.isDisplayed());
        searchField.sendKeys(searchString);
        driver.findElement(By.name("btnK")).click();
    }
}
