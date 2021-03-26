package com.sdsmdg.harjot.vectormaster.utilities.parser;

import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;

public class PathParser {
    private static final String TAG = "PATH_PARSER";

    /* JADX WARNING: Removed duplicated region for block: B:86:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02a3 A[SYNTHETIC] */
    public static Path doPath(String str) {
        char c;
        RectF rectF;
        Path path;
        ParserHelper parserHelper;
        int i;
        boolean z;
        char c2;
        float f;
        float f2;
        String str2 = str;
        int length = str.length();
        ParserHelper parserHelper2 = new ParserHelper(str2);
        parserHelper2.skipWhitespace();
        Path path2 = new Path();
        RectF rectF2 = new RectF();
        char c3 = 'm';
        float f3 = 0.0f;
        char c4 = 'x';
        float f4 = 0.0f;
        float f5 = 0.0f;
        char c5 = 'm';
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (parserHelper2.pos < length) {
            char charAt = str2.charAt(parserHelper2.pos);
            if (Character.isDigit(charAt) || charAt == '.' || charAt == '-') {
                c = c4 == 'M' ? 'L' : c4 == c3 ? 'l' : c4;
            } else {
                parserHelper2.advance();
                c = charAt;
            }
            path2.computeBounds(rectF2, true);
            switch (c) {
                case 'A':
                case 'a':
                    float nextFloat = parserHelper2.nextFloat();
                    float nextFloat2 = parserHelper2.nextFloat();
                    float nextFloat3 = parserHelper2.nextFloat();
                    int nextFloat4 = (int) parserHelper2.nextFloat();
                    int nextFloat5 = (int) parserHelper2.nextFloat();
                    float nextFloat6 = parserHelper2.nextFloat();
                    float nextFloat7 = parserHelper2.nextFloat();
                    if (c == 'a') {
                        nextFloat6 += f4;
                        nextFloat7 += f5;
                    }
                    i = length;
                    parserHelper = parserHelper2;
                    c2 = c;
                    path = path2;
                    rectF = rectF2;
                    drawArc(path2, (double) f4, (double) f5, (double) nextFloat6, (double) nextFloat7, (double) nextFloat, (double) nextFloat2, (double) nextFloat3, nextFloat4 == 1, nextFloat5 == 1);
                    f4 = nextFloat6;
                    f5 = nextFloat7;
                    z = false;
                    if (!z) {
                        f8 = f4;
                        f9 = f5;
                    }
                    parserHelper.skipWhitespace();
                    str2 = str;
                    c4 = c2;
                    c5 = c4;
                    length = i;
                    parserHelper2 = parserHelper;
                    path2 = path;
                    rectF2 = rectF;
                    c3 = 'm';
                    f3 = 0.0f;
                case 'C':
                case 'c':
                    float nextFloat8 = parserHelper2.nextFloat();
                    float nextFloat9 = parserHelper2.nextFloat();
                    float nextFloat10 = parserHelper2.nextFloat();
                    float nextFloat11 = parserHelper2.nextFloat();
                    float nextFloat12 = parserHelper2.nextFloat();
                    float nextFloat13 = parserHelper2.nextFloat();
                    if (c == 'c') {
                        nextFloat8 += f4;
                        nextFloat10 += f4;
                        nextFloat12 += f4;
                        nextFloat9 += f5;
                        nextFloat11 += f5;
                        nextFloat13 += f5;
                    }
                    f8 = nextFloat10;
                    f9 = nextFloat11;
                    path2.cubicTo(nextFloat8, nextFloat9, f8, f9, nextFloat12, nextFloat13);
                    i = length;
                    parserHelper = parserHelper2;
                    f4 = nextFloat12;
                    c2 = c;
                    f5 = nextFloat13;
                    path = path2;
                    rectF = rectF2;
                    z = true;
                    if (!z) {
                    }
                    parserHelper.skipWhitespace();
                    str2 = str;
                    c4 = c2;
                    c5 = c4;
                    length = i;
                    parserHelper2 = parserHelper;
                    path2 = path;
                    rectF2 = rectF;
                    c3 = 'm';
                    f3 = 0.0f;
                    break;
                case 'H':
                case 'h':
                    float nextFloat14 = parserHelper2.nextFloat();
                    if (c == 'h') {
                        path2.rLineTo(nextFloat14, f3);
                        f4 += nextFloat14;
                        i = length;
                        parserHelper = parserHelper2;
                        c2 = c;
                        path = path2;
                        rectF = rectF2;
                        z = false;
                        if (!z) {
                        }
                        parserHelper.skipWhitespace();
                        str2 = str;
                        c4 = c2;
                        c5 = c4;
                        length = i;
                        parserHelper2 = parserHelper;
                        path2 = path;
                        rectF2 = rectF;
                        c3 = 'm';
                        f3 = 0.0f;
                    } else {
                        path2.lineTo(nextFloat14, f5);
                        i = length;
                        parserHelper = parserHelper2;
                        f4 = nextFloat14;
                        c2 = c;
                        path = path2;
                        rectF = rectF2;
                        z = false;
                        if (!z) {
                        }
                        parserHelper.skipWhitespace();
                        str2 = str;
                        c4 = c2;
                        c5 = c4;
                        length = i;
                        parserHelper2 = parserHelper;
                        path2 = path;
                        rectF2 = rectF;
                        c3 = 'm';
                        f3 = 0.0f;
                    }
                    break;
                case 'L':
                case 'l':
                    float nextFloat15 = parserHelper2.nextFloat();
                    float nextFloat16 = parserHelper2.nextFloat();
                    if (c == 'l') {
                        if ((c5 == 'M' || c5 == c3) && nextFloat15 == f3 && nextFloat16 == f3) {
                            path2.addCircle(nextFloat15, nextFloat16, 1.0f, Path.Direction.CW);
                        } else {
                            path2.rLineTo(nextFloat15, nextFloat16);
                            f4 += nextFloat15;
                            f5 += nextFloat16;
                            i = length;
                            parserHelper = parserHelper2;
                            c2 = c;
                            path = path2;
                            rectF = rectF2;
                            z = false;
                            if (!z) {
                            }
                            parserHelper.skipWhitespace();
                            str2 = str;
                            c4 = c2;
                            c5 = c4;
                            length = i;
                            parserHelper2 = parserHelper;
                            path2 = path;
                            rectF2 = rectF;
                            c3 = 'm';
                            f3 = 0.0f;
                        }
                    } else if ((c5 == 'M' || c5 == c3) && nextFloat15 == f4 && nextFloat16 == f5) {
                        path2.addCircle(nextFloat15, nextFloat16, 1.0f, Path.Direction.CW);
                    } else {
                        path2.lineTo(nextFloat15, nextFloat16);
                        i = length;
                        parserHelper = parserHelper2;
                        f4 = nextFloat15;
                        f5 = nextFloat16;
                        c2 = c;
                        path = path2;
                        rectF = rectF2;
                        z = false;
                        if (!z) {
                        }
                        parserHelper.skipWhitespace();
                        str2 = str;
                        c4 = c2;
                        c5 = c4;
                        length = i;
                        parserHelper2 = parserHelper;
                        path2 = path;
                        rectF2 = rectF;
                        c3 = 'm';
                        f3 = 0.0f;
                    }
                    i = length;
                    parserHelper = parserHelper2;
                    c2 = c;
                    path = path2;
                    rectF = rectF2;
                    z = false;
                    if (!z) {
                    }
                    parserHelper.skipWhitespace();
                    str2 = str;
                    c4 = c2;
                    c5 = c4;
                    length = i;
                    parserHelper2 = parserHelper;
                    path2 = path;
                    rectF2 = rectF;
                    c3 = 'm';
                    f3 = 0.0f;
                    break;
                case 'M':
                case 'm':
                    float nextFloat17 = parserHelper2.nextFloat();
                    float nextFloat18 = parserHelper2.nextFloat();
                    if (c == c3) {
                        path2.rMoveTo(nextFloat17, nextFloat18);
                        f4 += nextFloat17;
                        f5 += nextFloat18;
                    } else {
                        path2.moveTo(nextFloat17, nextFloat18);
                        f4 = nextFloat17;
                        f5 = nextFloat18;
                    }
                    i = length;
                    parserHelper = parserHelper2;
                    f6 = f4;
                    f7 = f5;
                    c2 = c;
                    path = path2;
                    rectF = rectF2;
                    z = false;
                    if (!z) {
                    }
                    parserHelper.skipWhitespace();
                    str2 = str;
                    c4 = c2;
                    c5 = c4;
                    length = i;
                    parserHelper2 = parserHelper;
                    path2 = path;
                    rectF2 = rectF;
                    c3 = 'm';
                    f3 = 0.0f;
                    break;
                case 'Q':
                case 'q':
                    float nextFloat19 = parserHelper2.nextFloat();
                    float nextFloat20 = parserHelper2.nextFloat();
                    float nextFloat21 = parserHelper2.nextFloat();
                    float nextFloat22 = parserHelper2.nextFloat();
                    if (c == 'q') {
                        nextFloat21 += f4;
                        nextFloat22 += f5;
                        nextFloat19 += f4;
                        nextFloat20 += f5;
                    }
                    f8 = nextFloat19;
                    f9 = nextFloat20;
                    f2 = nextFloat21;
                    f = nextFloat22;
                    path2.cubicTo(f4, f5, f8, f9, f2, f);
                    i = length;
                    parserHelper = parserHelper2;
                    f4 = f2;
                    c2 = c;
                    path = path2;
                    rectF = rectF2;
                    f5 = f;
                    z = true;
                    if (!z) {
                    }
                    parserHelper.skipWhitespace();
                    str2 = str;
                    c4 = c2;
                    c5 = c4;
                    length = i;
                    parserHelper2 = parserHelper;
                    path2 = path;
                    rectF2 = rectF;
                    c3 = 'm';
                    f3 = 0.0f;
                    break;
                case 'S':
                case 's':
                    float nextFloat23 = parserHelper2.nextFloat();
                    float nextFloat24 = parserHelper2.nextFloat();
                    float nextFloat25 = parserHelper2.nextFloat();
                    float nextFloat26 = parserHelper2.nextFloat();
                    if (c == 's') {
                        nextFloat23 += f4;
                        nextFloat25 += f4;
                        nextFloat24 += f5;
                        nextFloat26 += f5;
                    }
                    path2.cubicTo((f4 * 2.0f) - f8, (f5 * 2.0f) - f9, nextFloat23, nextFloat24, nextFloat25, nextFloat26);
                    i = length;
                    parserHelper = parserHelper2;
                    f8 = nextFloat23;
                    c2 = c;
                    path = path2;
                    rectF = rectF2;
                    f9 = nextFloat24;
                    f4 = nextFloat25;
                    f5 = nextFloat26;
                    z = true;
                    if (!z) {
                    }
                    parserHelper.skipWhitespace();
                    str2 = str;
                    c4 = c2;
                    c5 = c4;
                    length = i;
                    parserHelper2 = parserHelper;
                    path2 = path;
                    rectF2 = rectF;
                    c3 = 'm';
                    f3 = 0.0f;
                    break;
                case 'T':
                case 't':
                    float nextFloat27 = parserHelper2.nextFloat();
                    float nextFloat28 = parserHelper2.nextFloat();
                    if (c == 't') {
                        nextFloat27 += f4;
                        nextFloat28 += f5;
                    }
                    f2 = nextFloat27;
                    f = nextFloat28;
                    f8 = (f4 * 2.0f) - f8;
                    f9 = (2.0f * f5) - f9;
                    path2.cubicTo(f4, f5, f8, f9, f2, f);
                    i = length;
                    parserHelper = parserHelper2;
                    f4 = f2;
                    c2 = c;
                    path = path2;
                    rectF = rectF2;
                    f5 = f;
                    z = true;
                    if (!z) {
                    }
                    parserHelper.skipWhitespace();
                    str2 = str;
                    c4 = c2;
                    c5 = c4;
                    length = i;
                    parserHelper2 = parserHelper;
                    path2 = path;
                    rectF2 = rectF;
                    c3 = 'm';
                    f3 = 0.0f;
                    break;
                case 'V':
                case 'v':
                    float nextFloat29 = parserHelper2.nextFloat();
                    if (c == 'v') {
                        path2.rLineTo(f3, nextFloat29);
                        f5 += nextFloat29;
                        i = length;
                        parserHelper = parserHelper2;
                        c2 = c;
                        path = path2;
                        rectF = rectF2;
                        z = false;
                        if (!z) {
                        }
                        parserHelper.skipWhitespace();
                        str2 = str;
                        c4 = c2;
                        c5 = c4;
                        length = i;
                        parserHelper2 = parserHelper;
                        path2 = path;
                        rectF2 = rectF;
                        c3 = 'm';
                        f3 = 0.0f;
                    } else {
                        path2.lineTo(f4, nextFloat29);
                        i = length;
                        parserHelper = parserHelper2;
                        f5 = nextFloat29;
                        c2 = c;
                        path = path2;
                        rectF = rectF2;
                        z = false;
                        if (!z) {
                        }
                        parserHelper.skipWhitespace();
                        str2 = str;
                        c4 = c2;
                        c5 = c4;
                        length = i;
                        parserHelper2 = parserHelper;
                        path2 = path;
                        rectF2 = rectF;
                        c3 = 'm';
                        f3 = 0.0f;
                    }
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    i = length;
                    parserHelper = parserHelper2;
                    c2 = c;
                    path = path2;
                    rectF = rectF2;
                    f4 = f6;
                    f5 = f7;
                    z = false;
                    if (!z) {
                    }
                    parserHelper.skipWhitespace();
                    str2 = str;
                    c4 = c2;
                    c5 = c4;
                    length = i;
                    parserHelper2 = parserHelper;
                    path2 = path;
                    rectF2 = rectF;
                    c3 = 'm';
                    f3 = 0.0f;
                    break;
                default:
                    i = length;
                    parserHelper = parserHelper2;
                    c2 = c;
                    path = path2;
                    rectF = rectF2;
                    Log.w("PATH_PARSER", "Invalid path command: " + c2);
                    parserHelper.advance();
                    z = false;
                    if (!z) {
                    }
                    parserHelper.skipWhitespace();
                    str2 = str;
                    c4 = c2;
                    c5 = c4;
                    length = i;
                    parserHelper2 = parserHelper;
                    path2 = path;
                    rectF2 = rectF;
                    c3 = 'm';
                    f3 = 0.0f;
                    break;
            }
        }
        return path2;
    }

