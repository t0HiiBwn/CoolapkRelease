package com.coolapk.market.view.dyhv8.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.ItemRightCoverViewBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.viewholder.iview.BindingViewPart;

public class ArticleRightCoverViewPart extends BindingViewPart<ItemRightCoverViewBinding, DyhArticle> {
    public static final int LAYOUT_ID = 2131558902;
    private DyhArticle dyhArticle;
    private final DataBindingComponent mComponent;

    private ArticleRightCoverViewPart(DataBindingComponent dataBindingComponent) {
        this.mComponent = dataBindingComponent;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemRightCoverViewBinding) getBinding()).setClick(this);
    }

    public static ArticleRightCoverViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent) {
        ArticleRightCoverViewPart articleRightCoverViewPart = new ArticleRightCoverViewPart(dataBindingComponent);
        articleRightCoverViewPart.createView(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        return articleRightCoverViewPart;
    }

    public void onBindToContent(DyhArticle dyhArticle2) {
        ItemRightCoverViewBinding itemRightCoverViewBinding = (ItemRightCoverViewBinding) getBinding();
        itemRightCoverViewBinding.setMessage(dyhArticle2.getMessage());
        itemRightCoverViewBinding.setPic(dyhArticle2.getThumbnailPic());
        this.dyhArticle = dyhArticle2;
        itemRightCoverViewBinding.executePendingBindings();
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemRightCoverViewBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ItemRightCoverViewBinding) DataBindingUtil.inflate(layoutInflater, 2131558902, viewGroup, false, this.mComponent);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == 2131362489) {
            ActionManager.startPhotoViewActivity(view, this.dyhArticle.getPicArr().get(0), this.dyhArticle.getThumbnailPic());
        }
    }
}
