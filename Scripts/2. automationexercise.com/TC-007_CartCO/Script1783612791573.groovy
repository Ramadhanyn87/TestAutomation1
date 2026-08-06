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
import java.io.FileInputStream as FileInputStream
import java.io.FileOutputStream as FileOutputStream
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow

'======Awal Cara Pertama Buat Ngambil Data======'
def dataGet = TestDataFactory.findTestData('Data Files/DataLoginExcel')
int LastBaris = dataGet.getRowNumbers()

String InptComment1 = dataGet.getValue('First Name', LastBaris)
String InptComment2 = dataGet.getValue('Last Name', LastBaris)

String InptNama = InptComment1 + ' ' + InptComment2

'====Inisiasi Random String===='
Random rand1 = new Random()


int AcakCVC = rand1.nextInt(900) + 100
int AcakMM = rand1.nextInt(12) + 1
int AcakYears = rand1.nextInt(122) + 1900
int digitBelakangNumber = rand1.nextInt(900000000) + 100000000

String CardNumber = '870' + digitBelakangNumber
String CVC = String.valueOf(AcakCVC)
String MM = String.valueOf(AcakMM)
String Years = String.valueOf(AcakYears)

//String InptEmail = dataGet.getValue('First Name', LastBaris) + ('Last Name', LastBaris)

'Login'
WebUI.callTestCase(findTestCase('2. automationexercise.com/TC-002_SignIn'), [:], FailureHandling.STOP_ON_FAILURE)

'AddProduct'
WebUI.callTestCase(findTestCase('2. automationexercise.com/TC-006_AddProductCart'), [:], FailureHandling.STOP_ON_FAILURE)

//'Open Link'
//WebUI.openBrowser('https://automationexercise.com/')
'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'Cart'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtCartCO/1. btnCart'), 3)
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtCartCO/17. ItemCart'), 0)
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtCartCO/1. btnCart'), 0)
CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Halaman Cart')
'Click Process'
WebUI.click(findTestObject('2.Objectautomationexercise/BtCartCO/2. ProceedCO'))

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Confirm Address')
'Review Order'
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtCartCO/3. ScrollReviewOrder'), 2)
CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Confirm Order')
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtCartCO/4. ScrollTotalAmount'), 0)
'Isi Komentar'
WebUI.setText(findTestObject('2.Objectautomationexercise/BtCartCO/5. InptCommentCO'), InptNama, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Isi Komentar')
WebUI.click(findTestObject('2.Objectautomationexercise/BtCartCO/6. btnPlaceOrder'))

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'Payment'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtCartCO/7. ScrollPayment'), 3)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtCartCO/8. InptNameOnCard'), InptNama, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtCartCO/9. InptCardNumber'), CardNumber, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtCartCO/10. InptCVC'), CVC, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtCartCO/11. InptExpiryMonth'), MM, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtCartCO/12. InptExpiryYears'), Years, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Confirm Payment')
WebUI.click(findTestObject('2.Objectautomationexercise/BtCartCO/13. btnPayCfmOrder'))

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'Cfm Order'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtCartCO/14. VisibleOrder'), 3)
WebUI.click(findTestObject('2.Objectautomationexercise/BtCartCO/15. btnDownloadInvoice'))
CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Donwload Invoice Berhasil')
WebUI.click(findTestObject('2.Objectautomationexercise/BtCartCO/16. btnContinue'))

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'verify Cart sudah kosong'
WebUI.click(findTestObject('2.Objectautomationexercise/BtCartCO/1. btnCart'))
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtCartCO/18. CartEmpty'), 3)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Cart Sudah Kosong')
CustomKeywords.'com.report.pdf.ManualPdfReporter.buatPdf'('Evidence_Checkout')