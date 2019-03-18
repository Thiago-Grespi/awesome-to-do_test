package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.insertItemIntoListPage;

public class InsertItemIntoList {

    private insertItemIntoListPage page = new insertItemIntoListPage();

    WebElement visibleMark;

    @Given("i access the Awesome To-Do List (.*)")
    public void acessarAwesomeToDoList(String atd_url){
        page.driver.get(atd_url);
        Assert.assertEquals("Awesome To-Do List", page.getMainText());
    }

    @When("i insert a task title (.*)")
    public void insertTaskTitle(String taskTitle){
        page.setTaskTitle(taskTitle);
        Assert.assertEquals(taskTitle, page.getTaskTitleFromInput());
    }

    @And("add the task")
    public void addTask(){
        page.clickAddTask();
    }

    @Then("the task with (.*) must be on the list")
    public void assertTaskInList(String taskTitle){
        for (WebElement taskItem: page.tasksList()) {
            Assert.assertTrue(taskItem.getText().contains(taskTitle));
        }
    }

    //Mark item as done

    @And("i have items in the list")
    public void assertListNotEmpty(){
        String taskTitle = "Dar banho no cachorro";
        insertTaskTitle(taskTitle);
        addTask();
        assertTaskInList(taskTitle);
        Assert.assertTrue(page.tasksList().size() != 0);
        visibleMark = page.visibleMark();
    }

    @When("mark the first task of the list as done")
    public void markasDone(){
        page.markAsDone();
    }

    @Then("the mark icon must be changed")
    public void assertMarkChanged(){
        Assert.assertNotEquals(page.visibleMark(), visibleMark);
    }

    //Insert a empty title item in To-Do List

    @When("i add an item without title")
    public void addItemWithoutTItle(){
        addTask();
    }

    @Then("an alert message should be displayed with (.*)")
    public void assertAlertMessage(String message){
        Assert.assertEquals(message, page.getAlertMessage());
    }

}
