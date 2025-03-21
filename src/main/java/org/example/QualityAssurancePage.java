package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class QualityAssurancePage {
    WebDriver driver;
    Actions actions;

    public QualityAssurancePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "See all QA jobs")
    private WebElement seeAllQAJobsButton;
    @FindBy(id = "select2-filter-by-location-container")
    private WebElement locationFilter;
    @FindBy(id = "select2-filter-by-department-container")
    private WebElement departmentFilter;
    @FindBy(xpath = "//li[text()='Istanbul, Turkiye']")
    private WebElement istanbulOption;
    @FindBy(xpath = "//li[text()='Quality Assurance']")
    private WebElement qualityAssuranceOption;
    @FindBy(id = "career-position-list")
    private List<WebElement> jobList;
    @FindBy(css = ".position-title")
    private WebElement jobPosition;
    @FindBy(css = ".position-department")
    private WebElement jobDepartment;
    @FindBy(css = ".position-location")
    private WebElement jobLocation;
    @FindBy(linkText = "View Role")
    private WebElement viewRoleButton;


    public void goToQualityAssurancePage() {
        driver.get("https://useinsider.com/careers/quality-assurance/");
    }

    public boolean checkJobList() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement seeAllQAJobsBtn = wait.until(ExpectedConditions.elementToBeClickable(seeAllQAJobsButton));
        seeAllQAJobsBtn.click();

        Thread.sleep(15000);

        WebElement locationFilterBtn = wait.until(ExpectedConditions.elementToBeClickable(locationFilter));
        locationFilterBtn.click();

        WebElement istanbulOptionBtn = wait.until(ExpectedConditions.elementToBeClickable(istanbulOption));
        istanbulOptionBtn.click();

        WebElement departmentFilterBtn = wait.until(ExpectedConditions.elementToBeClickable(departmentFilter));
        departmentFilterBtn.click();

        WebElement qualityAssuranceOptionBtn = wait.until(ExpectedConditions.elementToBeClickable(qualityAssuranceOption));
        qualityAssuranceOptionBtn.click();

        return jobList.stream().allMatch(WebElement::isDisplayed);
    }


    public boolean checkJobPosition() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement seeAllQAJobsBtn = wait.until(ExpectedConditions.elementToBeClickable(seeAllQAJobsButton));
        seeAllQAJobsBtn.click();

        Thread.sleep(15000);

        WebElement locationFilterBtn = wait.until(ExpectedConditions.elementToBeClickable(locationFilter));
        locationFilterBtn.click();

        WebElement istanbulOptionBtn = wait.until(ExpectedConditions.elementToBeClickable(istanbulOption));
        istanbulOptionBtn.click();

        WebElement departmentFilterBtn = wait.until(ExpectedConditions.elementToBeClickable(departmentFilter));
        departmentFilterBtn.click();

        WebElement qualityAssuranceOptionBtn = wait.until(ExpectedConditions.elementToBeClickable(qualityAssuranceOption));
        qualityAssuranceOptionBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(jobList));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            js.executeScript("window.scrollBy(0, 400);");
            Thread.sleep(1000);
        }

            WebElement jobPositionElement = wait.until(ExpectedConditions.visibilityOf(jobPosition));
            WebElement jobDepartmentElement = wait.until(ExpectedConditions.visibilityOf(jobDepartment));
            WebElement jobLocationElement = wait.until(ExpectedConditions.visibilityOf(jobLocation));

            String jobPositionText = jobPositionElement.getText();
            String jobDepartmentText = jobDepartmentElement.getText();
            String jobLocationText = jobLocationElement.getText();

            if (!jobPositionText.equals("Quality Assurance")
                    && !jobDepartmentText.equals("Quality Assurance")
                    && !jobLocationText.equals("Istanbul, Turkey")) {
                return false;
            }

        return true;
    }

    public boolean checkViewRoleButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement seeAllQAJobsBtn = wait.until(ExpectedConditions.elementToBeClickable(seeAllQAJobsButton));
        seeAllQAJobsBtn.click();

        Thread.sleep(15000);

        WebElement locationFilterBtn = wait.until(ExpectedConditions.elementToBeClickable(locationFilter));
        locationFilterBtn.click();

        WebElement istanbulOptionBtn = wait.until(ExpectedConditions.elementToBeClickable(istanbulOption));
        istanbulOptionBtn.click();

        WebElement departmentFilterBtn = wait.until(ExpectedConditions.elementToBeClickable(departmentFilter));
        departmentFilterBtn.click();

        WebElement qualityAssuranceOptionBtn = wait.until(ExpectedConditions.elementToBeClickable(qualityAssuranceOption));
        qualityAssuranceOptionBtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(jobList));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            js.executeScript("window.scrollBy(0, 400);");
            Thread.sleep(1000);
        }
        actions.moveToElement(jobList.get(0)).perform();
        actions.moveToElement(jobList.get(0)).click().perform();

        Thread.sleep(1000);
        WebElement viewRoleBtn = wait.until(ExpectedConditions.visibilityOf(viewRoleButton));
        viewRoleBtn.click();

        driver.get(viewRoleButton.getAttribute("href"));
        Set<String> windows = driver.getWindowHandles();

        if (windows.size() > 1) {
            return true;
        }
        return false;
    }

}
