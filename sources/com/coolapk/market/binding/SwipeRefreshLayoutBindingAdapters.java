package com.coolapk.market.binding;

import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.ListenerUtil;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class SwipeRefreshLayoutBindingAdapters {
    public static void setRefreshing(SwipeRefreshLayout swipeRefreshLayout, boolean z) {
        if (z != swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(z);
        }
    }

    public static void setOnRefreshListener(SwipeRefreshLayout swipeRefreshLayout, final SwipeRefreshLayout.OnRefreshListener onRefreshListener, final InverseBindingListener inverseBindingListener) {
        AnonymousClass1 r0 = new SwipeRefreshLayout.OnRefreshListener() {
            /* class com.coolapk.market.binding.SwipeRefreshLayoutBindingAdapters.AnonymousClass1 */

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                SwipeRefreshLayout.OnRefreshListener onRefreshListener = onRefreshListener;
                if (onRefreshListener != null) {
                    onRefreshListener.onRefresh();
                }
                InverseBindingListener inverseBindingListener = inverseBindingListener;
                if (inverseBindingListener != null) {
                    inverseBindingListener.onChange();
                }
            }
        };
        if (((SwipeRefreshLayout.OnRefreshListener) ListenerUtil.trackListener(swipeRefreshLayout, r0, 2131363055)) != null) {
            swipeRefreshLayout.setOnRefreshListener(null);
        }
        swipeRefreshLayout.setOnRefreshListener(r0);
    }

    public static boolean isRefreshing(SwipeRefreshLayout swipeRefreshLayout) {
        return swipeRefreshLayout.isRefreshing();
    }
}
