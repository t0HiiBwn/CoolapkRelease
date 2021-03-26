package com.github.florent37.shapeofview.manager;

import android.graphics.Paint;
import android.graphics.Path;

public interface ClipManager {
    Path createMask(int i, int i2);

    Paint getPaint();

    Path getShadowConvexPath();

    boolean requiresBitmap();

    void setupClipLayout(int i, int i2);
}
