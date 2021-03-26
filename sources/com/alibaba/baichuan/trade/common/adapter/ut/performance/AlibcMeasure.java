package com.alibaba.baichuan.trade.common.adapter.ut.performance;

public class AlibcMeasure {
    protected Double a;
    protected Double b;
    protected String c;
    protected Double d;

    public AlibcMeasure(String str) {
        this(str, Double.valueOf(0.0d));
    }

    public AlibcMeasure(String str, Double d2) {
        this(str, d2, Double.valueOf(0.0d), null);
    }

    public AlibcMeasure(String str, Double d2, Double d3, Double d4) {
        double d5 = 0.0d;
        Double valueOf = Double.valueOf(0.0d);
        this.a = valueOf;
        this.b = valueOf;
        this.d = valueOf;
        this.a = d3;
        this.b = d4;
        this.c = str;
        this.d = Double.valueOf(d2 != null ? d2.doubleValue() : d5);
    }

    public Double getConstantValue() {
        return this.d;
    }

    public Double getMax() {
        return this.b;
    }

    public Double getMin() {
        return this.a;
    }

    public String getName() {
        return this.c;
    }

    public void setConstantValue(Double d2) {
        this.d = d2;
    }

    public void setMax(Double d2) {
        this.b = d2;
    }

    public void setMin(Double d2) {
        this.a = d2;
    }

    public void setRange(Double d2, Double d3) {
        this.a = d2;
        this.b = d3;
    }

    public boolean valid(AlibcMeasureValue alibcMeasureValue) {
        Double valueOf = Double.valueOf(alibcMeasureValue.getValue());
        return valueOf != null && (this.a == null || valueOf.doubleValue() >= this.a.doubleValue()) && (this.b == null || valueOf.doubleValue() <= this.b.doubleValue());
    }
}
