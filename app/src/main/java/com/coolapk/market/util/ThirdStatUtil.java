package com.coolapk.market.util;

import android.app.Activity;
import android.content.Context;
import com.coolapk.market.AppMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eJ\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/util/ThirdStatUtil;", "", "appContext", "Landroid/content/Context;", "appMetadata", "Lcom/coolapk/market/AppMetadata;", "(Landroid/content/Context;Lcom/coolapk/market/AppMetadata;)V", "thirdStat", "", "Lcom/coolapk/market/util/IThirdStat;", "confirmInit", "", "recordCustomKVEvent", "event", "", "kvmap", "", "recordPauseEvent", "activity", "Landroid/app/Activity;", "string", "recordResumeEvent", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ThirdStatUtil.kt */
public final class ThirdStatUtil {
    private final List<IThirdStat> thirdStat;

    public ThirdStatUtil(Context context, AppMetadata appMetadata) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(appMetadata, "appMetadata");
        ArrayList arrayList = new ArrayList();
        this.thirdStat = arrayList;
        arrayList.add(new UmengStat(context, appMetadata));
    }

    public final void recordResumeEvent(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "string");
        Iterator<T> it2 = this.thirdStat.iterator();
        while (it2.hasNext()) {
            it2.next().recordResumeEvent(activity, str);
        }
    }

    public final void recordPauseEvent(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "string");
        Iterator<T> it2 = this.thirdStat.iterator();
        while (it2.hasNext()) {
            it2.next().recordPauseEvent(activity, str);
        }
    }

    public final void confirmInit() {
        Iterator<T> it2 = this.thirdStat.iterator();
        while (it2.hasNext()) {
            it2.next().confirmInit();
        }
    }

    public final void recordCustomKVEvent(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "event");
        Iterator<T> it2 = this.thirdStat.iterator();
        while (it2.hasNext()) {
            it2.next().recordCustomKVEvent(str, map);
        }
    }
}
