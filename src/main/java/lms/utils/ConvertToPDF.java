package lms.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DTO.StudentDTO;
import DTO.TeacherDTO;
import lms.domain.Student;
import lms.service.StorageService;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ConvertToPDF {
    private static final Logger logger = LoggerFactory.getLogger(ConvertToPDF.class);

    public static Path students(Iterable<StudentDTO> students, String filename) {

        Document document = new Document();
        document.setPageSize(PageSize.A4);
        File file = new File(filename);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<String> columns = new ArrayList<>(
                Arrays.asList("ID", "First name", "Last name", "Personal number", "Username"));

        try {

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            // table.setWidths(new int[]{1, 3, 3, 3, 3, 3, 3, 3, 3, 3});

            Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);

            PdfPCell hcell;
            for (String column : columns) {
                hcell = new PdfPCell(new Phrase(column, headFont));
                hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);
            }
            /*
             * hcell = new PdfPCell(new Phrase("ID", headFont));
             * hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
             * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
             * hcell = new PdfPCell(new Phrase("First name", headFont));
             * hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
             * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
             * hcell = new PdfPCell(new Phrase("Last name", headFont));
             * hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
             * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
             */

            for (StudentDTO student : students) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(student.getId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getFirstName()));
                // cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getLastName()));
                // cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getCardNumber()));
                // cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getUser().getUsername()));
                // cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return file.toPath();
    }

    public static Path student(StudentDTO student, String filename) {

        Document document = new Document();
        document.setPageSize(PageSize.A4);
        File file = new File(filename);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<String> columns = new ArrayList<>(
                Arrays.asList("ID", "First name", "Last name", "Personal number", "Username"));

        try {

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            // table.setWidths(new int[]{1, 3, 3, 3, 3, 3, 3, 3, 3, 3});

            Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);

            PdfPCell hcell;
            for (String column : columns) {
                hcell = new PdfPCell(new Phrase(column, headFont));
                hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);
            }
            /*
             * hcell = new PdfPCell(new Phrase("ID", headFont));
             * hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
             * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
             * hcell = new PdfPCell(new Phrase("First name", headFont));
             * hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
             * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
             * hcell = new PdfPCell(new Phrase("Last name", headFont));
             * hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
             * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
             */


                PdfPCell cell;

                cell = new PdfPCell(new Phrase(student.getId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getFirstName()));
                // cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getLastName()));
                // cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getCardNumber()));
                // cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getUser().getUsername()));
                // cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
            

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return file.toPath();
    }

    

    public static Path teachers(List<TeacherDTO> teachers, String filename) {

        Document document = new Document();
        document.setPageSize(PageSize.A3);
        File file = new File(filename);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<String> columns = new ArrayList<>(Arrays.asList("ID", "First name", "Last name", "Personal number", "Username"));

        try {

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            //table.setWidths(new int[]{1, 3, 3, 3, 3, 3, 3, 3, 3, 3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            for(String column: columns) {
            	hcell = new PdfPCell(new Phrase(column, headFont));
                hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);
            }
            /*
            hcell = new PdfPCell(new Phrase("ID", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            hcell = new PdfPCell(new Phrase("First name", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            hcell = new PdfPCell(new Phrase("Last name", headFont));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);*/

            for (TeacherDTO teacher : teachers) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(teacher.getId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(teacher.getFirstName()));
                //cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(teacher.getLastName()));
                //cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(teacher.getPersonalIdentificationNumber()));
               // cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                
                cell = new PdfPCell(new Phrase(teacher.getUser().getUsername()));
                //cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);


            
            document.close();

            

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }


        

        return file.toPath();
    }
}