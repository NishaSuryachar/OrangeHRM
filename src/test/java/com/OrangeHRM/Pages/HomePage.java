package com.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    @FindBy(xpath = "//span[text()='Time']")
    private WebElement timeEdt;

    @FindBy(xpath = "//span[contains(.,'Project Info')]")
    private WebElement projectInfoEdt;

    @FindBy(xpath = "//a[text()='Customers']")
    private WebElement customersEdt;

    @FindBy(xpath = "//a[text()='Projects']")
    private WebElement projectsEdt;

   public HomePage(WebDriver driver)
   {
       PageFactory.initElements(driver, this);
   }

    public WebElement getTimeEdt() {
        return timeEdt;
    }

    public void setTimeEdt(WebElement timeEdt) {
        this.timeEdt = timeEdt;
    }

    public WebElement getProjectInfoEdt() {
        return projectInfoEdt;
    }

    public void setProjectInfoEdt(WebElement projectInfoEdt) {
        this.projectInfoEdt = projectInfoEdt;
    }

    public WebElement getCustomersEdt() {
        return customersEdt;
    }

    public void setCustomersEdt(WebElement customersEdt) {
        this.customersEdt = customersEdt;
    }

    public WebElement getProjectsEdt() {
        return projectsEdt;
    }

    public void setProjectsEdt(WebElement projectsEdt) {
        this.projectsEdt = projectsEdt;
    }

    public void Homepage()
    {
        getTimeEdt().click();
        getProjectInfoEdt().click();
        getCustomersEdt().click();
    }

    public void Homepage1()
    {
        getTimeEdt().click();
        getProjectInfoEdt().click();
        getProjectsEdt().click();
    }

}
