package com.ruoyi.common.annotation;

import java.lang.annotation.*;

/**
 * Security允许匿名访问
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnonymousAccess {
}