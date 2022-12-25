import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class Login_Test {
    private WebDriver driver;
    private LoginPage loginPage;
    private String email;
    private String password;

    @BeforeTest
    @Before
    @Parameters({"email", "password"})
    public void setUp() {
        // Set up Chrome driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        this.email = email;
        this.password = password;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Given("^the user is on the login page$")
    public void the_user_is_on_the_login_page() throws Throwable {
        driver.get("https://demowebshop.tricentis.com/login");
    }

    @When("^the user enters a valid email and password$")
    public void the_user_enters_a_valid_email_and_password() throws Throwable {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("^clicks the login button$")
    public void clicks_the_login_button() throws Throwable {
        loginPage.clickLoginButton();
    }

    @Then("^the user should be redirected to the home page$")
    public void the_user_should_be_redirected_to_the_home_page() throws Throwable {
        String expectedUrl = "https://demowebshop.tricentis.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

//    @When("^the user enters an invalid email and password$")
//    public void the_user_enters_an_invalid_email_and_password() throws Throwable {
//        loginPage.enterEmail("invalid@example.com");
//        loginPage.enterPassword("invalidpassword");
//    }
//
//    @Then("^the user should see an error message$")
//    public void the_user_should_see_an_error_message() throws Throwable {
//        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.";
//        String actualErrorMessage = loginPage.getErrorMessage();
//        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
//    }
}
