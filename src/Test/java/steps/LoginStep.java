package steps;

import Base.BaseUtil;
import cucumber.api.DataTable;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;


import java.awt.*;

import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.concurrent.TimeUnit;


public class LoginStep extends BaseUtil {
    User u=new User();
    Random r = new java.util.Random ();
    String s = Long.toString (r.nextLong () & Long.MAX_VALUE, 36);

    Robot robot1 = new Robot();







    private BaseUtil base;
    WebElement element;


    public LoginStep(BaseUtil base) throws AWTException {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        base.driver.manage().window().maximize();





    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
       base.driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();


    }


    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {





        //WebDriverWait wait = new WebDriverWait(base.driver, 100);
        //element= wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("Login")));

      // base.driver.navigate().to("http://executeautomation.com/demosite/index.html?UserName="+u.username+"&Password="+u.password);
       // base.driver.navigate().to("http://127.0.0.1:8083/share/page/user/admin/dashboard");
        base.driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);



       // base.driver.findElement(By.id("global_x002e_header_x0023_default-searchText")).sendKeys("ghhj");
        //CaptureEcran(base.driver);

        //WebElement adminProcess = base.driver.findElement(By.className("title-link titleLink seeAll"));
        //HoverAndClick(base.driver,adminProcess);
       // base.driver.findElement(By.tagName("workflow-console")).click();

     //  base.driver.findElement(By.id("dashlet_documents_link")).click();



        base.driver.findElement(By.id("dashlet_admin_process_link")).click();
        base.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-newWorkflow-button-button")).click();
       // base.driver.manage().timeouts().pageLoadTimeout(250, TimeUnit.SECONDS);
        base.driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
       if( base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow-dialog")).isDisplayed()) {
           System.out.println("afficher");

           base.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
           base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_cm_name")).sendKeys(s);
           base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-itemGroupActions")).click();

           base.driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
           base.driver.findElement(By.id("alf-id5")).click();
           //base.driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[2]/tr[2]/td[3]/div[1]/a[1]/span[1]")).click();
           //
           base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-ok-button")).click();

           base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow-form-submit-button")).click();
           // base.driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
           Actions builder = new Actions(base.driver);
           Thread.sleep(5000);
           base.driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
           // builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300 , 300).click().build().perform();


           // base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-properties-form-form-tabview")).click();


          /* base.driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
           base.driver.findElement(By.xpath("//html//div[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-properties']//li[2]")).click();*/

           Robot bot = new Robot();

           int mask1 = InputEvent.BUTTON1_DOWN_MASK;
           bot.mouseMove(400, 400);
           bot.mousePress(mask1);
           bot.mouseRelease(mask1);

           Thread.sleep(1000);
           int mask = InputEvent.BUTTON1_DOWN_MASK;
           bot.mouseMove(1350, 600);
           bot.mousePress(mask);
           bot.mouseRelease(mask);

           Thread.sleep(1000);

           base.driver.findElement(By.xpath("//em[contains(text(),'Données')]")).click();
           Thread.sleep(1000);

           int mask2 = InputEvent.BUTTON1_DOWN_MASK;
           bot.mouseMove(1293, 520);
           bot.mousePress(mask2);
           bot.mouseRelease(mask2);
          base.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

         //  WebDriverWait some_element = new WebDriverWait(base.driver,100);
         //  some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-properties-form_prop_wdm_workflowVariables-cntrl-newVariable_prop_wdm_workflowVariableId']")));


            base.driver.findElement(By.xpath("//input[contains(@id,'-newVariable_prop_wdm_workflowVariableId')]")).sendKeys("nom");
            base.driver.findElement(By.name("prop_wdm_workflowVariableLabel")).sendKeys("nom");
            base.driver.findElement(By.name("prop_wdm_workflowVariableType")).sendKeys("Texte");
            base.driver.findElement(By.xpath("//button[contains(@id,'newVariable-form-submit-button')]")).click();

           Thread.sleep(1000);
           int mask3 = InputEvent.BUTTON1_DOWN_MASK;
           bot.mouseMove(1350, 300);
           bot.mousePress(mask3);
           bot.mouseRelease(mask3);

           //WebElement debut=base.driver.findElement(By.id("userTask"));

           base.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

           base.driver.findElement(By.id("startTask")).click();

           builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
           base.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
           base.driver.findElement(By.xpath("//em[contains(text(),'Designer de formulaire')]")).click();
          // base.driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
           base.driver.switchTo().frame(base.driver.findElement(By.xpath("//iframe[contains(@id,'-form-builder')]")));
            base.driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);


