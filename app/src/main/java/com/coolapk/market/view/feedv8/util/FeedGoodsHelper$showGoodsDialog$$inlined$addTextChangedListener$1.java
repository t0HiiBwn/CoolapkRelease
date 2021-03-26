package com.coolapk.market.view.feedv8.util;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.SubmitFeedNewGoodsBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.ResourceUtils;
import group.infotech.drawable.dsl.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextView.kt */
public final class FeedGoodsHelper$showGoodsDialog$$inlined$addTextChangedListener$1 implements TextWatcher {
    final /* synthetic */ Activity $activity$inlined;
    final /* synthetic */ SubmitFeedNewGoodsBinding $binding$inlined;
    final /* synthetic */ Ref.ObjectRef $oldHasPost$inlined;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public FeedGoodsHelper$showGoodsDialog$$inlined$addTextChangedListener$1(Ref.ObjectRef objectRef, SubmitFeedNewGoodsBinding submitFeedNewGoodsBinding, Activity activity) {
        this.$oldHasPost$inlined = objectRef;
        this.$binding$inlined = submitFeedNewGoodsBinding;
        this.$activity$inlined = activity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String obj = editable != null ? editable.toString() : null;
        if (obj == null) {
            obj = "";
        }
        boolean z = (obj.length() > 0) && FeedGoodsUrlUtils.INSTANCE.isUrlPostBefore(obj);
        if (!Intrinsics.areEqual(this.$oldHasPost$inlined.element, Boolean.valueOf(z))) {
            this.$oldHasPost$inlined.element = (T) Boolean.valueOf(z);
            TextView textView = this.$binding$inlined.errorView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.errorView");
            textView.setVisibility(z ? 0 : 8);
            EditText editText = this.$binding$inlined.editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setCornerRadius(NumberExtendsKt.getDpf((Number) 8));
            Stroke stroke = new Stroke();
            if (z) {
                stroke.setColor(ResourceUtils.getColorInt(this.$activity$inlined, 2131099825));
            } else if (AppHolder.getAppTheme().isDarkTheme()) {
                stroke.setColor(872415231);
            } else {
                stroke.setColor(520093696);
            }
            stroke.setWidth(NumberExtendsKt.getDp((Number) 1));
            gradientDrawable.setStroke(stroke.getWidth(), stroke.getColor(), stroke.getDashWidth(), stroke.getDashGap());
            Unit unit = Unit.INSTANCE;
            editText.setBackground(gradientDrawable);
        }
    }
}
