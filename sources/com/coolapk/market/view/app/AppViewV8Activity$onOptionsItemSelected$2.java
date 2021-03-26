package com.coolapk.market.view.app;

import androidx.fragment.app.FragmentManager;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewV8Activity.kt */
final class AppViewV8Activity$onOptionsItemSelected$2 implements Runnable {
    final /* synthetic */ AppViewV8Activity this$0;

    AppViewV8Activity$onOptionsItemSelected$2(AppViewV8Activity appViewV8Activity) {
        this.this$0 = appViewV8Activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        AddToAlbumDialog newInstance = AddToAlbumDialog.newInstance(loginSession.getUid(), this.this$0.getServiceApp());
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }
}
