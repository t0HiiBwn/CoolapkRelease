package com.sdsmdg.harjot.vectormaster.utilities;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class Utils {
    public static float getAlphaFromInt(int i) {
        return ((float) i) / 255.0f;
    }

    public static int getColorFromString(String str) {
        if (str.length() == 4) {
            return Color.parseColor("#" + str.charAt(1) + str.charAt(1) + str.charAt(2) + str.charAt(2) + str.charAt(3) + str.charAt(3));
        } else if (str.length() == 7 || str.length() == 9) {
            return Color.parseColor(str);
        } else {
            if (str.length() != 2) {
                return 0;
            }
            return Color.parseColor("#" + str.charAt(1) + str.charAt(1) + str.charAt(1) + str.charAt(1) + str.charAt(1) + str.charAt(1) + str.charAt(1) + str.charAt(1));
        }
    }

    public static Path.FillType getFillTypeFromString(String str) {
        return str.equals("1") ? Path.FillType.EVEN_ODD : Path.FillType.WINDING;
    }

    public static Paint.Cap getLineCapFromString(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Paint.Cap.BUTT;
            case 1:
                return Paint.Cap.ROUND;
            case 2:
                return Paint.Cap.SQUARE;
            default:
                return Paint.Cap.BUTT;
        }
    }

    public static Paint.Join getLineJoinFromString(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Paint.Join.MITER;
            case 1:
                return Paint.Join.ROUND;
            case 2:
                return Paint.Join.BEVEL;
            default:
                return Paint.Join.MITER;
        }
    }

    public static int getAlphaFromFloat(float f) {
        return Math.min(255, (int) (f * 255.0f));
    }

    public static int dpToPx(int i) {
        return (int) (((float) i) * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int i) {
        return (int) (((float) i) / Resources.getSystem().getDisplayMetrics().density);
    }

    public static float getFloatFromDimensionString(String str) {
        if (str.contains("dip")) {
            return Float.parseFloat(str.substring(0, str.length() - 3));
        }
        return Float.parseFloat(str.substring(0, str.length() - 2));
    }

    public static boolean isEqual(Object obj, Object obj2) {
        return (obj == null && obj2 == null) || !(obj == null || obj2 == null || !obj.equals(obj2));
    }
}
