package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

public class Service {
    private Class<?> a;
    private Class<?> b;
    private boolean c;

    public static class Builder {
        Class<?> a;
        Class<?> b;
        private boolean c;

        private Builder(Class<?> cls, Class<?> cls2) {
            if (cls == null) {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            } else if (cls2 == null) {
                throw new IllegalArgumentException("the clazz parameter cannot be NULL");
            } else if (cls2.isInterface() || !Modifier.isPublic(cls2.getModifiers())) {
                throw new IllegalArgumentException("the clazz parameter must be interface type and public");
            } else {
                this.a = cls;
                this.b = cls2;
                this.c = cls2.isAnnotationPresent(Singleton.class);
            }
        }

        public Service build() {
            Service service = new Service(this.a, this.b);
            service.c = this.c;
            return service;
        }

        public Builder isSingleton(boolean z) {
            this.c = z;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.a = cls;
        this.b = cls2;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder(cls, cls);
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder(cls, cls2);
    }

    public Class<?> getInterface() {
        return this.a;
    }

    public Class<?> getType() {
        return this.b;
    }

    public boolean isSingleton() {
        return this.c;
    }
}
