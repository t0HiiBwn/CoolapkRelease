package com.coolapk.market.view.dyhv8.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemDyhSourcePartBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DyhArticleSourceViewPart.kt */
public final class DyhArticleSourceViewPart extends BindingViewPart<ItemDyhSourcePartBinding, DyhArticle> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558683;
    private final DataBindingComponent component;
    private final Lazy ninePicViewPart$delegate;

    private final NinePicViewPart getNinePicViewPart() {
        return (NinePicViewPart) this.ninePicViewPart$delegate.getValue();
    }

    public static final DyhArticleSourceViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent) {
        return Companion.newInstance(viewGroup, dataBindingComponent);
    }

    public /* synthetic */ DyhArticleSourceViewPart(DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, DefaultConstructorMarker defaultConstructorMarker) {
        this(dataBindingComponent, itemActionHandler);
    }

    private DyhArticleSourceViewPart(DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        this.component = dataBindingComponent;
        this.ninePicViewPart$delegate = LazyKt.lazy(new DyhArticleSourceViewPart$ninePicViewPart$2(this));
    }

    public void onBindToContent(DyhArticle dyhArticle) {
        Intrinsics.checkNotNullParameter(dyhArticle, "data");
        ItemDyhSourcePartBinding itemDyhSourcePartBinding = (ItemDyhSourcePartBinding) getBinding();
        View root = itemDyhSourcePartBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setVisibility(0);
        addHeader(dyhArticle);
        addContent(dyhArticle);
        getNinePicViewPart().setMaxShowCount(9);
        getNinePicViewPart().setFullSizeWhenOne(false);
        getNinePicViewPart().setImageViewClickable(false);
        if (dyhArticle.getPicArr() != null) {
            NinePicViewPart ninePicViewPart = getNinePicViewPart();
            List<String> picArr = dyhArticle.getPicArr();
            Intrinsics.checkNotNull(picArr);
            Intrinsics.checkNotNullExpressionValue(picArr, "data.picArr!!");
            ninePicViewPart.bindToContent(picArr);
        }
        ViewExtendsKt.setUtilClickListener(getView(), new DyhArticleSourceViewPart$onBindToContent$1(this, dyhArticle));
        itemDyhSourcePartBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemDyhSourcePartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558683, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        return (ItemDyhSourcePartBinding) inflate;
    }

    /* compiled from: DyhArticleSourceViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DyhArticleSourceViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            DyhArticleSourceViewPart dyhArticleSourceViewPart = new DyhArticleSourceViewPart(dataBindingComponent, null, null);
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(container.context)");
            dyhArticleSourceViewPart.createView(from, viewGroup);
            return dyhArticleSourceViewPart;
        }
    }

    private final void addHeader(DyhArticle dyhArticle) {
        FrameLayout frameLayout = ((ItemDyhSourcePartBinding) getBinding()).headerContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.headerContainer");
        DyhViewModel dyhViewModel = new DyhViewModel();
        dyhViewModel.setDyhArticle(dyhArticle);
        dyhViewModel.setInForward(true);
        FrameLayout frameLayout2 = frameLayout;
        DyhArticleMiniHeaderViewPart newInstance = DyhArticleMiniHeaderViewPart.Companion.newInstance(frameLayout2, this.component, dyhViewModel);
        LayoutInflater from = LayoutInflater.from(frameLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(parent.context)");
        newInstance.createView(from, frameLayout2);
        newInstance.bindToContent(dyhArticle);
        View view = newInstance.getView();
        if (frameLayout.getChildAt(0) != view) {
            frameLayout.removeAllViews();
            frameLayout.addView(view);
        }
    }

    private final void addContent(DyhArticle dyhArticle) {
        FrameLayout frameLayout = ((ItemDyhSourcePartBinding) getBinding()).contentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.contentContainer");
        DyhViewModel dyhViewModel = new DyhViewModel();
        dyhViewModel.setDyhArticle(dyhArticle);
        dyhViewModel.setMaxWords(60);
        FrameLayout frameLayout2 = frameLayout;
        DyhArticleContentViewPart newInstance = DyhArticleContentViewPart.Companion.newInstance(frameLayout2, this.component, dyhViewModel);
        LayoutInflater from = LayoutInflater.from(frameLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(parent.context)");
        newInstance.createView(from, frameLayout2);
        newInstance.bindToContent(dyhArticle);
        View view = newInstance.getView();
        if (frameLayout.getChildAt(0) != view) {
            frameLayout.removeAllViews();
            frameLayout.addView(view);
        }
    }
}
