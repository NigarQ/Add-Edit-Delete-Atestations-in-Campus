package POM;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBarElements extends BasePOM {

    public NavigationBarElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Human Resources']")
    private WebElement humanResourcesButton;

    @FindBy(xpath = "(//span[text()='Setup'])[3]")
    private WebElement setupButton;

    @FindBy(xpath = "//span[text()='Attestations']")
    private WebElement attestationsButton;


    public void navigateToAttestationsPage(){
        humanResourcesButton.click();
        setupButton.click();
        attestationsButton.click();
    }




















}
