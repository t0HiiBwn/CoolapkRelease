package com.coolapk.market.view.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/settings/HttpInfoFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "()V", "textView", "Landroid/widget/TextView;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: HttpInfoFragment.kt */
public final class HttpInfoFragment extends BaseFragment {
    private TextView textView;

    public static final /* synthetic */ TextView access$getTextView$p(HttpInfoFragment httpInfoFragment) {
        TextView textView2 = httpInfoFragment.textView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        return textView2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = layoutInflater.getContext();
        ScrollView scrollView = new ScrollView(context);
        TextView textView2 = new TextView(context);
        this.textView = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView2.setText("请稍后...");
        TextView textView3 = this.textView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView3.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        TextView textView4 = this.textView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView4.setPadding(NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16));
        TextView textView5 = this.textView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        scrollView.addView(textView5, new ViewGroup.LayoutParams(-1, -2));
        return scrollView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getHttpInfo().compose(RxUtils.applyIOSchedulers()).subscribe(new HttpInfoFragment$onActivityCreated$1(this), new HttpInfoFragment$onActivityCreated$2(this));
    }
}
