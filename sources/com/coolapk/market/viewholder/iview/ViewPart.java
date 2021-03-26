package com.coolapk.market.viewholder.iview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH$J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/viewholder/iview/ViewPart;", "Landroid/view/View$OnClickListener;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "()V", "isInit", "", "<set-?>", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "createView", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onClick", "", "v", "onCreateView", "onRecycled", "onViewCreated", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewPart.kt */
public abstract class ViewPart implements View.OnClickListener, Recyclable {
    private boolean isInit;
    private View view;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Intrinsics.checkNotNullParameter(view2, "v");
    }

    protected abstract View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
    }

    protected void onViewCreated() {
    }

    public final View getView() {
        View view2 = this.view;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }
        return view2;
    }

    public final View createView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (!this.isInit) {
            this.view = onCreateView(layoutInflater, viewGroup);
            onViewCreated();
            this.isInit = true;
        }
        View view2 = this.view;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }
        return view2;
    }
}
