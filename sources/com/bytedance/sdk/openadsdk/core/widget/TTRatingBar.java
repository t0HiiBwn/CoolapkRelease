package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;

public class TTRatingBar extends LinearLayout {
    private int a = 5;
    private int b = 0;
    private int c = 0;
    private float d;
    private float e;
    private float f;
    private Drawable g;
    private Drawable h;
    private Drawable i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        this.g = ac.c(context, "tt_star_empty_bg");
        this.h = ac.c(context, "tt_star_full_bg");
        this.i = ac.c(context, "tt_star_empty_bg");
        this.d = (float) ak.c(context, 15.0f);
        this.e = (float) ak.c(context, 15.0f);
        this.f = (float) ak.c(context, 5.0f);
    }

    public int getStarFillNum() {
        return this.a;
    }

    public void setStarFillNum(int i2) {
        this.a = i2;
    }

    public int getStarHalfNum() {
        return this.b;
    }

    public void setStarHalfNum(int i2) {
        this.b = i2;
    }

    public int getStarEmptyNum() {
        return this.c;
    }

    public void setStarEmptyNum(int i2) {
        this.c = i2;
    }

    public float getStarImageWidth() {
        return this.d;
    }

    public void setStarImageWidth(float f2) {
        this.d = f2;
    }

    public float getStarImageHeight() {
        return this.e;
    }

    public void setStarImageHeight(float f2) {
        this.e = f2;
    }

    public float getStarImagePadding() {
        return this.f;
    }

    public void setStarImagePadding(float f2) {
        this.f = f2;
    }

    public Drawable getStarEmptyDrawable() {
        return this.g;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.g = drawable;
    }

    public Drawable getStarFillDrawable() {
        return this.h;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.h = drawable;
    }

    public Drawable getStarHalfDrawable() {
        return this.i;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.i = drawable;
    }

    public void a() {
        removeAllViews();
        for (int i2 = 0; i2 < getStarFillNum(); i2++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i3 = 0; i3 < getStarHalfNum(); i3++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i4 = 0; i4 < getStarEmptyNum(); i4++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.d), Math.round(this.e)));
        imageView.setPadding(0, 0, Math.round(this.f), 0);
        return imageView;
    }
}
