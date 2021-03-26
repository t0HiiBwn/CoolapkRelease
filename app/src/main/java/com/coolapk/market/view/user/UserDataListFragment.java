package com.coolapk.market.view.user;

import com.coolapk.market.view.main.DataListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/coolapk/market/view/user/UserDataListFragment;", "Lcom/coolapk/market/view/main/DataListFragment;", "()V", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserFollowAppForumFragment.kt */
public final class UserDataListFragment extends DataListFragment {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/user/UserDataListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/user/UserDataListFragment;", "action", "", "title", "subTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserFollowAppForumFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ UserDataListFragment newInstance$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return companion.newInstance(str, str2, str3);
        }

        public final UserDataListFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "action");
            UserDataListFragment userDataListFragment = new UserDataListFragment();
            userDataListFragment.setArguments(DataListFragment.Companion.createArguments$default(DataListFragment.Companion, str, str2, str3, 0, 8, null));
            return userDataListFragment;
        }
    }
}
