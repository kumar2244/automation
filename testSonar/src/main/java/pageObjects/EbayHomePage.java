package pageObjects;


import static org.junit.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class EbayHomePage extends baseClass{

	public EbayHomePage() {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gh-ac")
	WebElement searchBoxHomePage;
	
	@FindBy(id = "gh-btn")
	WebElement searchButton;
	
	/*
	 * @FindBy(xpath = "//*[@id=\"ui-id-1\"]/li") List<WebElement> autoDropdownList;
	 */
	
	@FindBy(xpath = "//*[@id=\"srp-river-results\"]/ul/li/div/div[2]/a/h3")
	List<WebElement> itemList;
	
	@FindBy(id = "isCartBtn_btn")
	WebElement addToCart;
	
	@FindBy(xpath = "//*[@id=\"ADDON_0\"]/div/div[2]/div/div[4]/div/button[1]")
	WebElement noThanksButton;
	
	@FindBy(xpath = "//*[@id=\"mainContent\"]//h3/span/a/span/span")
	WebElement cartItem;
	
	@FindBy(xpath = "//*[@id=\"gh-eb-My\"]/div/a[1]")
	WebElement myEbayLink;
	
	@FindBy(id = "signin-continue-btn")
	WebElement continueButton;
	
	@FindBy(id = "signin-error-msg")
	WebElement loginErrorMessage;
	
	String bikeName;
	
	public void enterSearchItem(String valueToSearch) {
		logger.info("Searching for "+valueToSearch + " in the search box");
		searchBoxHomePage.sendKeys(valueToSearch);
	}
	
	public void searchItem() {
		logger.info("Clicking on the Search button");
		searchButton.click();
	}

	public void selectFistItemInList() {
		bikeName= itemList.get(0).getText();
		logger.info("Selecting first item from the list");
		logger.info("Bike name: "+ bikeName);
		itemList.get(0).click();
	}
	
	public void addToCart() {
		logger.info("Add to cart");
		addToCart.click();
		noThanksButton.click();
	}
	
	public void verifyItemSelected() {
		logger.info("Product name in cart: "+cartItem.getText());
		assertEquals("The Cart item does not match the selected bike",cartItem.getText(), bikeName);  // validating selected item in the cart
	}
	
	public void clickOnMyEbayLink() {
		logger.info("Clicking on My ebay link");
		myEbayLink.click();
	}
	
	public void clickOnContinueButton() {
		logger.info("Clicking on continue button");
		continueButton.click();
	}
	
	public void validateLoginError(String errorMessage) {
		logger.info("ErrorMessage on login page: "+loginErrorMessage.getText());
		assertEquals("The error message does not match", errorMessage, loginErrorMessage.getText());
	}
}
