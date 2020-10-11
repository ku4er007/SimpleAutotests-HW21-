import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class GoogleSearchTest extends BaseUiTests {
    String url = "https://google.com/ncr";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }

    @Test
    public void positivEnterSearchTest() {
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        WebElement stats = wait.until(presenceOfElementLocated(By.cssSelector("#result-stats")));
        assertTrue(stats.getText().contains("About"));
    }

    @Test
    public void positivClickButtonSearchTest() {
        driver.findElement(By.name("q")).sendKeys("cheese");
        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Украина')]")).click();
        WebElement stats = wait.until(presenceOfElementLocated(By.cssSelector("#result-stats")));
        assertTrue(stats.getText().contains("About"));
     }
}
