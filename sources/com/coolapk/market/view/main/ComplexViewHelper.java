package com.coolapk.market.view.main;

import android.database.DataSetObserver;
import android.os.Handler;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.view.base.asynclist.AsyncListFragment;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.view.base.refresh.RefreshRecyclerFragment;
import com.coolapk.market.view.base.refresh.ViewPagerFragment;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004&'()B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u000eJ\u0010\u0010\u001f\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010\"\u001a\u00020\u001bJ\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/main/ComplexViewHelper;", "", "()V", "callback", "Lcom/coolapk/market/view/main/ComplexViewHelper$Callback;", "getCallback", "()Lcom/coolapk/market/view/main/ComplexViewHelper$Callback;", "setCallback", "(Lcom/coolapk/market/view/main/ComplexViewHelper$Callback;)V", "<set-?>", "Landroidx/fragment/app/Fragment;", "currentListFragment", "getCurrentListFragment", "()Landroidx/fragment/app/Fragment;", "Landroidx/recyclerview/widget/RecyclerView;", "currentRecyclerView", "getCurrentRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "dataSetObserver", "Lcom/coolapk/market/view/main/ComplexViewHelper$MyDataSetObserver;", "handler", "Landroid/os/Handler;", "onPageChangeListener", "Lcom/coolapk/market/view/main/ComplexViewHelper$MyOnPageChangeListener;", "scrollListener", "Lcom/coolapk/market/view/main/ComplexViewHelper$MyScrollListener;", "bindFragment", "", "fragment", "bindRecyclerView", "recyclerView", "bindViewPager", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "destroy", "postRun", "r", "Ljava/lang/Runnable;", "Callback", "MyDataSetObserver", "MyOnPageChangeListener", "MyScrollListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ComplexViewHelper.kt */
public final class ComplexViewHelper {
    private Callback callback;
    private Fragment currentListFragment;
    private RecyclerView currentRecyclerView;
    private final MyDataSetObserver dataSetObserver = new MyDataSetObserver();
    private final Handler handler = new Handler();
    private final MyOnPageChangeListener onPageChangeListener = new MyOnPageChangeListener();
    private final MyScrollListener scrollListener = new MyScrollListener();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0016¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/main/ComplexViewHelper$Callback;", "", "()V", "onPageDataSetChanged", "", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "onPageScrollStateChanged", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onRecyclerScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onRecyclerScrolled", "dx", "dy", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ComplexViewHelper.kt */
    public static abstract class Callback {
        public void onPageDataSetChanged(ViewPager viewPager) {
            Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        }

        public void onPageScrollStateChanged(ViewPager viewPager, int i) {
            Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        }

        public void onPageScrolled(ViewPager viewPager, int i, float f, int i2) {
            Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        }

        public void onPageSelected(ViewPager viewPager, int i) {
            Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        }

        public void onRecyclerScrollStateChanged(RecyclerView recyclerView, int i) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        }

