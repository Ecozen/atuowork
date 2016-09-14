package com.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
    private String filePath;
    private String sheetName;
    private Workbook workBook;    
    private Sheet sheet;
    private List<String> columnHeaderList;
    private List<List<String>> listData;
    private List<Map<String,String>> mapData;
    private boolean flag;

    public List<Map<String, String>> getMapData() {
		return mapData;
	}

	public ExcelUtil(String filePath, String sheetName) {
        this.filePath = filePath;
        this.sheetName = sheetName;
        this.flag = false;
        this.load();
    }    

	public ExcelUtil(String filePath){
		this.filePath = filePath;
		if (filePath.endsWith(".xlsx")) {
			workBook = new XSSFWorkbook();
		}else if(filePath.endsWith(".xls")){
			workBook = new HSSFWorkbook();
		}
    	
	}
	
    private void load() {
        FileInputStream inStream = null;
        try {
        	inStream = new FileInputStream(new File(filePath));
            workBook = WorkbookFactory.create(inStream);
            sheet = workBook.getSheet(sheetName);
            getSheetData();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(inStream!=null){
                    inStream.close();
                }                
            } catch (IOException e) {                
                e.printStackTrace();
            }
        }
    }

    private String getCellValue(Cell cell) {
        String cellValue = "";
        DataFormatter formatter = new DataFormatter();
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellValue = formatter.formatCellValue(cell);
                    } else {
                        double value = cell.getNumericCellValue();
                        int intValue = (int) value;
                        cellValue = value - intValue == 0 ? String.valueOf(intValue) : String.valueOf(value);
                    }
                    break;
                case Cell.CELL_TYPE_STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    cellValue = String.valueOf(cell.getCellFormula());
                    break;
                case Cell.CELL_TYPE_BLANK:
                    cellValue = "";
                    break;
                case Cell.CELL_TYPE_ERROR:
                    cellValue = "";
                    break;
                default:
                    cellValue = cell.toString().trim();
                    break;
            }
        }
        return cellValue.trim();
    }

    private void getSheetData() {
        listData = new ArrayList<List<String>>();
        mapData = new ArrayList<Map<String, String>>();    
        columnHeaderList = new ArrayList<String>();
        int numOfRows = sheet.getLastRowNum() + 1;
        for (int i = 0; i < numOfRows; i++) {
            Row row = sheet.getRow(i);
            Map<String, String> map = new HashMap<String, String>();
            List<String> list = new ArrayList<String>();
            if (row != null) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    String cellValue = this.getCellValue(cell);
                    if (cellValue!="") {
                    	if (i == 0){
                    		columnHeaderList.add(cellValue);
                    	}
                    	else{                        
                    		map.put(columnHeaderList.get(j), cellValue);
                    	}
                    	list.add(cellValue);
					}
                }
                if (i > 0){
                	if(map.size()>0) mapData.add(map);
                }
                if(list.size()>0) listData.add(list);
            }
        }
        flag = true;
    }
    
    public String getCellData(int row, int col){
        if(row<=0 || col<=0){
            return null;
        }
        if(!flag){
            this.getSheetData();
        }        
        if(listData.size()>=row && listData.get(row-1).size()>=col){
            return listData.get(row-1).get(col-1);
        }else{
            return null;
        }
    }
    
    public String getCellData(int row, String headerName){
        if(row<=0){
            return null;
        }
        if(!flag){
            this.getSheetData();
        }        
        if(mapData.size()>=row && mapData.get(row-1).containsKey(headerName)){
            return mapData.get(row-1).get(headerName);
        }else{
            return null;
        }
    }

    public void writeSheetData(String sheetName,List<String> columnHeaderList,List<List<String>> listData){
    	int rowNum =0;
    	boolean hasHeader = false;
    	sheet = workBook.createSheet(sheetName);
    	for (int i = 0; i < listData.size(); i++) {
    		if(!hasHeader&&columnHeaderList!=null&&columnHeaderList.size()>0){
    			writeRowData(columnHeaderList, rowNum);
    			rowNum =1;
    			hasHeader = true;
    		}
    		List<String> rowData = listData.get(i);
    		writeRowData(rowData, rowNum);
			rowNum++;
		}
    	load(sheetName);
    	
    }
    
    private void load(String sheetName){
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(new File(filePath));
            
            workBook.write(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(stream!=null){
                	stream.close();
                }                
            } catch (IOException e) {                
                e.printStackTrace();
            }
        }
    }
    
    private void writeCellData(String data, Row headers, int colNum){
		Cell cell =headers.createCell(colNum, Cell.CELL_TYPE_STRING);
		cell.setCellValue(data);
    }
    
    private void writeRowData(List<String> rowData,int rowNum){
    	Row row = sheet.createRow(rowNum);
		for (int colNum = 0;colNum < rowData.size(); colNum++) {
			String cellData = rowData.get(colNum);
			writeCellData(cellData, row, colNum);
		}
    }
    
//    public static void main (String args[]){
//    	ExcelUtil util = new ExcelUtil("file/test.xlsx");
//    	List<String> columnHeader = new ArrayList<String>();
//    	List<List<String>> listData = new ArrayList<List<String>>();
//    	columnHeader.add("key");
//    	columnHeader.add("value");
//    	listData.add(columnHeader);
//    	util.writeSheetData("spring", columnHeader, listData);
//    }
}
