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
import java.io.FileInputStream as FileInputStream
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

def dataGet = TestDataFactory.findTestData('Data Files/DataLoginExcel')
int lastBaris = dataGet.getRowNumbers()
//int target = 5

String emailAktif = dataGet.getValue('Sign Up Email', lastBaris)
String emailTarget = "ramatest.6303@gmail.com"


//WebUI.openBrowser('https://automationexercise.com/')
//
//'FullScreen Window'
//WebUI.maximizeWindow()

'Buat Refresh Halaman'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'NungguElementSignUpMuncul'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtDeleted/BuatDeleteAcct'), 3)
CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Akun Mau Di Delete')
WebUI.click(findTestObject('2.Objectautomationexercise/BtDeleted/BuatDeleteAcct'))


WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtDeleted/VisibleAcctDelete'), 3)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Account Deleted!')

//WebUI.delay(6)
'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtSignUp/btnContinue'), 6)

WebUI.click(findTestObject('2.Objectautomationexercise/BtSignUp/btnContinue'))


'NungguElementSignUpMuncul'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtSignUp/btnSignUpLogin'), 3)

CustomKeywords.'com.report.excel.ExcelUpdater.updateDataBerdasarkanEmail'(
	emailAktif,
	"Status Registrasi",
	"DELETED",
	"Report_SignUp"
)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Akun Sukses Di Delete')
CustomKeywords.'com.report.pdf.ManualPdfReporter.buatPdf'('(Evidence_Deleted Account)')
