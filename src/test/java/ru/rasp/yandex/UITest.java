package ru.rasp.yandex;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("https://rasp.yandex.ru/search/?fromName="));
        String NextURL = driver.getCurrentUrl();
        driver.get(NextURL);

        for (WebElement Element : driver.findElementsByClassName("TransportIcon__icon")) {
            Assert.assertNotNull(driver.findElement(By.className("TransportIcon__icon")));
        }
        for (WebElement Element : driver.findElementsByClassName("SegmentTitle__title")) {
            Assert.assertNotNull(driver.findElement(By.className("SegmentTitle__title")));
        }
        for (WebElement Element : driver.findElementsByClassName("SearchSegment__duration")) {
            Assert.assertNotNull(driver.findElement(By.className("SearchSegment__duration")));
        }
        int i = driver.findElementsByClassName("SearchSegment_isVisible").size();
        Assert.assertEquals(3, i);
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

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("Яндекс.Расписания"));
        String NextURL = driver.getCurrentUrl();
        driver.get(NextURL);

        String TextError = driver.findElement(By.cssSelector("div[data-reactid=\"112\"]")).getText();
        Assert.assertTrue(TextError.equals("Пункт прибытия не найден. Проверьте правильность написания или выберите другой город."));
        System.out.println("Error: " + TextError);
    }
}