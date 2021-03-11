package com.company.test0302;

import java.lang.annotation.*;
import java.util.LinkedList;

import static java.lang.annotation.ElementType.*;

/**
 * @author SmileAlfred
 * @create 2021-03-04 15:48
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
    String value() default "hello";
}

