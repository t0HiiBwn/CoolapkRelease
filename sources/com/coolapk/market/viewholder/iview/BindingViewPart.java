package com.coolapk.market.viewholder.iview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0006\b\u0001\u0010\u0003 \u00002\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H$¢\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R \u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000@BX.¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "B", "Landroidx/databinding/ViewDataBinding;", "DATA", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "()V", "<set-?>", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "Landroidx/databinding/ViewDataBinding;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "bindToContent", "", "data", "(Ljava/lang/Object;)V", "onBindToContent", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/databinding/ViewDataBinding;", "onCreateView", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BindingViewPart.kt */
public abstract class BindingViewPart<B extends ViewDataBinding, DATA> extends ViewPart {
    private B binding;

    protected void onBindToContent(DATA data) {
    }

    protected abstract B onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public final B getBinding() {
        B b = this.binding;
        if (b == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return b;
    }

    public final Context getContext() {
        B b = this.binding;
        if (b == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = b.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        Context context = root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        return context;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        B onCreateBinding = onCreateBinding(layoutInflater, viewGroup);
        this.binding = onCreateBinding;
        if (onCreateBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = onCreateBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void bindToContent(DATA data) {
        onBindToContent(data);
    }
}
