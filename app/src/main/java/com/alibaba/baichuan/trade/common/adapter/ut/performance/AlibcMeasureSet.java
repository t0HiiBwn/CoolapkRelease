package com.alibaba.baichuan.trade.common.adapter.ut.performance;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AlibcMeasureSet {
    private List<AlibcMeasure> a = new ArrayList(3);

    private AlibcMeasureSet() {
    }

    public static AlibcMeasureSet create() {
        return new AlibcMeasureSet();
    }

    public static AlibcMeasureSet create(Collection<String> collection) {
        AlibcMeasureSet alibcMeasureSet = new AlibcMeasureSet();
        if (collection != null) {
            for (String str : collection) {
                alibcMeasureSet.addMeasure(str);
            }
        }
        return alibcMeasureSet;
    }

    public static AlibcMeasureSet create(String[] strArr) {
        AlibcMeasureSet alibcMeasureSet = new AlibcMeasureSet();
        if (strArr != null) {
            for (String str : strArr) {
                alibcMeasureSet.addMeasure(str);
            }
        }
        return alibcMeasureSet;
    }

    public AlibcMeasureSet addMeasure(AlibcMeasure alibcMeasure) {
        if (!this.a.contains(alibcMeasure)) {
            this.a.add(alibcMeasure);
        }
        return this;
    }

    public AlibcMeasureSet addMeasure(String str) {
        return addMeasure(new AlibcMeasure(str));
    }

    public AlibcMeasure getMeasure(String str) {
        for (AlibcMeasure alibcMeasure : this.a) {
            if (alibcMeasure.getName().equals(str)) {
                return alibcMeasure;
            }
        }
        return null;
    }

    public List<AlibcMeasure> getMeasures() {
        return this.a;
    }

    public void setConstantValue(AlibcMeasureValueSet alibcMeasureValueSet) {
        List<AlibcMeasure> list = this.a;
        if (!(list == null || alibcMeasureValueSet == null)) {
            for (AlibcMeasure alibcMeasure : list) {
                if (alibcMeasure.getConstantValue() != null && alibcMeasureValueSet.getValue(alibcMeasure.getName()) == null) {
                    alibcMeasureValueSet.setValue(alibcMeasure.getName(), alibcMeasure.getConstantValue().doubleValue());
                }
            }
        }
    }

    public void upateMeasure(AlibcMeasure alibcMeasure) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.a.get(i).c, alibcMeasure.c)) {
                this.a.get(i).setMax(alibcMeasure.getMax());
                this.a.get(i).setMin(alibcMeasure.getMin());
                this.a.get(i).setConstantValue(alibcMeasure.getConstantValue());
            }
        }
    }

    public void upateMeasures(List<AlibcMeasure> list) {
        int size = this.a.size();
        int size2 = list.size();
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (TextUtils.equals(this.a.get(i).c, list.get(i2).c)) {
                    this.a.get(i).setMax(list.get(i2).getMax());
                    this.a.get(i).setMin(list.get(i2).getMin());
                }
            }
        }
    }

    public boolean valid(AlibcMeasureValueSet alibcMeasureValueSet) {
        if (this.a == null) {
            return true;
        }
        if (alibcMeasureValueSet == null) {
            return false;
        }
        for (int i = 0; i < this.a.size(); i++) {
            AlibcMeasure alibcMeasure = this.a.get(i);
            if (alibcMeasure != null) {
                String name = alibcMeasure.getName();
                if (!(alibcMeasureValueSet.containValue(name) && alibcMeasure.valid(alibcMeasureValueSet.getValue(name)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
