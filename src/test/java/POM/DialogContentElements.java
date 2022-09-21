package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DialogContentElements extends BasePOM{

    public DialogContentElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type='text']")
    private WebElement nameSearchInput;

    String name;
    String name1;

    @FindBy(xpath = "//span[text()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(), 'success')]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(), 'already exists.')]")
    private WebElement unsuccessfulMessage;

    @FindBy(xpath = "//ms-add-button[@table='true']//button")
    private WebElement editButton;

    @FindBy(xpath = "//ms-delete-button[@table='true']//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[text()=' Delete ']")
    private WebElement submitDeleteButton;

    @FindBy(xpath = "//div[contains(text(), 'no')]")
    private WebElement thereIsNoDataDisplayed;


    public void addAttestation (String attestationName){
        addButton.click();
        nameInput.sendKeys(attestationName);
        saveButton.click();
    }

    public void validateSuccessMessage(){
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'successfully')]")));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        //Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));
    }

    public void addSameAttestationName(String sameAttestationName){
        addButton.click();
        nameInput.sendKeys(sameAttestationName);
        saveButton.click();
    }

    public void validateUnsuccessfulMessage(){
        wait.until(ExpectedConditions.visibilityOf(unsuccessfulMessage));
        Assert.assertTrue(unsuccessfulMessage.getText().contains("already exists.".toLowerCase()));

    }


    public void editAttestation(){
        nameSearchInput.sendKeys("nigar");
        searchButton.click();
    }


    public void editButton(){
        editButton.click();
        nameInput.sendKeys("nasker");
        saveButton.click();
    }

    public void validateSuccessfullyUpdatedMessage(){
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));

    }

    public void deleteAttestation(String name){
        nameSearchInput.sendKeys(name);
        searchButton.click();
        deleteButton.click();
        submitDeleteButton.click();

    }

    public void successfullyDeleted(){
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));
    }

    public void noDataDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(thereIsNoDataDisplayed));
        Assert.assertTrue(thereIsNoDataDisplayed.getText().contains("no".toLowerCase()));
    }










}
