package commonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil{
	/*ProjectName: Primus Bank
	 *Module Name: Admin Module
	 *TesterName: Vineeth
	 *Creation Date:1/25/2023
	 */
	//method for login
	public static boolean adminLogin(String user,String pass)
	{
		driver.findElement(By.xpath(conpro.getProperty("ObjUser"))).sendKeys(user);
		driver.findElement(By.xpath(conpro.getProperty("Objpass"))).sendKeys(pass);
		driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).click();
		String Expected = "adminflow";
		String Actual = driver.getCurrentUrl();
		if(Actual.toLowerCase().contains(Expected.toLowerCase()))
		{
			Reporter.log("Login Success::"+Expected+"     "+Actual,true);
			return true;
		}
		else
		{
			Reporter.log("Login fail::"+Expected+"     "+Actual,true);
			return false;
		}
	}
	//method for click branches button
	public static void clickBranches()
	{
		driver.findElement(By.xpath(conpro.getProperty("objBranches"))).click();
	}
	//method for branch creation
	public static boolean branchCreation(String Branchname,String Address1,String Address2,String Address3,String Area,String zipcode,String country,String state,String city) throws Throwable
	{
		driver.findElement(By.xpath(conpro.getProperty("ObjNewBranch"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjBranchName"))).sendKeys(Branchname);
		driver.findElement(By.xpath(conpro.getProperty("ObjAddress1"))).sendKeys(Address1);
		driver.findElement(By.xpath(conpro.getProperty("ObjAddress2"))).sendKeys(Address2);
		driver.findElement(By.xpath(conpro.getProperty("ObjAddress3"))).sendKeys(Address3);
		driver.findElement(By.xpath(conpro.getProperty("ObjArea"))).sendKeys(Area);
		driver.findElement(By.xpath(conpro.getProperty("ObjZipcode"))).sendKeys(zipcode);
		new Select(driver.findElement(By.xpath(conpro.getProperty("ObjCountry")))).selectByVisibleText(country);
		new Select(driver.findElement(By.xpath(conpro.getProperty("ObjState")))).selectByVisibleText(state);
		new Select(driver.findElement(By.xpath(conpro.getProperty("ObjCity")))).selectByVisibleText(city);
		driver.findElement(By.xpath(conpro.getProperty("ObjSubmitButton"))).click();
		//capture Alert message
		String Expected_Alert = driver.switchTo().alert().getText();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		String Actual_Alert ="New Branch with id";
		if(Expected_Alert.toLowerCase().contains(Actual_Alert.toLowerCase()))
		{
			Reporter.log(Expected_Alert,true);
			return true;
		}
		else
		{
			Reporter.log("New Branch Creation Fail",true);
			return false;
		}
	}
	//method for branch updation
	public static boolean branchUpdation(String BranchName,String Address1,String Area,String zipcode) throws Throwable
	{
		driver.findElement(By.xpath(conpro.getProperty("ObjEdit"))).click();
		WebElement element1=driver.findElement(By.xpath(conpro.getProperty("ObjBranch")));
		element1.clear();
		element1.sendKeys(BranchName);
		WebElement element2=driver.findElement(By.xpath(conpro.getProperty("ObjAddress")));
		element2.clear();
		element2.sendKeys(Address1);
		WebElement element3=driver.findElement(By.xpath(conpro.getProperty("ObjArea1")));
		element3.clear();
		element3.sendKeys(Area);
		WebElement element4=driver.findElement(By.xpath(conpro.getProperty("ObjZip")));
		element4.clear();
		element4.sendKeys(zipcode);
		driver.findElement(By.xpath(conpro.getProperty("ObjUpdatebutton"))).click();
		String Exp_Alert = driver.switchTo().alert().getText();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		String Act_Alert = "Branch updated";
		if(Exp_Alert.toLowerCase().contains(Act_Alert))
		{
			Reporter.log(Exp_Alert,true);
			return true;
		}
		else
		{
			Reporter.log("unable to update Branch",true);
			return false;
		}
	}
	//method for logout
	public static boolean adminLogout()
	{
		driver.findElement(By.xpath(conpro.getProperty("ObjLogout"))).click();
		if(driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).isDisplayed())
		{
			Reporter.log("Logout Success::",true);
			return true;
		}
		else
		{
			Reporter.log("Logout Fail::",true);
			return false;
		}
	}
}








