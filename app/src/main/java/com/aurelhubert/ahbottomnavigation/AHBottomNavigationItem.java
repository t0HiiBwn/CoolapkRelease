package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

public class AHBottomNavigationItem {
    private int color = -7829368;
    private int colorRes = 0;
    private Drawable drawable;
    private int drawableRes = 0;
    private String title = "";
    private int titleRes = 0;

    public AHBottomNavigationItem(String str, int i) {
        this.title = str;
        this.drawableRes = i;
    }

    @Deprecated
    public AHBottomNavigationItem(String str, int i, int i2) {
        this.title = str;
        this.drawableRes = i;
        this.color = i2;
    }

    public AHBottomNavigationItem(int i, int i2, int i3) {
        this.titleRes = i;
        this.drawableRes = i2;
        this.colorRes = i3;
    }

    public AHBottomNavigationItem(String str, Drawable drawable2) {
        this.title = str;
        this.drawable = drawable2;
    }

    public AHBottomNavigationItem(String str, Drawable drawable2, int i) {
        this.title = str;
        this.drawable = drawable2;
        this.color = i;
    }

    public String getTitle(Context context) {
        int i = this.titleRes;
        if (i != 0) {
            return context.getString(i);
        }
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
        this.titleRes = 0;
    }

    public void setTitle(int i) {
        this.titleRes = i;
        this.title = "";
    }

    public int getColor(Context context) {
        int i = this.colorRes;
        if (i != 0) {
            return ContextCompat.getColor(context, i);
        }
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
        this.colorRes = 0;
    }

    public void setColorRes(int i) {
        this.colorRes = i;
        this.color = 0;
    }

    public Drawable getDrawable(Context context) {
        int i = this.drawableRes;
        if (i == 0) {
            return this.drawable;
        }
        try {
            return AppCompatResources.getDrawable(context, i);
        } catch (Resources.NotFoundException unused) {
            return ContextCompat.getDrawable(context, this.drawableRes);
        }
    }

    public void setDrawable(int i) {
        this.drawableRes = i;
        this.drawable = null;
    }

    public void setDrawable(Drawable drawable2) {
        this.drawable = drawable2;
        this.drawableRes = 0;
    }
}
