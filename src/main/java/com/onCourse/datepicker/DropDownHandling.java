package com.onCourse.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class DropDownHandling {

    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver (Ensure chromedriver is in your PATH)
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // --- SCENARIO 1: STATIC SELECT DROPDOWN ---
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));

            Select select = new Select(staticDropdown);
            select.selectByVisibleText("Option2");
            System.out.println("Static Dropdown Selected: " + select.getFirstSelectedOption().getText());

            // --- SCENARIO 2: AUTO-SUGGESTIVE DYNAMIC DROPDOWN ---
            WebElement autoSuggestInput = driver.findElement(By.id("autocomplete"));
            autoSuggestInput.sendKeys("unit");

            // Wait for list items to be present
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".ui-menu-item div")));

            List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item div"));
            for (WebElement option : options) {
                if (option.getText().equalsIgnoreCase("United Kingdom (UK)")) {
                    option.click();
                    break;
                }
            }
            System.out.println("Auto-suggest option selected.");

            // --- SCENARIO 3: CLICK-TO-LOAD DYNAMIC DROPDOWN ---
            // Example: Clicking a menu that triggers a dynamic overlay
            driver.get("https://www.spicejet.com/"); // Popular site for dynamic dropdown practice

            // Click the 'From' destination trigger
            WebElement fromCity = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@data-testid='to-test-id-origin']")));
            fromCity.click();

            // Select a city from the dynamic list that appears
            WebElement citySelection = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(text(),'Bengaluru')]")));
            citySelection.click();
            System.out.println("Dynamic City Selected.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000); // Only to see the result before closing
            driver.quit();
        }
    }
}