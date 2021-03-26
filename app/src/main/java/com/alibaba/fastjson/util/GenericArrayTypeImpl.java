package com.alibaba.fastjson.util;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public class GenericArrayTypeImpl implements GenericArrayType {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Type genericComponentType;

    public GenericArrayTypeImpl(Type type) {
        this.genericComponentType = type;
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.genericComponentType;
    }

    @Override // java.lang.Object
    public String toString() {
        Type genericComponentType2 = getGenericComponentType();
        StringBuilder sb = new StringBuilder();
        if (genericComponentType2 instanceof Class) {
            sb.append(((Class) genericComponentType2).getName());
        } else {
            sb.append(genericComponentType2.toString());
        }
        sb.append("[]");
        return sb.toString();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            return this.genericComponentType.equals(((GenericArrayType) obj).getGenericComponentType());
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.genericComponentType.hashCode();
    }
}
