package com.kk.taurus.playerbase.receiver;

import android.view.View;

public interface ICover {
    public static final int COVER_LEVEL_HIGH = 64;
    public static final int COVER_LEVEL_LOW = 0;
    public static final int COVER_LEVEL_MEDIUM = 32;
    public static final int LEVEL_MAX = 32;

    int getCoverLevel();

    View getView();

    void setCoverVisibility(int i);
}
