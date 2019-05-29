package ru.rasp.yandex;

import org.junit.Test;
import org.openqa.selenium.By;

public class UITest extends WebDriver {

    @Test
    public void uiTest1() {
        driver.findElement(By.id("from")).clear();
        driver.findElement(By.id("from")).sendKeys("Кемерово");
        driver.findElement(By.id("to")).clear();
        driver.findElement(By.id("to")).sendKeys("Москва");
        driver.findElement(By.id("when")).clear();
        driver.findElement(By.id("when")).sendKeys("7 июля");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    }

    @Test
    public void uiTest2() {
        driver.findElement(By.cssSelector("span[data-reactid=\"39\"]")).click();
        driver.findElement(By.id("from")).clear();
        driver.findElement(By.id("from")).sendKeys("Кемерово проспект Ленина");
        driver.findElement(By.id("to")).clear();
        driver.findElement(By.id("to")).sendKeys("Кемерово Бакинский переулок");
        driver.findElement(By.id("when")).clear();
        driver.findElement(By.id("when")).sendKeys("29 июля");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    }
}