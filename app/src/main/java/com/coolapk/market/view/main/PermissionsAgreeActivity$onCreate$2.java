package com.coolapk.market.view.main;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/main/PermissionsAgreeActivity$onCreate$2", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PermissionsAgreeActivity.kt */
public final class PermissionsAgreeActivity$onCreate$2 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ PermissionsAgreeActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    PermissionsAgreeActivity$onCreate$2(PermissionsAgreeActivity permissionsAgreeActivity) {
        this.this$0 = permissionsAgreeActivity;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View root = PermissionsAgreeActivity.access$getBinding$p(this.this$0).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.getViewTreeObserver().removeOnPreDrawListener(this);
        this.this$0.startOpenAnimation();
        return false;
    }
}
