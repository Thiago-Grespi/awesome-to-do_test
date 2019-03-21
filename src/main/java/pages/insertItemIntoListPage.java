package pages;

import static core.DriverFactory.getDriver;
import core.basePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class insertItemIntoListPage extends basePage {

    private Alert alert;
    private WebElement green_check;
    private WebDriver driver = getDriver();

    public String getMainText(){
        return driver.findElement(By.tagName("h1")).getText();
    }

    public void setTaskTitle(String taskTitle){
        driver.findElement(By.id("todo-item")).sendKeys(taskTitle);
    }

    public String getTaskTitleFromInput(){
        return driver.findElement(By.id("todo-item")).getAttribute("ng-reflect-model");
    }

    public void clickAddTask(){
        driver.findElement(By.xpath("//input[@class='btn blue col s2']")).click();
    }

    public List<WebElement> tasksList(){
        return driver.findElements(By.xpath("/html/body/div[1]/app-root/div[2]/app-todo-list/ul"));
    }

    public void markAsDone() {
        visibleMark().click();
    }

    public WebElement visibleMark(){
        if(driver.findElement(By.xpath("/html/body/div[1]/app-root/div[2]/app-todo-list/ul/li[1]/app-todo-item/div/div/a[1]/i")).isDisplayed()){
            green_check = driver.findElement(By.xpath("/html/body/div[1]/app-root/div[2]/app-todo-list/ul/li[1]/app-todo-item/div/div/a[1]/i"));
            return green_check;
        }
        WebElement red_arrow_back = driver.findElement(By.xpath("/html/body/div[1]/app-root/div[2]/app-todo-list/ul/li[1]/app-todo-item/div/div/a[2]/i"));
        return red_arrow_back;
    }

    public WebElement elementMarkAsDone(){
        return driver.findElement(By.xpath("//i[@class=" + tasksList().get(0).getAttribute("class") + "]"));
    }

    public String getAlertMessage(){
        alert = driver.switchTo().alert();
        return alert.getText();
    }
}
