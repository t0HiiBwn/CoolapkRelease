package com.tencent.android.tpush.stat;

/* compiled from: ProGuard */
public enum StatReportStrategy {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    int v;

    private StatReportStrategy(int i) {
        this.v = i;
    }

    public int getIntValue() {
        return this.v;
    }

    public static StatReportStrategy getStatReportStrategy(int i) {
        StatReportStrategy[] values = values();
        for (StatReportStrategy statReportStrategy : values) {
            if (i == statReportStrategy.getIntValue()) {
                return statReportStrategy;
            }
        }
        return null;
    }
}
