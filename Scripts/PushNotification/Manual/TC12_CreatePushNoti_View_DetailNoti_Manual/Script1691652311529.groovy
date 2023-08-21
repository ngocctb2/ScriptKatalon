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
WebUI.click(findTestObject('Object Repository/PushNotificationPage/ButtonCreatePushNotification'))
Thread.sleep(5000)

WebUI.click(findTestObject('Object Repository/PushNotificationPage/CreatePushNotification/titleNew'))
Thread.sleep(1000)

WebUI.click(findTestObject('Object Repository/PushNotificationPage/TabManual/titlePushNotification'))
WebUI.sendKeys(findTestObject('Object Repository/PushNotificationPage/TabManual/titlePushNotification'), "Flash sale 80%")
WebUI.click(findTestObject('Object Repository/PushNotificationPage/TabManual/messageNotification'))
WebUI.sendKeys(findTestObject('Object Repository/PushNotificationPage/TabManual/messageNotification'), "STARTS NOW 80% OFF EVERYTHING!")

CustomKeywords.'generics.uploadImage.uploadImageNoti'()


WebUI.click(findTestObject('Object Repository/PushNotificationPage/TabManual/sendButton'))
Thread.sleep(1000)

WebUI.click(findTestObject('Object Repository/PushNotificationPage/TabManual/NotiDetail'))
Thread.sleep(1000)

//Check User đã upgrade pricing chưa
//try {
//	WebUI.click(findTestObject('Object Repository/PushNotificationPage/TabManual/buttonSendNotification'))
//	Thread.sleep(1000)
//}
//catch (Exception e){
//	println("Chưa upgrade lên Starter");}


WebUI.verifyEqual(findTestObject('Object Repository/PushNotificationPage/TabManual/title_Noti1'), 'Flash sale 80%')
WebUI.verifyEqual(findTestObject('Object Repository/PushNotificationPage/TabManual/message_Noti1'), 'STARTS NOW 80% OFF EVERYTHING!')