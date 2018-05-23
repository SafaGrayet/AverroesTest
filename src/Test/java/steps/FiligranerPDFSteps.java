package steps;

import Base.BaseUtil;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

public class FiligranerPDFSteps extends BaseUtil {
    private BaseUtil base;
    Robot bot = new Robot();



    public FiligranerPDFSteps(BaseUtil base) throws AWTException {
        this.base = base;
    }
    @Before
    public void InitializeTest() {
        System.out.println("opening the browser");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\PC-ASUS\\Downloads\\Compressed\\chromedriver.exe");

        base.driver=new ChromeDriver();
        // base.driver.manage().window().maximize();
        base.driver.navigate().to("http://127.0.0.1:8099/share/page/");
        base.driver.manage().window().maximize();




        //System.out.println("The password is"+ user.password);*/
        base.driver.findElement(By.name("username")).sendKeys("admin");
        base.driver.findElement(By.name("password")).sendKeys("Safa1994");

        base.driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();
        //boutton.loginbtn.click();


    }



    @Given("^je connecte à Averroès en tant que admin$")
    public void jeConnecteAAverroesEnTantQueAdmin() throws Throwable {

        System.out.println("Connnexion valide à Avveroès");


    }

    @Then("^je vois le dashboard d'admin$")
    public void jeVoisLeDashboardDAdmin() throws Throwable {
       if(base.driver.findElement(By.id("global_x002e_header_x0023_default-searchText")).isEnabled()){
           System.out.println("dashboard admin s'ouvre");

       }
    }

    @And("^je clique sur le lien du dashlet administration processus$")
    public void jeCliqueSurLeLienDuDashletAdministrationProcessus() throws Throwable {

        Thread.sleep(1000);
        base.driver.findElement(By.xpath("//a[@href='/share/page/console/process/workflow-console'][contains(text(),'Voir tout')]")).click();



        base.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }

    @And("^je créé un nouveau processus$")
    public void jeCreeUnNouveauProcessus() throws Throwable {

        //boutton.nouveauProcess.click();
        base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-newWorkflow-button-button")).click();
        base.driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);

