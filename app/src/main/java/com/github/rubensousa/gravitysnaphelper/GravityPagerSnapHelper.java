package com.github.rubensousa.gravitysnaphelper;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

@Deprecated
public class GravityPagerSnapHelper extends GravitySnapHelper {
    public GravityPagerSnapHelper(int i) {
        this(i, null);
    }

    public GravityPagerSnapHelper(int i, GravitySnapHelper.SnapListener snapListener) {
        super(i, false, snapListener);
        setMaxFlingSizeFraction(1.0f);
        setScrollMsPerInch(50.0f);
    }
}
