package com.coolapk.market.service;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/service/ServiceAction;", "", "getTaskKey", "", "intent", "Landroid/content/Intent;", "isThisAction", "", "action", "onHandleAction", "", "context", "Landroid/content/Context;", "onStartAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ServiceAction.kt */
public interface ServiceAction {
    String getTaskKey(Intent intent);

    boolean isThisAction(String str);

    void onHandleAction(Context context, Intent intent);

    void onStartAction(Context context, Intent intent);
}
