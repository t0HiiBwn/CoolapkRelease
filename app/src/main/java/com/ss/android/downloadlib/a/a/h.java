package com.ss.android.downloadlib.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: ZField */
public @interface h {
    boolean a() default false;

    int b();
}
