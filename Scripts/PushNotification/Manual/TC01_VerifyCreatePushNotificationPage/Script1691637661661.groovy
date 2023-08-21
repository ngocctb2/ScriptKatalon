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

WebUI.click(findTestObject('Object Repository/PushNotificationPage/ButtonPushNotification'))

CustomKeywords.'generics.ifamesPage.switchToAppIframe'()
Thread.sleep(10000)
WebUI.click(findTestObject('Object Repository/PushNotificationPage/ButtonCreatePushNotification'))
WebUI.click(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/titleCreatePushNotification'))

WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/titleCreatePushNotification')), 'Create push notification', true)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/titleManual')), 'Manual', true)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/titleNew')), 'New', true)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/desOptionNew')), 'Create personalized notifications from scratch and send them out as needed.', true)

WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/titleAutomation')), 'Automated', true)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/titleWelcomeOffer')), 'Welcome offer', true)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/desWelcomeOffer')), 'Send engaging messages to new customers when they first sign up.', true)

WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/titleAbandonedCart')), 'Abandoned cart', true)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/desAbandonedCart')), 'Increase potential sales by reminding customers of their abandoned carts.', true)

WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/titleInactiveUser')), 'Inactive user', true)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/desInactivateUser')), "Re-engage your customers who haven't used app in a long time.", true)

