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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.io.FileInputStream
import java.io.FileOutputStream
import org.apache.poi.xssf.usermodel.*

import internal.GlobalVariable

public class ExcelReporter {

	def cetakBarisExcel(List dataList) {
		' --- [CONFIG] PATH FILE EXCEL ---'
		String excelPath = RunConfiguration.getProjectDir() + '/Report_SignUp.xlsx'

		FileInputStream fileInput = new FileInputStream(excelPath)
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput)
		XSSFSheet sheet = workbook.getSheet('ReportPendaftaran')

		int rowCount = sheet.getLastRowNum()
		XSSFRow newRow = sheet.createRow(rowCount + 1)

		// Isi kolom A (No) secara otomatis berdasarkan indeks baris
		newRow.createCell(0).setCellValue(rowCount + 1)

		// Isi kolom B sampai seterusnya secara horizontal sesuai list data
		for (int i = 0; i < dataList.size(); i++) {
			newRow.createCell(i + 1).setCellValue(dataList.get(i).toString())
		}

		fileInput.close()
		FileOutputStream fileOutput = new FileOutputStream(excelPath)
		workbook.write(fileOutput)
		fileOutput.close()
		workbook.close()
	}
}
