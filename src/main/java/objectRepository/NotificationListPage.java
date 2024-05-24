package objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import genericUtility.WebDriverUtility;

public class NotificationListPage {

	//Rule-1 :- Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//input[@placeholder='Search...']")private WebElement SearchEdt;
    
    @FindBy(xpath="//h5[.='No records found']")private WebElement NoRecordsFoundMsg;
    
    @FindBy(xpath="//button[.='Add Notification']")private WebElement AddNotificationBtn;
	
    //td[.='Event Deleted']/following-sibling::td//button[.=' View ']  Traversing from Title
    @FindBy(xpath="(//button[.=' View '])[1]")private WebElement ViewBtn;
    
    //td[.='Event Deleted']/following-sibling::td/button[.=' Edit ']   Traversing from Title
    @FindBy(xpath="(//button[.=' Edit '])[1]")private WebElement EditBtn;
    
    //td[.='Event Deleted']/following-sibling::td/button[@class='btn-sm btn-edit bg-danger']   Traversing from Title
    @FindBy(xpath="(//button[@class='btn-sm btn-edit bg-danger'])[1]")private WebElement DeleteBtn;
    
    //td[.='Event Deleted']/following-sibling::td/button[.=' Send ']    Traversing from Title
    @FindBy(xpath="(//button[.=' Send '])[1]")private WebElement SendBtn;
    
    
	//Rule-2:- Create a constructor to initilise these elements
    
	public NotificationListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Rule-3:- Provide getters to access these variables
    
	public WebElement getSearchEdt() {
		return SearchEdt;
	}


	public WebElement getAddNotificationBtn() {
		return AddNotificationBtn;
	}


	public WebElement getViewBtn() {
		return ViewBtn;
	}


	public WebElement getEditBtn() {
		return EditBtn;
	}


	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}


	public WebElement getSendBtn() {
		return SendBtn;
	}
	

	// Rule-4 :- Create Business Library
	public void searchedInvalidNotification(String NotificationSearchValue) throws Exception
	{		
		SearchEdt.sendKeys(NotificationSearchValue);
	}
	
}
