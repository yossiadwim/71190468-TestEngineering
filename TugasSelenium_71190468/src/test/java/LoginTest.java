import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class LoginTest {

    static ChromeDriver driver;
//    ChromeOptions options = new ChromeOptions();
    @Given("browser opened")
    public void browser_opened() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside step - Buka Browser");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader()
                        .getResource("webdriver/chromedriver.exe")).getFile());

//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @Given("user in  register page")
    public void user_in_register_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside step - user ada di halaman register");
        driver.navigate().to("https://demo.guru99.com/insurance/v1/register.php");

    }
    @Given("menuju halaman login")
    public void menuju_halaman_login() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside step - menuju halaman login");
        driver.findElement(By.xpath("/html/body/div[3]/a")).click();
    }
    @When("^user insert email and password (.*) (.*)")
    public void user_insert_email_and_password(String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - insert username dan password");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);

    }
    @When("login button clicked")
    public void login_button_clicked() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/input")).click();
    }
    @Then("user redirect to main screen")
    public void user_redirect_to_main_screen() {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> btnLogout = driver.findElements(By.xpath("/html/body/div[3]/form/input"));
        Assertions.assertTrue(btnLogout.size() > 0,"Gagal Login");
    }
}
