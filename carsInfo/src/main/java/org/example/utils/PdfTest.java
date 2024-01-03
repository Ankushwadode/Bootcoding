package org.example.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class PdfTest {
    public static void main(String[] args) throws IOException, DocumentException, CsvValidationException {
        /* Step -1 : Read input CSV file in Java */
        String inputCSVFile = "src/main/resources/output/Allcars.csv";
        CSVReader reader = new CSVReader(new FileReader(inputCSVFile));

        /* Variables to loop through the CSV File */
        String [] nextLine; /* for every line in the file */

        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_data = new Document();
        PdfWriter.getInstance(my_pdf_data, new FileOutputStream("src/main/resources/output/converted_PDF_File.pdf"));
        my_pdf_data.open();
        PdfPTable   myFirstTable = new PdfPTable(9);
        PdfPCell table_cell;

        /* Step -3: Loop through CSV file and populate data to PDF table */
        while ((nextLine = reader.readNext()) != null) {

            for(String cellValue: nextLine){
                addValue(cellValue, myFirstTable);
            }
        }

        /* Step -4: Attach table to PDF and close the document */
        my_pdf_data.add(myFirstTable);
        my_pdf_data.close();
    }

    private static void addValue(String value, PdfPTable myFirstTable){
        PdfPCell table_cell=new PdfPCell(new Phrase(value));
        myFirstTable.addCell(table_cell);
    }
}
