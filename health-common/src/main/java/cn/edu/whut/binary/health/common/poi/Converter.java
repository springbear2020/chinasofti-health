package cn.edu.whut.binary.health.common.poi;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-27 14:13 Wednesday
 */
public interface Converter {
    <T> List<T> excelConvertBean(Class<T> var1);
}
