package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableInt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.AlbumListItemCardNonupleItemBinding;
import com.coolapk.market.databinding.ItemGridAlbumCardBinding;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumCard;
import com.coolapk.market.model.Card;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ViewUtil;

public class GridAlbumCardViewHolder extends GenericBindHolder<ItemGridAlbumCardBinding, Card> {
    public static final int LAYOUT_ID = 2131558771;
    private final DataAdapter adapter;
    private AlbumCard albumCard;
    private final ItemGridAlbumCardBinding binding;
    private CallBack callBack;
    private final DataBindingComponent component;
    private final ItemActionHandler itemActionHandler;
    private int spanCount;

    public interface CallBack {
        void onPopulateDivider(ItemGridAlbumCardBinding itemGridAlbumCardBinding, GridAlbumCardViewHolder gridAlbumCardViewHolder);
    }

    public GridAlbumCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler2, CallBack callBack2) {
        super(view, dataBindingComponent, itemActionHandler2);
        this.component = dataBindingComponent;
        this.itemActionHandler = itemActionHandler2;
        ItemGridAlbumCardBinding itemGridAlbumCardBinding = (ItemGridAlbumCardBinding) getBinding();
        this.binding = itemGridAlbumCardBinding;
        this.callBack = callBack2;
        DataAdapter dataAdapter = new DataAdapter();
        this.adapter = dataAdapter;
        itemGridAlbumCardBinding.gridView.setAdapter(dataAdapter);
        itemGridAlbumCardBinding.gridView.setNestedScrollingEnabled(false);
        itemGridAlbumCardBinding.gridView.setItemAnimator(null);
        ViewUtil.clickListener(itemGridAlbumCardBinding.moreView, this);
    }

    public void bindToContent(Card card) {
        AlbumCard albumCard2 = (AlbumCard) card;
        this.albumCard = albumCard2;
        int i = 3;
        if (CollectionUtils.safeSize(albumCard2.getEntities()) % 3 != 0) {
            i = 4;
        }
        this.spanCount = i;
        this.binding.gridView.setLayoutManager(new GridLayoutManager(getContext(), this.spanCount));
        this.adapter.notifyDataSetChanged();
        this.binding.setTitle(this.albumCard.getTitle());
        CallBack callBack2 = this.callBack;
        if (callBack2 != null) {
            callBack2.onPopulateDivider(this.binding, this);
        } else {
            this.binding.itemDivider.setVisibility(8);
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        public DataAdapter() {
            setHasStableIds(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(GridAlbumCardViewHolder.this.getContext()).inflate(2131558450, viewGroup, false);
            GridAlbumCardViewHolder gridAlbumCardViewHolder = GridAlbumCardViewHolder.this;
            return new DataViewHolder(gridAlbumCardViewHolder, inflate, gridAlbumCardViewHolder.component, GridAlbumCardViewHolder.this.itemActionHandler);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            int i2;
            if (GridAlbumCardViewHolder.this.spanCount == 3) {
                i2 = DisplayUtils.dp2px(GridAlbumCardViewHolder.this.getContext(), 72.0f);
            } else {
                i2 = DisplayUtils.dp2px(GridAlbumCardViewHolder.this.getContext(), 52.0f);
            }
            DataViewHolder dataViewHolder = (DataViewHolder) bindingViewHolder;
            dataViewHolder.width.set(i2);
            dataViewHolder.height.set(i2);
            bindingViewHolder.bindTo(GridAlbumCardViewHolder.this.albumCard.getEntities().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(GridAlbumCardViewHolder.this.albumCard.getEntities());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return Long.valueOf(GridAlbumCardViewHolder.this.albumCard.getEntities().get(i).getAlbumId()).longValue();
        }
    }

    public static class DataViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558450;
        private final GridAlbumCardViewHolder gridCardViewHolder;
        public ObservableInt height = new ObservableInt();
        public ObservableInt width = new ObservableInt();

        public DataViewHolder(GridAlbumCardViewHolder gridAlbumCardViewHolder, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            this.gridCardViewHolder = gridAlbumCardViewHolder;
            ViewUtil.clickListener(((AlbumListItemCardNonupleItemBinding) getBinding()).getRoot(), gridAlbumCardViewHolder);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            AlbumListItemCardNonupleItemBinding albumListItemCardNonupleItemBinding = (AlbumListItemCardNonupleItemBinding) getBinding();
            albumListItemCardNonupleItemBinding.setAlbum((Album) obj);
            albumListItemCardNonupleItemBinding.getRoot().setTag(Integer.valueOf(getAdapterPosition()));
            albumListItemCardNonupleItemBinding.setViewHolder(this);
            albumListItemCardNonupleItemBinding.executePendingBindings();
        }
    }
}
