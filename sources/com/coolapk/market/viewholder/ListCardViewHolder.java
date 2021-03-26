package com.coolapk.market.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemListCardBinding;
import com.coolapk.market.databinding.ItemTitleViewBinding;
import com.coolapk.market.model.Ads;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.ViewUtil;

public class ListCardViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558810;
    private final DataAdapter adapter;
    private EntityCard card;
    private TitleViewPart viewPart;

    public interface ExternalDataAdapter {
        int getItemViewType(String str);

        BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i);
    }

    public ListCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, ExternalDataAdapter externalDataAdapter) {
        super(view, dataBindingComponent, itemActionHandler);
        ItemListCardBinding itemListCardBinding = (ItemListCardBinding) getBinding();
        DataAdapter dataAdapter = new DataAdapter(externalDataAdapter);
        this.adapter = dataAdapter;
        itemListCardBinding.listView.setAdapter(dataAdapter);
        itemListCardBinding.listView.setNestedScrollingEnabled(false);
        itemListCardBinding.listView.setItemAnimator(null);
        itemListCardBinding.listView.setLayoutManager(new LinearLayoutManager(getContext()));
        TitleViewPart newInstance = TitleViewPart.newInstance(itemListCardBinding.listView, this);
        this.viewPart = newInstance;
        ViewUtil.clickListener(((ItemTitleViewBinding) newInstance.getBinding()).closeView, this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.card = (EntityCard) obj;
        ItemListCardBinding itemListCardBinding = (ItemListCardBinding) getBinding();
        itemListCardBinding.setTitle(this.card.getTitle());
        this.adapter.notifyDataSetChanged();
        int i = 0;
        boolean z = !CollectionUtils.isEmpty(this.card.getEntities()) ? this.card.getEntities().get(0) instanceof Ads : false;
        boolean z2 = !TextUtils.isEmpty(this.card.getUrl());
        this.viewPart.bindToContent(this.card);
        ((ItemTitleViewBinding) this.viewPart.getBinding()).closeView.setVisibility(z ? 0 : 8);
        ImageView imageView = ((ItemTitleViewBinding) this.viewPart.getBinding()).enterView;
        if (z || !z2) {
            i = 8;
        }
        imageView.setVisibility(i);
        itemListCardBinding.executePendingBindings();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private ExternalDataAdapter baseAdapter;

        public DataAdapter(ExternalDataAdapter externalDataAdapter) {
            this.baseAdapter = externalDataAdapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return this.baseAdapter.onCreateViewHolder(viewGroup, i);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(ListCardViewHolder.this.card.getEntities().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.baseAdapter.getItemViewType(ListCardViewHolder.this.card.getEntities().get(i).getEntityType());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(ListCardViewHolder.this.card.getEntities());
        }
    }
}
