package com.coolapk.market.view.cardlist;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.main.MainActivity;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002 !B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0012R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;", "", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "callback", "Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper$Callback;", "getFragment", "()Lcom/coolapk/market/view/cardlist/EntityListFragment;", "recyclerViewTop", "", "tmpRect", "Landroid/graphics/Rect;", "topView", "Landroid/view/View;", "topViewContainer", "Landroid/widget/LinearLayout;", "calculateLayoutOffset", "", "checkFixTopAndSetMinHeight", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "checkFixTopStatus", "hasFixTopView", "", "setFixTopView", "view", "originParent", "Landroid/view/ViewGroup;", "data", "Landroid/os/Parcelable;", "unsetTopView", "Callback", "SimpleCallback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListFixTopHelper.kt */
public final class EntityListFixTopHelper {
    private Callback callback;
    private final EntityListFragment fragment;
    private int recyclerViewTop;
    private final Rect tmpRect = new Rect();
    private View topView;
    private final LinearLayout topViewContainer;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper$Callback;", "", "onDetachFromTop", "", "view", "Landroid/view/View;", "shouldViewBeTop", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isTop", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: EntityListFixTopHelper.kt */
    public interface Callback {
        void onDetachFromTop(View view);

        boolean shouldViewBeTop(RecyclerView recyclerView, boolean z);
    }

