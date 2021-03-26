package com.coolapk.market.view.center;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/center/TouchCallBack;", "", "downTouch", "", "view", "Landroid/view/View;", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "findPosition", "position", "", "itemClear", "upTouch", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TouchCallBack.kt */
public interface TouchCallBack {
    void downTouch(View view, RecyclerView.ViewHolder viewHolder);

    void findPosition(int i, RecyclerView.ViewHolder viewHolder);

    void itemClear(int i, RecyclerView.ViewHolder viewHolder);

    void upTouch(View view, RecyclerView.ViewHolder viewHolder);
}
