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

//' --- [CONFIG] PATH FILE EXCEL ---'
//String excelPath = RunConfiguration.getProjectDir() + '/Report_SignUp.xlsx'
//
//'\'--- LOGIKA EMITTER HORIZONTAL (REUSABLE FUNCTION) ---\''
//def cetakBarisExcel = { List dataList ->
//	FileInputStream fileInput = new FileInputStream(excelPath)
//	XSSFWorkbook workbook = new XSSFWorkbook(fileInput)
//	XSSFSheet sheet = workbook.getSheet('ReportPendaftaran')
//
//	int rowCount = sheet.getLastRowNum()
//	XSSFRow newRow = sheet.createRow(rowCount + 1)
//
//	// Isi kolom A (No) secara otomatis berdasarkan indeks baris
//	newRow.createCell(0).setCellValue(rowCount + 1)
//
//	// Isi kolom B sampai seterusnya secara horizontal sesuai list data
//	for (int i = 0; i < dataList.size(); i++) {
//		newRow.createCell(i + 1).setCellValue(dataList.get(i).toString())
//	}
//	
//	fileInput.close()
//	FileOutputStream fileOutput = new FileOutputStream(excelPath)
//	workbook.write(fileOutput)
//	fileOutput.close()
//	workbook.close()
//}
'====Inisiasi Random String===='
Random rand1 = new Random()

'Random AngkaAcak'
int Acak1 = rand1.nextInt(9000) + 1000
int Acak3 = rand1.nextInt(100) + 1
'Random Index Days, Month, Years'
int RandDays = rand1.nextInt(31) + 1
int RandMonth = rand1.nextInt(12) + 1
int RandYears = rand1.nextInt(122) + 1900
'Random Index Country'
int RandCountry = rand1.nextInt(7)
'random ZipCode, and PhoneNumber'
int AcakZIP = rand1.nextInt(1100) + 1
int digitBelakangNumber = rand1.nextInt(900000000) + 100000000

String NamaDinamis = 'Ramadhany' + Acak1
String EmailDinamis = ('ramatest.' + Acak1) + '@gmail.com'
String PassDinamis = 'rama' + Acak1
String txtYear = String.valueOf(RandYears)
String FirstNameDinamis = 'testrama' + Acak1
String LastNameDinamis = 'testnur' + Acak1
String CompanyDinamis = 'NurSejahtera' + Acak3
String Address1Dinamis = 'Jalan Kampung selatan' + Acak3
String Address2Dinamis = 'Kemayoran Lama, Jakarta, ' + Acak3
String StateDinamis = 'Jakarta' + Acak3
String CityDinamis = 'Jakarta Pusat' + Acak3
String ZipDinamis = '1' + AcakZIP
String NumberPhoneDinamis = '087' + digitBelakangNumber

//'Open Link'
//WebUI.openBrowser('https://automationexercise.com/')
//'FullScreen Window'
//WebUI.maximizeWindow()
//WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)
//WebUI.refresh()
//WebUI.delay(2)

'Open Web'
WebUI.callTestCase(findTestCase('2. automationexercise.com/OpenWeb'), [:], FailureHandling.STOP_ON_FAILURE)

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)


CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Halaman Utama Automation Exercise')

'NungguElementSignUpMuncul'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtSignUp/btnSignUpLogin'), 3)
WebUI.click(findTestObject('2.Objectautomationexercise/BtSignUp/btnSignUpLogin'))

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'Input Sign Up'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtSignUp/InptSignUpName'), 3)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptSignUpName'), NamaDinamis)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptSignUpEmail'), EmailDinamis)
CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Input New User Sign Up')
WebUI.click(findTestObject('2.Objectautomationexercise/BtSignUp/btnSIGNUP'))

'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'NungguElemenInfoVisible'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtSignUp/visibleAcctInfo'), 0)
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtSignUp/visibleAcctInfo'), 0)
WebUI.click(findTestObject('2.Objectautomationexercise/BtSignUp/btnTitleMr'))

'Input Password'
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptPass'), PassDinamis)

