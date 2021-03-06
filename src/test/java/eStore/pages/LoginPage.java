package eStore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;

    private By usernameBy = By.id("username");
    private By passwordBy = By.id("password");
    private By signInBy = By.xpath("//input[@value=\'Submit\']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        driver.get("http://localhost:8080/eStore/login/");
    }

    /**
     * Login as valid user
     *
     * @param userName
     * @param password
     * @return HomePage object
     */
    public void login(String userName, String password){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(usernameBy))
                .sendKeys(userName);

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(passwordBy))
                .sendKeys(password);

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(signInBy))
                .click();
    }

    public boolean isLoggedIn() {
        WebElement element =  new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'  Logout')]")));

        return element != null;
    }

    public boolean isInLoginPage() {
        WebElement element =  new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".login-container")));

        return element != null;
    }
}
