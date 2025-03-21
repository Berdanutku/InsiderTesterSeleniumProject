package org.example;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class InsiderSeleniumTest {

    WebDriver driver;
    HomePage homePage;
    CareersPage careersPage;
    QualityAssurancePage qualityAssurancePage;
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        careersPage = new CareersPage(driver);
        qualityAssurancePage = new QualityAssurancePage(driver);
        driver.manage().window().maximize();
        driver.get("https://useinsider.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieAcceptAllBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("wt-cli-accept-all-btn")));
        cookieAcceptAllBtn.click();
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void testIsHomePageOpened() {
        Assert.isTrue(homePage.isHomePageOpened(), "Home page is not opened");
    }
    @Test
    public void testAreBlocksOpenedInCareersPage() {
        homePage.goToCareers();
        Assert.isTrue(careersPage.areCareersPageBlocksOpen(), "Careers page is not opened");
    }
    @Test
    public void testIsJobListOpenedInOpenPositionsPage() throws InterruptedException {
        qualityAssurancePage.goToQualityAssurancePage();
        Assert.isTrue(qualityAssurancePage.checkJobList(), "Job list is not opened");
    }
    @Test
    public void testAreJobPositionsInformationsCorrect() throws InterruptedException {
        qualityAssurancePage.goToQualityAssurancePage();
        Assert.isTrue(qualityAssurancePage.checkJobPosition(), "There is an error in job position information");
    }
    @Test
    public void testIsViewRoleButtonRedirectsToLeverApplicationFormPage() throws InterruptedException {
        qualityAssurancePage.goToQualityAssurancePage();
        Assert.isTrue(qualityAssurancePage.checkViewRoleButton(), "Lever application form page is not opened");
    }
}