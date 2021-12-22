import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DeyDamSignupTest {

    //import the DeyDam WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
        Thread.sleep(5000);
        //2. Input DeyDam Page URL (https://www.deydam.com/)
        driver.get("https://www.deydam.com/");
        //Test1. Verify the user inputs the right URL and is on the right Webpage
        if (driver.getCurrentUrl().contains("https://www.deydam.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //4. Click on Create new account button to open the sign up page
        //Test1. Verify that when the user clicks on the signup button, the user is directed to the signup page
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div[4]/a")).click();
        String expectedUrl = "https://www.deydam.com/signup?ref=null";
        String actualUrl = driver.getCurrentUrl();
         if (driver.getCurrentUrl().contains("https://www.deydam.com"))
        //Pass
                System.out.println("Correct Webpage");
              else
        //Fail
        System.out.println("Wrong webpage");
        Thread.sleep(5000);
           }

    @Test(priority = 0)
    public void negativeUsername() throws InterruptedException {
        //5. Input your username in the username field
        //Test2. Verify that user cannot sign up with username less than 4 characters
        driver.findElement(By.id("username")).sendKeys("Ay");
        Thread.sleep(5000);
        //6. Input email address in the email address field
        driver.findElement(By.id("email")).sendKeys("Ayoola@mailinator.com");
        Thread.sleep(5000);
        //7. Input password in password field
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Motunrayo");
        //8. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).sendKeys("Motunrayo");
        Thread.sleep(5000);
        //9. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @Test(priority = 1)
    public void negativeEmail() throws InterruptedException {
        //10. Input your username in the username field
        driver.findElement(By.id("username")).sendKeys("Ayoola");
        Thread.sleep(5000);
        driver.findElement(By.id("email")).clear();
        //11. Input email address in the email address field
        //Test3. Verify that user cannot sign up with invalid email address
        driver.findElement(By.id("email")).sendKeys("Ayoolamailinator.com");
        Thread.sleep(5000);
        //12. Input password in password field
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Motunrayo");
        //13. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("Motunrayo");
        Thread.sleep(5000);
        //14. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @Test(priority = 2)
    public void negativePassword() throws InterruptedException {
        //15. Input your username in the username field
        driver.findElement(By.id("username")).sendKeys("Ayoola");
        Thread.sleep(5000);
        //16. Input email address in the email address field
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("Ayoola@mailinator.com");
        Thread.sleep(5000);
        //17. Input password in password field
        //Test4. Verify that user cannot sign up with password less than 8 characters
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Motunrayo");
        //18. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("Motunrayo11");
        Thread.sleep(5000);
        //19. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @Test(priority = 3)
    public void negativeEmpty() throws InterruptedException {
        //20. Input your username in the username field
        driver.findElement(By.id("username")).sendKeys("Ayoola");
        Thread.sleep(5000);
        //21. Input email address in the email address field
        //Test5. Verify that user cannot sign up with any field blank
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("");
        Thread.sleep(5000);
        //22. Input password in password field
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Motunrayo");
        //23. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("Motunrayo");
        Thread.sleep(5000);
        //24. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @Test(priority = 4)
    public void positiveSignup() throws InterruptedException {
        //Test6. Verify that user is successfully signed up when valid details are used
        //25. Input your username in the username field
        driver.findElement(By.id("username")).sendKeys("Motunrayo904");
        Thread.sleep(5000);
        //26. Input email address in the email address field
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("Motunrayo904@mailinator.com");
        Thread.sleep(5000);
        //27. Input password in password field
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("passwords");
        //28. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("passwords");
        Thread.sleep(5000);
        //29. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @AfterTest
    public void closeBrowser() {
        //30. Quit the browser
        driver.quit();
    }
}
