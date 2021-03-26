package com.coolapk.market.view.dyhv8.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.ItemCoverViewBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.viewholder.iview.BindingViewPart;

public class ArticleCoverViewPart extends BindingViewPart<ItemCoverViewBinding, DyhArticle> {
    public static final int LAYOUT_ID = 2131558665;
    private DyhArticle dyhArticle;
    private final DataBindingComponent mComponent;

    private ArticleCoverViewPart(DataBindingComponent dataBindingComponent) {
        this.mComponent = dataBindingComponent;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemCoverViewBinding) getBinding()).setClick(this);
    }

    public static ArticleCoverViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent) {
        ArticleCoverViewPart articleCoverViewPart = new ArticleCoverViewPart(dataBindingComponent);
        articleCoverViewPart.createView(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        return articleCoverViewPart;
    }

    public void onBindToContent(DyhArticle dyhArticle2) {
        ItemCoverViewBinding itemCoverViewBinding = (ItemCoverViewBinding) getBinding();
        itemCoverViewBinding.setModel(dyhArticle2);
        this.dyhArticle = dyhArticle2;
        itemCoverViewBinding.executePendingBindings();
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemCoverViewBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ItemCoverViewBinding) DataBindingUtil.inflate(layoutInflater, 2131558665, viewGroup, false, this.mComponent);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == 2131362489) {
            ActionManager.startPhotoViewActivity(view, this.dyhArticle.getPic(), this.dyhArticle.getThumbnailPic());
        }
    }
}
