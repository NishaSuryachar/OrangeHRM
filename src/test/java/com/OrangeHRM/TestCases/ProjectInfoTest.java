package com.OrangeHRM.TestCases;

import com.OrangeHRM.Pages.CreateCustomersPage;
import com.OrangeHRM.Pages.CreateProjectsPage;
import com.OrangeHRM.Pages.HomePage;
import com.OrangeHRM.Pages.LoginPage;
import com.OrangeHRM.Util.ExcelUtility;
import com.OrangeHRM.base.BaseClass;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class ProjectInfoTest extends BaseClass
{
    @Test
    public void createCustomer() throws IOException
    {
        ExcelUtility eutil=new ExcelUtility();
        Random r=new Random();
        int ranInt=r.nextInt(5000);
       String NAME=eutil.getDataFromExcel("Sheet1",1,2);
       String DES=eutil.getDataFromExcel("Sheet1",1,3);
       HomePage hp=new HomePage(driver);
       hp.Homepage();
       CreateCustomersPage cc=new CreateCustomersPage(driver);
       cc.getAddBtnEdt().click();
       cc.creatingCustomer(NAME+ranInt,DES);
    }

    @Test
    public void createProjects() throws IOException, InterruptedException {
        ExcelUtility eutil=new ExcelUtility();
        String PROJECTNAME=eutil.getDataFromExcel("Sheet1",4,2);
        String CUSTNAME=eutil.getDataFromExcel("Sheet1",4,3);
        String DESC=eutil.getDataFromExcel("Sheet1",1,3);
        String PROADMIN=eutil.getDataFromExcel("Sheet1",4,4);
        HomePage hp = new HomePage(driver);
        hp.Homepage1();
        CreateProjectsPage cp=new CreateProjectsPage(driver);
        cp.addProjects(PROJECTNAME,CUSTNAME,DESC,PROADMIN);
    }

    @Test
    public void createProjectsWithNewCustomer() throws IOException, InterruptedException {
        ExcelUtility eutil=new ExcelUtility();
        String PROJECTNAME=eutil.getDataFromExcel("Sheet1",7,2);
        String DESC=eutil.getDataFromExcel("Sheet1",7,4);
        String PROADMIN=eutil.getDataFromExcel("Sheet1",7,5);
        HomePage hp = new HomePage(driver);
        hp.Homepage1();
        CreateProjectsPage cp=new CreateProjectsPage(driver);
        cp.addProjects1(driver,PROJECTNAME,DESC,PROADMIN);
    }

    @Test
    public void Test() throws IOException, InterruptedException {
       System.out.println("Hello");
    }



}
