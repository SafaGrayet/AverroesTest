package steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

public class GenerationIDSteps {
    public BaseUtil base;
    Robot bot = new Robot();
    Actions builder = new Actions(base.driver);

    public GenerationIDSteps(BaseUtil base) throws AWTException {

        this.base = base;
    }
    @And("^je réalise le workflow de \"([^\"]*)\"$")
    public void jeRealiseLeWorkflowDe(String arg0) throws Throwable {

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



    }

    @And("^je consulte la dashlet administration processus$")
    public void jeConsulteLaDashletAdministrationProcessus() throws Throwable {

        base.driver.navigate().to("http://localhost:8099/share/page/console/process/workflow-console");

        Thread.sleep(1000);
        base.driver.findElement(By.name("username")).sendKeys("admin");
        base.driver.findElement(By.name("password")).sendKeys("Safa1994");

        base.driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();
        Thread.sleep(1000);
        //base.driver.findElement(By.xpath("//a[@href='/share/page/console/process/workflow-console'][contains(text(),'Voir tout')]")).click();

    }

    @When("^je cliquer sur \"([^\"]*)\"$")
    public void jeCliquerSur(String arg0) throws Throwable {
       // WebDriverWait some_element = new WebDriverWait(base.driver,100);
       // some_element.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Gestion des compteurs")));
        base.driver.findElement(By.linkText("Gestion des compteurs")).click();

    }
    int val=8;
    @Then("^Le compteur nommé \"([^\"]*)\"qu'on a déjà créé s'incrémente avec la pas d'incrémentation$")
    public void leCompteurNommeQuOnADejeCreeSIncrementeAvecLaPasDIncrementation(String arg0) throws Throwable {
        Thread.sleep(3000);

       String compt=base.driver.findElement(By.xpath("//td[contains(@headers,'-th-value')]//div[@class='yui-dt-liner']")).getText();
        int x =Integer.parseInt(compt);
        if(x==val+1){
            val++;
            System.out.println("Le compteur a s'incrémeté par 1 (pas d'incrémentation)");
        }else
            System.out.println("Le compteur n'a pas s'incrémeté");

    }

    @And("^je configure l'action de la tache système Génération ID$")
    public void jeConfigureLActionDeLaTacheSystemeGenerationID() throws Throwable {
        Thread.sleep(4000);
        bot.mouseMove(1350, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
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
        dropdown1.selectByVisibleText("Générer Identifiant");


        base.driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();
        base.driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        WebDriverWait some_element = new WebDriverWait(base.driver,100);
         some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'Format')]")));
        base.driver.findElement(By.xpath("//input[contains(@name,'Format')]")).clear();
         base.driver.findElement(By.xpath("//input[contains(@name,'Format')]")).sendKeys("${counter:test}");

        Select dropdown9 = new Select(base.driver.findElement(By.xpath("//select[contains(@name,'WFvariable')]")));
        dropdown9.getFirstSelectedOption();
        dropdown9.selectByVisibleText("test:test");

        base.driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();






    }

    @And("^je lance le processus Générer Identifiant$")
    public void jeLanceLeProcessusGenererIdentifiant() throws Throwable {
        base.driver.findElement(By.linkText("Générer Identifiant")).click();
        Thread.sleep(5000);
        //bouton lancer
        base.driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
        Thread.sleep(2000);
    }
}
