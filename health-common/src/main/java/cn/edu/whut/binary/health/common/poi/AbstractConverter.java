package cn.edu.whut.binary.health.common.poi;


import cn.edu.whut.binary.health.common.poi.annotation.ExcelColumnName;
import cn.edu.whut.binary.health.common.poi.annotation.ExcelSheetName;
import cn.edu.whut.binary.health.common.poi.exception.ConverterException;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-27 14:13 Wednesday
 */
public abstract class AbstractConverter {

    public AbstractConverter() {
    }

    protected <T> String getSheetNameOnAnnotation(Class<T> clazz) {
        ExcelSheetName sheetNameAnnotation = clazz.getDeclaredAnnotation(ExcelSheetName.class);
        return sheetNameAnnotation == null ? "sheet1" : sheetNameAnnotation.value();
    }

    protected Sheet getWorkSheet(String fileAbsolutePath, String sheetName) throws ConverterException, IOException {
        InputStream inputStream = new FileInputStream(fileAbsolutePath);
        String fileSuffix = fileAbsolutePath.substring(fileAbsolutePath.lastIndexOf(46));
        Workbook workbook;
        if (!(".xls".equals(fileSuffix) || ".xlsx".equals(fileSuffix))) {
            throw new ConverterException(fileAbsolutePath + " (The file you chosen is not a excel file)");
        }
        workbook = HSSFWorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new ConverterException("@ExcelSheetName(\"" + sheetName + "\") (The sheet name you given is not exists)");
        } else {
            inputStream.close();
            return sheet;
        }
    }

    protected <T> Map<String, Field> getFieldsWithColumnNameAnnotation(Class<T> clazz) {
        HashMap<String, Field> validFieldMap = new HashMap<>();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            ExcelColumnName fieldAnnotation = field.getAnnotation(ExcelColumnName.class);
            if (fieldAnnotation != null) {
                String columnName = fieldAnnotation.value();
                if (columnName.length() > 0) {
                    validFieldMap.put(columnName, field);
                }
            }
        }

        return validFieldMap;
    }

    protected List<String> getSheetHeaderInformation(Sheet sheet) {
        List<String> sheetHeaderList = new ArrayList<>();
        Row row = sheet.getRow(0);

        for (Cell cell : row) {
            sheetHeaderList.add(cell.getStringCellValue());
        }

        return sheetHeaderList;
    }

    protected <T> void setFieldValueAccordingType(Cell cell, Field field, T instance) throws IllegalAccessException {
        if (cell != null) {
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            if (Boolean.class.equals(fieldType)) {
                cell.setCellType(CellType.BOOLEAN);
                field.set(instance, cell.getBooleanCellValue());
            } else {
                String cellValue;
                if (Character.class.equals(fieldType)) {
                    cell.setCellType(CellType.STRING);
                    cellValue = cell.getStringCellValue();
                    cellValue = cellValue.trim();
                    field.set(instance, cellValue);
                } else if (String.class.equals(fieldType)) {
                    cell.setCellType(CellType.STRING);
                    cellValue = cell.getStringCellValue();
                    cellValue = cellValue.trim();
                    field.set(instance, cellValue);
                } else if (Date.class.equals(fieldType)) {
                    field.set(instance, cell.getDateCellValue());
                } else if (Byte.class.equals(fieldType)) {
                    field.set(instance, (byte) ((int) cell.getNumericCellValue()));
                } else if (Short.class.equals(fieldType)) {
                    field.set(instance, (short) ((int) cell.getNumericCellValue()));
                } else if (Integer.class.equals(fieldType)) {
                    field.set(instance, (int) cell.getNumericCellValue());
                } else if (Float.class.equals(fieldType)) {
                    field.set(instance, (float) cell.getNumericCellValue());
                } else if (Long.class.equals(fieldType)) {
                    field.set(instance, (long) cell.getNumericCellValue());
                } else if (Double.class.equals(fieldType)) {
                    field.set(instance, cell.getNumericCellValue());
                }
            }
        }
    }
}

