package com.onCourse.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DatePickerDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        driver.switchTo().frame(0);

        // Use date picker
        String year = "2026";
        String month = "April";
        String date = "18";


        // first get month and year and then get Date

        // Open calendar
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        // select month and year
        while(true){

            String currMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (currMonth.equals(month) && currYear.equals(year)){
                break;
            }
            // click on next month button - we can do same for previous date, just change month and year variables
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }













    }

}