    public EntityListFixTopHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
        entityListFragment.getRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            /* class com.coolapk.market.view.cardlist.EntityListFixTopHelper.AnonymousClass1 */
            final /* synthetic */ EntityListFixTopHelper this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                this.this$0.checkFixTopStatus(recyclerView);
            }
        });
        View view = entityListFragment.getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) view;
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        linearLayout.setClickable(true);
        Unit unit = Unit.INSTANCE;
        this.topViewContainer = linearLayout;
        frameLayout.addView(linearLayout);
        frameLayout.post(new Runnable(this) {
            /* class com.coolapk.market.view.cardlist.EntityListFixTopHelper.AnonymousClass3 */
            final /* synthetic */ EntityListFixTopHelper this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.calculateLayoutOffset();
            }
        });
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    public final void calculateLayoutOffset() {
        int i;
        ViewGroup.MarginLayoutParams marginParams;
        int i2;
        int i3;
        int[] iArr = new int[2];
        this.topViewContainer.getLocationOnScreen(iArr);
        Context context = this.topViewContainer.getContext();
        int i4 = iArr[1];
        FragmentActivity activity = this.fragment.getActivity();
        boolean z = activity instanceof AlphaToolbarActivity;
        if (z) {
            if (!z) {
                activity = null;
            }
            AlphaToolbarActivity alphaToolbarActivity = (AlphaToolbarActivity) activity;
            Intrinsics.checkNotNull(alphaToolbarActivity);
            Toolbar toolbar = alphaToolbarActivity.getToolbar();
            toolbar.getLocationInWindow(iArr);
            i2 = iArr[1];
            i3 = toolbar.getHeight();
        } else if (activity instanceof MainActivity) {
            i = i4;
            int i5 = i4 >= i ? i - i4 : 0;
            if (!z) {
                this.fragment.getRecyclerView().getLocationInWindow(iArr);
                i = iArr[1];
            }
            this.recyclerViewTop = i;
            marginParams = ViewExtendsKt.getMarginParams(this.topViewContainer);
            if (marginParams != null && marginParams.topMargin != i5) {
                marginParams.topMargin = i5;
                this.topViewContainer.requestLayout();
                return;
            }
        } else {
            i2 = UiUtils.getActionBarSize(context);
            i3 = UiUtils.getStatusBarHeight(context);
        }
        i = i2 + i3;
        if (i4 >= i) {
        }
        if (!z) {
        }
        this.recyclerViewTop = i;
        marginParams = ViewExtendsKt.getMarginParams(this.topViewContainer);
        if (marginParams != null) {
        }
    }

    public final void checkFixTopStatus(RecyclerView recyclerView) {
        View view;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Callback callback2 = this.callback;
        if (callback2 != null && (view = this.topView) != null) {
            boolean areEqual = Intrinsics.areEqual(view.getParent(), this.topViewContainer);
            boolean shouldViewBeTop = callback2.shouldViewBeTop(recyclerView, areEqual);
            if (shouldViewBeTop && !areEqual) {
                ViewExtendsKt.detachFromParent(view);
                this.topViewContainer.addView(view);
            } else if (!shouldViewBeTop && areEqual) {
                ViewExtendsKt.detachFromParent(view);
                callback2.onDetachFromTop(view);
                this.topViewContainer.post(new EntityListFixTopHelper$checkFixTopStatus$1(this));
            }
        }
    }

    public final void checkFixTopAndSetMinHeight(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        checkFixTopStatus(recyclerView);
        View view = this.topView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            recyclerView.setMinimumHeight(view.getHeight());
        }
    }

    public final boolean hasFixTopView() {
        return this.callback != null;
    }

    public final void setFixTopView(View view, ViewGroup viewGroup, Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewGroup, "originParent");
        Intrinsics.checkNotNullParameter(parcelable, "data");
        if (view == this.topView) {
            Callback callback2 = this.callback;
            if (callback2 instanceof SimpleCallback) {
                SimpleCallback simpleCallback = (SimpleCallback) callback2;
                if (simpleCallback.getOriginParent() == viewGroup && Intrinsics.areEqual(simpleCallback.getData(), parcelable)) {
                    return;
                }
            }
        }
        setFixTopView(view, new SimpleCallback(this, viewGroup, parcelable));
    }

    public final void setFixTopView(View view, Callback callback2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        unsetTopView();
        this.topView = view;
        this.callback = callback2;
    }

    public final void unsetTopView() {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            View view = this.topView;
            if (view != null) {
                ViewExtendsKt.detachFromParent(view);
                callback2.onDetachFromTop(view);
            }
            this.topView = null;
            this.callback = null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper$SimpleCallback;", "Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper$Callback;", "topHelper", "Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;", "originParent", "Landroid/view/ViewGroup;", "data", "Landroid/os/Parcelable;", "(Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;Landroid/view/ViewGroup;Landroid/os/Parcelable;)V", "getData", "()Landroid/os/Parcelable;", "getOriginParent", "()Landroid/view/ViewGroup;", "screenArray", "", "tmpRect", "Landroid/graphics/Rect;", "getTopHelper", "()Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;", "onDetachFromTop", "", "view", "Landroid/view/View;", "shouldViewBeTop", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isTop", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: EntityListFixTopHelper.kt */
    public static class SimpleCallback implements Callback {
        private final Parcelable data;
        private final ViewGroup originParent;
        private final int[] screenArray = {0, 0};
        private final Rect tmpRect;
        private final EntityListFixTopHelper topHelper;

        public SimpleCallback(EntityListFixTopHelper entityListFixTopHelper, ViewGroup viewGroup, Parcelable parcelable) {
            Intrinsics.checkNotNullParameter(entityListFixTopHelper, "topHelper");
            Intrinsics.checkNotNullParameter(viewGroup, "originParent");
            Intrinsics.checkNotNullParameter(parcelable, "data");
            this.topHelper = entityListFixTopHelper;
            this.originParent = viewGroup;
            this.data = parcelable;
            this.tmpRect = entityListFixTopHelper.tmpRect;
        }

        public final Parcelable getData() {
            return this.data;
        }

        public final ViewGroup getOriginParent() {
            return this.originParent;
        }

        public final EntityListFixTopHelper getTopHelper() {
            return this.topHelper;
        }

        @Override // com.coolapk.market.view.cardlist.EntityListFixTopHelper.Callback
        public boolean shouldViewBeTop(RecyclerView recyclerView, boolean z) {
            int i;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            int indexOf = this.topHelper.getFragment().getDataList().indexOf(this.data);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager == null) {
                return false;
            }
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            this.originParent.getLocationInWindow(this.screenArray);
            int i2 = this.screenArray[1];
            recyclerView.getLocalVisibleRect(this.tmpRect);
            if (this.topHelper.getFragment().getActivity() instanceof AlphaToolbarActivity) {
                i = this.topHelper.recyclerViewTop;
            } else {
                recyclerView.getLocationInWindow(this.screenArray);
                i = this.screenArray[1];
            }
            if (findFirstVisibleItemPosition < 0) {
                return z;
            }
            if (findFirstVisibleItemPosition <= indexOf && findLastVisibleItemPosition >= indexOf) {
                if (i2 - i < 0) {
                    return true;
                }
                return false;
            } else if (indexOf < findFirstVisibleItemPosition) {
                return true;
            } else {
                return false;
            }
        }

        @Override // com.coolapk.market.view.cardlist.EntityListFixTopHelper.Callback
        public void onDetachFromTop(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.originParent.addView(view);
        }
    }
}
