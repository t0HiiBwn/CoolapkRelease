package com.coolapk.market.util;

import android.app.Activity;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J&\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H&¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/util/IThirdStat;", "", "confirmInit", "", "recordCountEvent", "category", "", "key", "recordCustomKVEvent", "event", "kvmap", "", "recordPauseEvent", "activity", "Landroid/app/Activity;", "string", "recordResumeEvent", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ThirdStatUtil.kt */
public interface IThirdStat {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* compiled from: ThirdStatUtil.kt */
    public static final class DefaultImpls {
        public static void confirmInit(IThirdStat iThirdStat) {
        }
    }

    void confirmInit();

    void recordCountEvent(String str, String str2);

    void recordCustomKVEvent(String str, Map<String, ? extends Object> map);

    void recordPauseEvent(Activity activity, String str);

    void recordResumeEvent(Activity activity, String str);
}
