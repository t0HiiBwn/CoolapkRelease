package cn.bertsir.zbar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import cn.bertsir.zbar.R;

public class CornerView extends View {
    private static final int LEFT_BOTTOM = 1;
    private static final int LEFT_TOP = 0;
    private static final int RIGHT_BOTTOM = 3;
    private static final int RIGHT_TOP = 2;
    private static final String TAG = "CornerView";
    private Canvas canvas;
    private int cornerColor;
    private int cornerGravity;
    private int cornerWidth;
    private int height = 0;
    private Paint paint;
    private int width = 0;

    public CornerView(Context context) {
        super(context, null);
    }

    public CornerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornerView);
        this.cornerColor = obtainStyledAttributes.getColor(R.styleable.CornerView_corner_color, getResources().getColor(R.color.common_color));
        this.cornerWidth = (int) obtainStyledAttributes.getDimension(R.styleable.CornerView_corner_width, 10.0f);
        this.cornerGravity = obtainStyledAttributes.getInt(R.styleable.CornerView_corner_gravity, 1);
        obtainStyledAttributes.recycle();
        this.paint = new Paint();
        this.canvas = new Canvas();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth((float) this.cornerWidth);
        this.paint.setColor(this.cornerColor);
        this.paint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas2) {
        super.onDraw(canvas2);
        int i = this.cornerGravity;
        if (i == 0) {
            canvas2.drawLine(0.0f, 0.0f, (float) this.width, 0.0f, this.paint);
            canvas2.drawLine(0.0f, 0.0f, 0.0f, (float) this.height, this.paint);
        } else if (i == 1) {
            canvas2.drawLine(0.0f, 0.0f, 0.0f, (float) this.height, this.paint);
            int i2 = this.height;
            canvas2.drawLine(0.0f, (float) i2, (float) this.width, (float) i2, this.paint);
        } else if (i == 2) {
            canvas2.drawLine(0.0f, 0.0f, (float) this.width, 0.0f, this.paint);
            int i3 = this.width;
            canvas2.drawLine((float) i3, 0.0f, (float) i3, (float) this.height, this.paint);
        } else if (i == 3) {
            int i4 = this.width;
            canvas2.drawLine((float) i4, 0.0f, (float) i4, (float) this.height, this.paint);
            int i5 = this.height;
            canvas2.drawLine(0.0f, (float) i5, (float) this.width, (float) i5, this.paint);
        }
    }

    public void setColor(int i) {
        this.cornerColor = i;
        this.paint.setColor(i);
        invalidate();
    }

    public void setLineWidth(int i) {
        int dip2px = dip2px(i);
        this.cornerWidth = dip2px;
        this.paint.setStrokeWidth((float) dip2px);
        invalidate();
    }

    public int dip2px(int i) {
        return (int) (((double) (((float) i) * getContext().getResources().getDisplayMetrics().density)) + 0.5d);
    }
}
