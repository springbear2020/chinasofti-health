package cn.edu.whut.binary.health.common.poi.annotation;

import java.lang.annotation.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-27 14:11 Wednesday
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelSheetName {
    String value() default "sheet1";
}
