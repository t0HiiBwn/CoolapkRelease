package com.coolapk.market.receiver;

import android.content.Context;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.AppPushManger;
import com.coolapk.market.manager.PushMessage;
import com.coolapk.market.util.LogUtils;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

public class CoolMarketPushReceiver extends PushMessageReceiver {
    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        super.onReceivePassThroughMessage(context, miPushMessage);
        LogUtils.d("onReceivePassThroughMessage %s", miPushMessage.toString());
        AppHolder.getAppNotification().handlePushMessage(PushMessage.fromOldMiPush(miPushMessage));
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        super.onReceiveRegisterResult(context, miPushCommandMessage);
        boolean z = true;
        LogUtils.d("We succeed in registering the push Service, onReceiveRegisterResult: %s", miPushCommandMessage.toString());
        if (!"register".equals(miPushCommandMessage.getCommand()) || miPushCommandMessage.getResultCode() != 0) {
            z = false;
        }
        AppPushManger appPushManager = AppHolder.getAppPushManager();
        appPushManager.setRegistered(z);
        appPushManager.registerUserAccount();
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageArrived(context, miPushMessage);
        AppHolder.getAppNotification().handlePushMessage(PushMessage.fromMiPush(miPushMessage));
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        super.onCommandResult(context, miPushCommandMessage);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageClicked(context, miPushMessage);
    }
}
