package com.coolapk.market.view.feedv8.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;

public class ArticleEditText extends AppCompatEditText {
    public ArticleEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onCreateContextMenu(ContextMenu contextMenu) {
        super.onCreateContextMenu(contextMenu);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), i2);
    }

    @Override // android.widget.TextView, android.view.KeyEvent.Callback, android.view.View
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return true;
        }
    }
}
