import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Login_with_valid_data {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I navigate to Cura System homepage")
	def I_navigate_to_Cura_System_homepage() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
		WebUI.maximizeWindow()
	}

	@When("I click Make Appointment buttton")
	def I_click_Make_Appointment_buttton() {
		WebUI.click(findTestObject('Login/button make appointment'))
	}

	@And("I enter valid username (.*) and password (.*)")
	def I_enter_valid_username_and_password(String username, String password) {
		WebUI.setText(findTestObject('Login/username'), username)
		WebUI.setText(findTestObject('Login/password'), password)
	}

	@And("I click button Login")
	def I_click_button_Login() {
		WebUI.click(findTestObject('Login/button login'))
	}

	@Then("I should be able to Login successfully and verify homepage")
	def I_should_be_able_to_Login_successfully_and_verify_homepage() {


		WebUI.verifyElementText(findTestObject('Login/verify make appointment'), 'Make Appointment')
		WebUI.closeBrowser()
	}
}