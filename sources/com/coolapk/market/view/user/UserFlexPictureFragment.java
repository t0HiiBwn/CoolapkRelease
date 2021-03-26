package com.coolapk.market.view.user;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.view.userv9.UserSpaceV9Activity;
import com.coolapk.market.view.wallpaper.coolpic.FallsListFragment;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/user/UserFlexPictureFragment;", "Lcom/coolapk/market/view/wallpaper/coolpic/FallsListFragment;", "()V", "uid", "", "getUid", "()Ljava/lang/String;", "uid$delegate", "Lkotlin/Lazy;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserPictureFragment.kt */
public final class UserFlexPictureFragment extends FallsListFragment {
    public static final Companion Companion = new Companion(null);
    private final Lazy uid$delegate = LazyKt.lazy(new UserFlexPictureFragment$uid$2(this));

    @JvmStatic
    public static final UserFlexPictureFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    public final String getUid() {
        return (String) this.uid$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/user/UserFlexPictureFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/user/UserFlexPictureFragment;", "uid", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserPictureFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UserFlexPictureFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "uid");
            UserFlexPictureFragment userFlexPictureFragment = new UserFlexPictureFragment();
            Bundle bundle = new Bundle();
            bundle.putString("uid", str);
            bundle.putString("URL", "/feed/userCoolPictureFeedList?fragmentTemplate=flex&uid=" + str);
            Unit unit = Unit.INSTANCE;
            userFlexPictureFragment.setArguments(bundle);
            return userFlexPictureFragment;
        }
    }

    @Override // com.coolapk.market.view.wallpaper.coolpic.FallsListFragment, com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setRefreshEnable(false);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setClipChildren(false);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        RecyclerView recyclerView3 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
        RecyclerView recyclerView4 = recyclerView3;
        recyclerView4.setPadding(recyclerView4.getPaddingLeft(), recyclerView4.getPaddingTop(), recyclerView4.getPaddingRight(), NumberExtendsKt.getDp((Number) 12));
        if (getActivity() instanceof UserSpaceV9Activity) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.userv9.UserSpaceV9Activity");
            if (((UserSpaceV9Activity) activity).isInBlackList()) {
                setEmptyData("由于你的黑名单设置，该用户动态对你不可见", 0);
            }
        }
    }
}
