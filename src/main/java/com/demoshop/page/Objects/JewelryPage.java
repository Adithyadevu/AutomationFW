package com.demoshop.page.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;

public class JewelryPage extends PageActions {
	
private WebDriver driver;
	
	public JewelryPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
		
	}

	
	@FindBy(css=".product-title")
	private WebElement jewelrychain;
	
	@FindBy(css=".product-name")
	private WebElement producttitle;
	
	@FindBy(name="product_attribute_71_10_16")
	private WebElement lengthcm;
	
	
	@FindBy(id="add-to-cart-button-71")
	private WebElement addtocart;
	
	@FindBy(css=".content")
	private WebElement msgConfirmation;
	
	
	
	
	
	
	
	public void selectjewelrychain() {
		clickElement(jewelrychain);
	}
	
	public String getproducttitle(){
		return getElementText(producttitle);
		
	}
	
	public  void addLengthCm(String len) {
		setTextBox(lengthcm, len);
	}
	public void addcartchain() {
		clickElement(addtocart);
	}
   public String getmsgconfirmation() {
	   return getElementText(msgConfirmation);
	   
   }


}
