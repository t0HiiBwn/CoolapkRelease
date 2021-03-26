package com.coolapk.market.view.live;

import android.os.Bundle;
import com.coolapk.market.view.main.DataListFragment;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveRelativeListFragment.kt */
public final class LiveRelativeListFragment extends DataListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_SUBTITLE = "SUBTITLE";
    public static final String KEY_TITLE = "TITLE";
    public static final String KEY_URL = "URL";

    /* compiled from: LiveRelativeListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ LiveRelativeListFragment newInstance$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return companion.newInstance(str, str2, str3);
        }

        public final LiveRelativeListFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "action");
            LiveRelativeListFragment liveRelativeListFragment = new LiveRelativeListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("URL", str);
            bundle.putString("TITLE", str2);
            bundle.putString("SUBTITLE", str3);
            Unit unit = Unit.INSTANCE;
            liveRelativeListFragment.setArguments(bundle);
            return liveRelativeListFragment;
        }
    }
}
