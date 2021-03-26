package com.coolapk.market.view.feed.pick;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.databinding.SearchBackHeaderBinding;
import com.coolapk.market.extend.StringExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.ThemeUtilsCompat;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.TriangleDrawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/feed/pick/SearchHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/SearchBackHeaderBinding;", "", "Landroid/widget/TextView$OnEditorActionListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "onKeyWords", "Lkotlin/Function1;", "", "getOnKeyWords", "()Lkotlin/jvm/functions/Function1;", "setOnKeyWords", "(Lkotlin/jvm/functions/Function1;)V", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onEditorAction", "", "v", "Landroid/widget/TextView;", "actionId", "", "event", "Landroid/view/KeyEvent;", "onViewCreated", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchHeaderViewPart.kt */
public final class SearchHeaderViewPart extends BindingViewPart<SearchBackHeaderBinding, Unit> implements TextView.OnEditorActionListener {
    private final Activity activity;
    private Function1<? super String, Unit> onKeyWords;

    public SearchHeaderViewPart(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> */
    public final Function1<String, Unit> getOnKeyWords() {
        return this.onKeyWords;
    }

    public final void setOnKeyWords(Function1<? super String, Unit> function1) {
        this.onKeyWords = function1;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public SearchBackHeaderBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559129, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…header, viewGroup, false)");
        return (SearchBackHeaderBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        int i;
        super.onViewCreated();
        ProgressBar progressBar = ((SearchBackHeaderBinding) getBinding()).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        ViewExtendsKt.gone(progressBar);
        AutoCompleteTextView autoCompleteTextView = ((SearchBackHeaderBinding) getBinding()).searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "binding.searchText");
        autoCompleteTextView.setThreshold(1);
        ((SearchBackHeaderBinding) getBinding()).searchText.setOnEditorActionListener(this);
        ((SearchBackHeaderBinding) getBinding()).searchText.addTextChangedListener(new SearchHeaderViewPart$onViewCreated$1(this));
        ((SearchBackHeaderBinding) getBinding()).clearButton.setOnClickListener(new SearchHeaderViewPart$onViewCreated$2(this));
        ((SearchBackHeaderBinding) getBinding()).searchButton.setOnClickListener(new SearchHeaderViewPart$onViewCreated$3(this));
        ((SearchBackHeaderBinding) getBinding()).navigationButton.setOnClickListener(new SearchHeaderViewPart$onViewCreated$4(this));
        FrameLayout frameLayout = ((SearchBackHeaderBinding) getBinding()).qrOrClearButton;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.qrOrClearButton");
        frameLayout.setVisibility(8);
        LinearLayout linearLayout = ((SearchBackHeaderBinding) getBinding()).searchBoxLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.searchBoxLayout");
        UiUtils.setDrawableSolidColors(linearLayout.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorPrimary());
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        if (appSetting.isAppHeaderSearchBackgroundTransparent()) {
            i = AppHolder.getAppTheme().getColorPrimary();
        } else {
            i = ShapeUtils.createSearchBoxColor();
        }
        LinearLayout linearLayout2 = ((SearchBackHeaderBinding) getBinding()).searchBoxLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.searchBoxLayout");
        UiUtils.setDrawableSolidColors(linearLayout2.getBackground(), new int[]{1}, i);
        int pickThemeColor = ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#FFFFFF"));
        int pickThemeColor2 = ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#525252"), StringExtendsKt.colorInt("#C1C1C1"), StringExtendsKt.colorInt("#7FFFFFFF"));
        ((SearchBackHeaderBinding) getBinding()).searchText.setTextColor(pickThemeColor);
        ((SearchBackHeaderBinding) getBinding()).searchText.setHintTextColor(pickThemeColor2);
        ((SearchBackHeaderBinding) getBinding()).searchTypeText.setTextColor(pickThemeColor);
        ImageView imageView = ((SearchBackHeaderBinding) getBinding()).navigationIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.navigationIcon");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView.getDrawable()).mutate(), pickThemeColor);
        ImageView imageView2 = ((SearchBackHeaderBinding) getBinding()).qrView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.qrView");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView2.getDrawable()).mutate(), pickThemeColor);
        ImageView imageView3 = ((SearchBackHeaderBinding) getBinding()).clearButton;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.clearButton");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView3.getDrawable()).mutate(), pickThemeColor);
        ImageView imageView4 = ((SearchBackHeaderBinding) getBinding()).searchIcon;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.searchIcon");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView4.getDrawable()).mutate(), pickThemeColor);
        ((SearchBackHeaderBinding) getBinding()).arrowView.setImageDrawable(new TriangleDrawable(pickThemeColor));
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(textView, "v");
        if (i != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        Function1<? super String, Unit> function1 = this.onKeyWords;
        if (function1 == null) {
            return true;
        }
        function1.invoke(textView.getText().toString());
        return true;
    }
}
