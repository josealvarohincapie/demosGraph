package com.dacartec.service.impl;
import com.spire.xls.CellRange;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

public class ReadData {

    public static void main(String[] args) {

        //Create a Workbook object
        Workbook wb = new Workbook();

        //Load an existing Excel file
        wb.loadFromFile("C:\\Users\\alvar\\Downloads\\excelTest.xlsx");

        //Get the first worksheet
        Worksheet sheet = wb.getWorksheets().get(0);

        //Get the cell range containing data
        CellRange locatedRange = sheet.getAllocatedRange();

        //Iterate through the rows
        for (int i = 0; i < locatedRange.getRows().length; i++) {

            //Iterate through the columns
            for (int j = 0; j < locatedRange.getColumnCount(); j++) {

                //Get data of a specific cell
                System.out.print(locatedRange.get(i + 1, j + 1).getValue() + "  ");
            }
            System.out.println();
        }
    }
}