package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

public class ParseContext {
    public final Object fieldName;
    public final int level;
    public Object object;
    public final ParseContext parent;
    private transient String path;
    public Type type;

    public ParseContext(ParseContext parseContext, Object obj, Object obj2) {
        int i;
        this.parent = parseContext;
        this.object = obj;
        this.fieldName = obj2;
        if (parseContext == null) {
            i = 0;
        } else {
            i = parseContext.level + 1;
        }
        this.level = i;
    }

    public String toString() {
        if (this.path == null) {
            if (this.parent == null) {
                this.path = "$";
            } else if (this.fieldName instanceof Integer) {
                this.path = this.parent.toString() + "[" + this.fieldName + "]";
            } else {
                this.path = this.parent.toString() + "." + this.fieldName;
            }
        }
        return this.path;
    }
}
