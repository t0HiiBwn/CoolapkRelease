package com.coolapk.market.view.main.channel;

import androidx.recyclerview.widget.RecyclerView;

public interface ItemTouchHelperAdapter {
    boolean onItemMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);
}
