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

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.io.FileInputStream as FileInputStream
import java.io.FileOutputStream as FileOutputStream
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow

'====Inisiasi Random String===='
Random rand1 = new Random()

'Random AngkaAcak, Get Text'
int AcakQuantity = rand1.nextInt(100) + 1

'Open Link'
WebUI.openBrowser('https://automationexercise.com/')

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'FullScreen Window'
WebUI.maximizeWindow()

'NungguElementSignUpMuncul'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtProduct/1. btnProduct'), 3)
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/1. btnProduct'))

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'Product 1'
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtProduct/2. ScrollProduct1'), 0)
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/3. DetailProduct1'))
'Add Quantity and Cart'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtProduct/4. AddQuantity'), 3)
'Random Quantity'
WebUI.setText(findTestObject('2.Objectautomationexercise/BtProduct/4. AddQuantity'), AcakQuantity.toString())
'Add Cart'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/5. btnAddCart'))

'Continue Shopping'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/6. btnContinueShopping'))
'Balik Ke Product'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/1. btnProduct'))
'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'Product 2'
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtProduct/8. ScrollProduct2'), 0)
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/9. DetailProduct2'))
'Add Quantity and Cart'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtProduct/4. AddQuantity'), 3)
'Random Quantity'
WebUI.setText(findTestObject('2.Objectautomationexercise/BtProduct/4. AddQuantity'), AcakQuantity.toString())
'Add Cart'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/5. btnAddCart'))

'Continue Shopping'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/6. btnContinueShopping'))
'Balik Ke Product'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/1. btnProduct'))
'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'Product 3'
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtProduct/10. ScrollProduct3'), 0)
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/11. DetailProduct3'))
'Add Quantity and Cart'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtProduct/4. AddQuantity'), 3)
'Random Quantity'
WebUI.setText(findTestObject('2.Objectautomationexercise/BtProduct/4. AddQuantity'), AcakQuantity.toString())
'Add Cart'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/5. btnAddCart'))

'Continue Shopping'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/6. btnContinueShopping'))
'Balik Ke Product'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/1. btnProduct'))
'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'Product 4'
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtProduct/12. ScrollProduct4'), 0)
WebUI.mouseOver(findTestObject('2.Objectautomationexercise/BtProduct/12. ScrollProduct4'), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(6)
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/13. DetailProduct4'))
//'Add Quantity and Cart'
//WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtProduct/4. AddQuantity'), 3)
//'Random Quantity'
//WebUI.setText(findTestObject('2.Objectautomationexercise/BtProduct/4. AddQuantity'), AcakQuantity.toString())

'Continue Shopping'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/6. btnContinueShopping'))
'Scroll Ke Search Product'
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtProduct/1. btnProduct'), 0)


'Get Text'
String Product5 = WebUI.getText(findTestObject('2.Objectautomationexercise/BtProduct/19. getNameProduct5'), FailureHandling.STOP_ON_FAILURE)

'Product5'
WebUI.setText(findTestObject('2.Objectautomationexercise/BtProduct/15. SearchProduct'), Product5, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/16. btnSearchProduct'), FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtProduct/17. ScrollProduct5'), 0)
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/18. DetailProduct5'))
'Add Quantity and Cart'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtProduct/4. AddQuantity'), 3)
'Random Quantity'
WebUI.setText(findTestObject('2.Objectautomationexercise/BtProduct/4. AddQuantity'), AcakQuantity.toString())
'Add Cart'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/5. btnAddCart'))
'View Cart'
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/7. btnViewCart'))
'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)


//'Add Cart'
//WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/5. btnAddCart'))