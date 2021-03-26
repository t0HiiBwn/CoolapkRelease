package com.coolapk.market.widget.multitype;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/widget/multitype/ViewHolderFactor;", "", "itemViewType", "", "getItemViewType", "()I", "isSuitedToViewHolder", "", "item", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewHolderFactor.kt */
public interface ViewHolderFactor {
    int getItemViewType();

    boolean isSuitedToViewHolder(Object obj);

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Object obj);

    RecyclerView.ViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup);
}
