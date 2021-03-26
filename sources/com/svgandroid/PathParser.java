package com.svgandroid;

import android.graphics.Path;

public class PathParser {
    private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i, int i2) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r1 != 'L') goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0188 A[SYNTHETIC] */
    public static void parse(String str, Path path) {
        char c;
        boolean z;
        float f;
        float f2;
        int length = str.length();
        ParserHelper parserHelper = new ParserHelper(str, 0);
        parserHelper.skipWhitespace();
        char c2 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        while (parserHelper.pos < length) {
            char charAt = str.charAt(parserHelper.pos);
            if (!(charAt == '+' || charAt == '-')) {
                switch (charAt) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        break;
                    default:
                        parserHelper.advance();
                        c2 = charAt;
                        c = c2;
                        break;
                }
                z = true;
                switch (c2) {
                    case 'A':
                    case 'a':
                        float nextFloat = parserHelper.nextFloat();
                        float nextFloat2 = parserHelper.nextFloat();
                        drawArc(path, f3, f4, nextFloat, nextFloat2, parserHelper.nextFloat(), parserHelper.nextFloat(), parserHelper.nextFloat(), (int) parserHelper.nextFloat(), (int) parserHelper.nextFloat());
                        f3 = nextFloat;
                        f4 = nextFloat2;
                        f6 = f6;
                        f5 = f5;
                        z = false;
                        break;
                    case 'C':
                    case 'c':
                        float nextFloat3 = parserHelper.nextFloat();
                        float nextFloat4 = parserHelper.nextFloat();
                        float nextFloat5 = parserHelper.nextFloat();
                        float nextFloat6 = parserHelper.nextFloat();
                        float nextFloat7 = parserHelper.nextFloat();
                        float nextFloat8 = parserHelper.nextFloat();
                        if (c2 == 'c') {
                            nextFloat3 += f3;
                            nextFloat5 += f3;
                            nextFloat7 += f3;
                            nextFloat4 += f4;
                            nextFloat6 += f4;
                            nextFloat8 += f4;
                        }
                        path.cubicTo(nextFloat3, nextFloat4, nextFloat5, nextFloat6, nextFloat7, nextFloat8);
                        f3 = nextFloat7;
                        f4 = nextFloat8;
                        f8 = nextFloat6;
                        f7 = nextFloat5;
                        break;
                    case 'H':
                    case 'h':
                        float nextFloat9 = parserHelper.nextFloat();
                        if (c2 == 'h') {
                            path.rLineTo(nextFloat9, 0.0f);
                            f3 += nextFloat9;
                        } else {
                            path.lineTo(nextFloat9, f4);
                            f3 = nextFloat9;
                        }
                        z = false;
                        break;
                    case 'L':
                    case 'l':
                        f2 = parserHelper.nextFloat();
                        f = parserHelper.nextFloat();
                        if (c2 == 'l') {
                            path.rLineTo(f2, f);
                            f3 += f2;
                            f4 += f;
                            z = false;
                            break;
                        } else {
                            path.lineTo(f2, f);
                            f3 = f2;
                            f4 = f;
                            z = false;
                        }
                    case 'M':
                    case 'm':
                        f2 = parserHelper.nextFloat();
                        f = parserHelper.nextFloat();
                        if (c2 == 'm') {
                            f6 += f2;
                            f5 += f;
                            path.rMoveTo(f2, f);
                            f3 += f2;
                            f4 += f;
                            z = false;
                            break;
                        } else {
                            path.moveTo(f2, f);
                            f3 = f2;
                            f6 = f3;
                            f4 = f;
                            f5 = f4;
                            z = false;
                        }
                    case 'S':
                    case 's':
                        float nextFloat10 = parserHelper.nextFloat();
                        float nextFloat11 = parserHelper.nextFloat();
                        float nextFloat12 = parserHelper.nextFloat();
                        float nextFloat13 = parserHelper.nextFloat();
                        if (c2 == 's') {
                            nextFloat10 += f3;
                            nextFloat12 += f3;
                            nextFloat11 += f4;
                            nextFloat13 += f4;
                        }
                        path.cubicTo((f3 * 2.0f) - f7, (f4 * 2.0f) - f8, nextFloat10, nextFloat11, nextFloat12, nextFloat13);
                        f7 = nextFloat10;
                        f8 = nextFloat11;
                        f3 = nextFloat12;
                        f4 = nextFloat13;
                        break;
                    case 'V':
                    case 'v':
                        float nextFloat14 = parserHelper.nextFloat();
                        if (c2 == 'v') {
                            path.rLineTo(0.0f, nextFloat14);
                            f4 += nextFloat14;
                        } else {
                            path.lineTo(f3, nextFloat14);
                            f4 = nextFloat14;
                        }
                        z = false;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path.moveTo(f6, f5);
                        f4 = f5;
                        f8 = f4;
                        f3 = f6;
                        f7 = f3;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (!z) {
                    f7 = f3;
                    f8 = f4;
                }
                parserHelper.skipWhitespace();
                c2 = c;
            }
            if (c2 == 'm' || c2 == 'M') {
                c = c2;
                c2 = (char) (c2 - 1);
                z = true;
                switch (c2) {
                    case 'A':
                    case 'a':
                        break;
                    case 'C':
                    case 'c':
                        break;
                    case 'H':
                    case 'h':
                        break;
                    case 'L':
                    case 'l':
                        break;
                    case 'M':
                    case 'm':
                        break;
                    case 'S':
                    case 's':
                        break;
                    case 'V':
                    case 'v':
                        break;
                    case 'Z':
                    case 'z':
                        break;
                }
                if (!z) {
                }
                parserHelper.skipWhitespace();
                c2 = c;
            } else {
                if (c2 != 'c') {
                    if (c2 != 'C') {
                        if (c2 != 'l') {
                        }
                    }
                }
                c = c2;
                z = true;
                switch (c2) {
                    case 'A':
                    case 'a':
                        break;
                    case 'C':
                    case 'c':
                        break;
                    case 'H':
                    case 'h':
                        break;
                    case 'L':
                    case 'l':
                        break;
                    case 'M':
                    case 'm':
                        break;
                    case 'S':
                    case 's':
                        break;
                    case 'V':
                    case 'v':
                        break;
                    case 'Z':
                    case 'z':
                        break;
                }
                if (!z) {
                }
                parserHelper.skipWhitespace();
                c2 = c;
            }
        }
    }
}
