package steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static steps.LoginStep.dragAndDropElement;

public class GenerationPDF {


    public BaseUtil base;
    Robot bot = new Robot();
    Actions builder = new Actions(base.driver);

    public GenerationPDF(BaseUtil base) throws AWTException {

        this.base = base;
    }
    @Then("^je réalise le workflow de génération PDF statique$")
    public void jeRealiseLeWorkflowDeGenerationPDFStatique() throws Throwable {
        Thread.sleep(2000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 300);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        Actions builder = new Actions(base.driver);
        base.driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(3000);

        base.driver.findElement(By.id("startTask")).click();
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        base.driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);

        WebDriverWait some_element = new WebDriverWait(base.driver,10000000);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sauvegarder')]")));

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
    }

    @And("^je configure la tache système génération PDF statique$")
    public void jeConfigureLaTacheSystemeGenerationPDFStatique() throws Throwable {
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
        dropdown1.selectByVisibleText("Génération de PDF");
        base.driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();
        WebDriverWait some_element = new WebDriverWait(base.driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'_prop_cm_name')]")));
        base.driver.findElement(By.xpath("//button[contains(text(),'Indexer le document')]")).click();
        Thread.sleep(1000);
        base.driver.findElement(By.xpath("//input[contains(@name,'prop_cm_name')]")).sendKeys("pdfstatique.pdf");
        base.driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
        Thread.sleep(1000);

        base.driver.findElement(By.xpath("//input[contains(@id,'_prop_cm_name')]")).sendKeys("PDFstatique");

        base.driver.findElement(By.xpath("//button[contains(text(),'Sélectionner')]")).click();
        Thread.sleep(2500);
        bot.mouseMove(650, 390);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);

        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        Select dropdown2 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'prop_gen-pdf_emplacement')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Statique");
        base.driver.findElement(By.xpath("//button[contains(@id,'folderLocation-cntrl-selectLocation-button-button')]")).click();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//span[contains(text(),'PDF généré')]")).click();
        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        WebDriverWait some_elemen = new WebDriverWait(base.driver,100);
        some_elemen.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enregistrer')]")));

        base.driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();









    }

    @When("^je lance le processus Génération d'un PDF statique dans un emplacement statique$")
    public void jeLanceLeProcessusGeneationDUnPDFStatiqueDansUnEmplacementStatique() throws Throwable {
        base.driver.findElement(By.linkText("Génération d'un PDF statique dans un emplacement statique")).click();

        Thread.sleep(2000);
        base.driver.switchTo().frame(base.driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//input[contains(@name,'data[var-nom]')]")).sendKeys("Grayet");

        base.driver.findElement(By.xpath("//input[contains(@name,'data[var-prenom]')]")).sendKeys("Safa");

        base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        //bouton lancer
        base.driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
        Thread.sleep(2000);
    }

    @And("^je créé le formulaire contenat les champs nom, prénom  dans le noeud de début$")
    public void jeCreeLeFormulaireContenatLesChampsNomPrenomDansLeNoeudDeDebut() throws Throwable {
        Thread.sleep(5000);
        bot.mouseMove(1350, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(1000);
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();


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

    @Then("^je consule la dashlet bibliothéque$")
    public void jeConsuleLaDashletBibliotheque() throws Throwable {
        Thread.sleep(2000);
        base.driver.navigate().to("http://localhost:8099/share/page/site/averroes/documentlibrary");

        base.driver.findElement(By.name("username")).sendKeys("admin");
        base.driver.findElement(By.name("password")).sendKeys("Safa1994");

        base.driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();
        Thread.sleep(4000);
    }

    @And("^je trouve le fichier généré dans l'enplacement statique indiqué dans la configuration de la tache système$")
    public void jeTrouveLeFichierGenereDansLEnplacementStatiqueIndiqueDansLaConfigurationDeLaTacheSysteme() throws Throwable {

        base.driver.findElement(By.linkText("PDF généré")).click();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//a[contains(text(),'pdfstatique.pdf')]")).click();
       // "C:\Users\PC-ASUS\Downloads\PDFstatique_Génération d'un PDF statique dans un emplacement statique_3654_1524554832780.pdf"
        base.driver.findElement(By.xpath("//div[@class='document-download']//a[@title='Télécharger']")).click();
        Thread.sleep(15000);
        PDDocument pd;
       pd= PDDocument.load(new File("C:\\Users\\PC-ASUS\\Downloads\\pdfstatique.pdf"));
        PDFTextStripper pdf=new PDFTextStripper();
        System.out.println(pdf.getText(pd));
        if(pdf.getText(pd).contains("Safa")&&(pdf.getText(pd).contains("Grayet"))){
            System.out.println("pdf généré avec succès" );
        }else
            System.out.println("le fichier généré ne contient les données remplis dans le formulaire");


    }

    @And("^je créé le formulaire contenat les champs nom, prénom, dossier dans le noeud de début$")
    public void jeCreeLeFormulaireContenatLesChampsNomPrenomDossierDansLeNoeudDebut() throws Throwable {
        Thread.sleep(5000);
        bot.mouseMove(1350, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(1000);
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();


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
        Thread.sleep(1000);
        base.driver.findElement(By.xpath("//span[contains(text(),'Composants de base')]")).click();
        base.driver.findElement(By.xpath("//span[contains(text(),'Composants Averroes')]")).click();


        WebElement dragFrom1 = base.driver.findElement(By.xpath("//span[contains(@title,'Contenu GED')]"));
        WebElement dragTo1 = base.driver.findElement(By.className("dropzone"));

        dragAndDropElement( dragFrom1,  dragTo1);


        Select dropdown2 = new Select(base.driver.findElement(By.id("key")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("dossier");

        base.driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
    }

    @And("^je configure la tache système génération PDF statique avc emplacement dynamique$")
    public void jeConfigureLaTacheSystemeGenerationPDFStatiqueAvcEmplacementDynamique() throws Throwable {
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
        dropdown1.selectByVisibleText("Génération de PDF");
        base.driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();
        WebDriverWait some_element = new WebDriverWait(base.driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'_prop_cm_name')]")));
        base.driver.findElement(By.xpath("//button[contains(text(),'Indexer le document')]")).click();
        Thread.sleep(1000);
        base.driver.findElement(By.xpath("//input[contains(@name,'prop_cm_name')]")).sendKeys("pdfstatiqueempdyn.pdf");
        base.driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
        Thread.sleep(1000);

        base.driver.findElement(By.xpath("//input[contains(@id,'_prop_cm_name')]")).sendKeys("PDFstatempdyn");

        base.driver.findElement(By.xpath("//button[contains(text(),'Sélectionner')]")).click();
        Thread.sleep(2500);
        bot.mouseMove(650, 390);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);

        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        Select dropdown2 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'prop_gen-pdf_emplacement')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Dynamique");

        WebDriverWait some_elemen = new WebDriverWait(base.driver,100);
        some_elemen.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enregistrer')]")));

        base.driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }

    @When("^je lance le processus Génération d'un PDF statique dans un emplacement dynamique$")
    public void jeLanceLeProcessusGenerationDUnPDFStatiqueDansUnEmplacementDynamique() throws Throwable {
        base.driver.findElement(By.linkText("Génération d'un PDF statique dans un emplacement dynamique")).click();

        Thread.sleep(2000);
        base.driver.switchTo().frame(base.driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//input[contains(@name,'data[var-nom]')]")).sendKeys("Grayet");

        base.driver.findElement(By.xpath("//input[contains(@name,'data[var-prenom]')]")).sendKeys("Safa");

        ((JavascriptExecutor)base.driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[0].click();");
        Thread.sleep(1000);
        base.driver.switchTo().defaultContent();
        Thread.sleep(1000);
        base.driver.findElement(By.id("alf-id6")).click();

        base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();


        base.driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @And("^je trouve le fichier généré dans l'enplacement dynamique indiqué dans le formulaire$")
    public void jeTrouveLeFichierGenereDansLEnplacementDynamiqueIndiqueDansLeFormulaire() throws Throwable {
        Thread.sleep(3000);
        base.driver.findElement(By.linkText("PDF généré")).click();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//a[contains(text(),'pdfstatiqueempdyn.pdf')]")).click();
        // "C:\Users\PC-ASUS\Downloads\PDFstatique_Génération d'un PDF statique dans un emplacement statique_3654_1524554832780.pdf"
        base.driver.findElement(By.xpath("//div[@class='document-download']//a[@title='Télécharger']")).click();
        Thread.sleep(15000);
        PDDocument pd;
        pd= PDDocument.load(new File("C:\\Users\\PC-ASUS\\Downloads\\pdfstatiqueempdyn.pdf"));
        PDFTextStripper pdf=new PDFTextStripper();
        System.out.println(pdf.getText(pd));
        if(pdf.getText(pd).contains("Safa")&&(pdf.getText(pd).contains("Grayet"))){
            System.out.println("pdf généré avec succès" );
        }else
            System.out.println("le fichier généré ne contient les données remplis dans le formulaire");




    }

    @Then("^je réalise le workflow de génération PDF dynamique dans un emplacement statique$")
    public void jeRealiseLeWorkflowDeGenerationPDFDynamiqueDansUnEmplacementStatique() throws Throwable {
        Thread.sleep(2000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 300);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        Actions builder = new Actions(base.driver);
        base.driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(3000);

        base.driver.findElement(By.id("startTask")).click();
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        base.driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);

        WebDriverWait some_element = new WebDriverWait(base.driver,10000000);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sauvegarder')]")));

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
    }

    @And("^je créé le formulaire contenat les champs nom, prénom, fichier dans le noeud de début$")
    public void jeCreeLeFormulaireContenatLesChampsNomPrenomFichierDansLeNoeudDeDebut() throws Throwable {
        Thread.sleep(5000);
        bot.mouseMove(1350, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(1000);
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();


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
        Thread.sleep(1000);
        base.driver.findElement(By.xpath("//span[contains(text(),'Composants de base')]")).click();
        base.driver.findElement(By.xpath("//span[contains(text(),'Composants Averroes')]")).click();


        WebElement dragFrom1 = base.driver.findElement(By.xpath("//span[contains(@title,'Contenu GED')]"));
        WebElement dragTo1 = base.driver.findElement(By.className("dropzone"));

        dragAndDropElement( dragFrom1,  dragTo1);


        Select dropdown2 = new Select(base.driver.findElement(By.id("key")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("fichier");

        base.driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
    }

    @And("^je configure la tache système génération PDF dynamique avc emplacement statique$")
    public void jeConfigureLaTacheSystemeGenerationPDFDynamiqueAvcEmplacementStatique() throws Throwable {
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
        dropdown1.selectByVisibleText("Génération de PDF");
        base.driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();
        WebDriverWait some_element = new WebDriverWait(base.driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'_prop_cm_name')]")));
        base.driver.findElement(By.xpath("//button[contains(text(),'Indexer le document')]")).click();
        Thread.sleep(1000);
        base.driver.findElement(By.xpath("//input[contains(@name,'prop_cm_name')]")).sendKeys("pdfdynempstatique.pdf");
        base.driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
        Thread.sleep(1000);

        base.driver.findElement(By.xpath("//input[contains(@id,'_prop_cm_name')]")).sendKeys("PDFdunempstatique");
        Select dropdown = new Select(base.driver.findElement(By.xpath("//select[contains(@id,'-cntrl-template_mode_menu_select')]")));
        dropdown.getFirstSelectedOption();
        dropdown.selectByVisibleText("Dynamique");


        Select dropdown2 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'prop_gen-pdf_emplacement')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Statique");
        base.driver.findElement(By.xpath("//button[contains(@id,'folderLocation-cntrl-selectLocation-button-button')]")).click();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//span[contains(text(),'PDF généré')]")).click();
        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        WebDriverWait some_elemen = new WebDriverWait(base.driver,100);
        some_elemen.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enregistrer')]")));

        base.driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }

    @When("^je lance le processus Génération d'un PDF dynamique dans un emplacement statique$")
    public void jeLanceLeProcessusGenerationDUnPDFDynamiqueDansUnEmplacementStatique() throws Throwable {

        base.driver.findElement(By.linkText("Génération d'un PDF dynamique dans un emplacement statique")).click();

        Thread.sleep(2000);
        base.driver.switchTo().frame(base.driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//input[contains(@name,'data[var-nom]')]")).sendKeys("Grayet");

        base.driver.findElement(By.xpath("//input[contains(@name,'data[var-prenom]')]")).sendKeys("Safa");
        Thread.sleep(1000);

        ((JavascriptExecutor)base.driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[0].click();");
        base.driver.switchTo().defaultContent();
        Thread.sleep(3000);

        bot.mouseMove(668, 500);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        base.driver.findElement(By.id("alf-id12")).click();
        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        base.driver.switchTo().defaultContent();


        base.driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();

    }

    @And("^je trouve le fichier généré dynamiqument dans l'emplacement statique indiqué dans la configuration de la tache système$")
    public void jeTrouveLeFichierGenereDynamiqumentDansLEmplacementStatiqueIndiqueDansLaConfigurationDeLaTacheSysteme() throws Throwable {
        Thread.sleep(3000);
        base.driver.findElement(By.linkText("PDF généré")).click();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//a[contains(text(),'pdfdynempstatique.pdf')]")).click();
        // "C:\Users\PC-ASUS\Downloads\PDFstatique_Génération d'un PDF statique dans un emplacement statique_3654_1524554832780.pdf"
        base.driver.findElement(By.xpath("//div[@class='document-download']//a[@title='Télécharger']")).click();
        Thread.sleep(15000);
        PDDocument pd;
        pd= PDDocument.load(new File("C:\\Users\\PC-ASUS\\Downloads\\pdfdynempstatique.pdf"));
        PDFTextStripper pdf=new PDFTextStripper();
        System.out.println(pdf.getText(pd));
        if(pdf.getText(pd).contains("Safa")&&(pdf.getText(pd).contains("Grayet"))){
            System.out.println("pdf généré avec succès" );
        }else
            System.out.println("le fichier généré ne contient les données remplis dans le formulaire");
    }

    @Then("^je réalise le workflow de génération PDF dynamique dans un emplacement dynamique$")
    public void jeRealiseLeWorkflowDeGenerationPDFDynamiqueDansUnEmplacementDynamique() throws Throwable {
        Thread.sleep(2000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 300);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        Actions builder = new Actions(base.driver);
        base.driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(3000);

        base.driver.findElement(By.id("startTask")).click();
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        base.driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);

        WebDriverWait some_element = new WebDriverWait(base.driver,10000000);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sauvegarder')]")));

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
    }


    @And("^je créé le formulaire contenat les champs nom, prénom, fichier,dossier dans le noeud de début$")
    public void jeCreeLeFormulaireContenatLesChampsNomPrenomFichierDossierDansLeNoeudDeDebut() throws Throwable {
        Thread.sleep(5000);
        bot.mouseMove(1350, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(1000);
        builder.moveToElement( base.driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();


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
        Thread.sleep(1000);
        base.driver.findElement(By.xpath("//span[contains(text(),'Composants de base')]")).click();
        base.driver.findElement(By.xpath("//span[contains(text(),'Composants Averroes')]")).click();


        WebElement dragFrom1 = base.driver.findElement(By.xpath("//span[contains(@title,'Contenu GED')]"));
        WebElement dragTo1 = base.driver.findElement(By.className("dropzone"));

        dragAndDropElement( dragFrom1,  dragTo1);


        Select dropdown2 = new Select(base.driver.findElement(By.id("key")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("fichier");

        base.driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();
        WebElement dragFrom2 = base.driver.findElement(By.xpath("//span[contains(@title,'Contenu GED')]"));
        WebElement dragTo2 = base.driver.findElement(By.className("dropzone"));

        dragAndDropElement( dragFrom2,  dragTo2);


        Select dropdown3 = new Select(base.driver.findElement(By.id("key")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("dossier");

        base.driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
        return;
    }

    @And("^je configure la tache système génération PDF dynamique avec emplacement dynamique$")
    public void jeConfigureLaTacheSystemeGenerationPDFDynamiqueAvecEmplacementDynamique() throws Throwable {
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
        dropdown1.selectByVisibleText("Génération de PDF");
        base.driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();
        WebDriverWait some_element = new WebDriverWait(base.driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'_prop_cm_name')]")));
        base.driver.findElement(By.xpath("//button[contains(text(),'Indexer le document')]")).click();
        Thread.sleep(1000);
        base.driver.findElement(By.xpath("//input[contains(@name,'prop_cm_name')]")).sendKeys("pdfdynamique.pdf");
        base.driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
        Thread.sleep(1000);

        base.driver.findElement(By.xpath("//input[contains(@id,'_prop_cm_name')]")).sendKeys("PDFdynamique");
        Select dropdown = new Select(base.driver.findElement(By.xpath("//select[contains(@id,'-cntrl-template_mode_menu_select')]")));
        dropdown.getFirstSelectedOption();
        dropdown.selectByVisibleText("Dynamique");


        Select dropdown2 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'prop_gen-pdf_emplacement')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Dynamique");


        WebDriverWait some_elemen = new WebDriverWait(base.driver,100);
        some_elemen.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enregistrer')]")));

        base.driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }

    @When("^je lance le processus Génération d'un PDF dynamique dans un emplacement dynamique$")
    public void jeLanceLeProcessusGenrationDUnPDFDynamiqueDansUnEmplacementDynamique() throws Throwable {
        base.driver.findElement(By.linkText("Génération d'un PDF dynamique dans un emplacement dynamique")).click();

        Thread.sleep(2000);
        base.driver.switchTo().frame(base.driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//input[contains(@name,'data[var-nom]')]")).sendKeys("Grayet");

        base.driver.findElement(By.xpath("//input[contains(@name,'data[var-prenom]')]")).sendKeys("Safa");
        Thread.sleep(1000);

        ((JavascriptExecutor)base.driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[0].click();");
        base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        base.driver.findElement(By.id("alf-id6")).click();

        base.driver.switchTo().defaultContent();

        ((JavascriptExecutor)base.driver).executeScript("document.getElementsByClassName('yui-button yui-push-button')[6].click();");
        Thread.sleep(2000);
        base.driver.switchTo().frame(base.driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));

        Thread.sleep(2000);

        ((JavascriptExecutor)base.driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[1].click();");
        Thread.sleep(1000);
        base.driver.switchTo().defaultContent();
        Thread.sleep(3000);

        bot.mouseMove(668, 500);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //base.driver.switchTo().defaultContent();
        Thread.sleep(2000);
        base.driver.findElement(By.id("alf-id20")).click();
        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        base.driver.switchTo().defaultContent();
        Thread.sleep(2000);

        base.driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @And("^je trouve le fichier généré dynamiqument dans l'emplacement dynamique$")
    public void jeTrouveLeFichierGenereDynamiqumentDansLEmplacementDynamique() throws Throwable {
        Thread.sleep(3000);
        base.driver.findElement(By.linkText("PDF généré")).click();
        Thread.sleep(2000);
        base.driver.findElement(By.xpath("//a[contains(text(),'pdfdynamique.pdf')]")).click();
        // "C:\Users\PC-ASUS\Downloads\PDFstatique_Génération d'un PDF statique dans un emplacement statique_3654_1524554832780.pdf"
        base.driver.findElement(By.xpath("//div[@class='document-download']//a[@title='Télécharger']")).click();
        Thread.sleep(15000);
        PDDocument pd;
        pd= PDDocument.load(new File("C:\\Users\\PC-ASUS\\Downloads\\pdfdynamique.pdf"));
        PDFTextStripper pdf=new PDFTextStripper();
        System.out.println(pdf.getText(pd));
        if(pdf.getText(pd).contains("Safa")&&(pdf.getText(pd).contains("Grayet"))){
            System.out.println("pdf généré avec succès" );
        }else
            System.out.println("le fichier généré ne contient les données remplis dans le formulaire");

    }
}
