import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.transform.ThreadInterrupt

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class Login {

	@BeforeTestCase
	def LoginPage(TestCaseContext testCaseContext) {
		WebUI.openBrowser("https://partners.shopify.com/728636/apps/23556390913/overview")
		WebUI.maximizeWindow()
		WebUI.refresh()
		WebUI.setText(findTestObject('Object Repository/LoginPage/input_Email'), GlobalVariable.Email)
		WebUI.click(findTestObject('Object Repository/LoginPage/button_ContinueWithEmail'))
		WebUI.setText(findTestObject('Object Repository/LoginPage/input_Password'),GlobalVariable.Password)
		WebUI.click(findTestObject('Object Repository/LoginPage/button_Login'))
		WebUI.click(findTestObject('Object Repository/HomePageShopify/selectStoreBtn'))
		WebUI.click(findTestObject('Object Repository/HomePageShopify/chosenStore'))
		WebUI.click(findTestObject('Object Repository/HomePageShopify/chosenAccount'))
		WebUI.click(findTestObject('Object Repository/HomePageShopify/chosenAccount'))
		Thread.sleep(1000);

	}
	

	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		WebUI.closeBrowser()
	}
}