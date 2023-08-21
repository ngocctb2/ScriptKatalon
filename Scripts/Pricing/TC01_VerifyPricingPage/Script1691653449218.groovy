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
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.apache.commons.lang3.StringUtils as StringUtils

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.usermodel.*
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By

WebUI.click(findTestObject('Object Repository/PricingPage/buttonPricing'))
Thread.sleep(1000)
CustomKeywords.'generics.ifamesPage.switchToAppIframe'()

WebUI.click(findTestObject('Object Repository/PricingPage/buttonShowAllFeatures'))
Thread.sleep(2000)
// Find the table element
WebDriver driver = DriverFactory.getWebDriver()
WebElement table = driver.findElement(By.xpath("//table"))

// Find all rows in the table
List<WebElement> rows = table.findElements(By.tagName("tr"))

// Create a new Excel workbook and sheet
Workbook workbook = new XSSFWorkbook()
Sheet sheet = workbook.createSheet("Table Data")

int rowNum = 0

for (WebElement row : rows) {
	Row excelRow = sheet.createRow(rowNum)
	List<WebElement> cells = row.findElements(By.tagName("td"))

	int cellNum = 0

	for (WebElement cell : cells) {
		String cellText = cell.getText()

		// If cell is empty or blank, set it to "TRUE"
		if (cellText.trim().isEmpty()) {
			cellText = "TRUE"
		}

		Cell excelCell = excelRow.createCell(cellNum)
		excelCell.setCellValue(cellText)
		cellNum++
	}

	rowNum++
}

// Define the Excel file path
String excelFilePath = "C:/Users/ngocctb1/git/ScriptKatalon/Data Files/Pricing.xlsx"

// Write the workbook to the Excel file
FileOutputStream fileOut = new FileOutputStream(excelFilePath)
workbook.write(fileOut)
fileOut.close()