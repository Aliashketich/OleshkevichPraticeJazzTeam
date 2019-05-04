import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class BSUIRTest {
    private WebDriver chromeDriver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @BeforeGroups("main page")
    public void mainPageTestsGroup() {
        chromeDriver.get("https://www.bsuir.by/");
    }

    @BeforeGroups("contact page")
    public void contactPageTestsGroup() {
        chromeDriver.get("https://www.bsuir.by/ru/kontaktnaya-informatsiya");
    }

    @AfterSuite
    public void closeChrome() {
        chromeDriver.quit();
    }

    @Test(groups = {"main page"})
    public void mainPageTitleIsCorrectTest() {
        String expectedTitle = "Белорусский государственный университет информатики и радиоэлектроники";
        assertEquals(expectedTitle, chromeDriver.getTitle());
    }

    @Test(groups = {"main page"})
    public void mainPageCopyrightIsCorrectTest() {
        String expectedTitle = "© ЦИИР БГУИР, 2002-2019";
        assertEquals(expectedTitle, chromeDriver.findElement(By.className("copyright")).getText());
    }

    @Test(groups = {"contact page"})
    public void contactPageHeaderHaveCorrectTextTest() {
        String expectedHeader = "Контактная информация";
        assertEquals(expectedHeader, chromeDriver.findElement(By.className("con2")).findElement(By.tagName("h1")).getText());
    }

    @Test
    public void contactPageLinkIsCorrectTest() {
        WebElement contactPageLinkButton = chromeDriver.findElement(By.className("top_menu")).findElement(By.id("m6"));
        contactPageLinkButton.click();
        String contactPageUrl = "https://www.bsuir.by/ru/kontaktnaya-informatsiya";
        assertEquals(contactPageUrl, chromeDriver.getCurrentUrl());
    }
}
