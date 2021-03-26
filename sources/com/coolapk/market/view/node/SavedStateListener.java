package com.coolapk.market.view.node;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/node/SavedStateListener;", "", "onInitSavedInstanceState", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SavedStateListener.kt */
public interface SavedStateListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* compiled from: SavedStateListener.kt */
    public static final class DefaultImpls {
        public static void onInitSavedInstanceState(SavedStateListener savedStateListener, Bundle bundle) {
        }

        public static void onSaveInstanceState(SavedStateListener savedStateListener, Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "outState");
        }
    }

    void onInitSavedInstanceState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle);
}
