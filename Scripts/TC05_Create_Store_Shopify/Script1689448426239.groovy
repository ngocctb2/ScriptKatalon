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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

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
int randomNumber = rand.nextInt(1000) 
String existingString = "ngoc-test"
TestObject textField = findTestObject('Object Repository/CreateStorePage/input_StoreName')
WebUI.setText(textField, String.valueOf(existingString + randomNumber))

WebUI.delay(5)
WebUI.click(findTestObject("Object Repository/CreateStorePage/button_CreateDevelopmentStore"))
WebUI.verifyEqual(WebUI.getText(findTestObject("Object Repository/CreateStorePage/input_StoreCreated")),String.valueOf(existingString + randomNumber))
WebUI.closeBrowser()
