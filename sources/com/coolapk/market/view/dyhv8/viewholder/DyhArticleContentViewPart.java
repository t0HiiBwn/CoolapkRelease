package com.coolapk.market.view.dyhv8.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemDyhArticleContentBinding;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0014J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleContentViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemDyhArticleContentBinding;", "Lcom/coolapk/market/model/DyhArticle;", "dataBindingComponent", "Landroidx/databinding/DataBindingComponent;", "mDyhViewModel", "Lcom/coolapk/market/view/dyhv8/DyhViewModel;", "(Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/dyhv8/DyhViewModel;)V", "mDyhArticle", "onBindToContent", "", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleContentViewPart.kt */
public final class DyhArticleContentViewPart extends BindingViewPart<ItemDyhArticleContentBinding, DyhArticle> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558682;
    private final DataBindingComponent dataBindingComponent;
    private DyhArticle mDyhArticle;
    private final DyhViewModel mDyhViewModel;

    @JvmStatic
    public static final DyhArticleContentViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent2, DyhViewModel dyhViewModel) {
        return Companion.newInstance(viewGroup, dataBindingComponent2, dyhViewModel);
    }

    public DyhArticleContentViewPart(DataBindingComponent dataBindingComponent2, DyhViewModel dyhViewModel) {
        Intrinsics.checkNotNullParameter(dataBindingComponent2, "dataBindingComponent");
        Intrinsics.checkNotNullParameter(dyhViewModel, "mDyhViewModel");
        this.dataBindingComponent = dataBindingComponent2;
        this.mDyhViewModel = dyhViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleContentViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "newInstance", "Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleContentViewPart;", "container", "Landroid/view/ViewGroup;", "component", "Landroidx/databinding/DataBindingComponent;", "mDyhViewModel", "Lcom/coolapk/market/view/dyhv8/DyhViewModel;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleContentViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DyhArticleContentViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent, DyhViewModel dyhViewModel) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(dyhViewModel, "mDyhViewModel");
            DyhArticleContentViewPart dyhArticleContentViewPart = new DyhArticleContentViewPart(dataBindingComponent, dyhViewModel);
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(container.context)");
            dyhArticleContentViewPart.createView(from, viewGroup);
            return dyhArticleContentViewPart;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemDyhArticleContentBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558682, viewGroup, false, this.dataBindingComponent);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…se, dataBindingComponent)");
        return (ItemDyhArticleContentBinding) inflate;
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(DyhArticle dyhArticle) {
        Intrinsics.checkNotNullParameter(dyhArticle, "data");
        super.onBindToContent((DyhArticleContentViewPart) dyhArticle);
        this.mDyhArticle = dyhArticle;
        this.mDyhViewModel.setDyhArticle(dyhArticle);
        ((ItemDyhArticleContentBinding) getBinding()).setModel(this.mDyhViewModel);
        ((ItemDyhArticleContentBinding) getBinding()).setFoldText(" ");
        ((ItemDyhArticleContentBinding) getBinding()).executePendingBindings();
    }
}
