package androidx.databinding.adapters;

import android.widget.AbsListView;

public class AbsListViewBindingAdapter {

    public interface OnScroll {
        void onScroll(AbsListView absListView, int i, int i2, int i3);
    }

    public interface OnScrollStateChanged {
        void onScrollStateChanged(AbsListView absListView, int i);
    }

    public static void setOnScroll(AbsListView absListView, final OnScroll onScroll, final OnScrollStateChanged onScrollStateChanged) {
        absListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class androidx.databinding.adapters.AbsListViewBindingAdapter.AnonymousClass1 */

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                OnScrollStateChanged onScrollStateChanged = onScrollStateChanged;
                if (onScrollStateChanged != null) {
                    onScrollStateChanged.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                OnScroll onScroll = onScroll;
                if (onScroll != null) {
                    onScroll.onScroll(absListView, i, i2, i3);
                }
            }
        });
    }
}
