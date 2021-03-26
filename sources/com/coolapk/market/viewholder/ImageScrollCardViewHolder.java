package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemImageScrollCardBinding;
import com.coolapk.market.databinding.ItemImageScrollCardItemBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.decoration.ItemDecorations;

public class ImageScrollCardViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558799;
    private EntityCard entityCard;

    public ImageScrollCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ItemImageScrollCardBinding itemImageScrollCardBinding = (ItemImageScrollCardBinding) getBinding();
        itemImageScrollCardBinding.moreView.setOnClickListener(this);
        itemImageScrollCardBinding.recyclerView.setAdapter(new DataAdapter(dataBindingComponent));
        itemImageScrollCardBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        itemImageScrollCardBinding.recyclerView.addItemDecoration(ItemDecorations.horizontal(getContext()).type(0, 2131231072).create());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.entityCard = (EntityCard) obj;
        ItemImageScrollCardBinding itemImageScrollCardBinding = (ItemImageScrollCardBinding) getBinding();
        ((LinearLayoutManager) itemImageScrollCardBinding.recyclerView.getLayoutManager()).setInitialPrefetchItemCount(CollectionUtils.safeSize(this.entityCard.getEntities()));
        itemImageScrollCardBinding.setTitle(this.entityCard.getTitle());
        itemImageScrollCardBinding.recyclerView.getAdapter().notifyDataSetChanged();
        itemImageScrollCardBinding.executePendingBindings();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private DataBindingComponent component;

        public DataAdapter(DataBindingComponent dataBindingComponent) {
            this.component = dataBindingComponent;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558800, viewGroup, false), this.component, new ItemActionHandler() {
                /* class com.coolapk.market.viewholder.ImageScrollCardViewHolder.DataAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    super.onItemClick(viewHolder, view);
                    ActionManager.startActivityByUrl(ImageScrollCardViewHolder.this.getContext(), ImageScrollCardViewHolder.this.entityCard.getEntities().get(viewHolder.getAdapterPosition()).getUrl());
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(ImageScrollCardViewHolder.this.entityCard.getEntities().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(ImageScrollCardViewHolder.this.entityCard.getEntities());
        }
    }

    private static class ViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558800;

        public ViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemImageScrollCardItemBinding itemImageScrollCardItemBinding = (ItemImageScrollCardItemBinding) getBinding();
            ViewUtil.clickListener(this.itemView, this);
            itemImageScrollCardItemBinding.setImageCard((Entity) obj);
            itemImageScrollCardItemBinding.executePendingBindings();
        }
    }
}
