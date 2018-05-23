package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardElements extends BaseUtil {
    private BaseUtil base;

    public DashboardElements(BaseUtil base) {
        this.base = base;
    }

    public WebElement processlLink=base.driver.findElement(By.id("dashlet_admin_process_link"));

    public WebElement documentLink=base.driver.findElement(By.id("dashlet_documents_link"));
    public  WebElement tasksLink=base.driver.findElement(By.id("dashlet_tasks_link"));
}
