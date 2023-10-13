import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;





public class TextBoxTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\AutoTest\\chromedriver-win64\\chromedriver.exe");
        // Создание экземпляра драйвера Chrome
        driver = new ChromeDriver();
        // Максимизация окна браузера
        driver.manage().window().maximize();
    }

    @Test
    public void textBoxTest() {
        // Шаг 1: Перейти на сайт "https://demoqa.com/"
        driver.get("https://demoqa.com/");

        // Шаг 2: Нажать на блок "Elements"
        WebElement elementsBlock = driver.findElement(By.xpath("//div[@class='category-cards']//div[text()='Elements']"));
        elementsBlock.click();

        // Шаг 3: Выбрать в списке "Elements" поле "Text Box"
        WebElement textBoxOption = driver.findElement(By.xpath("//div[@class='element-group']//div[text()='Text Box']"));
        textBoxOption.click();

        // Шаг 4: Заполнить все 4 поля любыми значениями
        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys("John Doe");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("johndoe@example.com");

        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        currentAddressInput.sendKeys("123 Main Street");

        WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));
        permanentAddressInput.sendKeys("456 Oak Avenue");

        // Шаг 5: Нажать на кнопку "Submit"
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Шаг 6: Проверить, что вывелись правильные данные
        WebElement nameOutput = driver.findElement(By.id("name"));
        Assert.assertEquals(nameOutput.getText(), "Name:John Doe");

        WebElement emailOutput = driver.findElement(By.id("email"));
        Assert.assertEquals(emailOutput.getText(), "Email:johndoe@example.com");

        WebElement currentAddressOutput = driver.findElement(By.cssSelector("#output div:nth-child(3)"));
        Assert.assertEquals(currentAddressOutput.getText(), "Current Address :123 Main Street");

        WebElement permanentAddressOutput = driver.findElement(By.cssSelector("#output div:nth-child(4)"));
        Assert.assertEquals(permanentAddressOutput.getText(), "Permananet Address :456 Oak Avenue");
    }

    @AfterClass
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }
}
