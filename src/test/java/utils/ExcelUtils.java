package utils;

import cucumber.api.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExcelUtils {

    public static void logScenarioToExcel(Scenario scenario, LocalTime start, LocalTime end, Duration duration, String browserName) {
        String path = "src/test/resources/logs/log.xlsx";
        File file = new File(path);
        if (!file.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("Scenario Id");
            row.createCell(1).setCellValue("Scenario Name");
            row.createCell(2).setCellValue("Browser Name");
            row.createCell(3).setCellValue("Start Time");
            row.createCell(4).setCellValue("End Time");
            row.createCell(5).setCellValue("Duration");
            row.createCell(6).setCellValue("Status");
            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue(scenario.getId());
            row1.createCell(1).setCellValue(scenario.getName());
            row1.createCell(2).setCellValue(browserName);
            row1.createCell(3).setCellValue(start.format(DateTimeFormatter.ISO_TIME));
            row1.createCell(4).setCellValue(end.format(DateTimeFormatter.ISO_TIME));
            row1.createCell(5).setCellValue(duration.toMillis() + " miliseconds");
            row1.createCell(6).setCellValue(scenario.getStatus());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            } catch (IOException exception) {
            }
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                Workbook workbook = WorkbookFactory.create(fileInputStream);
                Sheet sheet = workbook.getSheetAt(0);
                int rowCount = sheet.getPhysicalNumberOfRows();
                Row row = sheet.createRow(rowCount);
                row.createCell(0).setCellValue(scenario.getId());
                row.createCell(1).setCellValue(scenario.getName());
                row.createCell(2).setCellValue(browserName);
                row.createCell(3).setCellValue(start.format(DateTimeFormatter.ISO_TIME));
                row.createCell(4).setCellValue(end.format(DateTimeFormatter.ISO_TIME));
                row.createCell(5).setCellValue(duration.toMillis() + " miliseconds");
                row.createCell(6).setCellValue(scenario.getStatus());
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
    public static void logTestToExcel(String testName, LocalDate startDate, LocalDate finishDate, LocalTime startTime, LocalTime endTime, Duration duration) {
        String path = "src/test/resources/logs/testLogs.xlsx";
        File file = new File(path);
        if (!file.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("Test Name");
            row.createCell(1).setCellValue("Start Date");
            row.createCell(2).setCellValue("Finish Date");
            row.createCell(3).setCellValue("Start Time");
            row.createCell(4).setCellValue("End Time");
            row.createCell(5).setCellValue("Duration");
            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue(testName);
            row1.createCell(1).setCellValue(startDate.toString());
            row1.createCell(2).setCellValue(finishDate.toString());
            row1.createCell(3).setCellValue(startTime.format(DateTimeFormatter.ISO_TIME));
            row1.createCell(4).setCellValue(endTime.format(DateTimeFormatter.ISO_TIME));
            row1.createCell(5).setCellValue(duration.toMinutes() + " minutes");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                Workbook workbook = WorkbookFactory.create(fileInputStream);
                Sheet sheet = workbook.getSheetAt(0);
                int rowCount = sheet.getPhysicalNumberOfRows();
                Row row = sheet.createRow(rowCount);
                row.createCell(0).setCellValue(testName);
                row.createCell(1).setCellValue(startDate.toString());
                row.createCell(2).setCellValue(finishDate.toString());
                row.createCell(3).setCellValue(startTime.format(DateTimeFormatter.ISO_TIME));
                row.createCell(4).setCellValue(endTime.format(DateTimeFormatter.ISO_TIME));
                row.createCell(5).setCellValue(duration.toMinutes() + " minutes");
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
