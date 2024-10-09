package com.demoshop.page.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demoshop.utils.PageActions;

public class CheckOutPage extends PageActions{
private WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="removefromcart")
	private WebElement checkBox1;
	
	@FindBy(id="termsofservice")
	private WebElement checkBox2;
	
	@FindBy(id="checkout")
	private WebElement checkoutBtn;
	
	@FindBy(id="BillingNewAddress_CountryId")
	private WebElement countryDropdown;
	
	public void clickCheckBox() {
		clickElement(checkBox1);
		clickElement(checkBox2);
	}
	
	public boolean isBox1Checked() {
		boolean isChecked1=checkBox1.isSelected();
		return isChecked1;
	}
	public boolean isBox2Checked() {
		boolean isChecked2=checkBox2.isSelected();
		return isChecked2;
	}
	
	public void clickCheckOutBtn() {
		clickElement(checkoutBtn);
	}
	
	public void selectCountry() {
    Select country = new Select(countryDropdown);
    country.selectByIndex(1);
	}

}
