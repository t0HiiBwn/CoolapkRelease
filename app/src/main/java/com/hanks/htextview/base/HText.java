package com.hanks.htextview.base;

import android.graphics.Canvas;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

public abstract class HText implements IHText {
    protected AnimationListener animationListener;
    protected List<Float> gapList = new ArrayList();
    protected HTextView mHTextView;
    protected int mHeight;
    protected TextPaint mOldPaint;
    protected CharSequence mOldText;
    protected TextPaint mPaint;
    protected CharSequence mText;
    protected float mTextSize;
    protected int mWidth;
    protected List<Float> oldGapList = new ArrayList();
    protected float oldStartX = 0.0f;
    protected float progress;

    protected abstract void animatePrepare(CharSequence charSequence);

    protected abstract void animateStart(CharSequence charSequence);

    protected abstract void drawFrame(Canvas canvas);

    protected abstract void initVariables();

    public void setProgress(float f) {
        this.progress = f;
        this.mHTextView.invalidate();
    }

    @Override // com.hanks.htextview.base.IHText
    public void init(HTextView hTextView, AttributeSet attributeSet, int i) {
        this.mHTextView = hTextView;
        this.mOldText = "";
        this.mText = hTextView.getText();
        this.progress = 1.0f;
        this.mPaint = new TextPaint(1);
        this.mOldPaint = new TextPaint(this.mPaint);
        this.mHTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.hanks.htextview.base.HText.AnonymousClass1 */

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                float f;
                if (Build.VERSION.SDK_INT >= 16) {
                    HText.this.mHTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    HText.this.mHTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                HText hText = HText.this;
                hText.mTextSize = hText.mHTextView.getTextSize();
                HText hText2 = HText.this;
                hText2.mWidth = hText2.mHTextView.getWidth();
                HText hText3 = HText.this;
                hText3.mHeight = hText3.mHTextView.getHeight();
                HText.this.oldStartX = 0.0f;
                try {
                    int layoutDirection = ViewCompat.getLayoutDirection(HText.this.mHTextView);
                    HText hText4 = HText.this;
                    if (layoutDirection == 0) {
                        f = hText4.mHTextView.getLayout().getLineLeft(0);
                    } else {
                        f = hText4.mHTextView.getLayout().getLineRight(0);
                    }
                    hText4.oldStartX = f;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                HText.this.initVariables();
            }
        });
        prepareAnimate();
    }

    private void prepareAnimate() {
        float textSize = this.mHTextView.getTextSize();
        this.mTextSize = textSize;
        this.mPaint.setTextSize(textSize);
        this.mPaint.setColor(this.mHTextView.getCurrentTextColor());
        this.mPaint.setTypeface(this.mHTextView.getTypeface());
        this.gapList.clear();
        for (int i = 0; i < this.mText.length(); i++) {
            this.gapList.add(Float.valueOf(this.mPaint.measureText(String.valueOf(this.mText.charAt(i)))));
        }
        this.mOldPaint.setTextSize(this.mTextSize);
        this.mOldPaint.setColor(this.mHTextView.getCurrentTextColor());
        this.mOldPaint.setTypeface(this.mHTextView.getTypeface());
        this.oldGapList.clear();
        for (int i2 = 0; i2 < this.mOldText.length(); i2++) {
            this.oldGapList.add(Float.valueOf(this.mOldPaint.measureText(String.valueOf(this.mOldText.charAt(i2)))));
        }
    }

    @Override // com.hanks.htextview.base.IHText
    public void animateText(CharSequence charSequence) {
        this.mHTextView.setText(charSequence);
        this.mOldText = this.mText;
        this.mText = charSequence;
        prepareAnimate();
        animatePrepare(charSequence);
        animateStart(charSequence);
    }

    @Override // com.hanks.htextview.base.IHText
    public void setAnimationListener(AnimationListener animationListener2) {
        this.animationListener = animationListener2;
    }

    @Override // com.hanks.htextview.base.IHText
    public void onDraw(Canvas canvas) {
        drawFrame(canvas);
    }
}
