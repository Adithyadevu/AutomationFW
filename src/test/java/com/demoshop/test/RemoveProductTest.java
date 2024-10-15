package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.page.Objects.CartPage;

public class RemoveProductTest extends BaseTest {
	@Test
	public void verifyProductIsRemovedFromCart() {
		
		loginPage.searchProduct(prop.getProperty("productToSearch"));
		
		cartpage.viewLaptop();
		
		cartpage.addProductToCart();
		
		cartpage.navigateToCart();
		
		checkoutpage.clickCheckBox();
		
		productremovefromcart.removeProduct();
		String cartMsg = productremovefromcart.emptyCartMessage();
		Assert.assertEquals(cartMsg, prop.getProperty("emptyCartMsg"), "product not removed");
		  
		}
	}
		
	
		
