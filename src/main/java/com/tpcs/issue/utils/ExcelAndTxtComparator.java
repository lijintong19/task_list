package com.tpcs.issue.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelAndTxtComparator {
    public static void main(String[] args) {
        //存储txt文件名和大小的Map
        Map<String, String> txtFileMap = new HashMap<>();
        //excel文件路径
        String excelFilePath = "C:\\Users\\lijt\\Documents\\perl\\pratice\\perl_test\\excelTest\\HR0002_TPCS-HFC_Tooling_Form_20240711_v1.xlsx";
        //txt文件路径
        String[] txtFilePath = {
            "C:\\Users\\lijt\\Documents\\perl\\pratice\\perl_test\\excelTest\\cksum_ca000z.txt",
            "C:\\Users\\lijt\\Documents\\perl\\pratice\\perl_test\\excelTest\\cksum_m1001z.txt",
            "C:\\Users\\lijt\\Documents\\perl\\pratice\\perl_test\\excelTest\\cksum_NP000Z.txt",
            "C:\\Users\\lijt\\Documents\\perl\\pratice\\perl_test\\excelTest\\cksum_PC001Z.txt",
            "C:\\Users\\lijt\\Documents\\perl\\pratice\\perl_test\\excelTest\\cksum_V1000Z.txt"
        };

        for (String filePath : txtFilePath) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
             //读取txt文件中的文件名和大小，存储在Map中 parts[2]文件名  parts[1]软件size大小
             String line;
             while ((line = br.readLine()) != null) {
                 String[] parts = line.split("\\s+");
                 if (parts.length >= 2) {
                     txtFileMap.put(parts[2], parts[1]);
                 }
             }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
             Workbook workbook = new XSSFWorkbook(fis);) {
            // 获取名为md5sum的工作表
            Sheet sheet = workbook.getSheet("md5sum");
            if (sheet == null) {
                System.out.println("Sheet 'md5sum' not found in the Excel file.");
                return;
            }
            System.out.println("=============================start program=======================================");
            // 遍历Excel中的每一行，比较文件名和大小
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    continue; // 跳过空行
                }

                Cell fileNameCell = row.getCell(2); // 第三列是文件名
                Cell fileSizeCell = row.getCell(3); // 第四列是文件大小

                if (fileNameCell != null && fileSizeCell != null) {
                    String fileName = fileNameCell.getStringCellValue();
                    String fileSize = String.valueOf((long) fileSizeCell.getNumericCellValue());
                    String txtFileSize = txtFileMap.get(fileName);
                    if (txtFileSize != null && !txtFileSize.equals(fileSize)) {
                        System.out.println("Mismatch found for file: " + fileName +
                                " (Excel size: " + fileSize + ", TXT size: " + txtFileSize + ")");
                    }
                }
            }
            System.out.println("=============================end program=========================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

