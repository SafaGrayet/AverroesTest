package steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.InputEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import static steps.LoginStep.dragAndDropElement;

public class SelectionBDSteps {
    public BaseUtil base;
    Robot bot = new Robot();
    Actions builder = new Actions(base.driver);


    public SelectionBDSteps(BaseUtil base) throws AWTException {
        this.base = base;
    }
    @And("^je réalise le workflow de sélection dans la base de doonée$")
    public void jeRealiseLeWorkflowDeSelectionDansLaBaseDeDoonee() throws Throwable {
        Thread.sleep(3000);



        int mask1 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 300);
        bot.mousePress(mask1);
        bot.mouseRelease(mask1);

        Actions builder = new Actions(base.driver);
        base.driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(4000);
        //click sur noeud de début

        base.driver.findElement(By.id("startTask")).click();
        Thread.sleep(500);
        //placer le noeud de début dans les coordonnées x=200,y=200
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        base.driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);

        Thread.sleep(1000);
        //cliquer sur "sauvegarder"
        base.driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
        Thread.sleep(500);
        //cliquer sur la tache système
        base.driver.findElement(By.id("serviceTask")).click();
        //base.driver.findElement(By.id("startTask")).click();
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
        base.driver.findElement(By.id("sequenceFlow")).click();
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200, 200).click().build().perform();

        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

        //click sur la tache utilisateur

        base.driver.findElement(By.id("userTask")).click();
        //placer le noeud de début dans les coordonnées x=500,y=300
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 500 , 300).click().build().perform();

        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//em[contains(text(),'Affectation')]")).click();
        Thread.sleep(1000);

        base.driver.findElement(By.xpath("//button[contains(@id,'_workflowUserTaskAssignment-cntrl-select-assignee-button-button')]")).click();

        base.driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
        Thread.sleep(500);

        base.driver.findElement(By.id("sequenceFlow")).click();


        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 500, 300).click().build().perform();


        base.driver.findElement(By.id("endEvent")).click();
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 400, 400).click().build().perform();


        base.driver.findElement(By.id("sequenceFlow")).click();


        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 500, 300).click().build().perform();

        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 400, 400).click().build().perform();

        base.driver.findElement(By.id("select")).click();
    }

    @And("^je créé le formulaire contenat les champs nom et prénom dans la tache utilisateur$")
    public void jeCreeLeFormulaireContenatLesChampsNomEtPrenomDansLaTacheSysteme() throws Throwable {
        Thread.sleep(5000);
        bot.mouseMove(1350, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        Thread.sleep(2000);
        bot.mouseMove(700, 500);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        base.driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
        // builder.moveToElement( base.driver.findElement(By.xpath("//div[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-designer']//div[@class='jspContainer']//div[@class='jspPane']")), 500 , 300).click().build().perform();
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

        dragAndDropElement( dragFrom,  dragTo);

        Select dropdown1 = new Select(base.driver.findElement(By.id("key")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("prenom");

        base.driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
    }

    @And("^je configure l'action de la tache système selection dans la base de données$")
    public void jeConfigureLActionDeLaTacheSystemeSelectionDansLaBaseDeDonnees() throws Throwable {
        Thread.sleep(2000);

        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        base.driver.findElement(By.xpath("//a[@href='#tab_1']")).click();


        Select dropdown1 = new Select(base.driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Sélection de la base de données");
        base.driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        Select dropdown6 = new Select(base.driver.findElement(By.name("prop_select-fromDb_testConnection")));
        dropdown6.getFirstSelectedOption();
        dropdown6.selectByVisibleText("averroesDB");

        base.driver.findElement(By.xpath("//em[contains(text(),'Récupération des données')]")).click();
        Thread.sleep(2000);
        base.driver.findElement(By.name("request")).sendKeys("SELECT nom, prenom FROM test;");
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//em[contains(text(),'Valorisation des propriétés processus')]")).click();
        Thread.sleep(3000);
        int mask2 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(800, 400);
        bot.mousePress(mask2);
        bot.mouseRelease(mask2);
        base.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        base.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("nom");

        Thread.sleep(2000);
        bot.mouseMove(820, 430);
        bot.mousePress(mask2);
        bot.mouseRelease(mask2);

        base.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("prenom");






        ((JavascriptExecutor)base.driver).executeScript("document.getElementsByClassName('yui-button yui-submit-button')[0].click();");
        Thread.sleep(1000);
    }

    @When("^je lance le processus Sélection dans la base de données$")
    public void jeLanceLeProcessusSelectionDansLaBaseDeDonnees() throws Throwable {
        base.driver.findElement(By.linkText("Sélection de la base de données")).click();
        Thread.sleep(7000);
        //bouton lancer
        base.driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
        Thread.sleep(2000);
    }

    @Then("^je vois que les données de la base de données sont figurer dans le formulaire$")
    public void jeVoisQueLesDonneesDeLaBaseDeDonneesSontFigurerDansLeFormulaire() throws Throwable {
        Class.forName("org.postgresql.Driver");
        DriverManager.getConnection("jdbc:postgresql://localhost:5434/alfresco","alfresco","Safa1994");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5434/alfresco","alfresco","Safa1994");
        con.createStatement();
        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery("Select * from test");
        while(rs.next()) {
             String nomm= rs.getString("nom");
            String pre= rs.getString("prenom");
            Thread.sleep(4000);
            base.driver.switchTo().frame(base.driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));
            Thread.sleep(2000);
            String nm= base.driver.findElement(By.xpath("//input[contains(@name,'data[var-nom]')]")).getText();
            String pr=base.driver.findElement(By.xpath("//input[contains(@name,'data[var-prenom]')]")).getText();
            if(nm.equals(nomm)&&(pr.equals(pre))){
                System.out.println("Les données sont bien sélectionner de la base de donnés ");
            }else
                System.out.println("erreur lors de la sélection de la base de données");



        }

    }
}
