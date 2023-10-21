import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {
    @Test
    public void firstTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testfasttrackit.info/magento-test/");
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("youtube");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[1]/button"));
        searchButton.click();
        WebElement searchResultTextElement = driver.findElement(By.className("note-msg"));
        String actualText = searchResultTextElement.getText();
        String expectedText = "Your search returns no results.";
        Assert.assertEquals(actualText, expectedText, "Search result text is not the expected one.");
        driver.quit();

    }
}
