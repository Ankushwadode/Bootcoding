package org.bootCoding.pdf;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.bootCoding.writer.IFileWriter;

import java.io.*;
import java.util.List;

public class PdfConvertors implements IFileWriter {

     @Override
     public void write(List data, String outputPath) {
          Document document = new Document();
          try{
               PdfWriter pdfWriter = PdfWriter.getInstance(document,new FileOutputStream(outputPath));
               String lines,tableCells;
               document.open();

               PdfPTable pdfPTable = new PdfPTable(6);
               pdfPTable.addCell("SquareFeet");
               pdfPTable.addCell("Bedrooms");
               pdfPTable.addCell("Bathrooms");
               pdfPTable.addCell("Neighborhood");
               pdfPTable.addCell("YearBuilt");
               pdfPTable.addCell("Price");

               for (Object d: data) {
                    lines = d.toString();
                    String[] lineArray = lines.split(",");
                    for (int i=0;i<lineArray.length;i++){
                         tableCells = lineArray[i];
                         pdfPTable.addCell(tableCells);
                    }
               }
               document.add(pdfPTable);
               document.close();
          }catch (Exception ex){
               ex.printStackTrace();
          }
     }
}
