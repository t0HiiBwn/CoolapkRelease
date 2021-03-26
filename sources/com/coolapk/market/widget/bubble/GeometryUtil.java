package com.coolapk.market.widget.bubble;

import android.graphics.PointF;
import android.graphics.drawable.AnimationDrawable;

public class GeometryUtil {
    public static float getDistanceBetween2Points(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow((double) (pointF.y - pointF2.y), 2.0d) + Math.pow((double) (pointF.x - pointF2.x), 2.0d));
    }

    public static PointF getMiddlePoint(PointF pointF, PointF pointF2) {
        return new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
    }

    public static PointF getPointByPercent(PointF pointF, PointF pointF2, float f) {
        return new PointF(evaluateValue(f, Float.valueOf(pointF.x), Float.valueOf(pointF2.x)), evaluateValue(f, Float.valueOf(pointF.y), Float.valueOf(pointF2.y)));
    }

    public static float evaluateValue(float f, Number number, Number number2) {
        return number.floatValue() + ((number2.floatValue() - number.floatValue()) * f);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002e: APUT  
      (r0v1 android.graphics.PointF[])
      (0 ??[int, short, byte, char])
      (wrap: android.graphics.PointF : 0x002b: CONSTRUCTOR  (r2v0 android.graphics.PointF) = 
      (wrap: float : 0x0027: ARITH  (r3v1 float) = (wrap: float : 0x0025: IGET  (r3v0 float) = (r5v0 android.graphics.PointF) android.graphics.PointF.x float) + (r6v1 float))
      (wrap: float : 0x002a: ARITH  (r4v1 float) = (wrap: float : 0x0028: IGET  (r4v0 float) = (r5v0 android.graphics.PointF) android.graphics.PointF.y float) + (r7v1 float))
     call: android.graphics.PointF.<init>(float, float):void type: CONSTRUCTOR)
     */
    public static PointF[] getIntersectionPoints(PointF pointF, float f, Double d) {
        float f2;
        PointF[] pointFArr = new PointF[2];
        if (d != null) {
            double atan = (double) ((float) Math.atan(d.doubleValue()));
            double d2 = (double) f;
            f2 = (float) (Math.sin(atan) * d2);
            f = (float) (Math.cos(atan) * d2);
        } else {
            f2 = 0.0f;
        }
        pointFArr[0] = new PointF(pointF.x + f, pointF.y + f2);
        pointFArr[1] = new PointF(pointF.x - f, pointF.y - f2);
        return pointFArr;
    }

    public static long getAnimDuration(AnimationDrawable animationDrawable) {
        long j = 0;
        for (int i = 0; i < animationDrawable.getNumberOfFrames(); i++) {
            j += (long) animationDrawable.getDuration(i);
        }
        return j;
    }
}
