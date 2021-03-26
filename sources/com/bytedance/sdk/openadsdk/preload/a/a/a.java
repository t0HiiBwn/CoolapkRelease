package com.bytedance.sdk.openadsdk.preload.a.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Expose */
public @interface a {
    boolean a() default true;

    boolean b() default true;
}
