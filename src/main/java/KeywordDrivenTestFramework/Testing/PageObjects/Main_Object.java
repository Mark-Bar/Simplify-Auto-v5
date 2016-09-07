/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Testing.PageObjects;

import KeywordDrivenTestFramework.Core.BaseClass;

/**
 *
 * @author Abongile Bonga Maso
 */
public class Main_Object extends BaseClass {

    public static String NavigateToSpreeUrl() {
        return currentEnvironment.SpreeURL;
    }

    public static String NewsletterImage() {
        return "//*[@src='http://stage.spreeza.net/skin/frontend/site/spree-blackwhite/images/general/modal-heading.png']";
    }

    public static String CloseNewLetter() {
        return "//*[@alt='X']";
    }

    public static String ParentMenuNewXpath() {
        return "//*[@id='menu']/ul/li/a[text()='NEW']";
    }

    public static String IEParrentMenuXpatth() {
        return "//*[@id='menu']/ul/li[1]/a";
    }

    public static String SubCatergoryClothingXpath() {
        return "//*[@class='menu_item parent new']//ul//ul[@data-menu='WOMEN']/li/a[text()='Clothing']";
    }

    public static String ActiveWearXpath() {
        return "//*[@class='block-content filter']/dl/dd/ol/li[4]/a[text()='Activewear']";
    }

    public static String FoortwearXpath() {
        return "//*[text()='Footwear']";
    }

    public static String CasualSneaker() {
        return "//*[text()='Erke Tennis Shoes Pale Grey']";
    }

    public static String SizeXpath() {
        return "//*[text()='5']";
    }

    public static String AddToCartButtonXpath() {
        return "//*[text()='Add to cart']";
    }

    public static String CartValueXpath() {
        return "//*[@id='cart-header-flyout']/a/span";
    }

    //TC3
    public static String CartLinkHeader() {
        return "//*[@id='cart-header-flyout']/a/i";
    }

    public static String CartItemsXpath() {
        return "//*[@class='cart-product-image']/a/img";
    }

    //customer details 
    public static String CustomerNameXpath() {
        return "//*[@class='customer-name']/label[1]/input";
    }

    public static String CustomerSurnameXpath() {
        return "//*[@class='customer-name']/label[2]/input";
    }

    public static String CutomerEmailXpath() {
        return "//*[@for ='email_address']/input";
    }

    public static String DateOfBirthXpath(int day) {
        return "//*[@class='input-box customer-dob']/span[" + day + "]/input";
    }

    public static String GenderMaleRadioButtonXpath() {
        return "//*[@class='input-box gender-box']/input[1]";
    }

    public static String PasswordTextboxXpath() {
        return "//*[@for='password']/input";
    }

    public static String ConfirmPasswordTextBoxXpath() {
        return "//*[@for='confirmation']/input";
    }

    public static String AllCheckBoxXpath() {
        return "//*[@class='sub-cont newsletter-selection']/label[1]/input";
    }

    public static String RegsterCustomerXpath() {
        return "//*[@name='submit-register']";
    }

    public static String NewUserXpath() {
        return "//*[@class='icon-account']/../span";
    }

    //TC4
    public static String CheckOutButtonXpath() {
        return "//*[text()='Checkout']";
    }

    public static String AddShippingAddressXpath() {
        return "//*[text()='Add shipping address']";
    }

    public static String FieldNameXpath(int number) {
        return "//*[@class='floaters']/div[" + number + "]/input";
    }

    public static String StreetAddressXpath(int number) {
        return "//*[@class='floaters']/div[" + number + "]/input[4]";
    }

    public static String SaveButtonXpath() {
        return "//*[text()='Save']";
    }

    public static String StreetAddressDropDownXpath() {
        return "//*[text()='Street Address']/../../div[6]/input";
    }

    public static String DoorToDoorRadioButtonXpath() {
        return "//*[text()='Door to Door - FREE']/../i";
    }

    public static String SelectPaymentMethodXppath() {
        return "//*[text()='Select Payment Method']";
    }

    public static String DebitCreditCardXpath() {
        return "//*[text()='Debit/Credit Card']";
    }

    public static String CardFieldXpath(int num) {
        return "//*[@class='floaters cf']/div[" + num + "]/input[1]";
    }

    public static String CardFieldExpireDate(int num) {
        return "//*[@class='floaters cf']/div[3]/input[" + num + "]";
    }

    public static String ExpireDateXpath() {
        return "//*[text()='Expiry Date']";
    }

    public static String ManualEFTXpath() {
        return "//*[text()='Manual EFT']";
    }

    public static String SelectManuelEft() {
        return "//*[text()='Select Manual EFT']";
    }

    public static String PlaceOrderNowXpath() {
        return "//*[text()='Place Order Now']";
    }

    public static String ProofOfPaymentsHeaderXpath(int Num1) {
        return "//*[text()='FNB']/../../tr[" + Num1 + "]/td[1]";
    }

    public static String ProofOfPaymentsContentXpath(int Num1) {
        return "//*[text()='FNB']/../../tr[" + Num1 + "]/td[2]";
    }

    public static String MyOrdersXpath() {
        return "//*[text()='My Orders']";
    }

    public static String OrderHeadingXpath(int num) {
        return "//*[@class='order-history']/thead/tr/th[" + num + "]";
    }

    public static String OrderContent(int Num) {
        return "//*[@class='order-history']/tbody/tr/td[" + Num + "]";
    }

    //vaalidate login page 
    public static String LogoutXpath() {
        return "//*[text()='Logout']";
    }

    public static String UsernameEmailXpath() {
        return "//*[@for='email-login']/input";
    }

    public static String PasswordXpath() {
        return "//*[@for='password-login']/input";
    }

    public static String LoginButtonXpath() {
        return "//*[@value='Login']";
    }

    public static String EmailMessage() {
        return "//*[@for='email-login']/div";
    }

    public static String passwordMessage() {
        return "//*[@for='password-login']/div";
    }

    public static String SnapScanXpath() {
        return "//*[text()='SnapScan']";
    }

    public static String SelectSnaooScanXpath() {
        return "//*[text()='Select SnapScan']";
    }

}
