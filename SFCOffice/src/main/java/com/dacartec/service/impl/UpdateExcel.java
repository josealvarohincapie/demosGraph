package com.dacartec.service.impl;

import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

public class UpdateExcel {

    public static void main(String[] args) {

        //Create a Workbook object
        Workbook wb = new Workbook();

        //Load an existing Excel file
        wb.loadFromFile("C:\\Users\\alvar\\Downloads\\excelTest.xlsx");

        //Get the first worksheet
        Worksheet sheet = wb.getWorksheets().get(0);

        //Change the value of a specific cell
        sheet.getRange().get("A1").setValue("Updated Value");

        //Save to file
        wb.saveToFile("C:\\Users\\alvar\\Downloads\\excelTest.xlsx", ExcelVersion.Version2016);
    }
}