import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class DemoGuruLoginTest extends BaseUiTests {

    String loginUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String login = "1303";
    String newUrl = "http://demo.guru99.com/insurance/v1/index.php";
    String bankUrl = "http://demo.guru99.com/V1/index.php";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(loginUrl);
    }

    @Test
    public void positiveLoginTest() {
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        WebElement logoutButton = wait.until(presenceOfElementLocated(By.linkText("Log out")));
        logoutButton.click();
        assertEquals(driver.switchTo().alert().getText(), "You Have Succesfully Logged Out!!");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), loginUrl);

    }

    @Test
    public void negativeWrongPasswordLoginTest() {
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys("qwerty ");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void negativeWrongLoginTest() {
        driver.findElement(By.name("uid")).sendKeys("1304");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }
    @Test
    public void negativeEmptyLoginTest() {
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }
    @Test
    public void positiveResetButtonLoginTest() {
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.xpath("//input[@name='btnReset']")).click();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }
    @Test
    public void negativeEmptyLoginAndPasswordTest() {
        driver.findElement(By.name("uid")).sendKeys("1304");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }
    @Test
    public void positiveSwitchToInsuranceProjectTest() {
        driver.findElement(By.xpath("//a[@href='http://demo.guru99.com/insurance/v1/index.php']")).click();
        assertEquals(driver.getCurrentUrl(), newUrl);
        driver.navigate().back();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }
    @Test
    public void positiveSwitchToBankProjectTest() {
        driver.findElement(By.xpath("//a[@href='http://demo.guru99.com/V1/index.php']")).click();
        assertEquals(driver.getCurrentUrl(), bankUrl);
        driver.navigate().back();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }
}
