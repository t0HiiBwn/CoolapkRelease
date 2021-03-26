package com.coolapk.market.manager;

import com.coolapk.market.manager.AppIMManager;
import com.coolapk.market.util.LogUtils;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"com/coolapk/market/manager/AppIMManager$ensureInit$1", "Lcom/tencent/imsdk/v2/V2TIMSDKListener;", "onConnectFailed", "", "code", "", "error", "", "onConnectSuccess", "onConnecting", "onKickedOffline", "onSelfInfoUpdated", "info", "Lcom/tencent/imsdk/v2/V2TIMUserFullInfo;", "onUserSigExpired", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppIMManager.kt */
public final class AppIMManager$ensureInit$1 extends V2TIMSDKListener {
    final /* synthetic */ String $logTag;
    final /* synthetic */ AppIMManager this$0;

    AppIMManager$ensureInit$1(AppIMManager appIMManager, String str) {
        this.this$0 = appIMManager;
        this.$logTag = str;
    }

    @Override // com.tencent.imsdk.v2.V2TIMSDKListener
    public void onConnecting() {
        LogUtils.d(this.$logTag + " 正在连接到腾讯云服务器", new Object[0]);
    }

    @Override // com.tencent.imsdk.v2.V2TIMSDKListener
    public void onConnectSuccess() {
        LogUtils.d(this.$logTag + " 已经成功连接到腾讯云服务器", new Object[0]);
    }

    @Override // com.tencent.imsdk.v2.V2TIMSDKListener
    public void onConnectFailed(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        LogUtils.d(this.$logTag + " 连接腾讯云服务器失败 " + i + ", " + str, new Object[0]);
    }

    @Override // com.tencent.imsdk.v2.V2TIMSDKListener
    public void onKickedOffline() {
        LogUtils.d(this.$logTag + " 当前用户被踢下线", new Object[0]);
        for (AppIMManager.StateListener stateListener : this.this$0.stateListener) {
            stateListener.onKickedOffline();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSDKListener
    public void onUserSigExpired() {
        LogUtils.d(this.$logTag + " 登录票据已经过期", new Object[0]);
        this.this$0.currentImInfo = null;
        for (AppIMManager.StateListener stateListener : this.this$0.stateListener) {
            stateListener.onUserSigExpired();
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSDKListener
    public void onSelfInfoUpdated(V2TIMUserFullInfo v2TIMUserFullInfo) {
        LogUtils.d(this.$logTag + " 当前用户的资料发生了更新", new Object[0]);
    }
}
