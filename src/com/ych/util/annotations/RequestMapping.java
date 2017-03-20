package com.ych.util.annotations;

import java.lang.annotation.*;

/**
 * Created by hua on 2017/2/14.
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {

    String value() default "";
}
