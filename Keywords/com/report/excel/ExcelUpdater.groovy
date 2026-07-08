package com.report.excel

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import com.kms.katalon.core.configuration.RunConfiguration
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

import internal.GlobalVariable

public class ExcelUpdater {


	def updateDataBerdasarkanEmail(String emailTarget, String namaKolomYangDiubah, String nilaiBaru, String namaFileExcel) {
		String excelPath = RunConfiguration.getProjectDir() + "/" + namaFileExcel + ".xlsx"
		File file = new File(excelPath)

		if (!file.exists()) {
			println("=== [WARNING] File Excel tidak ditemukan di: " + excelPath + " ===")
			return
		}

		FileInputStream fis = new FileInputStream(file)
		Workbook workbook = new XSSFWorkbook(fis)
		Sheet sheet = workbook.getSheetAt(0)

		int kolEmail = -1 //beda nya disini
		int kolTargetUbah = -1

		// 1. Cari indeks kolom "Email" dan kolom yang ingin diubah berdasarkan Header (Row 0)
		Row headerRow = sheet.getRow(0)
		for (int cellIdx = 0; cellIdx < headerRow.getLastCellNum(); cellIdx++) {
			String headerValue = headerRow.getCell(cellIdx).getStringCellValue()

			if (headerValue.equalsIgnoreCase("Sign Up Email") || headerValue.equalsIgnoreCase("Email")) {
				kolEmail = cellIdx
			} else if (headerValue.equalsIgnoreCase(namaKolomYangDiubah)) {
				kolTargetUbah = cellIdx
			}
		}

		// Jika kolom target yang mau diubah belum ada, otomatis buat kolom baru di ujung kanan
		if (kolTargetUbah == -1) {
			kolTargetUbah = headerRow.getLastCellNum()
			Cell newHeader = headerRow.createCell(kolTargetUbah)
			newHeader.setCellValue(namaKolomYangDiubah)
		}

		if (kolEmail == -1) {
			println("=== [ERROR] Kolom Email tidak ditemukan! ===")
			workbook.close()
			fis.close()
			return
		}

		boolean dataBerhasilDiupdate = false

		// 2. Looping data untuk mencari baris email yang cocok
		for (int rowIdx = 1; rowIdx <= sheet.getLastRowNum(); rowIdx++) {
			Row row = sheet.getRow(rowIdx)
			if (row == null) continue

				Cell emailCell = row.getCell(kolEmail)
			if (emailCell != null && emailCell.getStringCellValue().equalsIgnoreCase(emailTarget)) {

				// 3. Timpa nilai cell lama dengan Nilai Baru
				Cell targetCell = row.getCell(kolTargetUbah)
				if (targetCell == null) {
					targetCell = row.createCell(kolTargetUbah)
				}

				targetCell.setCellValue(nilaiBaru)
				dataBerhasilDiupdate = true
				println("=== [SUCCESS] Berhasil mengupdate kolom '${namaKolomYangDiubah}' menjadi '${nilaiBaru}' untuk email: ${emailTarget} ===")
				break
			}
		}

		if (!dataBerhasilDiupdate) {
			println("=== [INFO] Email ${emailTarget} tidak ditemukan, tidak ada data yang diubah ===")
		}

		// 4. Tulis kembali perubahan ke file Excel
		fis.close()
		FileOutputStream fos = new FileOutputStream(file)
		workbook.write(fos)
		fos.close()
		workbook.close()
	}


	def updateDataBerdasarkanBaris(int nomorBaris, String namaKolomYangDiubah, String nilaiBaru, String namaFileExcel) {
		String excelPath = RunConfiguration.getProjectDir() + "/" + namaFileExcel + ".xlsx"
		File file = new File(excelPath)

		if (!file.exists()) {
			println("=== [WARNING] File Excel tidak ditemukan di: " + excelPath + " ===")
			return
		}

		FileInputStream fis = new FileInputStream(file)
		Workbook workbook = new XSSFWorkbook(fis)
		Sheet sheet = workbook.getSheetAt(0)

		int kolTargetUbah = -1

		// 1. Cari indeks kolom berdasarkan Nama Header di baris pertama (Row 0)
		Row headerRow = sheet.getRow(0)
		for (int cellIdx = 0; cellIdx < headerRow.getLastCellNum(); cellIdx++) {
			String headerValue = headerRow.getCell(cellIdx).getStringCellValue()
			if (headerValue.equalsIgnoreCase(namaKolomYangDiubah)) {
				kolTargetUbah = cellIdx
				break
			}
		}

		// Jika kolom target belum ada, otomatis buat kolom baru di ujung kanan
		if (kolTargetUbah == -1) {
			kolTargetUbah = headerRow.getLastCellNum()
			Cell newHeader = headerRow.createCell(kolTargetUbah)
			newHeader.setCellValue(namaKolomYangDiubah)
		}

		// 2. Langsung ambil baris spesifik yang diminta (nomorBaris)
		// Catatan: Di Apache POI, indeks baris dimulai dari 0 (Header = 0, Data ke-1 = baris 1, Data ke-5 = baris 5)
		Row row = sheet.getRow(nomorBaris)
		if (row == null) {
			row = sheet.createRow(nomorBaris)
		}

		// 3. Isi atau timpa nilai cell tersebut dengan nilai baru
		Cell targetCell = row.getCell(kolTargetUbah)
		if (targetCell == null) {
			targetCell = row.createCell(kolTargetUbah)
		}
		targetCell.setCellValue(nilaiBaru)

		println("=== [SUCCESS] Berhasil mengupdate baris ke-${nomorBaris} pada kolom '${namaKolomYangDiubah}' menjadi '${nilaiBaru}' ===")

		// 4. Tulis kembali perubahan ke file Excel
		fis.close()
		FileOutputStream fos = new FileOutputStream(file)
		workbook.write(fos)
		fos.close()
		workbook.close()
	}
}
