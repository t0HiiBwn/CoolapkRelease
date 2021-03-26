package com.hanks.htextview.rainbow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.DisplayUtils;
import com.hanks.htextview.base.HTextView;

public class RainbowTextView extends HTextView {
    private float colorSpace;
    private float colorSpeed;
    private int[] colors;
    private LinearGradient mLinearGradient;
    private Matrix mMatrix;
    private float mTranslate;

    @Override // com.hanks.htextview.base.HTextView
    public void setProgress(float f) {
    }

    public RainbowTextView(Context context) {
        this(context, null);
    }

    public RainbowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RainbowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.colors = new int[]{-54494, -32990, -1179870, -14483678, -14486273, -14534145, -11271945};
        init(attributeSet, i);
    }

    @Override // com.hanks.htextview.base.HTextView
    public void setAnimationListener(AnimationListener animationListener) {
        throw new UnsupportedOperationException("Invalid operation for rainbow");
    }

    private void init(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RainbowTextView);
        this.colorSpace = obtainStyledAttributes.getDimension(R.styleable.RainbowTextView_colorSpace, (float) DisplayUtils.dp2px(150.0f));
        this.colorSpeed = obtainStyledAttributes.getDimension(R.styleable.RainbowTextView_colorSpeed, (float) DisplayUtils.dp2px(5.0f));
        obtainStyledAttributes.recycle();
        this.mMatrix = new Matrix();
        initPaint();
    }

    public float getColorSpace() {
        return this.colorSpace;
    }

    public void setColorSpace(float f) {
        this.colorSpace = f;
    }

    public float getColorSpeed() {
        return this.colorSpeed;
    }

    public void setColorSpeed(float f) {
        this.colorSpeed = f;
    }

    public void setColors(int... iArr) {
        this.colors = iArr;
        initPaint();
    }

    private void initPaint() {
        this.mLinearGradient = new LinearGradient(0.0f, 0.0f, this.colorSpace, 0.0f, this.colors, (float[]) null, Shader.TileMode.MIRROR);
        getPaint().setShader(this.mLinearGradient);
    }

    @Override // com.hanks.htextview.base.HTextView
    public void animateText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mMatrix == null) {
            this.mMatrix = new Matrix();
        }
        float f = this.mTranslate + this.colorSpeed;
        this.mTranslate = f;
        this.mMatrix.setTranslate(f, 0.0f);
        this.mLinearGradient.setLocalMatrix(this.mMatrix);
        super.onDraw(canvas);
        postInvalidateDelayed(100);
    }
}
