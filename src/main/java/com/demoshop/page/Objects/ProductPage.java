package com.demoshop.page.Objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;

public class ProductPage extends PageActions {
private WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);                                          
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".product-title a")
	private List<WebElement> productList;//text containing diamond
	
	public List<String> getSearchedProductList() {
		return getElementTextList(productList);
	}

}
