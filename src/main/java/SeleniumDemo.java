import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumDemo {


    @Test
    public void navigateToVk() {



     System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        vkLogin(driver);

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement aVechornychka = driver.findElement(By.xpath("//*[contains(text(),'Андріївська')]"));
        aVechornychka.click();

        WebElement inviteFriends = driver.findElement(By.xpath("//*[contains(text(), 'Запросити друзів')]"));
        inviteFriends.click();

        WebElement inviteGroup = driver.findElement(By.xpath("//*[contains(text(), 'Запросити учасників групи')]"));
        inviteGroup.click();



        JavascriptExecutor jse = (JavascriptExecutor) driver;
        


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

for (int count =0; count<18; count++) {
    List<WebElement> elements = driver.findElements(By.xpath("//button[contains(text(), 'Надіслати запрошення')]"));
    for (WebElement element : elements) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("NIAVKA" + ((RemoteWebElement) element).getId());
        try {
            element.click();
        } catch (Throwable n) {
            System.out.println("SKIPPED" + ((RemoteWebElement) element).getId());
        }


        jse.executeScript("scroll(0, 3000);");

    }
}

    }

    private void vkLogin(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("http://www.vk.com");

        WebElement loginField = driver.findElement(By.id("index_email"));
        loginField.clear();
        loginField.sendKeys("+38050 4457128");

        WebElement passField = driver.findElement(By.id("index_pass"));
        passField.clear();
        passField.sendKeys("VechornytsiAAA");

        WebElement loginBtn = driver.findElement(By.id("index_login_button"));
        loginBtn.click();


    }


}
