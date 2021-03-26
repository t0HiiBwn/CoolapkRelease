package com.coolapk.market.receiver;

import android.content.Context;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.PushMessage;
import com.coolapk.market.util.LogUtils;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0010H\u0016J\"\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/receiver/TencentXGTPushReceiver;", "Lcom/tencent/android/tpush/XGPushBaseReceiver;", "()V", "onDeleteAccountResult", "", "p0", "Landroid/content/Context;", "p1", "", "p2", "", "onDeleteAttributeResult", "onDeleteTagResult", "onNotificationClickedResult", "Lcom/tencent/android/tpush/XGPushClickedResult;", "onNotificationShowedResult", "Lcom/tencent/android/tpush/XGPushShowedResult;", "onRegisterResult", "Lcom/tencent/android/tpush/XGPushRegisterResult;", "onSetAccountResult", "onSetAttributeResult", "onSetTagResult", "onTextMessage", "Lcom/tencent/android/tpush/XGPushTextMessage;", "onUnregisterResult", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TencentXGTPushReceiver.kt */
public final class TencentXGTPushReceiver extends XGPushBaseReceiver {
    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onRegisterResult(Context context, int i, XGPushRegisterResult xGPushRegisterResult) {
        Intrinsics.checkNotNullParameter(context, "p0");
        LogUtils.d("onRegisterResult, p1: " + i + ", p2:" + xGPushRegisterResult, new Object[0]);
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onUnregisterResult(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "p0");
        LogUtils.d("onUnregisterResult, p1: " + i + ' ', new Object[0]);
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onSetTagResult(Context context, int i, String str) {
        Intrinsics.checkNotNullParameter(context, "p0");
        LogUtils.d("onSetTagResult, p1: " + i + ", p2:" + str, new Object[0]);
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onDeleteTagResult(Context context, int i, String str) {
        Intrinsics.checkNotNullParameter(context, "p0");
        LogUtils.d("onDeleteTagResult, p1: " + i + ", p2:" + str, new Object[0]);
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onSetAccountResult(Context context, int i, String str) {
        Intrinsics.checkNotNullParameter(context, "p0");
        LogUtils.d("onSetAccountResult, p1: " + i + ", p2:" + str, new Object[0]);
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onDeleteAccountResult(Context context, int i, String str) {
        Intrinsics.checkNotNullParameter(context, "p0");
        LogUtils.d("onDeleteAccountResult, p1: " + i + ", p2:" + str, new Object[0]);
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onSetAttributeResult(Context context, int i, String str) {
        Intrinsics.checkNotNullParameter(context, "p0");
        LogUtils.d("onSetAttributeResult, p1: " + i + ", p2:" + str, new Object[0]);
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onDeleteAttributeResult(Context context, int i, String str) {
        Intrinsics.checkNotNullParameter(context, "p0");
        LogUtils.d("onDeleteAttributeResult, p1: " + i + ", p2:" + str, new Object[0]);
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onTextMessage(Context context, XGPushTextMessage xGPushTextMessage) {
        Intrinsics.checkNotNullParameter(context, "p0");
        Intrinsics.checkNotNullParameter(xGPushTextMessage, "p1");
        LogUtils.d("onTextMessage, p1: " + xGPushTextMessage + ' ', new Object[0]);
        AppHolder.getAppNotification().handlePushMessage(PushMessage.Companion.fromPushMessage(xGPushTextMessage));
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onNotificationClickedResult(Context context, XGPushClickedResult xGPushClickedResult) {
        Intrinsics.checkNotNullParameter(context, "p0");
        Intrinsics.checkNotNullParameter(xGPushClickedResult, "p1");
        LogUtils.d("onNotificationClickedResult, p1: " + xGPushClickedResult + ' ', new Object[0]);
    }

    @Override // com.tencent.android.tpush.XGPushBaseReceiver
    public void onNotificationShowedResult(Context context, XGPushShowedResult xGPushShowedResult) {
        Intrinsics.checkNotNullParameter(context, "p0");
        Intrinsics.checkNotNullParameter(xGPushShowedResult, "p1");
        boolean z = false;
        LogUtils.d("onNotificationShowedResult, p1: " + xGPushShowedResult + ' ', new Object[0]);
        if (xGPushShowedResult.getPushChannel() == 100 && AppHolder.getActivityLifeCycle().isAppForeground()) {
            PushMessage fromPushMessage = PushMessage.Companion.fromPushMessage(xGPushShowedResult);
            if (fromPushMessage != PushMessage.Companion.getEMPTY_MESSAGE()) {
                z = true;
            }
            if (!z) {
                fromPushMessage = null;
            }
            if (fromPushMessage != null) {
                AppHolder.getAppNotification().handlePushMessage(fromPushMessage);
            }
        }
    }
}
