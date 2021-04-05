package com.core.federix.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class TestService {

    public ByteArrayOutputStream export() throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Doctores");
        sheet.setDefaultColumnWidth(20);

        Object[][] bookData = {
                {"Head First Java", "Kathy Serria", 79},
                {"Effective Java", "Joshua Bloch", 36},
                {"Clean Code", "Robert martin", 42},
                {"Thinking in Java", "Bruce Eckel", 35},
        };

        int rowCount = 0;
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
            int columnCount = 0;
            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        ByteArrayOutputStream res = new ByteArrayOutputStream();
        try {
            workbook.write(res);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error al generar planilla");
        } finally {
            workbook.close();
        }
        return res;
    }
}
