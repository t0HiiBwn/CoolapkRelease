package com.coolapk.market.view.base.refresh;

import android.content.Context;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class RefreshRecyclerViewModel extends BaseObservable {
    private final Context context;
    private int emptyImageRes;
    private String emptyText;
    private boolean loading;
    private boolean showEmptyView;
    private boolean showList;

    public RefreshRecyclerViewModel(Context context2) {
        this.context = context2.getApplicationContext();
    }

    @Bindable
    public boolean getRecyclerViewVisibility() {
        return !this.loading && this.showList;
    }

    @Bindable
    public boolean getEmptyViewVisibility() {
        return this.showEmptyView && !this.loading;
    }

    @Bindable
    public int getEmptyImageRes() {
        return this.emptyImageRes;
    }

    @Bindable
    public String getEmptyText() {
        return this.emptyText;
    }

    @Bindable
    public boolean isLoading() {
        return this.loading;
    }

    public void setEmptyData(String str, int i) {
        this.emptyText = str;
        this.emptyImageRes = i;
        notifyPropertyChanged(91);
        notifyPropertyChanged(90);
    }

    public void showContent(boolean z) {
        if (this.showList != z) {
            this.showList = z;
            notifyPropertyChanged(230);
            notifyPropertyChanged(92);
        }
    }

    public void setLoading(boolean z) {
        if (this.loading != z) {
            this.loading = z;
            notifyPropertyChanged(230);
            notifyPropertyChanged(92);
            notifyPropertyChanged(187);
        }
    }

    public void showEmptyView(boolean z) {
        if (this.showEmptyView != z) {
            this.showEmptyView = z;
            notifyPropertyChanged(92);
        }
    }
}
