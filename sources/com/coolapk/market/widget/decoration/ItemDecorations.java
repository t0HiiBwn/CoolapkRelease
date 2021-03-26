package com.coolapk.market.widget.decoration;

import android.content.Context;
import com.coolapk.market.widget.decoration.HorizontalItemDecoration;
import com.coolapk.market.widget.decoration.VerticalItemDecoration;

public class ItemDecorations {
    public static VerticalItemDecoration.Builder vertical(Context context) {
        return new VerticalItemDecoration.Builder(context);
    }

    public static HorizontalItemDecoration.Builder horizontal(Context context) {
        return new HorizontalItemDecoration.Builder(context);
    }
}
