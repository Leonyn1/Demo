package com.example.demo.aspect;


import java.lang.annotation.*;

/**
 * AOP日志切面注解
 * @author Leon
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiLog {

    String description() default "";
}
