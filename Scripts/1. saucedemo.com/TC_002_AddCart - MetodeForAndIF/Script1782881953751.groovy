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

//WebUI.callTestCase(findTestCase('1. saucedemo.com/TC_001_Login'), [:], FailureHandling.STOP_ON_FAILURE)

'TungguBuat Pop Muncul dan hilangkan pop up chrome'
WebUI.delay(2)

Robot robot = new Robot()

robot.keyPress(KeyEvent.VK_ENTER)

robot.keyRelease(KeyEvent.VK_ENTER)

'1. Ambil total produk yang terdeteksi di halaman utama'
List<WebElement> tempProduk = WebUI.findWebElements(findTestObject('1.ObjectSauceDemo/BuatAddCart/DetailProduct'), 1)
int totalProduk = tempProduk.size()

'2. Perulangan indeks angka untuk mengantisipasi Stale Element'
for (int i = 0; i < totalProduk; i++) {
	
	'Ambil list produk yang segar setiap kembali ke halaman utama'
	List<WebElement> allProduk = WebUI.findWebElements(findTestObject('1.ObjectSauceDemo/BuatAddCart/DetailProduct'), 1)
	WebElement produk = allProduk.get(i)
	
	String NProduk = produk.getText()

	'3. UBAH DI SINI: Hanya proses jika nama produk sesuai dengan dua pilihanmu'
	if (NProduk.equals('Sauce Labs Backpack') || NProduk.equals('Sauce Labs Bolt T-Shirt')) {
		
		// Masuk ke detail produk
		produk.click()
		// Klik Add to Cart
		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))
		// Kembali ke halaman produk utama
		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))
		// Beri jeda agar halaman utama selesai memuat ulang
		//WebUI.delay(1)
		WebUI.scrollToPosition(0, 250)
	}
	else if (NProduk.equals('Sauce Labs Onesie') || NProduk.equals('Test.allTheThings() T-Shirt (Red)')) {
		
		// Masuk ke detail produk
		produk.click()
		// Klik Add to Cart
		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))
		// Kembali ke halaman produk utama
		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))
		// Beri jeda agar halaman utama selesai memuat ulang
		//WebUI.delay(1)
		WebUI.scrollToPosition(0, 250)
	}
	else if (NProduk.equals('Sauce Labs Bike Light') || NProduk.equals('Sauce Labs Fleece Jacket')) {
		
		// Masuk ke detail produk
		produk.click()
		// Klik Add to Cart
		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))
		// Kembali ke halaman produk utama
		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))
		// Beri jeda agar halaman utama selesai memuat ulang
		//WebUI.delay(1)
		WebUI.scrollToPosition(0, 250)
	}
}

WebUI.scrollToPosition(0, 0)


//'Ambil Jumlah Total Produk Terlebih Dahulu'
//List<WebElement> tempProduk = WebUI.findWebElements(findTestObject('1.ObjectSauceDemo/BuatAddCart/DetailProduct'), 5)
//int totalProduk = tempProduk.size()
//
//'Perulangan menggunakan indeks angka agar terhindar dari Stale Element Exception'
//for (int i = 0; i < totalProduk; i++) {
//	
//	'PENTING: Ambil ulang list produk yang segar setiap kali kembali ke halaman utama'
//	List<WebElement> allProduk = WebUI.findWebElements(findTestObject('1.ObjectSauceDemo/BuatAddCart/DetailProduct'), 5)
//	WebElement produk = allProduk.get(i)
//	
//	String NProduk = produk.getText()
//
//		
//	'Jika ketemu yang namanya produk, klik produk tersebut dan click Add Cart'
//	if (NProduk.equals('Sauce Labs Backpack')) {
//		produk.click()
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))
//		WebUI.delay(1) // Beri jeda 1 detik agar halaman utama loading sempurna
//	}
//	else if (NProduk.equals('Sauce Labs Bolt T-Shirt')) {
//		produk.click()
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))
//		WebUI.delay(1)
//	}
//	else if (NProduk.equals('Sauce Labs Onesie')) {
//		produk.click()
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))
//		WebUI.delay(1)
//	}
//	else if (NProduk.equals('Test.allTheThings() T-Shirt (Red)')) {
//		produk.click()
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))
//		WebUI.delay(1)
//	}
//	else if (NProduk.equals('Sauce Labs Bike Light')) {
//		produk.click()
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))
//		WebUI.delay(1)
//	}
//	else if (NProduk.equals('Sauce Labs Fleece Jacket')) {
//		produk.click()
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/AddCart'))
//		WebUI.click(findTestObject('1.ObjectSauceDemo/BuatAddCart/BackPageAllProduct'))
//		WebUI.delay(1)
//	}
//}

