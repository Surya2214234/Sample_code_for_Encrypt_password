package simplePackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Samplecodesecretkey{

	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement UserNameField;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement PasswordField;
	
	@FindBy(css = "button[type='submit']")
	WebElement login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

public void EnterLoginCredential() throws Exception {
	
	String Username = PropertiesOperation.getPropertyValuebyKey("username");
	String Password = PropertiesOperation.getPropertyValuebyKey("password");
	
	UserNameField.sendKeys(AESEncryption.decrypt(Username));
	PasswordField.sendKeys(AESEncryption.decrypt(Password));
	login.click();
}
}
