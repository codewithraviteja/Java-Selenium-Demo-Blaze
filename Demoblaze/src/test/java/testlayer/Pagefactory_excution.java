package testlayer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;
import pagelayer.Pagefactory_withpom;
import pagelayer.ProductsPagefactory_withpom;
import pagelayer.CartPagefactory_withpom;
import pagelayer.CategoriesPagefactory_withpom;
import pagelayer.ContactPagefactory_withpom;
import pagelayer.MenuPagefactory_withpom;

public class Pagefactory_excution {
	
	//with page factory
	public static void main(String[]args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		//driver.get("https://demoblaze.com/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		Pagefactory_withpom homepag = new Pagefactory_withpom(driver);
		
		MenuPagefactory_withpom menuchek = new MenuPagefactory_withpom(driver);
		
		CategoriesPagefactory_withpom categories = new CategoriesPagefactory_withpom(driver);
		
		ProductsPagefactory_withpom productsadd = new ProductsPagefactory_withpom(driver);
		
		CartPagefactory_withpom cartsection = new CartPagefactory_withpom(driver);
		
		ContactPagefactory_withpom verifycontact = new ContactPagefactory_withpom(driver);
		
		driver.get("https://demoblaze.com");
		Thread.sleep(3000);
		System.out.println("-----Navigated to the website----");
//		menu and login Functionality
		menuchek.homebutton();
		Thread.sleep(3000);
		System.out.println("-----home button clicked----");
		menuchek.contact();
		Thread.sleep(2000);
		System.out.println("-----contact button clicked----");
		verifycontact.sendmessagebutton();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
//		menuchek.contactclose();
		Thread.sleep(2000);
		menuchek.aboutus();
		Thread.sleep(2000);
		System.out.println("-----about us button clicked----");
		menuchek.aboutusclose();
		Thread.sleep(2000);
		menuchek.signup();
		System.out.println("-----signup button clicked----");
		Thread.sleep(2000);
		menuchek.signupclose();
		homepag.loginlink();
		System.out.println("-----login button clicked----");
		Thread.sleep(2000);
		homepag.verifyusername();
		System.out.println("-----Username entered----");
		Thread.sleep(1000);
		homepag.verifypassword();
		System.out.println("-----password entered----");
		homepag.loginbutton();
		
		//Categories Functionailty
		Thread.sleep(3000);
		categories.notebook();
		System.out.println("-----Notebook category clicked----");
		Thread.sleep(2000);
		categories.monitor();
		System.out.println("-----monitor category clicked----");
		Thread.sleep(2000);
		categories.phone();
		System.out.println("-----phone category clicked----");
		Thread.sleep(1000);
		
		//Products add 
		
		driver.get("https://www.demoblaze.com/prod.html?idp_=1");
		Thread.sleep(2000);
		productsadd.addtocartbutton();
		Thread.sleep(2000);
        String alertMsg1 = driver.switchTo().alert().getText();
        System.out.println("-----item status for product 1 is : " + alertMsg1 + "-----");
        driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.get("https://www.demoblaze.com/prod.html?idp_=2");
		Thread.sleep(2000);
		productsadd.addtocartbutton();
		Thread.sleep(2000);
        String alertMsg2 = driver.switchTo().alert().getText();
        System.out.println("-----item status for product 2 is : " + alertMsg2 + "-----");
        driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.get("https://www.demoblaze.com/prod.html?idp_=3");
		Thread.sleep(2000);
		productsadd.addtocartbutton();
		Thread.sleep(2000);
        String alertMsg3 = driver.switchTo().alert().getText();
        System.out.println("-----item status for product 3 is : " + alertMsg3 + "-----");
        driver.switchTo().alert().accept();
        
        // Cart Page
        
        cartsection.clickcartpage();
        
        Thread.sleep(1000);
        cartsection.placeorderbutton();
        
        Thread.sleep(1000);
        cartsection.nameTxtElement();

        Thread.sleep(1000);
        cartsection.countryTxtElement();

        Thread.sleep(1000);
        cartsection.cityTxtElement();

        Thread.sleep(1000);
        cartsection.cardTxtElement();

        Thread.sleep(1000);
        cartsection.monthElement();

        Thread.sleep(1000);
        cartsection.yearTxtElement();
        Thread.sleep(1000);
        cartsection.purchaseBtnElement();
        Thread.sleep(1000);
        cartsection.thanksMsgElement();
        Thread.sleep(1000);
        cartsection.okBtnElement();
}
}
