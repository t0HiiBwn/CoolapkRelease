package com.rd.draw.drawer.type;

import android.graphics.Paint;
import com.rd.draw.data.Indicator;

class BaseDrawer {
    Indicator indicator;
    Paint paint;

    BaseDrawer(Paint paint2, Indicator indicator2) {
        this.paint = paint2;
        this.indicator = indicator2;
    }
}
