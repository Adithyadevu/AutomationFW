package com.demoshop.test;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.demoshop.context.DriverManager;
import com.demoshop.page.Objects.CartPage;
import com.demoshop.page.Objects.CheckOutPage;
import com.demoshop.page.Objects.JewelryPage;
import com.demoshop.page.Objects.LoginPage;
import com.demoshop.page.Objects.ProductPage;
import com.demoshop.page.Objects.ProductRemoveFromCart;
import com.demoshop.page.Objects.RegisterPage;
import com.demoshop.utils.TestProperties;

    public class BaseTest {  //parent class
    
    	WebDriver driver= null;
    	public Properties prop;
    	
       @BeforeMethod(alwaysRun=true)
       @Parameters({"browserName"})
    	public void initDriver(@Optional String browserName) throws IOException {
    	    prop = TestProperties.getProperties();
    	   System.out.println("In before Method");
    	   if(browserName==null || browserName.isEmpty()) {
    		 browserName = prop.getProperty("browser"); 
    	   }
    	   
    	   System.out.println(browserName);
    		getDriver(browserName);
    		DriverManager.setDriver(driver);
    		DriverManager.getDriver().manage().window().maximize();
    		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    		String url=prop.getProperty(prop.getProperty("environment"));
    		DriverManager.getDriver().get(url);
    		initPages();
    		
    	}
    	
    	public WebDriver getDriver(String browserName) {
    		if(browserName.equalsIgnoreCase("Chrome")) {
    			 driver = new ChromeDriver();
    		}
    		else if(browserName.equalsIgnoreCase("edge")) {
    			 driver = new EdgeDriver();
    		}
    		else if(browserName.equalsIgnoreCase("firefox")) {
    		 driver = new FirefoxDriver();
    		}
    		else {
    			System.out.println("Please chooose correct browser");
    		}
    		return driver;
    	}
    	
    	public LoginPage loginPage;
    	public RegisterPage registerPage;
    	public  ProductPage productPage;
    	public CartPage cartpage;
    	public ProductRemoveFromCart productremovefromcart;
    	public CheckOutPage checkoutpage;
    	public JewelryPage jewelrypage;
    	
    	public void initPages() {
    		loginPage= new LoginPage(driver);
    	    registerPage = new RegisterPage(driver);
    	    productPage = new ProductPage(driver);
    	    cartpage=new CartPage(driver);
    	    productremovefromcart = new ProductRemoveFromCart(driver);
    	    checkoutpage = new CheckOutPage(driver);
    	    jewelrypage = new  JewelryPage(driver);
    	    
    	    }
    	
    	@AfterMethod(alwaysRun=true)
    	public void tearDown() {
    		DriverManager.getDriver().quit();
    	}
    	

    }
   
	