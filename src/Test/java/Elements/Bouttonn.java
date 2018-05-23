package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Bouttonn {

    public Bouttonn(WebDriver driver){
        PageFactory.initElements(driver,this);   }

    @FindBy(how = How.ID, using = "page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")
    public WebElement loginbtn;

    @FindBy(how= How.ID, using="page_x002e_ctool_x002e_process_x0023_default-newWorkflow-button-button")
    public WebElement nouveauProcess;

    @FindBy(how= How.ID, using="page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-itemGroupActions")
    public WebElement selectionnerCategorie;

    @FindBy(how= How.ID, using="alf-id4")
    public WebElement categorieGenerale;

    @FindBy(how= How.ID, using="page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-ok-button")
    public WebElement confirmerCategorie;

    @FindBy(how= How.ID, using="page_x002e_ctool_x002e_process_x0023_default-createWorkflow-form-submit-button")
    public WebElement confirmerProcess;








}
