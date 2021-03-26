package com.coolapk.market.util;

import android.app.Activity;
import android.content.Context;
import com.coolapk.market.AppMetadata;
import com.coolapk.market.manager.CondomContextUtils;
import com.coolapk.market.widget.condom.CondomContext;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J&\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/util/UmengStat;", "Lcom/coolapk/market/util/IThirdStat;", "appContext", "Landroid/content/Context;", "appMetadata", "Lcom/coolapk/market/AppMetadata;", "(Landroid/content/Context;Lcom/coolapk/market/AppMetadata;)V", "confirmInit", "", "recordCountEvent", "category", "", "key", "recordCustomKVEvent", "event", "kvmap", "", "", "recordPauseEvent", "activity", "Landroid/app/Activity;", "string", "recordResumeEvent", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ThirdStatUtil.kt */
public final class UmengStat implements IThirdStat {
    private final Context appContext;
    private final AppMetadata appMetadata;

    @Override // com.coolapk.market.util.IThirdStat
    public void recordCountEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "category");
        Intrinsics.checkNotNullParameter(str2, "key");
    }

    public UmengStat(Context context, AppMetadata appMetadata2) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(appMetadata2, "appMetadata");
        this.appContext = context;
        this.appMetadata = appMetadata2;
        CondomContext buildContext = CondomContextUtils.buildContext(context);
        UMConfigure.setLogEnabled(false);
        UMConfigure.preInit(buildContext, "5a387236a40fa374880002f4", appMetadata2.getChannel());
    }

    @Override // com.coolapk.market.util.IThirdStat
    public void confirmInit() {
        UMConfigure.init(CondomContextUtils.buildContext(this.appContext), "5a387236a40fa374880002f4", this.appMetadata.getChannel(), 1, "");
        MobclickAgent.setCatchUncaughtExceptions(false);
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.LEGACY_AUTO);
    }

    @Override // com.coolapk.market.util.IThirdStat
    public void recordResumeEvent(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "string");
        MobclickAgent.onResume(activity);
    }

    @Override // com.coolapk.market.util.IThirdStat
    public void recordPauseEvent(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "string");
        MobclickAgent.onPause(activity);
    }

    @Override // com.coolapk.market.util.IThirdStat
    public void recordCustomKVEvent(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "event");
        MobclickAgent.onEventObject(this.appContext, str, map);
    }
}
