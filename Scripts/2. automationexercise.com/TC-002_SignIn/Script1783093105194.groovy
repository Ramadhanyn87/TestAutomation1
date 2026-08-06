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


//' --- [CONFIG] PATH FILE EXCEL ---'
//String excelPath = RunConfiguration.getProjectDir() + '/Report_SignUp.xlsx'
//
//'Buka file Excel'
//FileInputStream fileInput = new FileInputStream(excelPath)
//XSSFWorkbook workbook = new XSSFWorkbook(fileInput)
//XSSFSheet sheet = workbook.getSheet('ReportPendaftaran')
//
//'3. Tentukan baris mana yang mau diambil datanya'
//// Misal: Mau mengambil data di baris kedua (indeks baris = 1, tepat di bawah header)
//int barisYangMauDiambil = 1
//XSSFRow row = sheet.getRow(barisYangMauDiambil)
////int barisTerakhir = sheet.getLastRowNum()
////XSSFRow row = sheet.getRow(barisTerakhir)
//
//'4. Ambil data dari kolom spesifik (Sesuaikan indeks kolom Excel kamu!)'
//// Contoh asumsi posisi kolom: Kolom C (indeks 2) = Name, Kolom D (indeks 3) = Email, Kolom F (indeks 5) = Password
//String dataEmail = row.getCell(3).getStringCellValue()
//String dataPassword = row.getCell(5).getStringCellValue()
//
//// Tampilkan di console Katalon untuk memastikan data berhasil terbaca
//println("Email yang diambil dari Excel: " + dataEmail)
//println("Password yang diambil dari Excel: " + dataPassword)
//
//// Close koneksi Excel setelah selesai membaca data
//fileInput.close()
//workbook.close()

'======Awal Cara Pertama Buat Ngambil Data======'
def dataGet = TestDataFactory.findTestData('Data Files/DataLoginExcel')
int LastBaris = dataGet.getRowNumbers()

String InptEmail = dataGet.getValue('Sign Up Email', LastBaris)
String InptPass = dataGet.getValue('Password', LastBaris)



//WebUI.openBrowser('https://automationexercise.com/')
//'FullScreen Window'
//WebUI.maximizeWindow()

'Open Web'
WebUI.callTestCase(findTestCase('2. automationexercise.com/OpenWeb'), [:], FailureHandling.STOP_ON_FAILURE)

'Buat Refresh Halaman'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Berhasil Akses Halaman Utama')


'NungguElementSignUpMuncul'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtSignUp/btnSignUpLogin'), 3)
WebUI.click(findTestObject('2.Objectautomationexercise/BtSignUp/btnSignUpLogin'))

'Buat Refresh Halaman'
WebUI.callTestCase(findTestCase('BuatRefresh'), [:], FailureHandling.STOP_ON_FAILURE)

'Input Sign In'
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtSignIn/VisibleLogin'), 3)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignIn/InptLoginEmail'), InptEmail, FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('2.Objectautomationexercise/BtSignIn/InptLoginPass'), InptPass, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Input Credential')

WebUI.click(findTestObject('2.Objectautomationexercise/BtSignIn/ClickBtnLogin'), FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementVisible(findTestObject('2.Objectautomationexercise/BtSignUp/VerifyVisibleLoggedInAS'), 3)

CustomKeywords.'com.report.pdf.ManualPdfReporter.tambahStep'('Berhasil Login')
CustomKeywords.'com.report.pdf.ManualPdfReporter.buatPdf'('(Evidence_Sign In)')