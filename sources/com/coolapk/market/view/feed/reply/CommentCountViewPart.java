package com.coolapk.market.view.feed.reply;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.databinding.FeedCommentCountViewPartBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.view.cardlist.EntityListFixTopHelper;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.view.SimpleIndicatorView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommentCountViewPart.kt */
public final class CommentCountViewPart extends BindingViewPart<FeedCommentCountViewPartBinding, Integer> {
    private final Parcelable entity;
    private final EntityListFixTopHelper fixTopHelper;
    private final FeedReplyPresenter presenter;

    public CommentCountViewPart(FeedReplyPresenter feedReplyPresenter, EntityListFixTopHelper entityListFixTopHelper, Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(feedReplyPresenter, "presenter");
        Intrinsics.checkNotNullParameter(entityListFixTopHelper, "fixTopHelper");
        Intrinsics.checkNotNullParameter(parcelable, "entity");
        this.presenter = feedReplyPresenter;
        this.fixTopHelper = entityListFixTopHelper;
        this.entity = parcelable;
    }

    public final Parcelable getEntity() {
        return this.entity;
    }

    public final EntityListFixTopHelper getFixTopHelper() {
        return this.fixTopHelper;
    }

    public final FeedReplyPresenter getPresenter() {
        return this.presenter;
    }

    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public /* bridge */ /* synthetic */ void onBindToContent(Integer num) {
        onBindToContent(num.intValue());
    }

    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public FeedCommentCountViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558559, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…w_part, viewGroup, false)");
        return (FeedCommentCountViewPartBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((FeedCommentCountViewPartBinding) getBinding()).fixTopView.addOnAttachStateChangeListener(new CommentCountViewPart$onViewCreated$1(this));
        LifecycleOwner lifecycleOwner = this.presenter.getLifecycleOwner();
        FeedReplyViewModel viewModel = this.presenter.getViewModel();
        viewModel.getForwardNum().observe(lifecycleOwner, new CommentCountViewPart$onViewCreated$2(this));
        viewModel.getLikeNum().observe(lifecycleOwner, new CommentCountViewPart$onViewCreated$3(this));
        viewModel.getCommentNum().observe(lifecycleOwner, new CommentCountViewPart$onViewCreated$4(this));
        viewModel.getLoadDataType().observe(lifecycleOwner, new CommentCountViewPart$onViewCreated$5(this));
        ((FeedCommentCountViewPartBinding) getBinding()).likeView.setOnClickListener(new CommentCountViewPart$onViewCreated$6(this));
        ((FeedCommentCountViewPartBinding) getBinding()).forwardView.setOnClickListener(new CommentCountViewPart$onViewCreated$7(this));
        ((FeedCommentCountViewPartBinding) getBinding()).filterView.setOnClickListener(new CommentCountViewPart$onViewCreated$8(this, viewModel));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (r10.isAdmin() != false) goto L_0x008a;
     */
    public final void showFilterPopMenu(View view) {
        boolean z;
        Integer value = this.presenter.getViewModel().getBlockNum().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "presenter.viewModel.blockNum.value!!");
        int intValue = value.intValue();
        BasePopMenu basePopMenu = new BasePopMenu(getContext(), view);
        FilterArgs[] values = FilterArgs.values();
        ArrayList<FilterArgs> arrayList = new ArrayList();
        int length = values.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                break;
            }
            FilterArgs filterArgs = values[i];
            if (filterArgs == FilterArgs.FILTER_BY_BLOCK_STATUS) {
                z = false;
            }
            if (z) {
                arrayList.add(filterArgs);
            }
            i++;
        }
        for (FilterArgs filterArgs2 : arrayList) {
            basePopMenu.getMenu().add(0, filterArgs2.validId(), filterArgs2.validId(), filterArgs2.getTextId());
        }
        if (intValue > 0) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        }
        z = false;
        if (z) {
            FilterArgs filterArgs3 = FilterArgs.FILTER_BY_BLOCK_STATUS;
            basePopMenu.getMenu().add(0, filterArgs3.validId(), filterArgs3.validId(), filterArgs3.getTextId());
        }
        basePopMenu.setOnMenuItemClickListener(new CommentCountViewPart$showFilterPopMenu$3(this));
        basePopMenu.show();
    }

    protected void onBindToContent(int i) {
        super.onBindToContent((CommentCountViewPart) Integer.valueOf(i));
        SimpleIndicatorView simpleIndicatorView = ((FeedCommentCountViewPartBinding) getBinding()).indicatorView;
        Intrinsics.checkNotNullExpressionValue(simpleIndicatorView, "binding.indicatorView");
        simpleIndicatorView.getViewTreeObserver().addOnPreDrawListener(new CommentCountViewPart$onBindToContent$1(this));
        EntityListFixTopHelper entityListFixTopHelper = this.fixTopHelper;
        FrameLayout frameLayout = ((FeedCommentCountViewPartBinding) getBinding()).fixTopView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fixTopView");
        FrameLayout frameLayout2 = ((FeedCommentCountViewPartBinding) getBinding()).cardView;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.cardView");
        entityListFixTopHelper.setFixTopView(frameLayout, frameLayout2, this.entity);
    }

    public final String getLabelTitle(String str, int i) {
        return str + ' ' + i;
    }

    public final void checkIndicatorOffset() {
        Integer value = this.presenter.getViewModel().getLoadDataType().getValue();
        if (value != null && value.intValue() == 1) {
            LinearLayout linearLayout = ((FeedCommentCountViewPartBinding) getBinding()).filterView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.filterView");
            ((FeedCommentCountViewPartBinding) getBinding()).indicatorView.animatorToOffset(linearLayout.getLeft() + ((linearLayout.getWidth() - ((FeedCommentCountViewPartBinding) getBinding()).indicatorView.getIndicatorWidth()) / 2));
        } else if (value != null && value.intValue() == 2) {
            TextView textView = ((FeedCommentCountViewPartBinding) getBinding()).forwardView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.forwardView");
            ((FeedCommentCountViewPartBinding) getBinding()).indicatorView.animatorToOffset(textView.getLeft() + ((textView.getWidth() - ((FeedCommentCountViewPartBinding) getBinding()).indicatorView.getIndicatorWidth()) / 2));
        } else if (value != null && value.intValue() == 0) {
            TextView textView2 = ((FeedCommentCountViewPartBinding) getBinding()).likeView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.likeView");
            ((FeedCommentCountViewPartBinding) getBinding()).indicatorView.animatorToOffset(textView2.getLeft() + ((textView2.getWidth() - ((FeedCommentCountViewPartBinding) getBinding()).indicatorView.getIndicatorWidth()) / 2));
        }
    }
}
