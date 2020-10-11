import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class GoogleSearch extends BaseUiTests {
    String url = "https://google.com/ncr";
    String findUrl = "stylus.ua";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }

    @Test
    public void positivEnterSearchTest() {
        driver.findElement(By.name("q")).sendKeys("iphone kyiv buy" + Keys.ENTER);
        int y = 0;
        for (int i = 1; i < 5; i++) {
            if (y == 0) {
                List<WebElement> elements = driver.findElements(By.cssSelector("div.g"));
                for (WebElement element : elements) {
                    if (element.getText().contains(findUrl)) {
                        System.out.println("STYLUS.UA has been found on page " + i);
                        y++;
                    }
                }
            } else {
                break;
            }
            if (y == 0) {
                driver.findElement(By.id("pnnext")).click();
            }
        }
        if (y == 0) {
            System.out.println("STYLUS.UA not found on first 5 pages");
        }
    }
}

//
//
//
//        try {
//            List<WebElement> elements = driver.findElements(By.tagName("cite"));
//            for (WebElement element : elements) {
//                System.out.println(element.getText());
//            }
//        } finally {
////            WebElement stats = wait.until(presenceOfElementLocated(By.name("#text")));
////            assertTrue(stats.getText().contains(findUrl));
//
//            driver.findElement(By.xpath("//span[@style='display:block;margin-left:53px']")).click();
//            try {
//                List<WebElement> elements = driver.findElements(By.tagName("cite"));
//                for (WebElement element : elements) {
//                    System.out.println(element.getText());
//                }
//            } finally {
//                WebElement stats = wait.until(presenceOfElementLocated(By.name("stylus.ua")));
//                assertTrue(stats.getText().contains(findUrl));
//                if (elements == )
//
////                System.out.println("STYLUS.UA found on 2 page");
//
//
//            }
//
//        }
//
//    }