'Input Days, Month, Years'
WebUI.selectOptionByIndex(findTestObject('2.Objectautomationexercise/BtSignUp/InptDays'), RandDays, FailureHandling.STOP_ON_FAILURE)
WebUI.selectOptionByIndex(findTestObject('2.Objectautomationexercise/BtSignUp/InptMonth'), RandMonth, FailureHandling.STOP_ON_FAILURE)
WebUI.selectOptionByLabel(findTestObject('2.Objectautomationexercise/BtSignUp/InptYears'), txtYear, false)

'Check News and Spesial Offers'
//WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtSignUp/CheckNews'), 0)
WebUI.click(findTestObject('2.Objectautomationexercise/BtSignUp/CheckNews'))
WebUI.verifyElementChecked(findTestObject('2.Objectautomationexercise/BtSignUp/CheckNews'), 5)
WebUI.click(findTestObject('2.Objectautomationexercise/BtSignUp/CheckSpesialOffers'))
WebUI.verifyElementChecked(findTestObject('2.Objectautomationexercise/BtSignUp/CheckSpesialOffers'), 5)
CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Input Enter Account Information')

//WebUI.click(findTestObject('2.Objectautomationexercise/BtSignUp/CheckSpesialOffers'))
//
//WebUI.verifyElementNotChecked(findTestObject('2.Objectautomationexercise/BtSignUp/CheckSpesialOffers'), 5)
'Input Address Information Part 1'
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtSignUp/CheckSpesialOffers'), 3)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptFirstName'), FirstNameDinamis)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptLastName'), LastNameDinamis)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptCompany'), CompanyDinamis)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptAddress1'), Address1Dinamis)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptAddress2'), Address2Dinamis)
WebUI.selectOptionByIndex(findTestObject('2.Objectautomationexercise/BtSignUp/InptCountry'), RandCountry, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Input Address Information Part 1')

'Input Address Information Part 2'
WebUI.scrollToElement(findTestObject('2.Objectautomationexercise/BtSignUp/InptCountry'), 3)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptState'), StateDinamis)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptCity'), CityDinamis)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptZipcode'), ZipDinamis)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignUp/InptMobileNumber'), NumberPhoneDinamis)
CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Input Address Information Part 2')

'--- PROSES WRITE REPORT KE EXCEL (HORIZONTAL) ---'
String currentTime = new java.text.SimpleDateFormat('yyyy-MM-dd HH:mm:ss').format(new Date())

'Masukkan semua data ke dalam satu list sesuai urutan kolom template'
List rowData = [currentTime, NamaDinamis, EmailDinamis, 'Mr.', PassDinamis, RandDays, RandMonth, txtYear, 'True', 'True'
    , FirstNameDinamis, LastNameDinamis, CompanyDinamis, Address1Dinamis, Address2Dinamis, RandCountry, StateDinamis, CityDinamis
    , ZipDinamis, NumberPhoneDinamis, 'Account Created Successfully']

'Panggil fungsi untuk mencetak satu baris penuh'
CustomKeywords.'com.report.excel.ExcelReporter.cetakBarisExcel'(rowData)

'Klik Account Created'
WebUI.click(findTestObject('2.Objectautomationexercise/BtSignUp/btnCrtAcct'))
//'RefreshBuatNgilanginIklan'
//WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtSignUp/VerifyVisibleAcctCrtd'), 3)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Halaman Akun Berhasil Dibuat (Success)')

//WebUI.delay(6)
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtSignUp/btnContinue'), 6)
WebUI.click(findTestObject('2.Objectautomationexercise/BtSignUp/btnContinue'))
'RefreshBuatNgilanginIklan'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtSignUp/VerifyVisibleLoggedInAS'), 3)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Dashboard Utama - Berhasil Logged In')

'Buat Logout'
WebUI.callTestCase(findTestCase('2. automationexercise.com/TC-003_LogOut'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Berhasil LogOut')
CustomKeywords.'com.report.pdf.ManualPdfReporter.buatPdf'('(Evidence_Sign Up)')

