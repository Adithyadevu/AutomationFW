package com.demoshop.page.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;
import com.demoshop.utils.WaitUtils;

public class ProductRemoveFromCart extends PageActions {


	private WebDriver driver;
	  
	  public ProductRemoveFromCart(WebDriver driver) {
	    super(driver);
	    this.driver= driver;
	    PageFactory.initElements(driver, this);
	    
	  }

	     @FindBy(css=".cart-label")
	     private WebElement goToCart;

	     @FindBy(name="removefromcart")      
	    private WebElement checkBox1;
	  
	    @FindBy(name="updatecart")
	    private WebElement updateCart;      
	  
	    @FindBy(css=".order-summary-content")
	    private WebElement cartMsg;  
	  
		
		public void removeProduct() {
		    clickElement(goToCart);
		    clickElement(checkBox1);
		    clickElement(updateCart);
		    }
		  
		  public String emptyCartMessage() {
		    WaitUtils.waitUntilVisible(cartMsg, driver);
		    return getElementText(cartMsg);
		  }	
		
	
}
