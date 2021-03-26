package com.coolapk.market.view.feed.pick;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.FrameLayout;
import com.coolapk.market.databinding.SearchBackHeaderBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/coolapk/market/view/feed/pick/SearchHeaderViewPart$onViewCreated$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "onTextChanged", "before", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchHeaderViewPart.kt */
public final class SearchHeaderViewPart$onViewCreated$1 implements TextWatcher {
    final /* synthetic */ SearchHeaderViewPart this$0;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SearchHeaderViewPart$onViewCreated$1(SearchHeaderViewPart searchHeaderViewPart) {
        this.this$0 = searchHeaderViewPart;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        FrameLayout frameLayout = ((SearchBackHeaderBinding) this.this$0.getBinding()).qrOrClearButton;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.qrOrClearButton");
        int i = 0;
        if (!(editable.length() > 0)) {
            i = 8;
        }
        frameLayout.setVisibility(i);
    }
}
