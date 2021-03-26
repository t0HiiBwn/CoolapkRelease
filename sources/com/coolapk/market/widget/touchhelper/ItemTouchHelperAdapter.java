package com.coolapk.market.widget.touchhelper;

public interface ItemTouchHelperAdapter {
    boolean canMove(int i);

    boolean canSwipe(int i);

    boolean onItemMove(int i, int i2);
}
