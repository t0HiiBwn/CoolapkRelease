package com.coolapk.market.view.webview;

import com.coolapk.market.AppHolder;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: LoginFragment.kt */
final class LoginFragment$processLoginResult$1 implements Runnable {
    final /* synthetic */ String $message;

    LoginFragment$processLoginResult$1(String str) {
        this.$message = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.show$default(AppHolder.getApplication(), this.$message, 0, false, 12, null);
    }
}