        public void onRecyclerScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        }
    }

    public final RecyclerView getCurrentRecyclerView() {
        return this.currentRecyclerView;
    }

    public final Fragment getCurrentListFragment() {
        return this.currentListFragment;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public final void bindRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerView recyclerView2 = this.currentRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.scrollListener);
        }
        this.currentRecyclerView = recyclerView;
        recyclerView.addOnScrollListener(this.scrollListener);
    }

    public final void bindViewPager(ViewPager viewPager) {
        PagerAdapter adapter;
        if (viewPager != null && (adapter = viewPager.getAdapter()) != null) {
            Intrinsics.checkNotNullExpressionValue(adapter, "viewPager.adapter ?: return");
            this.onPageChangeListener.setViewPager(viewPager);
            viewPager.removeOnPageChangeListener(this.onPageChangeListener);
            viewPager.addOnPageChangeListener(this.onPageChangeListener);
            this.dataSetObserver.setViewPager(viewPager);
            try {
                adapter.unregisterDataSetObserver(this.dataSetObserver);
            } catch (Exception unused) {
            }
            try {
                adapter.registerDataSetObserver(this.dataSetObserver);
            } catch (Exception unused2) {
            }
            Object instantiateItem = adapter.instantiateItem((ViewGroup) viewPager, viewPager.getCurrentItem());
            Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) instantiateItem;
            if ((fragment instanceof NewAsyncListFragment) || (fragment instanceof AsyncListFragment)) {
                this.currentListFragment = fragment;
            }
            if (!(fragment instanceof RefreshRecyclerFragment)) {
                return;
            }
            if (fragment.getView() == null) {
                this.handler.post(new ComplexViewHelper$bindViewPager$1(this, viewPager));
                return;
            }
            RecyclerView recyclerView = ((RefreshRecyclerFragment) fragment).getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            bindRecyclerView(recyclerView);
        }
    }

    public final void bindFragment(Fragment fragment) {
        if (fragment != null) {
            if (fragment.getView() == null) {
                this.handler.post(new ComplexViewHelper$bindFragment$1(this, fragment));
            } else if (fragment instanceof ViewPagerFragment) {
                bindViewPager(((ViewPagerFragment) fragment).obtainViewPage());
            } else if (fragment instanceof RefreshRecyclerFragment) {
                if ((fragment instanceof NewAsyncListFragment) || (fragment instanceof AsyncListFragment)) {
                    this.currentListFragment = fragment;
                }
                RecyclerView recyclerView = ((RefreshRecyclerFragment) fragment).getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                bindRecyclerView(recyclerView);
            }
        }
    }

    public final void destroy() {
        try {
            this.onPageChangeListener.clear();
            this.dataSetObserver.clear();
            this.scrollListener.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void postRun(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "r");
        this.handler.post(runnable);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/main/ComplexViewHelper$MyScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "(Lcom/coolapk/market/view/main/ComplexViewHelper;)V", "clear", "", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ComplexViewHelper.kt */
    private final class MyScrollListener extends RecyclerView.OnScrollListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public MyScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Callback callback = ComplexViewHelper.this.getCallback();
            if (callback != null) {
                callback.onRecyclerScrollStateChanged(recyclerView, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Callback callback = ComplexViewHelper.this.getCallback();
            if (callback != null) {
                callback.onRecyclerScrolled(recyclerView, i, i2);
            }
        }

        public final void clear() {
            RecyclerView currentRecyclerView = ComplexViewHelper.this.getCurrentRecyclerView();
            if (currentRecyclerView != null) {
                currentRecyclerView.removeOnScrollListener(this);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/main/ComplexViewHelper$MyOnPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "(Lcom/coolapk/market/view/main/ComplexViewHelper;)V", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "clear", "", "onPageScrollStateChanged", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ComplexViewHelper.kt */
    private final class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private ViewPager viewPager;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public MyOnPageChangeListener() {
        }

        public final ViewPager getViewPager() {
            return this.viewPager;
        }

        public final void setViewPager(ViewPager viewPager2) {
            this.viewPager = viewPager2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Callback callback;
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 != null && (callback = ComplexViewHelper.this.getCallback()) != null) {
                callback.onPageScrollStateChanged(viewPager2, i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Callback callback;
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 != null && (callback = ComplexViewHelper.this.getCallback()) != null) {
                callback.onPageScrolled(viewPager2, i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Callback callback;
            ComplexViewHelper.this.handler.post(new ComplexViewHelper$MyOnPageChangeListener$onPageSelected$1(this));
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 != null && (callback = ComplexViewHelper.this.getCallback()) != null) {
                callback.onPageSelected(viewPager2, i);
            }
        }

        public final void clear() {
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 != null) {
                viewPager2.removeOnPageChangeListener(this);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/main/ComplexViewHelper$MyDataSetObserver;", "Landroid/database/DataSetObserver;", "(Lcom/coolapk/market/view/main/ComplexViewHelper;)V", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "clear", "", "onChanged", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ComplexViewHelper.kt */
    private final class MyDataSetObserver extends DataSetObserver {
        private ViewPager viewPager;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public MyDataSetObserver() {
        }

        public final ViewPager getViewPager() {
            return this.viewPager;
        }

        public final void setViewPager(ViewPager viewPager2) {
            this.viewPager = viewPager2;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Callback callback;
            ComplexViewHelper.this.handler.post(new ComplexViewHelper$MyDataSetObserver$onChanged$1(this));
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 != null && (callback = ComplexViewHelper.this.getCallback()) != null) {
                callback.onPageDataSetChanged(viewPager2);
            }
        }

        public final void clear() {
            PagerAdapter adapter;
            try {
                ViewPager viewPager2 = this.viewPager;
                if (viewPager2 != null && (adapter = viewPager2.getAdapter()) != null) {
                    adapter.unregisterDataSetObserver(this);
                }
            } catch (Exception unused) {
            }
        }
    }
}
