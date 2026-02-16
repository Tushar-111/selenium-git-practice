package com.onCourse.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

public class AlertDropdownTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/alerts");

        Thread.sleep(2000);

        driver.findElement(By.id("alertButton")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        driver.quit();
    }
}
