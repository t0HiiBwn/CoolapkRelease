package com.alibaba.fastjson.support.spring;

public class FastJsonContainer {
    private PropertyPreFilters filters;
    private Object value;

    FastJsonContainer(Object obj) {
        this.value = obj;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public PropertyPreFilters getFilters() {
        return this.filters;
    }

    public void setFilters(PropertyPreFilters propertyPreFilters) {
        this.filters = propertyPreFilters;
    }
}
