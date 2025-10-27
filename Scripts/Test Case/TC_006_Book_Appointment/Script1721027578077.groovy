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

WebUI.callTestCase(findTestCase('Test Case/TC_001_Login_with_Valid_Data'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Book Appointment/Facility'), 'Hongkong CURA Healthcare Center', true)

WebUI.click(findTestObject('Book Appointment/Checklist Hospital Readmisson'))

WebUI.click(findTestObject('Book Appointment/Healthcare Program'))

WebUI.setText(findTestObject('Book Appointment/Input Visit Date'), '04/07/2024')

WebUI.setText(findTestObject('Book Appointment/Comment'), 'Sakit Demam')

WebUI.click(findTestObject('Book Appointment/Button Book Appointment'))

WebUI.verifyElementText(findTestObject('Book Appointment/Verify Appointment Confirmation'), 'Appointment Confirmation')

WebUI.click(findTestObject('Book Appointment/Button goto homepage'))

