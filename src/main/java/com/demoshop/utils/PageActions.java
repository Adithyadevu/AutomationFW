package com.demoshop.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoshop.context.Constants;
import com.demoshop.context.DriverManager;

public class PageActions {
	private WebDriver driver;
	public PageActions(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void clickElement(WebElement element) {
		WaitUtils.waitUntilVisible(element, driver);
		WaitUtils.waitUntilClickable(element, driver);
		element.click();
	}
	
	public void setTextBox(WebElement element, String value) {
		WaitUtils.waitUntilVisible(element, driver);
		WaitUtils.waitUntilClickable(element, driver);
		element.sendKeys(value);
	}
	
	public String getElementText(WebElement element) {
		WaitUtils.waitUntilVisible(element, driver);
		return element.getText();
	}
	
	public void handleStaticDrowpdown(WebElement dropdown, String visibleText) {
	  Select select = new Select(dropdown);
	  select.selectByVisibleText(visibleText);
	}
	

	
	public List<String> getElementTextList(List<WebElement> listofElements) {
		
		List<String> textList = new ArrayList<>();
		for(WebElement element : listofElements) {
			textList.add(getElementText(element));
		}
	 return textList;
	}
	
	public static String getScreenShot(String testName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)DriverManager .getDriver();
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath=Constants.WORKINGDIRECTORY+ "\\screenshot\\"+testName+UniqueGenerator.getCurrentDateTime()+".png";
		File destFile = new File(screenshotPath);
		FileUtils.moveFile(srcFile, destFile);
		return screenshotPath;
	}
}

