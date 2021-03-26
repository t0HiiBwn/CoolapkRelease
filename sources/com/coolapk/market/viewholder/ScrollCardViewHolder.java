package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemScrollCardBinding;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.widget.decoration.ItemDecorations;

@Deprecated
public class ScrollCardViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558904;
    private EntityCard entityCard;

    public ScrollCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ItemScrollCardBinding itemScrollCardBinding = (ItemScrollCardBinding) getBinding();
        itemScrollCardBinding.moreView.setOnClickListener(this);
        itemScrollCardBinding.recyclerView.setAdapter(new DataAdapter(dataBindingComponent));
        itemScrollCardBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        itemScrollCardBinding.recyclerView.addItemDecoration(ItemDecorations.horizontal(getContext()).type(0, 2131231062).create());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.entityCard = (EntityCard) obj;
        ItemScrollCardBinding itemScrollCardBinding = (ItemScrollCardBinding) getBinding();
        ((LinearLayoutManager) itemScrollCardBinding.recyclerView.getLayoutManager()).setInitialPrefetchItemCount(CollectionUtils.safeSize(this.entityCard.getEntities()));
        itemScrollCardBinding.setTitle(this.entityCard.getTitle());
        itemScrollCardBinding.recyclerView.getAdapter().notifyDataSetChanged();
        itemScrollCardBinding.executePendingBindings();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private DataBindingComponent component;

        public DataAdapter(DataBindingComponent dataBindingComponent) {
            this.component = dataBindingComponent;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new LargeScrollCardItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558796, viewGroup, false), this.component, null);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(ScrollCardViewHolder.this.entityCard.getEntities().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(ScrollCardViewHolder.this.entityCard.getEntities());
        }
    }
}
