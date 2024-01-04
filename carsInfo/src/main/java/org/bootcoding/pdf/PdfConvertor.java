package org.bootcoding.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.bootcoding.writer.IFileWriter;

import java.io.FileOutputStream;
import java.util.List;

public class PdfConvertor implements IFileWriter {

    @Override
    public void write(List data, String outputPath) {
        Document document = new Document();
        try{
            PdfWriter pdfWriter = PdfWriter.getInstance(document,new FileOutputStream(outputPath));

            String  lines , tableCells;
            int index = 1;

            document.open();

            PdfPTable pdfPTable = new PdfPTable(10);
            pdfPTable.addCell("index");
            pdfPTable.addCell("model");
            pdfPTable.addCell("year");
            pdfPTable.addCell("price");
            pdfPTable.addCell("transmission");
            pdfPTable.addCell("mileage");
            pdfPTable.addCell("fuelType");
            pdfPTable.addCell("tax");
            pdfPTable.addCell("mpg");
            pdfPTable.addCell("engineSize");

            for(Object d: data){
                lines = d.toString();
                String[] LineArray = lines.split(",");
                pdfPTable.addCell(String.valueOf(index++));
                for(int k=0;k<LineArray.length;k++){
                    tableCells = LineArray[k];
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