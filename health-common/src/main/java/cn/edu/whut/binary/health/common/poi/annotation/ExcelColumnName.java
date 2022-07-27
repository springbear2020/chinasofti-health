package cn.edu.whut.binary.health.common.poi.annotation;

import java.lang.annotation.*;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-27 14:10 Wednesday
 */
@Inherited
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumnName {
    String value() default "";
}