        if( base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow-dialog")).isDisplayed()) {
            System.out.println("l'interface de création d'un process est affichée");

            base.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_cm_name")).sendKeys("Processus Filigraner PDF");

            base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-itemGroupActions")).click();
            base.driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
            base.driver.findElement(By.id("alf-id4")).click();
            base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-ok-button")).click();

            base.driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow-form-submit-button")).click();


        }
    }

    @And("^je réalise le workflow de filigranner PDF$")
    public void jeRealiseLeWorkflowDeFiligrannerPDF() throws Throwable {

        Actions builder = new Actions(base.driver);
        base.driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(3000);

        base.driver.findElement(By.id("startTask")).click();
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        base.driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);
        Thread.sleep(500);
        base.driver.findElement(By.xpath("//em[contains(text(),'Documents attachés')]")).click();
        base.driver.findElement(By.xpath("//label[contains(text(),'Voir')]")).click();
        base.driver.findElement(By.xpath("//label[contains(text(),'Ajouter')]")).click();
        base.driver.findElement(By.xpath("//label[contains(text(),'Supprimer')]")).click();


        Thread.sleep(2000);

        base.driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
        Thread.sleep(500);
        base.driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

        base.driver.findElement(By.id("serviceTask")).click();
        //base.driver.findElement(By.id("startTask")).click();
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
        base.driver.findElement(By.id("sequenceFlow")).click();
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200, 200).click().build().perform();


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
        Thread.sleep(2000);
        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        base.driver.findElement(By.xpath("//a[@href='#tab_1']")).click();






        Select dropdown1 = new Select(base.driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Filigraner PDF");



        base.driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();
        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);



    }

    @And("^je configure l'action de la tache système$")
    public void jeConfigureLActionDeLaTacheSysteme() throws Throwable {
        Thread.sleep(3000);
        Select dropdown1 = new Select(base.driver.findElement(By.name("prop_wm-pdf_watermark-type")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Image");
        Thread.sleep(1000);
        bot.mouseMove(430, 270);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(4000);
        bot.mouseMove(650, 350);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(4000);
        bot.mouseMove(1000, 580);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);







        base.driver.findElement(By.xpath("//input[contains(@id,'prop_wdm_workflowServiceTaskProcessing-watermark-pdf_prop_cm_name')]")).sendKeys("fichier filigrané");
        Select dropdown2 = new Select(base.driver.findElement(By.name("prop_wm-pdf_emplacement")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Statique");

        Thread.sleep(1000);
        bot.mouseMove(430, 470);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(4000);
        bot.mouseMove(500, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);



        base.driver.findElement(By.xpath("//button[contains(@id,'locationDialog-ok-button')]")).click();

        //documents attachés
        base.driver.findElement(By.xpath("//span[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-watermark-pdf_prop_wm-pdf_variables-type')]")).click();
        base.driver.findElement(By.xpath("//label[contains(@for,'pdf_variables-type-i1')]")).click();

        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);


        Select dropdown4 = new Select(base.driver.findElement(By.xpath("//select[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-watermark-pdf_prop_wm-pdf_watermark-depth')]")));
        dropdown4.getFirstSelectedOption();
        dropdown4.selectByVisibleText("Au-dessus");
        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        Select dropdown5 = new Select(base.driver.findElement(By.name("prop_wm-pdf_watermark-page")));
        dropdown5.getFirstSelectedOption();
        dropdown5.selectByVisibleText("Toutes");

        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        base.driver.findElement(By.xpath("//button[contains(@id,'wdm_workflowServiceTaskProcessing-watermark-pdf-form-submit-button')]")).click();












    }

    @And("^je clique sur l'icone générer$")
    public void jeCliqueSurLIconeGenerer() throws Throwable {
        Thread.sleep(5000);
        bot.mouseMove(1350, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //bouton générer
      base.driver.findElement(By.xpath("//button[contains(@id,'generateWorkflow-button-button')]")).click();
      Thread.sleep(45000);
    }

    @And("^je clique sur l'icone activer$")
    public void jeCliqueSurLIconeActiver() throws Throwable {
        //liste de processus
        base.driver.findElement(By.xpath("//em[contains(text(),'LISTE DES PROCESSUS')]")).click();
        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //icone d'activation du processus
        Thread.sleep(4000);
        bot.mouseMove(1160, 310);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        base.driver.findElement(By.xpath("//button[contains(@id,'-button')]")).click();
        Thread.sleep(2000);


    }

    @And("^je consule la dashlet processus$")
    public void jeConsuleLaDashletProcessus() throws Throwable {
        Thread.sleep(2000);
        base.driver.navigate().to("http://127.0.0.1:8099/share/page/");

        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(base.driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/share/page/workflows']")));

        base.driver.findElement(By.xpath("//a[@href='/share/page/workflows']")).click();


    }

    @And("^je lance le processus$")
    public void jeLanceLeProcessus() throws Throwable {
        Thread.sleep(2000);
        base.driver.findElement(By.linkText("Processus Filigraner PDF")).click();
        Thread.sleep(5000);

        base.driver.findElement(By.xpath("//button[contains(text(),'Document existant')]")).click();
        Thread.sleep(2000);

        base.driver.findElement(By.id("alf-id7")).click();

        base.driver.findElement(By.xpath("//button[contains(@id,'packageItems-cntrl-ok-button')]")).click();

        //bouton lancer
        base.driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @And("^je consulte la dashlet Bibliothéque$")
    public void jeConsulteLaDashletBibliotheque() throws Throwable {
        Thread.sleep(2000);
        base.driver.navigate().to("http://localhost:8099/share/page/site/averroes/documentlibrary");

        base.driver.findElement(By.name("username")).sendKeys("admin");
        base.driver.findElement(By.name("password")).sendKeys("Safa1994");

        base.driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();
        Thread.sleep(4000);
    }

    @Then("^je trouve le document filigrané$")
    public void jeTrouveLeDocumentFiligrane() throws Throwable {

    }
}











