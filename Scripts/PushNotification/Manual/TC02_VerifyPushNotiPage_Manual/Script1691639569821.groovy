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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.click(findTestObject('Object Repository/PushNotificationPage/ButtonPushNotification'))

CustomKeywords.'generics.ifamesPage.switchToAppIframe'()

Thread.sleep(1000)

try {
    WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/TabManual/TitleNotification')), 'Push notifications', true)
    WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/TabManual/tabManual')), 'Manual', true)
    WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/TabManual/Status')), 'Status', true)
    WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/TabManual/Sort')), 'Sort by Newest created', true)
    WebUI.verifyElementClickable(findTestObject('Object Repository/PushNotificationPage/ButtonCreatePushNotification'))
}
catch (Exception e) {
    WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/TabManual/TitleNotification')), 'Push notifications', true)
    WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/TabManual/tabManual')), 'Manual', true)
    WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/TabManual/Status')), 'Status', true)
    WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/TabManual/Sort')), 'Sort by Newest created', true)
	WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/TabManual/DescNotification1')), 'No manual notifications yet', true)
	WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/PushNotificationPage/TabManual/DescNotification2')), "Improving engagement, retention, and conversion rates is just one step away. Let's create a push notification.", true)
	WebUI.verifyElementClickable(findTestObject('Object Repository/PushNotificationPage/ButtonCreatePushNotification'))
}