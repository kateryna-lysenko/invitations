import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumDemo {


    @Test
    public void navigateToVk() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        vkLogin(driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement aVechornychka = driver.findElement(By.xpath("//*[contains(text(),'Андріївська')]"));
        aVechornychka.click();

        WebElement inviteFriends = driver.findElement(By.xpath("//*[contains(text(), 'Запросити друзів')]"));
        inviteFriends.click();

        WebElement inviteGroup = driver.findElement(By.xpath("//*[contains(text(), 'Запросити учасників групи')]"));
        inviteGroup.click();

        List<WebElement> elements = driver.findElements(By.xpath("//button[contains(text(), 'Надіслати запрошення')]"));
        for (WebElement element : elements) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            System.out.println("NIAVKA" + ((RemoteWebElement) element).getId());
            element.click();
        }
    }

    private void vkLogin(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("http://www.vk.com");

        WebElement loginField = driver.findElement(By.id("index_email"));
        loginField.clear();
        loginField.sendKeys("rishenka@ukr.net");

        WebElement passField = driver.findElement(By.id("index_pass"));
        passField.clear();
        passField.sendKeys("otVinta1995");

        WebElement loginBtn = driver.findElement(By.id("index_login_button"));
        loginBtn.click();


    }


}
