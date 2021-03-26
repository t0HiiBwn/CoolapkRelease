package cn.bertsir.zbar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import cn.bertsir.zbar.R;

@Deprecated
public class LineView extends View {
    private Canvas canvas;
    private int line_color;
    private Shader mShader;
    private Paint paint;

    public LineView(Context context) {
        super(context);
        this.line_color = getResources().getColor(R.color.common_color);
    }

    public LineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.line_color = getResources().getColor(R.color.common_color);
        this.paint = new Paint();
        this.canvas = new Canvas();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(10.0f);
        this.paint.setAntiAlias(true);
    }

    public void setLinecolor(int i) {
        this.line_color = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas2) {
        super.onDraw(canvas2);
        String valueOf = String.valueOf(Integer.toHexString(this.line_color));
        String substring = valueOf.substring(valueOf.length() - 6, valueOf.length() - 0);
        float measuredWidth = (float) getMeasuredWidth();
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, measuredWidth, 0.0f, new int[]{Color.parseColor("#00" + substring), this.line_color, Color.parseColor("#00" + substring)}, (float[]) null, Shader.TileMode.CLAMP);
        this.mShader = linearGradient;
        this.paint.setShader(linearGradient);
        canvas2.drawLine(0.0f, 0.0f, 1.6843096E7f, 0.0f, this.paint);
    }
}
