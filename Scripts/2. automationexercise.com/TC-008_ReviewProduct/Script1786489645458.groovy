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


//'Login'
//WebUI.callTestCase(findTestCase('2. automationexercise.com/TC-002_SignIn'), [:], FailureHandling.STOP_ON_FAILURE)

'======Awal Cara Pertama Buat Ngambil Data======'
def dataGet = TestDataFactory.findTestData('Data Files/DataLoginExcel')
int LastBaris = dataGet.getRowNumbers()

String InptNama1 = dataGet.getValue('First Name', LastBaris)
String InptNama2 = dataGet.getValue('Last Name', LastBaris)

String InptNama = InptNama1 + ' ' + InptNama2
String InptEmail = dataGet.getValue('Sign Up Email', LastBaris)


'OpenWeb'
WebUI.callTestCase(findTestCase('2. automationexercise.com/OpenWeb'), [:], FailureHandling.STOP_ON_FAILURE)

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'NungguElementProductMuncul'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtProduct/1. btnProduct'), 3)
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/1. btnProduct'))

//CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Di Halaman Product')

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'Product 1'
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtProduct/2. ScrollProduct1'), 0)
//CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Detail Product1 Part 1')
WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/3. DetailProduct1'))
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtReviewProduct/1. ScrollYourReview'), 3)
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtReviewProduct/1. ScrollYourReview'), 0)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtReviewProduct/2. InptName'), InptNama, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtReviewProduct/3. InptEmail'), InptEmail, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtReviewProduct/4. InptReview'), 'Apa yaa cobaa Test aja dulu', FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('2.Objectautomationexercise/BtReviewProduct/5. BtnReview'))

//'Product 2'
//WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtProduct/8. ScrollProduct2'), 0)
//CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Add Product2 Part 1')
//WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/9. DetailProduct2'))
//
//'Product 3'
//WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtProduct/10. ScrollProduct3'), 0)
//CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Add Product3 Part 1')
//WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/11. DetailProduct3'))
//
//'Product 4'
//WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtProduct/12. ScrollProduct4'), 0)
//CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Add Product4 Part 1')
//WebUI.mouseOver(findTestObject('2.Objectautomationexercise/BtProduct/12. ScrollProduct4'), FailureHandling.STOP_ON_FAILURE)
//CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Add Product4 Part 2 (Add Quantity)')
//WebUI.delay(6)
//WebUI.enhancedClick(findTestObject('2.Objectautomationexercise/BtProduct/13. DetailProduct4'))
//
//
//'Get Text'
//String Product5 = WebUI.getText(findTestObject('2.Objectautomationexercise/BtProduct/19. getNameProduct5'), FailureHandling.STOP_ON_FAILURE)
//
//'Product5'
//WebUI.setText(findTestObject('2.Objectautomationexercise/BtProduct/15. SearchProduct'), Product5, FailureHandling.STOP_ON_FAILURE)
//CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Add Product5 Part 1 -> (Search Product)')
//WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/16. btnSearchProduct'), FailureHandling.STOP_ON_FAILURE)
//WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtProduct/17. ScrollProduct5'), 0)
//CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Add Product5 Part 2 -> (Product 5)')
//WebUI.click(findTestObject('2.Objectautomationexercise/BtProduct/18. DetailProduct5'))