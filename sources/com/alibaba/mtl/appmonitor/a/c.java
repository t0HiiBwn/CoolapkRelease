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
    private Metric f40a;
    private DimensionValueSet b;

    /* renamed from: b  reason: collision with other field name */
    private MeasureValueSet f41b;

    /* renamed from: b  reason: collision with other field name */
    private Long f42b;
    private Map<String, MeasureValue> i;

    public boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        List<Measure> measures = this.f40a.getMeasureSet().getMeasures();
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
            this.f42b = Long.valueOf(currentTimeMillis);
        }
        this.i.put(str, (MeasureValue) a.a().a(MeasureValue.class, Double.valueOf((double) currentTimeMillis), Double.valueOf((double) (currentTimeMillis - this.f42b.longValue()))));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m4a(String str) {
        MeasureValue measureValue = this.i.get(str);
        if (measureValue != null) {
            double currentTimeMillis = (double) System.currentTimeMillis();
            i.a("DurationEvent", "statEvent consumeTime. module:", this.o, " monitorPoint:", this.p, " measureName:", str, " time:", Double.valueOf(currentTimeMillis - measureValue.getValue()));
            measureValue.setValue(currentTimeMillis - measureValue.getValue());
            measureValue.setFinish(true);
            this.f41b.setValue(str, measureValue);
            if (this.f40a.getMeasureSet().valid(this.f41b)) {
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
    public MeasureValueSet mo3a() {
        return this.f41b;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d
    /* renamed from: a */
    public DimensionValueSet mo3a() {
        return this.b;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        super.clean();
        this.f40a = null;
        this.f42b = null;
        for (MeasureValue measureValue : this.i.values()) {
            a.a().a((a) measureValue);
        }
        this.i.clear();
        if (this.f41b != null) {
            a.a().a((a) this.f41b);
            this.f41b = null;
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
        this.f40a = metric;
        if (metric.getDimensionSet() != null) {
            this.b = (DimensionValueSet) a.a().a(DimensionValueSet.class, new Object[0]);
            this.f40a.getDimensionSet().setConstantValue(this.b);
        }
        this.f41b = (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
    }
}
