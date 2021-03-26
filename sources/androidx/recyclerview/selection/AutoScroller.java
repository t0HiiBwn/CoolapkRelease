package androidx.recyclerview.selection;

import android.graphics.Point;

public abstract class AutoScroller {
    public abstract void reset();

    public abstract void scroll(Point point);
}
