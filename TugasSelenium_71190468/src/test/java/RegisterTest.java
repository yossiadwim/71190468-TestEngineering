import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisterTest {
    static ChromeDriver driver;
//    ChromeOptions options = new ChromeOptions();

    @Given("buka browser")
    public void buka_browser() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside step - buka browser");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader()
                        .getResource("webdriver/chromedriver.exe")).getFile());

//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @Given("user di halaman register")
    public void user_di_halaman_register() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside step - user berada di halaman register");
        driver.navigate().to("https://demo.guru99.com/insurance/v1/register.php");
    }
    @When("^user memasukkan (.*) (.*) (.*)$")
    public void user_memasukkan_firstname_email_password(String firstname,String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside step - masukkan firstname email dan password");
            driver.findElement(By.id("user_firstname")).sendKeys(firstname);
            driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys(email);
            driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys(password);
            driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys(password);

    }

    @When("ada tombol reset dan create")
    public void ada_tombol_reset_dan_create() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside step - ada button reset dan create");
        List listHasil = new ArrayList<>();

        List <WebElement> element = driver.findElements(By.tagName("input"));
        for(WebElement e : element) {
            if (e.getAttribute("value").equals("Reset") || e.getAttribute("value").equals("Create")) {
                listHasil.add(e.getText());
            }
        }
        Assertions.assertTrue(listHasil.size() > 1,"Button reset dan create tidak ditemukan");
    }

    @When("^username tidak kosong dan kata sandi valid (.*) (.*) (.*)$")
    public void username_tidak_kosong_dan_kata_sandi_valid(String username,String email, String password) {
        System.out.println("Inside step - Cek username dan kata sandi");
        try{
            Assertions.assertTrue(!username.equals("") && !email.equals("") && !password.equals("")
                    && password.matches("^[a-zA-Z0-9]*$")
                    && (password.length() >= 8 && password.length() <= 13),"Username atau Password Tidak Valid");
        }
        catch (Exception e){
            driver.quit();
        }

    }

    @Then("create button di klik")
    public void create_button_di_klik() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside step - klik tombol create");
        driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[5]/input[2]")).click();

    }
}


