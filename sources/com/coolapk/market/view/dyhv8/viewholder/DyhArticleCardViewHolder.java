package com.coolapk.market.view.dyhv8.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemDyhSourceTitleBinding;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;

public class DyhArticleCardViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558690;
    private DataAdapter adapter;
    private final ItemDyhSourceTitleBinding binding;
    private final DataBindingComponent component;
    private DyhModel dyhModel;
    private boolean isAddItemDecoration;
    private final ItemActionHandler itemActionHandler;

    public DyhArticleCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler2) {
        super(view, dataBindingComponent, itemActionHandler2);
        this.component = dataBindingComponent;
        this.itemActionHandler = itemActionHandler2;
        ItemDyhSourceTitleBinding itemDyhSourceTitleBinding = (ItemDyhSourceTitleBinding) getBinding();
        this.binding = itemDyhSourceTitleBinding;
        itemDyhSourceTitleBinding.articleList.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        initList();
    }

    private void initList() {
        this.adapter = new DataAdapter();
        this.binding.articleList.setAdapter(this.adapter);
        this.binding.articleList.setNestedScrollingEnabled(false);
        this.binding.articleList.setItemAnimator(null);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.dyhModel = (DyhModel) obj;
        this.binding.articleList.setLayoutManager(new LinearLayoutManager(getContext()));
        this.adapter.notifyDataSetChanged();
        if (!this.isAddItemDecoration) {
            this.binding.articleList.addItemDecoration(new PaddingDividerItemDecoration(new PaddingDividerItemDecoration.SimpleCallBack(getContext()) {
                /* class com.coolapk.market.view.dyhv8.viewholder.DyhArticleCardViewHolder.AnonymousClass1 */

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public int getEdgeColor() {
                    return 0;
                }

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public int getFirstHeight() {
                    return 0;
                }

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public int getLastHeight() {
                    return 0;
                }

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public boolean hasPadding(int i) {
                    return true;
                }

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public int getPaddingLeft() {
                    return DisplayUtils.dp2px(DyhArticleCardViewHolder.this.getContext(), 16.0f);
                }

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public int getPaddingRight() {
                    return DisplayUtils.dp2px(DyhArticleCardViewHolder.this.getContext(), 16.0f);
                }

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public int getDividerColor() {
                    return AppHolder.getAppTheme().getContentBackgroundDividerColor();
                }

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public int getLastColor() {
                    return AppHolder.getAppTheme().getContentBackgroundDividerColor();
                }

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public int getFirstColor() {
                    return AppHolder.getAppTheme().getContentBackgroundDividerColor();
                }

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public boolean isThinnestDivider(int i) {
                    return getDividerHeight(i) == DisplayUtils.dp2px(DyhArticleCardViewHolder.this.getContext(), 0.5f);
                }

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public int getItemCount() {
                    return CollectionUtils.safeSize(DyhArticleCardViewHolder.this.dyhModel.getEntities());
                }

                @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
                public int getDividerHeight(int i) {
                    return DisplayUtils.dp2px(DyhArticleCardViewHolder.this.getContext(), 1.0f);
                }
            }));
            this.isAddItemDecoration = true;
        }
        this.binding.executePendingBindings();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DyhArticleVH(LayoutInflater.from(DyhArticleCardViewHolder.this.getContext()).inflate(2131558684, viewGroup, false), DyhArticleCardViewHolder.this.component, new ItemActionHandler());
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(DyhArticleCardViewHolder.this.dyhModel.getEntities().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(DyhArticleCardViewHolder.this.dyhModel.getEntities());
        }
    }
}
