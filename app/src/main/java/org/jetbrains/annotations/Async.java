package org.jetbrains.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface Async {

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.CLASS)
    public @interface Execute {
    }

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.CLASS)
    public @interface Schedule {
    }
}
