package cn.edu.whut.binary.health.common.poi;

import cn.edu.whut.binary.health.common.poi.exception.ConverterException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-27 14:13 Wednesday
 */
public class SheetBeanConverter extends AbstractConverter implements Converter {
    private final String excelFileAbsoluteFullPath;

    public SheetBeanConverter(String excelFileAbsoluteFullPath) {
        this.excelFileAbsoluteFullPath = excelFileAbsoluteFullPath;
    }

    public <T> List<T> excelConvertBean(Class<T> clazz) {
        String sheetName = this.getSheetNameOnAnnotation(clazz);

        try {
            Sheet sheet = this.getWorkSheet(this.excelFileAbsoluteFullPath, sheetName);
            int rowSize = sheet.getLastRowNum() + 1;
            if (rowSize < 2) {
                throw new ConverterException("There is no valid data in the \"" + sheetName + "\" work sheet");
            } else {
                List<String> sheetHeaderList = this.getSheetHeaderInformation(sheet);
                Map<String, Field> validFieldMap = this.getFieldsWithColumnNameAnnotation(clazz);
                List<Integer> validSheetColumnIndex = this.getValidSheetColumnIndex(sheetHeaderList, validFieldMap);
                List<T> beanList = this.traverseSheet(sheet, rowSize, validSheetColumnIndex, sheetHeaderList, validFieldMap, clazz);
                System.out.println("********************************************************");
                System.out.println("* [ExcelBeanConverter] Work sheet row data size is " + (rowSize - 1) + " *");
                System.out.println("* [ExcelBeanConverter] Generate number of beans is " + beanList.size() + " *");
                System.out.println("********************************************************");
                return beanList;
            }
        } catch (IOException | ReflectiveOperationException | ConverterException var9) {
            var9.printStackTrace();
            return null;
        }
    }

    protected List<Integer> getValidSheetColumnIndex(List<String> sheetHeaderList, Map<String, Field> validFieldMap) {
        List<Integer> validSheetColumnIndex = new ArrayList<>();
        Set<String> validFieldColumnNames = validFieldMap.keySet();
        int sheetCols = sheetHeaderList.size();

        for (String validFieldColumnName : validFieldColumnNames) {
            for (int i = 0; i < sheetCols; ++i) {
                if (validFieldColumnName.equals(sheetHeaderList.get(i))) {
                    validSheetColumnIndex.add(i);
                }
            }
        }

        return validSheetColumnIndex;
    }

    private <T> List<T> traverseSheet(Sheet sheet, int rowSize, List<Integer> validSheetColumnIndex, List<String> sheetHeaderList, Map<String, Field> validFieldMap, Class<T> clazz) throws ReflectiveOperationException {
        List<T> beanList = new ArrayList<>();

        for (int rowIndex = 1; rowIndex < rowSize; ++rowIndex) {
            Row row = sheet.getRow(rowIndex);
            T instance = clazz.newInstance();

            for (Integer sheetColumnIndex : validSheetColumnIndex) {
                Cell cell = row.getCell(sheetColumnIndex);
                String sheetColumnName = sheetHeaderList.get(sheetColumnIndex);
                Field field = validFieldMap.get(sheetColumnName);
                this.setFieldValueAccordingType(cell, field, instance);
            }

            beanList.add(instance);
        }

        return beanList;
    }
}

