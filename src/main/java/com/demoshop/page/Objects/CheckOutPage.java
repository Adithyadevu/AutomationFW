package com.demoshop.page.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.BillingUtils;
import com.demoshop.utils.PageActions;
import com.demoshop.utils.WaitUtils;

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
	
	
	@FindBy(css=".page-title")				// checkout page title
	private WebElement checkOutHeading;
	
	
	@FindBy(id="BillingNewAddress_CountryId")    //dropdown
	private WebElement countryDropdown;
	
	
	@FindBy(id="BillingNewAddress_City")
	private WebElement cityaddress;                //enter the city
	
	
	@FindBy(id="BillingNewAddress_Address1")   
	private WebElement address1;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")   
	private WebElement postalcode;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")   
	private WebElement phonenum;
	
	@FindBy(css=".button-1.new-address-next-step-button")   
	private WebElement continuebtn;
	
	@FindBy(css="#checkout-step-shipping [title='Continue']")
	private WebElement shippingBtncontinue;
	
	@FindBy(css=".button-1.shipping-method-next-step-button")
	private WebElement continueBtnPayment;
	
	@FindBy(css="#payment-method-buttons-container [value='Continue']")
	private WebElement modeOfPaymentBtnContinue;
	
	@FindBy(css=".button-1.payment-info-next-step-button")
	private WebElement paymentContinue;
	
	@FindBy(css="#confirm-order-buttons-container .button-1.confirm-order-next-step-button")
	private WebElement orderConfirm;
	
	
	@FindBy(css=".section.order-completed strong")
	private WebElement textOfOrderPlaced;
	
	
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
	
	public String checkOutTitle() {
		return getElementText(checkOutHeading);
	}
	
	
	
	public void selectCountry() {
	handleStaticDrowpdown(countryDropdown, "United States" );
	}

	public void detailsConfirmationOfOrder() {
		handleStaticDrowpdown(countryDropdown, "United States");
		
		setTextBox(cityaddress, BillingUtils.getNameCity());
		
		setTextBox(address1, BillingUtils.getAddress());
		
		setTextBox(postalcode,BillingUtils.getPostalcode());
		
		setTextBox(phonenum,BillingUtils.getPhoneNo());
		
		clickElement(continuebtn);
		
		clickElement(shippingBtncontinue);
		
		clickElement(continueBtnPayment);
		
		clickElement(modeOfPaymentBtnContinue);
		
	    WaitUtils.waitUntilClickable(paymentContinue, driver);
	    
	     clickElement(paymentContinue);
	     
	     clickElement(orderConfirm);
	
	}
	
	public String orderPlacedMsg() {
		return getElementText(textOfOrderPlaced);
	}
}
