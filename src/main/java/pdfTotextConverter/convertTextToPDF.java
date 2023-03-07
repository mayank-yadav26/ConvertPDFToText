package pdfTotextConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class convertTextToPDF {
	public static void main(String[] args) {
		String fileName = "/home/mayank/Downloads/Mayank's Resume.pdf";
		String parsedText = null;
		PDDocument pdDoc = null;
		try {
			// load file
			pdDoc = PDDocument.load(new File(fileName));
			PDFTextStripper pdfStripper = new PDFTextStripper();
			parsedText = pdfStripper.getText(pdDoc);
			// write data to text file
			PrintWriter pw = new PrintWriter("/home/mayank/Downloads/Mayank's Resume.txt");
			pw.print(parsedText);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if (pdDoc != null) {
						pdDoc.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
