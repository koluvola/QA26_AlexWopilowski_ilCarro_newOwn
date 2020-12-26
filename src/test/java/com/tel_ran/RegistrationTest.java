package com.tel_ran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {

    WebDriver wd;

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void clickSubmit() {
        click(By.cssSelector("[type=\"submit\"]"));
    }

    public void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fillCheckBox() {
        click(By.id("check_policy"));
    }

    public void fillEmail() {
        String email = "Alex" + System.currentTimeMillis() + "@gmail.com";
        System.out.println("Email: " + email);
        type(By.xpath("//input[@id='email']"), email);
    }

    public void fillNameForm(String firstName) {
        type(By.cssSelector("#first_name"), firstName);
    }

    public void fillPassword() {
        String password = "A1234567";
        System.out.println("Password: " + password);
        type(By.id("password"), password);
    }

    public void fillSecondNameForm(String secondName) {
        type(By.cssSelector("#second_name"), secondName);
    }

    public boolean isRegistrationFormPresent() {
        return wd.findElements(By.xpath("//h2[contains(.,'Registration')]")).size() == 0;
    }

    public void openRegForm() {
        click(By.cssSelector("[href=\"/signup\"]"));
    }

    @BeforeMethod
    public void setUp() {
        wd = new FirefoxDriver();
        //wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        //new Method for Web  Driver
        wd.navigate().to("https://ilcarro-dev-v1.firebaseapp.com/");


    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        //Method "close" close one site page
        //wd.close();
        //Method "quit" close browser
        wd.quit();


    }

    @Test
    public void testRegistration() {
        //open reg form
        openRegForm();
        // wd.findElement(By.cssSelector("[href=\"/signup\"]")).click();


        //wd.findElement(By.cssSelector("[href=\"/car\"]")).click();
        //wd.findElement(By.name("address")).click();

        //fill registration
        //fill first name field
        //looking element By cssSelector
        //wd.findElement(By.id("first_name")).click();
        //wd.findElement(By.cssSelector("#first_name")).click();
        // click(By.cssSelector("#first_name"));
        // wd.findElement(By.id("first_name")).clear();
        // wd.findElement(By.cssSelector("#first_name")).clear();
        //wd.findElement(By.id("first_name")).sendKeys("Alex");
        // wd.findElement(By.cssSelector("#first_name")).sendKeys("Alex");
        fillNameForm("Alex");

        //fill last name field
        //looking element By cssSelector
        //wd.findElement(By.id("second_name")).click();
        // wd.findElement(By.cssSelector("#second_name")).click();
        // click(By.cssSelector("#second_name"));
        //wd.findElement(By.id("second_name")).clear();
        // wd.findElement(By.cssSelector("#second_name")).clear();
        //wd.findElement(By.id("second_name")).sendKeys("Wopilowski");
        // wd.findElement(By.cssSelector("#second_name")).sendKeys("Wopilowski");
        fillSecondNameForm("Wopilowski");

        //fill email field
        //Looking element by xPath
        //wd.findElement(By.id("email")).click();
        fillEmail();
        //wd.findElement(By.xpath("//input[@id='email']")).click();
        // click(By.xpath("//input[@id='email']"));
        // wd.findElement(By.id("email")).clear();
        //wd.findElement(By.id("email")).sendKeys(email);


        //fill password field
        fillPassword();
        //wd.findElement(By.id("password")).click();
        //click(By.id("password"));
        //wd.findElement(By.id("password")).clear();
        // wd.findElement(By.id("password")).sendKeys(password);

        //wd.findElement(By.name("address")).click();

        //select check box

        /*WebElement we = wd.findElement(By.id("check_policy"));
        we.click();*/
        fillCheckBox();
        //delay 10 sek
        delay(1000);

        //click Yalla button
        //WebElement wb = wd.findElement(By.className("yalla_yalla__1Jxk6"));
        //WebElement wb = wd.findElement(By.cssSelector("[type=\"submit\"]"));
        //wb.click();
        // wd.findElement(By.cssSelector("[type=\"submit\"]")).click();
        clickSubmit();

        //delay 5 sek
        delay(5000);

        Assert.assertFalse(isRegistrationFormPresent());

        //delay 2 sek
        delay(2000);


    }

    public void type(By lokator, String str) {
        click(lokator);
        wd.findElement(lokator).clear();
        wd.findElement(lokator).sendKeys(str);

    }

}
