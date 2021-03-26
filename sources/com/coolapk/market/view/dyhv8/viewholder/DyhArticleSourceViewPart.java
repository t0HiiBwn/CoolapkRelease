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
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0019\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleSourceViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemDyhSourcePartBinding;", "Lcom/coolapk/market/model/DyhArticle;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "ninePicViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getNinePicViewPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "ninePicViewPart$delegate", "Lkotlin/Lazy;", "addContent", "", "data", "addHeader", "onBindToContent", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleSourceViewPart.kt */
public final class DyhArticleSourceViewPart extends BindingViewPart<ItemDyhSourcePartBinding, DyhArticle> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558689;
    private final DataBindingComponent component;
    private final Lazy ninePicViewPart$delegate;

    private final NinePicViewPart getNinePicViewPart() {
        return (NinePicViewPart) this.ninePicViewPart$delegate.getValue();
    }

    @JvmStatic
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

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemDyhSourcePartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558689, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        return (ItemDyhSourcePartBinding) inflate;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleSourceViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "newInstance", "Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleSourceViewPart;", "container", "Landroid/view/ViewGroup;", "component", "Landroidx/databinding/DataBindingComponent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleSourceViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
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
