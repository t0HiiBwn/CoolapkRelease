package com.ali.auth.third.ui.iv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.ali.auth.third.ui.R;

public class AliUserSmsCodeView extends View {
    private StringBuilder a;
    private int b = -16777216;
    private float c = 36.0f;
    private int d = 4;
    private Paint e;
    private float f = 6.0f;
    private int g;
    private int h;
    private PointF[] i;
    private int j = -16777216;
    private int k = -16777216;
    private float l = 1.0f;
    private Paint m;
    private RectF[] n;
    private RectF[] o;
    private boolean p = true;
    private OnTextChangedListener q;
    private OnCompletedListener r;

    public interface OnCompletedListener {
        void onCompleted(String str);
    }

    public interface OnTextChangedListener {
        void onTextChanged(String str);
    }

    public AliUserSmsCodeView(Context context) {
        super(context);
        a(context, null);
    }

    public AliUserSmsCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public AliUserSmsCodeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a() {
        if (this.e == null) {
            this.e = new Paint(1);
        }
        this.e.setStyle(Paint.Style.FILL_AND_STROKE);
        this.e.setColor(this.b);
        this.e.setTextSize(this.c);
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setTypeface(Typeface.DEFAULT_BOLD);
        if (this.m == null) {
            this.m = new Paint(1);
        }
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setColor(this.j);
        this.m.setStrokeWidth(this.l);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AliUserSmsCodeView);
            this.d = obtainStyledAttributes.getInt(R.styleable.AliUserSmsCodeView_scTextCount, this.d);
            this.b = obtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scTextColor, this.b);
            this.c = obtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scTextSize, TypedValue.applyDimension(2, this.c, context.getResources().getDisplayMetrics()));
            this.f = obtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scDividerWidth, TypedValue.applyDimension(1, this.f, context.getResources().getDisplayMetrics()));
            this.l = obtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scUnderLineStrokeWidth, TypedValue.applyDimension(1, this.l, context.getResources().getDisplayMetrics()));
            this.j = obtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scUnderLineColor, this.j);
            this.k = obtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scNextUnderLineColor, this.k);
            obtainStyledAttributes.recycle();
        }
        this.a = new StringBuilder(this.d);
        int i2 = this.d;
        this.i = new PointF[i2];
        this.n = new RectF[i2];
        this.o = new RectF[i2];
        a();
        setFocusableInTouchMode(true);
    }

    private void b() {
        Paint.FontMetricsInt fontMetricsInt = this.e.getFontMetricsInt();
        float measureText = this.e.measureText("0");
        float f2 = (((float) (this.h / 2)) + (((float) (fontMetricsInt.bottom - fontMetricsInt.top)) / 2.0f)) - ((float) fontMetricsInt.bottom);
        int i2 = this.d;
        float f3 = (((float) this.g) - (((float) (i2 - 1)) * this.f)) / ((float) i2);
        int i3 = 0;
        while (i3 < this.d) {
            float f4 = (float) i3;
            float f5 = f4 * f3;
            this.i[i3] = new PointF((this.f * f4) + f5 + (f3 / 2.0f), f2);
            RectF[] rectFArr = this.n;
            float f6 = this.f;
            int i4 = i3 + 1;
            rectFArr[i3] = new RectF(f5 + (f4 * f6), 0.0f, (((float) i4) * f3) + (f4 * f6), (float) this.h);
            float f7 = measureText / 2.0f;
            this.o[i3] = new RectF(this.i[i3].x - f7, this.i[i3].y + ((float) fontMetricsInt.top), this.i[i3].x + f7, this.i[i3].y + ((float) fontMetricsInt.bottom));
            i3 = i4;
        }
    }

    public void clearText() {
        if (this.a.length() != 0) {
            StringBuilder sb = this.a;
            sb.delete(0, sb.length());
            OnTextChangedListener onTextChangedListener = this.q;
            if (onTextChangedListener != null) {
                onTextChangedListener.onTextChanged(this.a.toString());
            }
            invalidate();
        }
    }

    public void drawUnderLine(Canvas canvas, Paint paint, RectF rectF, RectF rectF2) {
        canvas.drawLine(rectF2.left - (rectF2.width() / 2.0f), rectF.bottom, rectF2.right + (rectF2.width() / 2.0f), rectF.bottom, paint);
    }

    public void focus() {
        requestFocus();
        postDelayed(new Runnable() {
            /* class com.ali.auth.third.ui.iv.AliUserSmsCodeView.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) AliUserSmsCodeView.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(AliUserSmsCodeView.this, 2);
                }
            }
        }, 100);
    }

    public String getText() {
        StringBuilder sb = this.a;
        return sb != null ? sb.toString() : "";
    }

    public int getTextCount() {
        return this.d;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AnonymousClass2 r0 = new BaseInputConnection(this, false) {
            /* class com.ali.auth.third.ui.iv.AliUserSmsCodeView.AnonymousClass2 */

            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean deleteSurroundingText(int i, int i2) {
                return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
            }
        };
        editorInfo.actionLabel = null;
        editorInfo.inputType = 3;
        editorInfo.imeOptions = 5;
        return r0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a();
        int length = this.a.length();
        for (int i2 = 0; i2 < this.d; i2++) {
            if (i2 < length) {
                canvas.drawText(this.a.toString(), i2, i2 + 1, this.i[i2].x, this.i[i2].y, this.e);
            }
            int i3 = this.j;
            if ((hasFocus() && i2 == length) || i2 < length) {
                i3 = this.k;
            }
            this.m.setColor(i3);
            drawUnderLine(canvas, this.m, this.n[i2], this.o[i2]);
            setBackgroundColor(-1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r0 != null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r0 != null) goto L_0x001b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        OnCompletedListener onCompletedListener;
        InputMethodManager inputMethodManager;
        OnTextChangedListener onTextChangedListener;
        if (i2 != 67 || this.a.length() <= 0) {
            if (i2 >= 7 && i2 <= 16 && this.a.length() < this.d) {
                this.a.append(keyEvent.getDisplayLabel());
                onTextChangedListener = this.q;
            }
            if (this.a.length() >= this.d && this.p) {
                onCompletedListener = this.r;
                if (onCompletedListener != null) {
                    onCompletedListener.onCompleted(this.a.toString());
                }
                inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                }
            }
            return super.onKeyDown(i2, keyEvent);
        }
        StringBuilder sb = this.a;
        sb.deleteCharAt(sb.length() - 1);
        onTextChangedListener = this.q;
        onTextChangedListener.onTextChanged(this.a.toString());
        invalidate();
        onCompletedListener = this.r;
        if (onCompletedListener != null) {
        }
        inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.g = View.MeasureSpec.getSize(i2);
        this.h = View.MeasureSpec.getSize(i3);
        b();
        setMeasuredDimension(this.g, this.h);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (motionEvent.getAction() != 0) {
            return true;
        }
        focus();
        return true;
    }

    public void setOnCompletedListener(OnCompletedListener onCompletedListener) {
        this.r = onCompletedListener;
    }

    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        this.q = onTextChangedListener;
    }

    public void setTextCount(int i2) {
        if (this.d != i2) {
            this.d = i2;
            invalidate();
        }
    }
}
