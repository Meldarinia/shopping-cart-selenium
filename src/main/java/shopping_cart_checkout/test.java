package shopping_cart_checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Gaga\\Desktop\\chrome driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.xpath("//input[@data-test='password']"));
        WebElement login = driver.findElement(By.cssSelector("#login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();

        WebElement addToCart = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
        addToCart.click();

        WebElement cartIcon = driver.findElement(By.cssSelector("#shopping_cart_container > a"));
        cartIcon.click();

        WebElement checkOut = driver.findElement(By.cssSelector("#checkout"));
        checkOut.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@data-test='firstName']"));
        firstName.sendKeys("Jane");
        WebElement lastName = driver.findElement(By.xpath("//input[@data-test='lastName']"));
        lastName.sendKeys("Doe");
        WebElement postalCode = driver.findElement(By.xpath("//input[@data-test='postalCode']"));
        postalCode.sendKeys("90013");

        WebElement continueButton = driver.findElement(By.xpath("//input[@data-test='continue']"));
        continueButton.click();


        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();


        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-complete.html")){
            System.out.println("Test passed! The order is complete successfully.");
        } else {
            System.out.println("Test failed. The order did not complete successfully.");
        }

        driver.close();
    }
}

