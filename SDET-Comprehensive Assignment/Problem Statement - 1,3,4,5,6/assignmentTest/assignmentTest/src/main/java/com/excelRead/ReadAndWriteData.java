package com.excelRead;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadAndWriteData {

    private static final String FILE_PATH = "./JavaProblem.xlsx";

    public static void main(String[] args) throws Exception{
        List<Map<String, String>> data = readExcelData(FILE_PATH);
        displayData(data);
    }

    private static List<Map<String, String>> readExcelData(String filePath) throws IOException {
        List<Map<String, String>> dataList = new ArrayList<>();

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

        int rows = sheet.getPhysicalNumberOfRows();
        if (rows > 1) { // Assuming header is present
            Row headerRow = sheet.getRow(0);

            for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
                Row currentRow = sheet.getRow(rowIndex);
                if (currentRow == null) {
                    continue; // Skip null rows
                }

                Map<String, String> rowData = new HashMap<>();

                for (int colIndex = 0; colIndex < headerRow.getPhysicalNumberOfCells(); colIndex++) {
                    Cell headerCell = headerRow.getCell(colIndex);
                    Cell currentCell = currentRow.getCell(colIndex);

                    // Check for null cells
                    if (headerCell == null || currentCell == null) {
                        continue;
                    }

                    // Check the cell type
                    if (currentCell.getCellType() == CellType.NUMERIC) {
                        // Handle numeric cell
                        if (DateUtil.isCellDateFormatted(currentCell)) {
                            // Handle date value if needed
                            rowData.put(headerCell.getStringCellValue(), currentCell.getLocalDateTimeCellValue().toString());
                        } else {
                            rowData.put(headerCell.getStringCellValue(), String.valueOf(currentCell.getNumericCellValue()));
                        }
                    } else if (currentCell.getCellType() == CellType.STRING) {
                        // Handle string cell
                        rowData.put(headerCell.getStringCellValue(), currentCell.getStringCellValue());
                    }
                    // You can add more conditions for other cell types as needed
                }

                dataList.add(rowData);
            }
        }

        workbook.close();
        fis.close();

        return dataList;
    }

    private static void displayData(List<Map<String, String>> data) {
        for (Map<String, String> row : data) {
            System.out.println("Name: " + row.get("Name") +
                    ", Courses: " + row.get("Courses") +
                    ", Fee: " + row.get("Fee"));
        }
    }
}