           WebElement dragFrom = base.driver.findElement(By.xpath("//span[contains(@title,'Text Field')]"));
           WebElement dragTo = base.driver.findElement(By.className("dropzone"));

           dragAndDropElement( dragFrom,  dragTo);


           Select dropdown = new Select(base.driver.findElement(By.id("key")));
           dropdown.getFirstSelectedOption();
           dropdown.selectByVisibleText("nom");

            base.driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

            base.driver.switchTo().defaultContent();
           base.driver.findElement(By.xpath("//button[contains(@id,'-button')]")).click();







           base.driver.findElement(By.id("serviceTask")).click();
           //base.driver.findElement(By.id("startTask")).click();
           builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
           base.driver.findElement(By.id("sequenceFlow")).click();
           builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200, 200).click().build().perform();
           base.driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

           builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

           base.driver.findElement(By.id("endEvent")).click();
           builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 400, 300).click().build().perform();
           base.driver.findElement(By.id("sequenceFlow")).click();


           builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

           builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 400, 300).click().build().perform();
           base.driver.findElement(By.id("select")).click();


           builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

           bot.mouseMove(1350, 600);
           bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(1000);
           base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

           base.driver.findElement(By.xpath("//a[@href='#tab_1']")).click();





           Select dropdown1 = new Select(base.driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
           dropdown1.getFirstSelectedOption();
           dropdown1.selectByVisibleText("Filigraner PDF");



           base.driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();






       }









    }


    @And("^I enter the following for login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

       /* System.out.println(data.get(0).get(0).toString());
        System.out.println(data.get(0).get(1).toString());*/
        List<User> users = new ArrayList<User>();
        //stockage des utilisateurs
        users = table.asList(User.class);

        for (User user : users) {
            //System.out.println( base.driver.findElement(By.name("Password")));

            //System.out.println("The password is"+ user.password);*/
           base.driver.findElement(By.name("username")).sendKeys(user.username);
          base.driver.findElement(By.name("password")).sendKeys(user.password);

        }


    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterPasswordAndUsername(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }




    public class User {
        public String username;
        public String password;

        public User(String UserName, String Password) {
            this.username = UserName;
            this.password = Password;
        }
        public User(){}

    }

    public static void CaptureEcran(WebDriver driver) throws IOException{
        File screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        org.openqa.selenium.io.FileHandler.copy(screenshot,new File("D:\\Screenshot.jpg"));



    }


    public static void dragAndDropElement(WebElement dragFrom, WebElement dragTo) throws Exception {

        Robot robot = new Robot();
        robot.setAutoDelay(500);
        // Get size of elements
        org.openqa.selenium.Dimension fromSize = dragFrom.getSize();
        org.openqa.selenium.Dimension toSize = dragTo.getSize();
        Point toLocation = dragTo.getLocation();
        Point fromLocation = dragFrom.getLocation();
        //Make Mouse coordinate centre of element
        toLocation.x += toSize.width/2;
       toLocation.y += 240 ;
        fromLocation.x += fromSize.width / 2;
        fromLocation.y += 235;

        //Move mouse to drag from location
        robot.mouseMove(fromLocation.x, fromLocation.y);
        //Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);

        //Drag events require more than one movement to register
        //Just appearing at destination doesn't work so move halfway first
        robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x , ((toLocation.y - fromLocation.y) / 2) + fromLocation.y);

        //Move to final position
        robot.mouseMove(toLocation.x, toLocation.y);
        //Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
}


}

