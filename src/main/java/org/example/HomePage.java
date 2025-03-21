package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    WebDriver driver;
    Actions actions;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Company")
    private WebElement companyMenu;
    @FindBy(linkText = "Careers")
    private WebElement CareersMenu;

    public boolean isHomePageOpened(){
        return driver.getTitle().equals("#1 Leader in Individualized, Cross-Channel CX — Insider");
    }

    public void goToCareers() {
        actions.moveToElement(companyMenu).perform();
        CareersMenu.click();
    }
}
