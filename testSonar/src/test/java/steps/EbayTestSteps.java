package steps;

import baseClass.baseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.EbayHomePage;

public class EbayTestSteps extends baseClass {
	EbayHomePage ebayHomePage;

	@Given("^Navigate to \"([^\"]*)\"$")
	public void navigate(String url) throws Throwable {
		launchWebsite(url);
		ebayHomePage = new EbayHomePage();
	}

	@When("^Search for \"([^\"]*)\"$")
	public void search_for(String valueToSearch) throws Throwable {
		ebayHomePage.enterSearchItem(valueToSearch);
		ebayHomePage.searchItem();
	}

	@When("^Click on the first bike item in the list$")
	public void click_on_the_first_bike_item_in_the_list() throws Throwable {
		ebayHomePage.selectFistItemInList();
	}

	@When("^Click on \"([^\"]*)\"$")
	public void click_on(String arg1) throws Throwable {
		ebayHomePage.addToCart();

	}

	@When("^Go to cart$")
	public void go_to_cart() throws Throwable {
		logger.info("Navigating to cart");

	}

	@Then("^Verify that the item is displayed in the cart$")
	public void verify_that_the_item_is_displayed_in_the_cart() throws Throwable {
		ebayHomePage.verifyItemSelected();
	}

	@When("^Click on ‘My Ebay’ located on the top right corner$")
	public void click_on_My_Ebay_located_on_the_top_right_corner() throws Throwable {
		ebayHomePage.clickOnMyEbayLink();
	}

	@When("^Leave the username or email blank$")
	public void leave_the_username_or_email_blank() throws Throwable {
		logger.info("Leaving the username field empty");
	}

	@When("^Click ‘Continue’$")
	public void click_Continue() throws Throwable {
		ebayHomePage.clickOnContinueButton();
	}

	@Then("^Verify the error message \"([^\"]*)\"$")
	public void verify_the_error_message_Oops_that_s_not_a_match(String errorMessage) throws Throwable {
		ebayHomePage.validateLoginError(errorMessage);
	}

}
