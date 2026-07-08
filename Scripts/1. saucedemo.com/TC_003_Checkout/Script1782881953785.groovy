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

//WebUI.callTestCase(findTestCase('1. saucedemo.com/TC_002_AddCart - MetodeForAndIF'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatCheckout/KlikCart'))

'BuatCheckout'
WebUI.scrollToElement(findTestObject('1.ObjectSauceDemo/BuatCheckout/btnCheckout'), 1)

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatCheckout/btnCheckout'))

'FieldFirstName'
WebUI.setText(findTestObject('1.ObjectSauceDemo/BuatCheckout/FieldFirstName'), 'Testing')

'FieldLastName'
WebUI.setText(findTestObject('1.ObjectSauceDemo/BuatCheckout/FieldLastName'), 'Nuryansyah')

'FieldZIP'
WebUI.setText(findTestObject('1.ObjectSauceDemo/BuatCheckout/FieldZIP'), '05601')

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatCheckout/btnContinue'))

'BuatFinish'
WebUI.scrollToElement(findTestObject('1.ObjectSauceDemo/BuatCheckout/btnFinish'), 1)

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatCheckout/btnFinish'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))

