package cn.bertsir.zbar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import cn.bertsir.zbar.R;

public class VerticalSeekBar extends SeekBar {
    public static final int ROTATION_ANGLE_CW_270 = 270;
    public static final int ROTATION_ANGLE_CW_90 = 90;
    private static final String TAG = "VerticalSeekBar";
    private int mRotationAngle = 90;

    private static boolean isValidRotationAngle(int i) {
        return i == 90 || i == 270;
    }

    public VerticalSeekBar(Context context) {
        super(context);
        initialize(context, null, 0, 0);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet, 0, 0);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context, attributeSet, i, 0);
    }

    private void initialize(Context context, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VerticalSeekBar, i, i2);
            int integer = obtainStyledAttributes.getInteger(R.styleable.VerticalSeekBar_seekBarRotation, 0);
            if (isValidRotationAngle(integer)) {
                this.mRotationAngle = integer;
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        int i = this.mRotationAngle;
        if (i == 270) {
            canvas.rotate(270.0f);
            canvas.translate((float) (-getHeight()), 0.0f);
        } else if (i == 90) {
            canvas.rotate(90.0f);
            canvas.translate(0.0f, (float) (-getWidth()));
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 2) {
            int i = this.mRotationAngle;
            if (i == 270) {
                setProgress(getMax() - ((int) ((((float) getMax()) * motionEvent.getY()) / ((float) getHeight()))));
            } else if (i == 90) {
                setProgress((int) ((((float) getMax()) * motionEvent.getY()) / ((float) getHeight())));
            }
            onSizeChanged(getWidth(), getHeight(), 0, 0);
        }
        return true;
    }
}
