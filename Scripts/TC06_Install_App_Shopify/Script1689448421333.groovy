import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.ui.SystemOutputInterceptor
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser("https://partners.shopify.com/728636/stores/new?store_type=test_store&data_type=static_data")
WebUI.maximizeWindow()
WebUI.refresh()
WebUI.setText(findTestObject('Object Repository/LoginPage/input_Email'), 'qc-test01@firegroup.io')
WebUI.click(findTestObject('Object Repository/LoginPage/button_ContinueWithEmail'))
WebUI.setText(findTestObject('Object Repository/LoginPage/input_Password'),'trinh250899')
WebUI.click(findTestObject('Object Repository/LoginPage/button_Login'))
WebUI.click(findTestObject("Object Repository/CreateStorePage/radio_CreateAStoreToTestAndBuild"))

//Set random store name
Random rand = new Random()
int randomNumber = rand.nextInt(10000) 
System.out.println(randomNumber)
String existingString = "ngoc-test"
TestObject textField = findTestObject('Object Repository/CreateStorePage/input_StoreName')
WebUI.setText(textField, String.valueOf(existingString + randomNumber))
WebUI.delay(5)
WebUI.click(findTestObject("Object Repository/CreateStorePage/button_CreateDevelopmentStore"))
WebUI.delay(15)

//Open new tab on chrome
int currentTab = WebUI.getWindowIndex()
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor js = ((driver) as JavascriptExecutor)
js.executeScript('window.open();')
WebUI.switchToWindowIndex(currentTab + 1)

WebUI.navigateToUrl('https://alireviews-fe.onecommerce.io/install')
WebUI.setText(findTestObject("Object Repository/AliReviewPage/Input_StoreName"),String.valueOf(existingString + randomNumber))
WebUI.click(findTestObject("Object Repository/AliReviewPage/button_Login"))

//if(WebUI.verifyElementVisible(findTestObject('Object Repository/AliReviewPage/button_ChooseAnAccount')))
//{
//	WebUI.click(findTestObject('Object Repository/AliReviewPage/button_ChooseAnAccount'))
//}
//else 
//	WebUI.back()
//	WebUI.click(findTestObject("Object Repository/AliReviewPage/button_Login"))
////		
//WebUI.delay(5)
WebUI.click(findTestObject("Object Repository/AliReviewPage/button_InstallApp"))
WebUI.waitForElementClickable(findTestObject("Object Repository/AliReviewPage/text_Ali Reviews - Product Reviews"), 15)
WebUI.takeScreenshot()
WebUI.closeBrowser()

