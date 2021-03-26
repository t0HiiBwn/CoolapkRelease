package com.coolapk.market.view.danmaku.easy.danmaku;

public class Danmaku {
    public static final String COLOR_BLUE = "#ff0000ff";
    public static final String COLOR_GREEN = "#ff00ff00";
    public static final String COLOR_PURPLE = "#ffff00ff";
    public static final String COLOR_RED = "#ffff0000";
    public static final String COLOR_WHITE = "#ffffffff";
    public static final String COLOR_YELLOW = "#ffffff00";
    public static final int DEFAULT_TEXT_SIZE = 24;
    public int color = -1;
    public Mode mode = Mode.scroll;
    public int size = 24;
    public CharSequence text;

    public enum Mode {
        scroll,
        top,
        bottom
    }

    public String toString() {
        return "Danmaku{text='" + ((Object) this.text) + "', textSize=" + this.size + ", mode=" + this.mode + ", color='" + this.color + "'}";
    }
}
