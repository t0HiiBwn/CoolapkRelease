package com.alibaba.fastjson.asm;

public class MethodCollector {
    private int currentParameter;
    protected boolean debugInfoPresent;
    private final int ignoreCount;
    private final int paramCount;
    private final StringBuilder result = new StringBuilder();

    protected MethodCollector(int i, int i2) {
        this.ignoreCount = i;
        this.paramCount = i2;
        boolean z = false;
        this.currentParameter = 0;
        this.debugInfoPresent = i2 == 0 ? true : z;
    }

    protected void visitLocalVariable(String str, int i) {
        int i2 = this.ignoreCount;
        if (i >= i2 && i < i2 + this.paramCount) {
            if (!str.equals("arg" + this.currentParameter)) {
                this.debugInfoPresent = true;
            }
            this.result.append(',');
            this.result.append(str);
            this.currentParameter++;
        }
    }

    protected String getResult() {
        return this.result.length() != 0 ? this.result.substring(1) : "";
    }
}
