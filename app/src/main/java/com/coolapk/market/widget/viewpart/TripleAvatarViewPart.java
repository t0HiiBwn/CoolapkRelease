package com.coolapk.market.widget.viewpart;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemTripleAvatarViewPartBinding;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/widget/viewpart/TripleAvatarViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemTripleAvatarViewPartBinding;", "", "", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "bindSampleData", "", "onBindToContent", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TripleAvatarViewPart.kt */
public final class TripleAvatarViewPart extends BindingViewPart<ItemTripleAvatarViewPartBinding, List<? extends String>> {
    private final DataBindingComponent component;

    public TripleAvatarViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public /* bridge */ /* synthetic */ void onBindToContent(List<? extends String> list) {
        onBindToContent((List<String>) list);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemTripleAvatarViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558963, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…        false, component)");
        return (ItemTripleAvatarViewPartBinding) inflate;
    }

    protected void onBindToContent(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        super.onBindToContent((TripleAvatarViewPart) list);
        ((ItemTripleAvatarViewPartBinding) getBinding()).setTransformer(new CircleTransform(false, 0, 3, null));
        ((ItemTripleAvatarViewPartBinding) getBinding()).setAvatar1((String) CollectionsKt.getOrNull(list, 0));
        ((ItemTripleAvatarViewPartBinding) getBinding()).setAvatar2((String) CollectionsKt.getOrNull(list, 1));
        ((ItemTripleAvatarViewPartBinding) getBinding()).setAvatar3((String) CollectionsKt.getOrNull(list, 2));
        ((ItemTripleAvatarViewPartBinding) getBinding()).executePendingBindings();
    }

    public final void bindSampleData() {
        bindToContent(CollectionsKt.arrayListOf("http://avatar.coolapk.com/data/000/40/05/22_avatar_big.jpg?1428854435", "http://avatar.coolapk.com/data/001/19/44/66_avatar_big.jpg?1567593672", "http://avatar.coolapk.com/data/000/44/76/26_avatar_big.jpg?1572447206"));
    }
}
