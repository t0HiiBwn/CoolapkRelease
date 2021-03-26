package com.coolapk.market.widget;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"com/coolapk/market/widget/FastReturnView$dataSetObserver$1", "Landroid/database/DataSetObserver;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "clear", "", "onChanged", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FastReturnView.kt */
public final class FastReturnView$dataSetObserver$1 extends DataSetObserver {
    final /* synthetic */ FastReturnView this$0;
    private ViewPager viewPager;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FastReturnView$dataSetObserver$1(FastReturnView fastReturnView) {
        this.this$0 = fastReturnView;
    }

    public final ViewPager getViewPager() {
        return this.viewPager;
    }

    public final void setViewPager(ViewPager viewPager2) {
        this.viewPager = viewPager2;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.this$0.post(new FastReturnView$dataSetObserver$1$onChanged$1(this));
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
