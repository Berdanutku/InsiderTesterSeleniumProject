package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPage {
    WebDriver driver;
    public CareersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "career-our-location")
    private WebElement locationsBlock;

    @FindBy(id = "career-find-our-calling")
    private WebElement teamsBlock;

    @FindBy(xpath = "//h2[text()='Life at Insider']")
    private WebElement lifeAtInsiderBlock;

    public boolean areCareersPageBlocksOpen(){
        return locationsBlock.isDisplayed() && teamsBlock.isDisplayed() && lifeAtInsiderBlock.isDisplayed();
    }


}
