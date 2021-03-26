package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* compiled from: EventWhiteList */
public class b extends EventList {
    private d a;
    private Object b = new Object();

    public b(String str, String str2) {
        super(str, str2);
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a2;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.b) {
            if (this.a == null) {
                this.a = new d(true, this.mEventList);
            }
            a2 = this.a.a(str);
        }
        return a2;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_WL = z;
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (!TextUtils.isEmpty(this.mEventList)) {
            synchronized (this.b) {
                this.a = null;
                this.a = new d(true, this.mEventList);
            }
        }
    }
}
