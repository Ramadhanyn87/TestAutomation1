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
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

'======Awal Cara Pertama Buat Ngambil Data======'
def dataGet1 = TestDataFactory.findTestData('Data Files/DataLoginExcel')
int LastBaris = dataGet1.getRowNumbers()

String InptName = dataGet1.getValue('Sign Up Name', LastBaris)
String InptEmail = dataGet1.getValue('Sign Up Email', LastBaris)

//'Open Link'
//WebUI.openBrowser('https://automationexercise.com/')
//'FullScreen Window'
//WebUI.maximizeWindow()

'Open Web'
WebUI.callTestCase(findTestCase('2. automationexercise.com/OpenWeb'), [:], FailureHandling.STOP_ON_FAILURE)

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Halaman Utama')


'Klik Contact Us'
WebUI.click(findTestObject('2.Objectautomationexercise/BtContactUs/1. btnContactUs'), FailureHandling.STOP_ON_FAILURE)

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'VisibleElement'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtContactUs/2. VisibleGetInTouch'), 6, FailureHandling.STOP_ON_FAILURE)

'Input Contact Us'
WebUI.setText(findTestObject('2.Objectautomationexercise/BtContactUs/3. InptName'), InptName, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtContactUs/4. InptEmail'), InptEmail, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtContactUs/5. InptSubject'), 'Keluhan', FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtContactUs/6. InptYourMessageHere'), 'Apa yaa cobaa Test aja dulu', FailureHandling.STOP_ON_FAILURE)
WebUI.uploadFile(findTestObject('2.Objectautomationexercise/BtContactUs/7. btnUploadFile'), 'D:/Project/TestUpload.png', FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Input Contact Us')
WebUI.click(findTestObject('2.Objectautomationexercise/BtContactUs/8. btnSubmit'), FailureHandling.STOP_ON_FAILURE)

//'Buat Klik Pop Up Window'
//Robot robot = new Robot()
//
//robot.keyPress(KeyEvent.VK_ENTER)
//robot.keyRelease(KeyEvent.VK_ENTER)

WebUI.waitForAlert(5)
WebUI.acceptAlert()
WebUI.delay(4)

//'RefreshBuatNgilanginIklan'
//WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'VisibleElement'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtContactUs/9. VisibleSuksesContact'), 6, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Sukses Input Contact Us')

'klik Home'
WebUI.click(findTestObject('2.Objectautomationexercise/BtContactUs/10. btnHome'), FailureHandling.STOP_ON_FAILURE)

'VisibleElement'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtContactUs/1. btnContactUs'), 6, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Berhasil ke home kembali')
CustomKeywords.'com.report.pdf.ManualPdfReporter.buatPdf'('(Evidence_Contact US)')
