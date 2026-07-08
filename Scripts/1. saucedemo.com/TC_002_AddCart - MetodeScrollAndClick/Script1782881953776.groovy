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
import org.openqa.selenium.WebElement as WebElement
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

WebUI.callTestCase(findTestCase('1. saucedemo.com/TC_001_Login'), [:], FailureHandling.STOP_ON_FAILURE)

'TungguBuat Pop Muncul dan hilangkan pop up chrome'
WebUI.delay(2)

Robot robot = new Robot()

robot.keyPress(KeyEvent.VK_ENTER)

robot.keyRelease(KeyEvent.VK_ENTER)

'Produk1\r\n'
WebUI.scrollToElement(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukSauceLabsBackpack'), 5)

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukSauceLabsBackpack'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))

'Produk2\r\n'
WebUI.scrollToElement(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukSauceLabsBikeLight'), 5)

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukSauceLabsBikeLight'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))

'Produk3'
WebUI.scrollToElement(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukSauceLabsBoltT-Shirt'), 5)

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukSauceLabsBoltT-Shirt'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))

'Produk4'
WebUI.scrollToElement(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukSauceLabsFleeceJacket'), 5)

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukSauceLabsFleeceJacket'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))

'Produk5'
WebUI.scrollToElement(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukSauceLabsOnesie'), 5)

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukSauceLabsOnesie'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))

'Produk6'
WebUI.scrollToElement(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukTest.allTheThings()T-Shirt(Red)'), 5)

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddProdukTest.allTheThings()T-Shirt(Red)'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))

WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))




