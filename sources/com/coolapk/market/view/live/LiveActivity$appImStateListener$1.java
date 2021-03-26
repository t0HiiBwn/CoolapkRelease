package com.coolapk.market.view.live;

import androidx.fragment.app.FragmentManager;
import com.coolapk.market.manager.AppIMManager;
import com.coolapk.market.view.base.SimpleDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/coolapk/market/view/live/LiveActivity$appImStateListener$1", "Lcom/coolapk/market/manager/AppIMManager$StateListener;", "onKickedOffline", "", "onUserSigExpired", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
public final class LiveActivity$appImStateListener$1 implements AppIMManager.StateListener {
    final /* synthetic */ LiveActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    LiveActivity$appImStateListener$1(LiveActivity liveActivity) {
        this.this$0 = liveActivity;
    }

    @Override // com.coolapk.market.manager.AppIMManager.StateListener
    public void onKickedOffline() {
        SimpleDialog newInstance = SimpleDialog.newInstance();
        newInstance.setMessage("同账号在别的地方已进入直播间，请重新进入");
        newInstance.setNegativeButton("退出直播间", new LiveActivity$appImStateListener$1$onKickedOffline$$inlined$apply$lambda$1(this));
        newInstance.setPositiveButton("重新进入", new LiveActivity$appImStateListener$1$onKickedOffline$$inlined$apply$lambda$2(this));
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }

    @Override // com.coolapk.market.manager.AppIMManager.StateListener
    public void onUserSigExpired() {
        SimpleDialog newInstance = SimpleDialog.newInstance();
        newInstance.setMessage("用户凭证已过期，请重新进入");
        newInstance.setNegativeButton("退出直播", new LiveActivity$appImStateListener$1$onUserSigExpired$$inlined$apply$lambda$1(this));
        newInstance.setPositiveButton("刷新凭证", new LiveActivity$appImStateListener$1$onUserSigExpired$$inlined$apply$lambda$2(this));
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }
}
