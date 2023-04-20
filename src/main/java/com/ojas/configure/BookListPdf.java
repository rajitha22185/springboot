package com.ojas.configure;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ojas.model.Book;


public class BookListPdf {
	public static String genetatePdf(List<Book> list) {

		Document document = new Document();
		String pdf_file_path = null;
		Font font1 = FontFactory.getFont(FontFactory.COURIER, 8, BaseColor.BLACK);
		boolean isPdfGenerated =false;
		document.open();
	

		PdfPTable table = new PdfPTable(3);
		Stream.of("Book ID ", "Book Name ", "Author Name").forEach(headerTitle -> {
			PdfPCell header = new PdfPCell();
			// Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setBorderWidth(1);
			header.setPhrase(new Phrase(headerTitle, font1));
			table.addCell(header);
		});
		pdf_file_path = "C:/Users/ra22185/Downloads/01_SB_DATA_JPA_CRUD/src/main/java/com/ojas/resources/Listpdf.pdf";
		try {
			PdfWriter.getInstance(document, new FileOutputStream(pdf_file_path));
			document.open();

			for (Book b : list) {

				Font font = FontFactory.getFont(FontFactory.COURIER, 8, BaseColor.BLACK);
				PdfPCell bidCell = new PdfPCell(new Phrase(String.valueOf(b.getBid()), font));
				bidCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				bidCell.setHorizontalAlignment(Element.ALIGN_CENTER);

				PdfPCell cnameCell = new PdfPCell(new Phrase(b.getName(), font));
				cnameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cnameCell.setHorizontalAlignment(Element.ALIGN_CENTER);

				PdfPCell caddCell = new PdfPCell(new Phrase(String.valueOf(b.getAuthor()), font));
				caddCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				caddCell.setHorizontalAlignment(Element.ALIGN_CENTER);

				table.addCell(bidCell);
				table.addCell(cnameCell);
				table.addCell(caddCell);

			
				
			}
			table.setWidthPercentage(100);
			document.add(table);
			isPdfGenerated=true;
			System.out.println("Pdf Created");
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pdf_file_path;

	}

}
