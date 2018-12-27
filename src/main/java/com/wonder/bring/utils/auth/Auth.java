package com.wonder.bring.utils.auth;

import java.lang.annotation.*;

@Target(ElementType.METHOD)

@Retention(RetentionPolicy.RUNTIME)

@Documented

@Inherited
public @interface Auth {
}


