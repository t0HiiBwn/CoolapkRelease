package com.coolapk.market.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.util.UriActionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/util/UriActionUtils$DouYinAction$takeAction$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onNext", "", "id", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UriActionUtils.kt */
public final class UriActionUtils$DouYinAction$takeAction$2 extends EmptySubscriber<String> {
    final /* synthetic */ Uri $uri;
    final /* synthetic */ UriActionUtils.DouYinAction this$0;

    UriActionUtils$DouYinAction$takeAction$2(UriActionUtils.DouYinAction douYinAction, Uri uri) {
        this.this$0 = douYinAction;
        this.$uri = uri;
    }

    public void onNext(String str) {
        Activity currentActivity = AppHolder.getCurrentActivity();
        if (currentActivity != null) {
            Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getCurrentActivity() ?: return");
            if (str != null) {
                if (new Regex("\\d+").matches(str)) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("snssdk1128://aweme/detail/" + str));
                    intent.setComponent(new ComponentName("com.ss.android.ugc.aweme", "com.ss.android.ugc.aweme.app.AdsAppActivity"));
                    try {
                        currentActivity.startActivity(intent);
                        return;
                    } catch (Exception unused) {
                        this.this$0.startDefault(currentActivity, this.$uri);
                        return;
                    }
                }
            }
            this.this$0.startDefault(currentActivity, this.$uri);
        }
    }
}
