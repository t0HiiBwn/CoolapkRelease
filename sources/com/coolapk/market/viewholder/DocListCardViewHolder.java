package com.coolapk.market.viewholder;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemDocListCardBinding;
import com.coolapk.market.databinding.ItemDocListCardItemBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.NewHeadLine;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.app.FetchGiftDialog;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.widget.decoration.ItemDecorations;

public class DocListCardViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558678;
    private final RecyclerView.Adapter adapter;
    private final DataBindingComponent component;
    private EntityCard entityCard;

    public DocListCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        this.component = dataBindingComponent;
        ItemDocListCardBinding itemDocListCardBinding = (ItemDocListCardBinding) getBinding();
        DataAdapter dataAdapter = new DataAdapter();
        this.adapter = dataAdapter;
        itemDocListCardBinding.recyclerView.setAdapter(dataAdapter);
        itemDocListCardBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        itemDocListCardBinding.recyclerView.addItemDecoration(ItemDecorations.vertical(getContext()).type(0, 2131231062).create());
        itemDocListCardBinding.recyclerView.setItemAnimator(null);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.entityCard = (EntityCard) obj;
        this.adapter.notifyDataSetChanged();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        public DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DataViewHolder(LayoutInflater.from(DocListCardViewHolder.this.getContext()).inflate(2131558679, viewGroup, false), DocListCardViewHolder.this.component);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(DocListCardViewHolder.this.entityCard.getEntities().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CollectionUtils.safeSize(DocListCardViewHolder.this.entityCard.getEntities());
        }
    }

    public static class DataViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558679;
        private Entity entity;

        public DataViewHolder(View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent, null);
            ItemDocListCardItemBinding itemDocListCardItemBinding = (ItemDocListCardItemBinding) getBinding();
            ViewUtil.clickListener(itemDocListCardItemBinding.getRoot(), this);
            ViewUtil.clickListener(itemDocListCardItemBinding.getView, this);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            this.entity = (Entity) obj;
            ItemDocListCardItemBinding itemDocListCardItemBinding = (ItemDocListCardItemBinding) getBinding();
            Entity entity2 = this.entity;
            if (entity2 instanceof Gift) {
                itemDocListCardItemBinding.setIsGift(true);
                itemDocListCardItemBinding.setTitle(this.entity.getTitle());
                itemDocListCardItemBinding.setEntityTypeName(this.entity.getEntityTypeName());
                itemDocListCardItemBinding.setLogo(((Gift) this.entity).getApkLogo());
            } else if (entity2 instanceof NewHeadLine) {
                itemDocListCardItemBinding.setIsGift(false);
                itemDocListCardItemBinding.setTitle(this.entity.getTitle());
                itemDocListCardItemBinding.setEntityTypeName(this.entity.getEntityTypeName());
                itemDocListCardItemBinding.setLogo(this.entity.getLogo());
            }
            itemDocListCardItemBinding.executePendingBindings();
            UiUtils.setDrawableColors(itemDocListCardItemBinding.entityTypeNameView.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorAccent());
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            if (view.getId() != 2131362613) {
                Entity entity2 = this.entity;
                if (entity2 instanceof Gift) {
                    Gift gift = (Gift) entity2;
                    ActionManager.startAppViewActivity(UiUtils.getActivity(getContext()), ((ItemDocListCardItemBinding) getBinding()).iconView, gift.getApkName(), gift.getApkLogo(), gift.getApkTitle(), gift.getExtraAnalysisData(), null, null);
                } else if (entity2 instanceof NewHeadLine) {
                    ActionManager.startActivityByUrl(getContext(), ((NewHeadLine) entity2).getUrl());
                }
            } else {
                final Gift gift2 = (Gift) this.entity;
                if (!gift2.isGet()) {
                    if (!gift2.isRequireInstalled() || PackageUtils.isInstalled(getContext(), gift2.getApkName())) {
                        FetchGiftDialog.newInstance(gift2).show(ContextExtendsKt.requireAppCompatActivity(getContext()).getSupportFragmentManager(), (String) null);
                        return;
                    }
                    SimpleDialog newInstance = SimpleDialog.newInstance();
                    newInstance.setMessage(getContext().getString(2131886884));
                    newInstance.setPositiveButton(2131886128, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.viewholder.DocListCardViewHolder.DataViewHolder.AnonymousClass1 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActionManager.startAppViewActivity(DataViewHolder.this.getContext(), gift2.getApkName(), true);
                        }
                    });
                    newInstance.setNegativeButton(2131886115);
                    newInstance.show(ContextExtendsKt.requireAppCompatActivity(getContext()).getSupportFragmentManager(), (String) null);
                }
            }
        }
    }
}
