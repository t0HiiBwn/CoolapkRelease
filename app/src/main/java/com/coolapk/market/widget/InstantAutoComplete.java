package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

public class InstantAutoComplete extends AppCompatAutoCompleteTextView {
    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        return true;
    }

    public InstantAutoComplete(Context context) {
        super(context);
    }

    public InstantAutoComplete(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstantAutoComplete(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z && getAdapter() != null) {
            performFiltering(getText(), 0);
        }
    }
}