    private static void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9 = (d - d3) / 2.0d;
        double d10 = (d2 - d4) / 2.0d;
        double radians = Math.toRadians(d7 % 360.0d);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d11 = (cos * d9) + (sin * d10);
        double d12 = ((-sin) * d9) + (d10 * cos);
        double abs = Math.abs(d5);
        double abs2 = Math.abs(d6);
        double d13 = abs * abs;
        double d14 = abs2 * abs2;
        double d15 = d11 * d11;
        double d16 = d12 * d12;
        double d17 = (d15 / d13) + (d16 / d14);
        double d18 = 1.0d;
        if (d17 > 1.0d) {
            abs *= Math.sqrt(d17);
            abs2 *= Math.sqrt(d17);
            d13 = abs * abs;
            d14 = abs2 * abs2;
        }
        double d19 = z == z2 ? -1.0d : 1.0d;
        double d20 = d13 * d14;
        double d21 = d13 * d16;
        double d22 = d14 * d15;
        double d23 = ((d20 - d21) - d22) / (d21 + d22);
        if (d23 < 0.0d) {
            d23 = 0.0d;
        }
        double sqrt = d19 * Math.sqrt(d23);
        double d24 = ((abs * d12) / abs2) * sqrt;
        double d25 = sqrt * (-((abs2 * d11) / abs));
        double d26 = ((d + d3) / 2.0d) + ((cos * d24) - (sin * d25));
        double d27 = ((d2 + d4) / 2.0d) + (sin * d24) + (cos * d25);
        double d28 = (d11 - d24) / abs;
        double d29 = (d12 - d25) / abs2;
        double d30 = ((-d11) - d24) / abs;
        double d31 = ((-d12) - d25) / abs2;
        double d32 = (d28 * d28) + (d29 * d29);
        double degrees = Math.toDegrees((d29 < 0.0d ? -1.0d : 1.0d) * Math.acos(d28 / Math.sqrt(d32)));
        double sqrt2 = Math.sqrt(d32 * ((d30 * d30) + (d31 * d31)));
        double d33 = (d28 * d30) + (d29 * d31);
        if ((d28 * d31) - (d29 * d30) < 0.0d) {
            d18 = -1.0d;
        }
        double degrees2 = Math.toDegrees(d18 * Math.acos(d33 / sqrt2));
        if (z2 || degrees2 <= 0.0d) {
            d8 = 360.0d;
            if (z2 && degrees2 < 0.0d) {
                degrees2 += 360.0d;
            }
        } else {
            d8 = 360.0d;
            degrees2 -= 360.0d;
        }
        path.addArc(new RectF((float) (d26 - abs), (float) (d27 - abs2), (float) (d26 + abs), (float) (d27 + abs2)), (float) (degrees % d8), (float) (degrees2 % d8));
    }
}
