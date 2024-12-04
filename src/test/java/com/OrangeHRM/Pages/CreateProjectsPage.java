package com.OrangeHRM.Pages;

import com.OrangeHRM.Util.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Random;

public class CreateProjectsPage
{
    @FindBy(xpath = "//a[text()='Projects']")
    private WebElement projectsEdt;

    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement AddEdt;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement projectNameEdt;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    private WebElement AddCustomertxtFieldEdt;

    @FindBy(xpath = "//textarea[@placeholder='Type description here']")
    private WebElement descEdt;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[2]")
    private WebElement addProjectAdminFieldEdt;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBtnEdt;

    @FindBy(xpath = " //button[contains(.,' Add Customer ')]")
    private WebElement addCustomerBtnEdt;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    private WebElement custNamePopupEdt;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement saveBtnEdt2;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-option']")
    private WebElement proAdmin1Edt;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-option']")
    private WebElement cust2Edt;

    public CreateProjectsPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public WebElement getProjectsEdt() {
        return projectsEdt;
    }

    public WebElement getCust2Edt() {
        return cust2Edt;
    }

    public void setCust2Edt(WebElement cust2Edt) {
        this.cust2Edt = cust2Edt;
    }

    public void setProjectsEdt(WebElement projectsEdt) {
        this.projectsEdt = projectsEdt;
    }

    public WebElement getAddEdt() {
        return AddEdt;
    }

    public WebElement getProAdmin1Edt() {
        return proAdmin1Edt;
    }

    public void setProAdmin1Edt(WebElement proAdmin1Edt) {
        this.proAdmin1Edt = proAdmin1Edt;
    }

    public void setAddEdt(WebElement addEdt) {
        AddEdt = addEdt;
    }

    public WebElement getProjectNameEdt() {
        return projectNameEdt;
    }

    public void setProjectNameEdt(WebElement projectNameEdt) {
        this.projectNameEdt = projectNameEdt;
    }

    public WebElement getAddCustomertxtFieldEdt() {
        return AddCustomertxtFieldEdt;
    }

    public void setAddCustomertxtFieldEdt(WebElement addCustomertxtFieldEdt) {
        AddCustomertxtFieldEdt = addCustomertxtFieldEdt;
    }

    public WebElement getDescEdt() {
        return descEdt;
    }

    public void setDescEdt(WebElement descEdt) {
        this.descEdt = descEdt;
    }

    public WebElement getAddProjectAdminFieldEdt() {
        return addProjectAdminFieldEdt;
    }

    public void setAddProjectAdminFieldEdt(WebElement addProjectAdminFieldEdt) {
        this.addProjectAdminFieldEdt = addProjectAdminFieldEdt;
    }

    public WebElement getSaveBtnEdt2() {
        return saveBtnEdt2;
    }

    public void setSaveBtnEdt2(WebElement saveBtnEdt2) {
        this.saveBtnEdt2 = saveBtnEdt2;
    }

    public WebElement getSaveBtnEdt() {
        return saveBtnEdt;
    }

    public void setSaveBtnEdt(WebElement saveBtnEdt) {
        this.saveBtnEdt = saveBtnEdt;
    }

    public WebElement getAddCustomerBtnEdt() {
        return addCustomerBtnEdt;
    }

    public void setAddCustomerBtnEdt(WebElement addCustomerBtnEdt) {
        this.addCustomerBtnEdt = addCustomerBtnEdt;
    }

    public WebElement getCustNamePopupEdt() {
        return custNamePopupEdt;
    }

    public void setCustNamePopupEdt(WebElement custNamePopupEdt) {
        this.custNamePopupEdt = custNamePopupEdt;
    }

    public void addProjects(String projectName, String custName, String desc, String projectAdmin) throws InterruptedException {
        Random r=new Random();
        int ranInt = r.nextInt(5000);
        getAddEdt().click();
        getProjectNameEdt().sendKeys(projectName+ranInt);
        getAddCustomertxtFieldEdt().sendKeys(custName);
        Thread.sleep(2000);
        getCust2Edt().click();
        getDescEdt().sendKeys(desc);
        getAddProjectAdminFieldEdt().sendKeys(projectAdmin);
        Thread.sleep(2000);
        getProAdmin1Edt().click();
        getSaveBtnEdt().click();
    }
    public void addProjects1(WebDriver driver,String projectName,String desc,String projectAdmin) throws IOException, InterruptedException {
        ExcelUtility eutil=new ExcelUtility();
        String CustName=eutil.getDataFromExcel("sheet1",7,3);
        Random r=new Random();
        int ranInt = r.nextInt(5000);
        getAddEdt().click();
        getProjectNameEdt().sendKeys(projectName);
        getAddCustomerBtnEdt().click();
        custNamePopupEdt.sendKeys(CustName+ranInt);
        saveBtnEdt2.click();
        getDescEdt().sendKeys(desc);
        getAddProjectAdminFieldEdt().sendKeys(projectAdmin);
        Thread.sleep(2000);
        getProAdmin1Edt().click();
        getSaveBtnEdt().click();
    }
}
