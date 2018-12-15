package com.weweb.common.annotation;

import java.lang.annotation.*;

/**
 * Created by shen on 2016/5/28.
 */
@Documented
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/**
 */
public @interface ValidationEntity {
}
