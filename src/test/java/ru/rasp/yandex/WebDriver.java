package ru.rasp.yandex;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver {

    ChromeDriver driver = new ChromeDriver();

    @Before
    public void start() {
        driver.get("https://rasp.yandex.ru/");

        String Title = driver.getTitle();
        Assert.assertTrue(Title.equals("Расписание самолётов, поездов, электричек и автобусов"));

        System.out.println("test start");
        System.setProperty("webdriver.chrome.driver", "/Users/Art/IdeaProjects/Test_Task5/chromedriver.exe");
    }


    @After
    public void end() {
        //driver.quit();
        System.out.println("\n" + "test close");
    }
}
