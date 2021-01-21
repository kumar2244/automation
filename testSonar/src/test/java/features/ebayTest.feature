Feature: Test ebay 
	Validate cart and login errors
	
@uiTest 
Scenario: Verify item added to cart is displayed in the cart 
	Given Navigate to "https://ebay.com.au" 
	When Search for "bike" 
	And Click on the first bike item in the list 
	And Click on "Add to cart" 
	And Go to cart 
	Then Verify that the item is displayed in the cart 
	
@uiTest 
Scenario: Verify error messages when logging in without username or password 
	Given Navigate to "https://ebay.com.au" 
	When Click on ‘My Ebay’ located on the top right corner 
	And Leave the username or email blank 
	And Click ‘Continue’ 
	Then Verify the error message "Oops, that's not a match." 
	
	
	
	
	
	
