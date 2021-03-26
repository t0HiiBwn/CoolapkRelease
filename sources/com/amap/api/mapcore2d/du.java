package com.amap.api.mapcore2d;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: EntityClass */
public @interface du {
    String a();

    boolean b() default false;
}
