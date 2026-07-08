package com.report.pdf

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
import internal.GlobalVariable


import com.kms.katalon.core.configuration.RunConfiguration
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.Image
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.Font as Font
import java.io.FileOutputStream
import java.io.File

public class ManualPdfReporter {

	// KUNCI PERBAIKAN: Variabel harus dideklarasikan sebagai public static agar tidak hilang saat dipanggil dari Test Case
	public static List<String> daftarScreenshot = new ArrayList<String>()
	public static int nomorUrut = 1

	def tambahStep(String namaStep) {
		String folderPath = RunConfiguration.getProjectDir() + "/TempManualSnap/"
		//		Buat folder jika belum ada
		File folder = new File(folderPath)
		if (!folder.exists()) {
			folder.mkdirs()
		}

		String cleanStepName = namaStep.replaceAll("[^a-zA-Z0-9]", "_")
		String fullPath = folderPath + "Step_${nomorUrut}_" + cleanStepName + ".png"

		// 1. Ambil screenshot layar saat ini
		WebUI.takeScreenshot(fullPath)

		// 2. Simpan path dan nama step ke dalam list memori (dipisahkan dengan karakter |)
		daftarScreenshot.add(fullPath + "|" + namaStep)
		nomorUrut++
		println("=== [SNAP] Berhasil memotret step: ${namaStep} ===")
	}

	def buatPdf(String namaFilePdf) {
		// Cek apakah list terbaca
		if (daftarScreenshot == null || daftarScreenshot.isEmpty()) {
			println("=== [WARNING] Tidak ada screenshot dalam antrean. PDF batal dibuat. ===")
			return
		}

		String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
		String pdfOutputPath = RunConfiguration.getProjectDir() + "/${namaFilePdf}_${timestamp}.pdf"

		//		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
		//		String pdfOutputPath = RunConfiguration.getProjectDir() + "/${namaFilePdf}_${timestamp}.pdf"

		// 1. Inisialisasi PDF Dokumen
		Document document = new Document()
		PdfWriter.getInstance(document, new FileOutputStream(pdfOutputPath))
		document.open()

		// 2. Tambah Judul Utama Laporan
		Font fontJudul = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD)
		Font fontSub = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC)

		//		document.add(new Paragraph("EXECUTION REPORT AUTOMATION EXERCISE", fontJudul))
		document.add(new Paragraph("EXECUTION REPORT - " + namaFilePdf, fontJudul))
		//		document.add(new Paragraph("Tanggal Cetak: " + new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), fontSub))
		document.add(new Paragraph("Tanggal Cetak: " + new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()), fontSub))
		document.add(new Paragraph("By : RamadhanyN", fontSub))
		document.add(new Paragraph("\n" + "="*75 + "\n\n"))

		// 3. Masukkan gambar dari antrean ke dalam PDF
		for (int i = 0; i < daftarScreenshot.size(); i++) {
			// Pecah kembali path gambar dan nama keterangan step-nya
			String[] parts = daftarScreenshot.get(i).split("\\|")
			String imgPath = parts[0]
			String keteranganStep = parts[1]

			File imgFile = new File(imgPath)
			if (imgFile.exists()) {
				// Tulis keterangan step di atas gambar
				document.add(new Paragraph("Step ${i + 1}: ${keteranganStep}", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)))
				document.add(new Paragraph("\n"))

				// Atur ukuran gambar pas kertas PDF
				Image pdfImg = Image.getInstance(imgPath)
				//				pdfImg.scaleToFit(document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin(),
				//						document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin() - 100)

				float lebarKertas = (float) (document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin())
				float tinggiKertas = (float) (document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin() - 100)

				pdfImg.scaleToFit(lebarKertas, tinggiKertas)

				pdfImg.setAlignment(Image.ALIGN_CENTER)

				document.add(pdfImg)

				// Berikan halaman baru (Page Break) jika bukan step terakhir
				if (i < daftarScreenshot.size() - 1) {
					document.newPage()
				}
			}
		}

		document.close()
		println("=== [SUCCESS] Manual PDF Report Sukses Dibuat di: " + pdfOutputPath + " ===")

		// 4. Bersihkan sisa gambar PNG mentah dan reset counter
		for (String item : daftarScreenshot) {
			String path = item.split("\\|")[0]
			new File(path).delete()
		}
		daftarScreenshot.clear()
		nomorUrut = 1
	}
}
