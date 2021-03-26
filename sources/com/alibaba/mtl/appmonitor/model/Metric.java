package com.alibaba.mtl.appmonitor.model;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.List;
import java.util.UUID;

public class Metric implements b {
    private DimensionSet b;

    /* renamed from: b  reason: collision with other field name */
    private MeasureSet f50b;
    private boolean g;
    private String o;
    private String p;
    private String r;
    private String s;
    private String z = null;

    @Deprecated
    public Metric() {
    }

    public Metric(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z2) {
        this.o = str;
        this.p = str2;
        this.b = dimensionSet;
        this.f50b = measureSet;
        this.s = null;
        this.g = z2;
    }

    public synchronized String getTransactionId() {
        if (this.r == null) {
            this.r = UUID.randomUUID().toString() + "$" + this.o + "$" + this.p;
        }
        return this.r;
    }

    public void resetTransactionId() {
        this.r = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    public boolean valid(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        DimensionSet dimensionSet = this.b;
        boolean z2 = true;
        boolean valid = dimensionSet != null ? dimensionSet.valid(dimensionValueSet) : true;
        Metric metric = MetricRepo.getRepo().getMetric("config_prefix" + this.o, "config_prefix" + this.p);
        if (metric == null || metric.getMeasureSet() == null || measureValueSet == null || measureValueSet.getMap() == null || this.f50b == null) {
            MeasureSet measureSet = this.f50b;
            if (measureSet == null) {
                return valid;
            }
            if (!valid || !measureSet.valid(measureValueSet)) {
                z2 = false;
            }
            return z2;
        }
        List<Measure> measures = metric.getMeasureSet().getMeasures();
        for (String str : measureValueSet.getMap().keySet()) {
            Measure a = a(str, measures);
            if (a == null) {
                a = a(str, this.f50b.getMeasures());
            }
            if (a == null || !a.valid(measureValueSet.getValue(str))) {
                return false;
            }
            while (r1.hasNext()) {
            }
        }
        return valid;
    }

    private Measure a(String str, List<Measure> list) {
        if (list == null) {
            return null;
        }
        for (Measure measure : list) {
            if (TextUtils.equals(str, measure.name)) {
                return measure;
            }
        }
        return null;
    }

    public String getModule() {
        return this.o;
    }

    public String getMonitorPoint() {
        return this.p;
    }

    public DimensionSet getDimensionSet() {
        return this.b;
    }

    public MeasureSet getMeasureSet() {
        return this.f50b;
    }

    public synchronized boolean isCommitDetail() {
        if ("1".equalsIgnoreCase(this.z)) {
            return true;
        }
        if ("0".equalsIgnoreCase(this.z)) {
            return false;
        }
        return this.g;
    }

    public int hashCode() {
        int i;
        String str = this.s;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i3 = (i + 31) * 31;
        String str2 = this.o;
        int hashCode = (i3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.p;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Metric metric = (Metric) obj;
        String str = this.s;
        if (str == null) {
            if (metric.s != null) {
                return false;
            }
        } else if (!str.equals(metric.s)) {
            return false;
        }
        String str2 = this.o;
        if (str2 == null) {
            if (metric.o != null) {
                return false;
            }
        } else if (!str2.equals(metric.o)) {
            return false;
        }
        String str3 = this.p;
        if (str3 == null) {
            if (metric.p != null) {
                return false;
            }
        } else if (!str3.equals(metric.p)) {
            return false;
        }
        return true;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        this.o = null;
        this.p = null;
        this.s = null;
        this.g = false;
        this.b = null;
        this.f50b = null;
        this.r = null;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        this.o = (String) objArr[0];
        this.p = (String) objArr[1];
        if (objArr.length > 2) {
            this.s = (String) objArr[2];
        }
    }

    public synchronized void setCommitDetailFromConfig(String str) {
        this.z = str;
    }
}
