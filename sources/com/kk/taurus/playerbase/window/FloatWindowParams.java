package com.kk.taurus.playerbase.window;

public class FloatWindowParams {
    private boolean defaultAnimation = true;
    private int flag = 8;
    private int format = 1;
    private int gravity = 51;
    private int height = -2;
    private int width = -2;
    private int windowType = 2002;
    private int x;
    private int y;

    public int getWindowType() {
        return this.windowType;
    }

    public FloatWindowParams setWindowType(int i) {
        this.windowType = i;
        return this;
    }

    public int getGravity() {
        return this.gravity;
    }

    public FloatWindowParams setGravity(int i) {
        this.gravity = i;
        return this;
    }

    public int getFormat() {
        return this.format;
    }

    public FloatWindowParams setFormat(int i) {
        this.format = i;
        return this;
    }

    public int getFlag() {
        return this.flag;
    }

    public FloatWindowParams setFlag(int i) {
        this.flag = i;
        return this;
    }

    public int getX() {
        return this.x;
    }

    public FloatWindowParams setX(int i) {
        this.x = i;
        return this;
    }

    public int getY() {
        return this.y;
    }

    public FloatWindowParams setY(int i) {
        this.y = i;
        return this;
    }

    public int getWidth() {
        return this.width;
    }

    public FloatWindowParams setWidth(int i) {
        this.width = i;
        return this;
    }

    public int getHeight() {
        return this.height;
    }

    public FloatWindowParams setHeight(int i) {
        this.height = i;
        return this;
    }

    public boolean isDefaultAnimation() {
        return this.defaultAnimation;
    }

    public FloatWindowParams setDefaultAnimation(boolean z) {
        this.defaultAnimation = z;
        return this;
    }
}
