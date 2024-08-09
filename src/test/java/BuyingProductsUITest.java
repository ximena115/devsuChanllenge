import org.testng.annotations.Test;
import ui.pages.CheckoutPage;
import ui.pages.ShoppingCartPage;
import ui.pages.SuccessOrderPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BuyingProductsUITest extends BaseUItest {

    @Test
    public void buyingProductsTest() {
        homePage.chooseProducts();
        assertTrue(homePage.getAddedMessage().contains("Success: You have added"),"The product was not added correctly");

        ShoppingCartPage shoppingCartPage = homePage.goToShoppingCart();
        assertEquals(shoppingCartPage.getCurrentUrl(),"https://opencart.abstracta.us/index.php?route=checkout/cart");

        CheckoutPage checkoutPage = shoppingCartPage.goToCheckoutPage();
        assertEquals(checkoutPage.getCurrentUrl(),"https://opencart.abstracta.us/index.php?route=checkout/checkout");

        checkoutPage.selectGuestOption();
        checkoutPage.fillRequiredDetails();
        SuccessOrderPage successOrderPage =  checkoutPage.confirmOrder();
        assertTrue(successOrderPage.orderInPlaceMessage().contains("Your order has been placed!"),"order not Processed");
    }
}
