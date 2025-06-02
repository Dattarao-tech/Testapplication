package com.quest_global.Questdemo;

import java.io.File;

import com.lowagie.text.pdf.PdfDocument;

public class Demoexample {
	public static void main(String[] args) {
		File f1 = new File("C:\\Users\\Microsoft\\Desktop\\result1\\Mindgate - Offer Letter - Dattarao Deosarkar.pdf");
		File f2 = new File("C:\\Users\\Microsoft\\Desktop\\result1\\QuEST Offer Letter-Dattarao Deosarkar (1).pdf");
		File newfile = new File("C:\\Users\\Microsoft\\Desktop\\result");
		newfile.mkdir();
		PDFMergeUtility pdfmeger= new PDFMergeUtility();
		
	}
}
