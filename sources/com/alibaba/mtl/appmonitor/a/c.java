package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.d.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DurationEvent */
public class c extends d {
    private static final Long a = 300000L;

    /* renamed from: a  reason: collision with other field name */
    private Metric f41a;
    private DimensionValueSet b;

    /* renamed from: b  reason: collision with other field name */
    private MeasureValueSet f42b;

    /* renamed from: b  reason: collision with other field name */
    private Long f43b;
    private Map<String, MeasureValue> i;

    public boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        List<Measure> measures = this.f41a.getMeasureSet().getMeasures();
        if (measures != null) {
            int size = measures.size();
            for (int i2 = 0; i2 < size; i2++) {
                Measure measure = measures.get(i2);
                if (measure != null) {
                    double doubleValue = measure.getMax() != null ? measure.getMax().doubleValue() : (double) a.longValue();
                    MeasureValue measureValue = this.i.get(measure.getName());
                    if (measureValue != null && !measureValue.isFinish() && ((double) currentTimeMillis) - measureValue.getValue() > doubleValue) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.i.isEmpty()) {
            this.f43b = Long.valueOf(currentTimeMillis);
        }
        this.i.put(str, (MeasureValue) a.a().a(MeasureValue.class, Double.valueOf((double) currentTimeMillis), Double.valueOf((double) (currentTimeMillis - this.f43b.longValue()))));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m14a(String str) {
        MeasureValue measureValue = this.i.get(str);
        if (measureValue != null) {
            double currentTimeMillis = (double) System.currentTimeMillis();
            i.a("DurationEvent", "statEvent consumeTime. module:", this.o, " monitorPoint:", this.p, " measureName:", str, " time:", Double.valueOf(currentTimeMillis - measureValue.getValue()));
            measureValue.setValue(currentTimeMillis - measureValue.getValue());
            measureValue.setFinish(true);
            this.f42b.setValue(str, measureValue);
            if (this.f41a.getMeasureSet().valid(this.f42b)) {
                return true;
            }
        }
        return false;
    }

    public void a(DimensionValueSet dimensionValueSet) {
        DimensionValueSet dimensionValueSet2 = this.b;
        if (dimensionValueSet2 == null) {
            this.b = dimensionValueSet;
        } else {
            dimensionValueSet2.addValues(dimensionValueSet);
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d
    /* renamed from: a  reason: collision with other method in class */
    public MeasureValueSet mo13a() {
        return this.f42b;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d
    /* renamed from: a */
    public DimensionValueSet mo13a() {
        return this.b;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        super.clean();
        this.f41a = null;
        this.f43b = null;
        for (MeasureValue measureValue : this.i.values()) {
            a.a().a((a) measureValue);
        }
        this.i.clear();
        if (this.f42b != null) {
            a.a().a((a) this.f42b);
            this.f42b = null;
        }
        if (this.b != null) {
            a.a().a((a) this.b);
            this.b = null;
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        super.fill(objArr);
        if (this.i == null) {
            this.i = new HashMap();
        }
        Metric metric = MetricRepo.getRepo().getMetric(this.o, this.p);
        this.f41a = metric;
        if (metric.getDimensionSet() != null) {
            this.b = (DimensionValueSet) a.a().a(DimensionValueSet.class, new Object[0]);
            this.f41a.getDimensionSet().setConstantValue(this.b);
        }
        this.f42b = (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
    }
}
