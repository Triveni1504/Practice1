package Sprint_6_Negative;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtility.ExcelFileUtility;
import genericUtility.FMS_BaseClass;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.DashboardPage;
import objectRepository.NotificationListPage;

@Listeners(genericUtility.ListnersImplementationClass.class)
public class d_NotificationAllActions extends FMS_BaseClass {

	ExcelFileUtility eUtil = new ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	JavaUtility jUtil = new JavaUtility();
	
	@Test
	public void notificationsTest() throws Exception
	{
		String NotificationSearchValue = eUtil.readDataFromExcel("Sprint-6 Negative", 6, 1);
		
		Thread.sleep(5000);
		DashboardPage dPage = new DashboardPage(driver);
		dPage.getNotificationLnk().click();
		Thread.sleep(1000);
		NotificationListPage nlPage = new NotificationListPage(driver);
		nlPage.searchedInvalidNotification(NotificationSearchValue);
		WebDriverUtility wUtil = new WebDriverUtility();
		
		WebElement NoRecordsFoundMsg = driver.findElement(By.xpath("//h5[.='No records found']"));
		
		if(NoRecordsFoundMsg.isDisplayed())
		{
			wUtil.takeScreenShot(driver, "a_Searched Invalid Notification Error");
		}
	}
	
}
