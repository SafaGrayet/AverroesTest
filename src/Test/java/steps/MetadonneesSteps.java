package steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import static steps.LoginStep.dragAndDropElement;

public class MetadonneesSteps {

    public BaseUtil base;
    Robot bot = new Robot();
    Actions builder = new Actions(base.driver);

    public MetadonneesSteps(BaseUtil base) throws AWTException {

        this.base = base;
    }


    @And("^je créé la varible de processus \"([^\"]*)\" de type Contenu GED$")
    public void jeCreeLaVaribleDeProcessusDeTypeContenuGED(String arg0) throws Throwable {

        //placer le scoll en bas
        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        int mask2 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1293, 520);
        bot.mousePress(mask2);
        bot.mouseRelease(mask2);
        base.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        //  WebDriverWait some_element = new WebDriverWait(base.driver,100);
        //  some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-properties-form_prop_wdm_workflowVariables-cntrl-newVariable_prop_wdm_workflowVariableId']")));


        base.driver.findElement(By.xpath("//input[contains(@id,'-newVariable_prop_wdm_workflowVariableId')]")).sendKeys("dossier");
        base.driver.findElement(By.name("prop_wdm_workflowVariableLabel")).sendKeys(arg0);
        base.driver.findElement(By.name("prop_wdm_workflowVariableType")).sendKeys("Contenu GED");
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//li[@class='yui-ac-highlight']//span[@id='ac-choice-cm:gedContent']")).click();
        Thread.sleep(1000);
        Select dropdown1 = new Select(base.driver.findElement(By.xpath("//select[contains(@id,'cntrl-constraints-list')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Dossier");

        base.driver.findElement(By.xpath("//button[contains(@id,'newVariable-form-submit-button')]")).click();
    }

    @And("^je réalise le workflow Copie de métadonnées: document vers workflow$")
    public void jeRealiseLeWorkflowCopieDeMetadonneesDocumentVersWorkflow() throws Throwable {

        Thread.sleep(2000);



        int mask1 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 300);
        bot.mousePress(mask1);
        bot.mouseRelease(mask1);

        Actions builder = new Actions(base.driver);
        base.driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(1000);
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

    @And("^je créé le formulaire contenant le champs dossier  dans le noeud de début$")
    public void jeCreeLeFormulaireContenatLeChampsDossierDansLeNoeudDeDebut() throws Throwable {
        Thread.sleep(1000);
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();

        base.driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
        // builder.moveToElement( base.driver.findElement(By.xpath("//div[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-designer']//div[@class='jspContainer']//div[@class='jspPane']")), 500 , 300).click().build().perform();
        base.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        base.driver.findElement(By.xpath("//em[contains(text(),'Designer de formulaire')]")).click();

        base.driver.switchTo().frame(base.driver.findElement(By.xpath("//iframe[contains(@id,'-form-builder')]")));
        Thread.sleep(1000);
        base.driver.findElement(By.xpath("//span[contains(text(),'Composants de base')]")).click();
        base.driver.findElement(By.xpath("//span[contains(text(),'Composants Averroes')]")).click();


        WebElement dragFrom = base.driver.findElement(By.xpath("//span[contains(@title,'Contenu GED')]"));
        WebElement dragTo = base.driver.findElement(By.className("dropzone"));

        dragAndDropElement( dragFrom,  dragTo);


        Select dropdown = new Select(base.driver.findElement(By.id("key")));
        dropdown.getFirstSelectedOption();
        dropdown.selectByVisibleText("dossier");

        base.driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();

    }

    @And("^je créé le formulaire contenat les champs nom, description et titre dans la tache utilisateur$")
    public void jeCreeLeFormulaireContenantLesChampsNomDescriptionEtTitreLaTacheUtilisateur() throws Throwable {
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
        dropdown1.selectByVisibleText("titre");
        base.driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        dragAndDropElement( dragFrom,  dragTo);

        Select dropdown2 = new Select(base.driver.findElement(By.id("key")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("description");

        base.driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
    }

    @And("^je configure l'action de la tache système Copie de métadonnées: document vers workflow$")
    public void jeConfigureLActionDeLaTacheSystemeCopieDeMetadonnesDocumentVersWorkflow() throws Throwable {
        //cliquer sur la tache système
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
        //placer le scoll en bas
        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        //cliquer sur configuration
        base.driver.findElement(By.xpath("//a[@href='#tab_1']")).click();
        //selectionner la tache système alimentation des variables
        Select dropdown1 = new Select(base.driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Copie de métadonnées");

        //cliquer sur l'icone de configuration de la tache système
        base.driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        WebDriverWait some_element = new WebDriverWait(base.driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@name,'copydirection')]")));

        Select dropdown2 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'copydirection')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Document vers workflow");

        Select dropdown3 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'documenttype')]")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("Dossier");

        Select dropdown4 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'vartype')]")));
        dropdown4.getFirstSelectedOption();
        dropdown4.selectByVisibleText("dossier");
        Thread.sleep(2000);

        bot.mouseMove(800, 500);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);


        Select dropdown5 = new Select(base.driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown5.getFirstSelectedOption();
        dropdown5.selectByVisibleText("Nom");
        Thread.sleep(2000);

        bot.mouseMove(800, 520);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);


        Select dropdown6 = new Select(base.driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown6.getFirstSelectedOption();
        dropdown6.selectByVisibleText("Description");
        Thread.sleep(2000);
        bot.mouseMove(800, 540);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);

        Select dropdown7 = new Select(base.driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown7.getFirstSelectedOption();
        dropdown7.selectByVisibleText("Titre");

        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();









    }

    @When("^je lance le processus copie méradonnées: document vers workflow$")
    public void jeLanceLeProcessusCopieMeradonneesDocumentVersWorkflow() throws Throwable {
        Thread.sleep(2000);
        // base.driver.findElement(By.xpath("//a[contains(text(),'Processus Alimentation Variable d'un utilisateur dynamique')]")).click();
        base.driver.findElement(By.linkText("copie méradonnées document vers workflow")).click();

        Thread.sleep(2000);
        base.driver.switchTo().frame(base.driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));

        Thread.sleep(1000);

        ((JavascriptExecutor)base.driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[0].click();");
        Thread.sleep(1000);
        base.driver.switchTo().defaultContent();
        Thread.sleep(1000);
        base.driver.findElement(By.id("alf-id5")).click();
        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();


        base.driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @Then("^je vois le formulaire avec le nom, le titre et la description du dossier selectinné dynamiquement$")
    public void jeVoisLeFormulaireAvecLeNomLeTitreEtLaDescriptionDuDossierSelectinneDynamiquement() throws Throwable {

    }

    @And("^je créé la varible de processus \"([^\"]*)\" de type Contenu GED contenu$")
    public void jeCreeLaVaribleDeProcessusDeTypeContenuGEDContenu(String arg0) throws Throwable {

        //  WebDriverWait some_element = new WebDriverWait(base.driver,100);
        //  some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-properties-form_prop_wdm_workflowVariables-cntrl-newVariable_prop_wdm_workflowVariableId']")));


        base.driver.findElement(By.xpath("//input[contains(@id,'-newVariable_prop_wdm_workflowVariableId')]")).sendKeys(arg0);
        base.driver.findElement(By.name("prop_wdm_workflowVariableLabel")).sendKeys(arg0);
        base.driver.findElement(By.name("prop_wdm_workflowVariableType")).sendKeys("Contenu GED");
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//li[@class='yui-ac-highlight']//span[@id='ac-choice-cm:gedContent']")).click();
        Thread.sleep(500);
        Select dropdown1 = new Select(base.driver.findElement(By.xpath("//select[contains(@id,'cntrl-constraints-list')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Contenu");

        base.driver.findElement(By.xpath("//button[contains(@id,'newVariable-form-submit-button')]")).click();
    }

    @And("^je créé le formulaire contenant le champs fichier  dans le noeud de début$")
    public void jeCreeLeFormulaireContenantLeChampsFichierDansLeNoeudDeDebut() throws Throwable {
        Thread.sleep(1000);
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();

        base.driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
        // builder.moveToElement( base.driver.findElement(By.xpath("//div[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-designer']//div[@class='jspContainer']//div[@class='jspPane']")), 500 , 300).click().build().perform();
        base.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        base.driver.findElement(By.xpath("//em[contains(text(),'Designer de formulaire')]")).click();

        base.driver.switchTo().frame(base.driver.findElement(By.xpath("//iframe[contains(@id,'-form-builder')]")));
        Thread.sleep(1000);
        base.driver.findElement(By.xpath("//span[contains(text(),'Composants de base')]")).click();
        base.driver.findElement(By.xpath("//span[contains(text(),'Composants Averroes')]")).click();


        WebElement dragFrom = base.driver.findElement(By.xpath("//span[contains(@title,'Contenu GED')]"));
        WebElement dragTo = base.driver.findElement(By.className("dropzone"));

        dragAndDropElement( dragFrom,  dragTo);


        Select dropdown = new Select(base.driver.findElement(By.id("key")));
        dropdown.getFirstSelectedOption();
        dropdown.selectByVisibleText("fichier");

        base.driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
    }

    @And("^je configure l'action de la tache système Copie de métadonnées: document vers workflow d'un contenu$")
    public void jeConfigureLActionDeLaTacheSystemeCopieDeMetadonneesDocumentVersWorkflowDUnContenu() throws Throwable {
        //cliquer sur la tache système
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
        //placer le scoll en bas
        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        //cliquer sur configuration
        base.driver.findElement(By.xpath("//a[@href='#tab_1']")).click();
        //selectionner la tache système alimentation des variables
        Select dropdown1 = new Select(base.driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Copie de métadonnées");

        //cliquer sur l'icone de configuration de la tache système
        base.driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        WebDriverWait some_element = new WebDriverWait(base.driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@name,'copydirection')]")));

        Select dropdown2 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'copydirection')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Document vers workflow");

        Select dropdown3 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'documenttype')]")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("Contenu");

        Select dropdown4 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'vartype')]")));
        dropdown4.getFirstSelectedOption();
        dropdown4.selectByVisibleText("fichier");
        Thread.sleep(2000);

        bot.mouseMove(800, 500);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);


        Select dropdown5 = new Select(base.driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown5.getFirstSelectedOption();
        dropdown5.selectByVisibleText("Nom");
        Thread.sleep(2000);

        bot.mouseMove(800, 520);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);


        Select dropdown6 = new Select(base.driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown6.getFirstSelectedOption();
        dropdown6.selectByVisibleText("Description");
        Thread.sleep(2000);
        bot.mouseMove(800, 540);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);

        Select dropdown7 = new Select(base.driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown7.getFirstSelectedOption();
        dropdown7.selectByVisibleText("Titre");

        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();





    }

    @When("^je lance le processus copie méradonnées: document vers workflow d'un contenu$")
    public void jeLanceLeProcessusCopieMeradonneesDocumentVersWorkflowDUnContenu() throws Throwable {

        Thread.sleep(2000);
        // base.driver.findElement(By.xpath("//a[contains(text(),'Processus Alimentation Variable d'un utilisateur dynamique')]")).click();
        base.driver.findElement(By.linkText("copie méradonnées document vers workflow d'un fichier")).click();
        Thread.sleep(2000);
        base.driver.switchTo().frame(base.driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));

        Thread.sleep(1000);

        ((JavascriptExecutor)base.driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[0].click();");
        Thread.sleep(1000);
        base.driver.switchTo().defaultContent();
        Thread.sleep(1000);
        base.driver.findElement(By.id("alf-id7")).click();
        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();



        base.driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @And("^je réalise le workflow Copie de métadonnées document vers workflow d'un fichier attaché$")
    public void jeRealiseLeWorkflowCopieDeMetadonneesDocumentVersWorkflowDUnFichierAttache() throws Throwable {

        Thread.sleep(2000);



        int mask1 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 300);
        bot.mousePress(mask1);
        bot.mouseRelease(mask1);

        Actions builder = new Actions(base.driver);
        base.driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //click sur noeud de début

        base.driver.findElement(By.id("startTask")).click();
        Thread.sleep(500);
        //placer le noeud de début dans les coordonnées x=200,y=200
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        base.driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);
        Thread.sleep(500);
        base.driver.findElement(By.xpath("//em[contains(text(),'Documents attachés')]")).click();
        base.driver.findElement(By.xpath("//label[contains(text(),'Voir')]")).click();
        base.driver.findElement(By.xpath("//label[contains(text(),'Ajouter')]")).click();
        base.driver.findElement(By.xpath("//label[contains(text(),'Supprimer')]")).click();

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

    @And("^je configure l'action de la tache système Copie de métadonnées document vers workflow d'un document attaché$")
    public void jeConfigureLActionDeLaTacheSystemeCopieDeMetadonneesDocumentVersWorkflowDUnDocumentAttache() throws Throwable {
        //cliquer sur la tache système
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
        //placer le scoll en bas
        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        //cliquer sur configuration
        base.driver.findElement(By.xpath("//a[@href='#tab_1']")).click();
        //selectionner la tache système alimentation des variables
        Select dropdown1 = new Select(base.driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Copie de métadonnées");

        //cliquer sur l'icone de configuration de la tache système
        base.driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        WebDriverWait some_element = new WebDriverWait(base.driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@name,'copydirection')]")));

        Select dropdown2 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'copydirection')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Document vers workflow");

        Select dropdown3 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'documenttype')]")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("Contenu");

        Select dropdown4 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'vartype')]")));
        dropdown4.getFirstSelectedOption();
        dropdown4.selectByVisibleText("Documents attachés");
        Thread.sleep(2000);

        bot.mouseMove(800, 500);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);


        Select dropdown5 = new Select(base.driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown5.getFirstSelectedOption();
        dropdown5.selectByVisibleText("Nom");
        Thread.sleep(2000);

        bot.mouseMove(800, 520);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);


        Select dropdown6 = new Select(base.driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown6.getFirstSelectedOption();
        dropdown6.selectByVisibleText("Description");
        Thread.sleep(2000);
        bot.mouseMove(800, 540);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);

        Select dropdown7 = new Select(base.driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown7.getFirstSelectedOption();
        dropdown7.selectByVisibleText("Titre");

        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
    }

    @When("^je lance le processus copie méradonnées  document vers workflow d'un fichier attaché$")
    public void jeLanceLeProcessusCopieMeradonneesDocumentVersWorkflowDUnFichierAttache() throws Throwable {


        Thread.sleep(2000);
        // base.driver.findElement(By.xpath("//a[contains(text(),'Processus Alimentation Variable d'un utilisateur dynamique')]")).click();
        base.driver.findElement(By.linkText("copie méradonnées document vers workflow d'un fichier attaché")).click();
        Thread.sleep(2000);

        base.driver.findElement(By.xpath("//button[contains(text(),'Document existant')]")).click();
        Thread.sleep(500);
        base.driver.findElement(By.id("alf-id7")).click();
        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        base.driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @Then("^je vois le formulaire avec le nom, le titre et la description du fichier attaché$")
    public void jeVoisLeFormulaireAvecLeNomLeTitreEtLaDescriptionDuFichierAttache() throws Throwable {

    }


}
