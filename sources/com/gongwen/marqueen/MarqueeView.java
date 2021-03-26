package com.gongwen.marqueen;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import java.util.List;

public class MarqueeView extends ViewFlipper {
    private int animDuration;
    private Animation animIn;
    private int animInRes;
    private Animation animOut;
    private int animOutRes;
    private int interval;

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interval = 2500;
        this.animDuration = 500;
        this.animInRes = R.anim.bottom_in;
        this.animOutRes = R.anim.top_out;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MarqueeView, 0, 0);
        this.interval = obtainStyledAttributes.getInt(R.styleable.MarqueeView_marqueeInterval, this.interval);
        this.animInRes = obtainStyledAttributes.getResourceId(R.styleable.MarqueeView_marqueeAnimIn, this.animInRes);
        this.animOutRes = obtainStyledAttributes.getResourceId(R.styleable.MarqueeView_marqueeAnimOut, this.animOutRes);
        this.animDuration = obtainStyledAttributes.getInt(R.styleable.MarqueeView_marqueeAnimDuration, this.animDuration);
        obtainStyledAttributes.recycle();
        setFlipInterval(this.interval);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), this.animInRes);
        this.animIn = loadAnimation;
        loadAnimation.setDuration((long) this.animDuration);
        setInAnimation(this.animIn);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), this.animOutRes);
        this.animOut = loadAnimation2;
        loadAnimation2.setDuration((long) this.animDuration);
        setOutAnimation(this.animOut);
    }

    public void setMarqueeFactory(MarqueeFactory marqueeFactory) {
        marqueeFactory.setAttachedToMarqueeView(this);
        removeAllViews();
        List marqueeViews = marqueeFactory.getMarqueeViews();
        if (marqueeViews != null) {
            for (int i = 0; i < marqueeViews.size(); i++) {
                addView((View) marqueeViews.get(i));
            }
        }
    }

    public void setInterval(int i) {
        this.interval = i;
        setFlipInterval(i);
    }

    public void setAnimDuration(int i) {
        this.animDuration = i;
        long j = (long) i;
        this.animIn.setDuration(j);
        setInAnimation(this.animIn);
        this.animOut.setDuration(j);
        setOutAnimation(this.animOut);
    }

    public void setAnimInAndOut(Animation animation, Animation animation2) {
        this.animIn = animation;
        this.animOut = animation2;
        setInAnimation(animation);
        setOutAnimation(animation2);
    }

    public void setAnimInAndOut(int i, int i2) {
        this.animIn = AnimationUtils.loadAnimation(getContext(), i);
        this.animOut = AnimationUtils.loadAnimation(getContext(), i2);
        this.animIn.setDuration((long) this.animDuration);
        this.animOut.setDuration((long) this.animDuration);
        setInAnimation(this.animIn);
        setOutAnimation(this.animOut);
    }

    public Animation getAnimIn() {
        return this.animIn;
    }

    public Animation getAnimOut() {
        return this.animOut;
    }

    @Override // android.widget.ViewFlipper, android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopFlipping();
    }
}
