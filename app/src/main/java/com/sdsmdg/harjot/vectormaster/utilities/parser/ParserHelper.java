package com.sdsmdg.harjot.vectormaster.utilities.parser;

class ParserHelper {
    private static final double[] pow10 = new double[128];
    private char current;
    private final int n;
    public int pos = 0;
    private final CharSequence s;

    public ParserHelper(CharSequence charSequence) {
        this.s = charSequence;
        this.n = charSequence.length();
        this.current = charSequence.charAt(this.pos);
    }

    private char read() {
        int i = this.pos;
        int i2 = this.n;
        if (i < i2) {
            this.pos = i + 1;
        }
        int i3 = this.pos;
        if (i3 == i2) {
            return 0;
        }
        return this.s.charAt(i3);
    }

    public void skipWhitespace() {
        while (true) {
            int i = this.pos;
            if (i < this.n && Character.isWhitespace(this.s.charAt(i))) {
                advance();
            } else {
                return;
            }
        }
    }

    void skipNumberSeparator() {
        while (true) {
            int i = this.pos;
            if (i < this.n) {
                char charAt = this.s.charAt(i);
                if (charAt == '\t' || charAt == '\n' || charAt == ' ' || charAt == ',') {
                    advance();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void advance() {
        this.current = read();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028 A[LOOP:0: B:10:0x0028->B:14:0x0034, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c1 A[LOOP:4: B:57:0x00c1->B:58:0x00c7, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025 A[RETURN] */
    float parseFloat() {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        char read;
        char read2;
        char c = this.current;
        boolean z3 = true;
        int i4 = 0;
        if (c == '+') {
            z = true;
        } else if (c != '-') {
            z = true;
            switch (this.current) {
                case '.':
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                    z2 = false;
                    if (this.current == '.') {
                        char read3 = read();
                        this.current = read3;
                        switch (read3) {
                            case '0':
                                if (i3 == 0) {
                                    while (true) {
                                        char read4 = read();
                                        this.current = read4;
                                        i2--;
                                        switch (read4) {
                                            case '0':
                                                break;
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                            default:
                                                if (!z2) {
                                                    return 0.0f;
                                                }
                                                break;
                                        }
                                    }
                                }
                                break;
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                while (true) {
                                    if (i3 < 9) {
                                        i3++;
                                        i = (i * 10) + (this.current - '0');
                                        i2--;
                                    }
                                    char read5 = read();
                                    this.current = read5;
                                    switch (read5) {
                                    }
                                }
                                break;
                            default:
                                if (!z2) {
                                    reportUnexpectedCharacterError(read3);
                                    return 0.0f;
                                }
                                break;
                        }
                    }
                    char c2 = this.current;
                    if (c2 == 'E' || c2 == 'e') {
                        read = read();
                        this.current = read;
                        if (read != '+') {
                            if (read != '-') {
                                switch (read) {
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
                                        reportUnexpectedCharacterError(read);
                                        return 0.0f;
                                }
                                switch (this.current) {
                                    case '0':
                                        while (true) {
                                            char read6 = read();
                                            this.current = read6;
                                            switch (read6) {
                                            }
                                        }
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        int i5 = 0;
                                        while (true) {
                                            if (i4 < 3) {
                                                i4++;
                                                i5 = (i5 * 10) + (this.current - '0');
                                            }
                                            char read7 = read();
                                            this.current = read7;
                                            switch (read7) {
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
                                                    i4 = i5;
                                                    break;
                                            }
                                        }
                                }
                            } else {
                                z3 = false;
                            }
                        }
                        read2 = read();
                        this.current = read2;
                        switch (read2) {
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
                                reportUnexpectedCharacterError(read2);
                                return 0.0f;
                        }
                        switch (this.current) {
                        }
                    }
                    if (!z3) {
                        i4 = -i4;
                    }
                    int i6 = i4 + i2;
                    if (!z) {
                        i = -i;
                    }
                    return buildFloat(i, i6);
                case '/':
                default:
                    return Float.NaN;
                case '0':
                    while (true) {
                        char read8 = read();
                        this.current = read8;
                        if (read8 != '.' && read8 != 'E' && read8 != 'e') {
                            switch (read8) {
                                case '0':
                                    break;
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
                                    return 0.0f;
                            }
                        }
                    }
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                    z2 = true;
                    if (this.current == '.') {
                    }
                    char c2 = this.current;
                    read = read();
                    this.current = read;
                    if (read != '+') {
                    }
                    read2 = read();
                    this.current = read2;
                    switch (read2) {
                    }
                    switch (this.current) {
                    }
                    if (!z3) {
                    }
                    int i6 = i4 + i2;
                    if (!z) {
                    }
                    return buildFloat(i, i6);
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                    while (true) {
                        if (i3 < 9) {
                            i3++;
                            i = (i * 10) + (this.current - '0');
                        } else {
                            i2++;
                        }
                        char read9 = read();
                        this.current = read9;
                        switch (read9) {
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
                                z2 = true;
                                if (this.current == '.') {
                                }
                                char c2 = this.current;
                                read = read();
                                this.current = read;
                                if (read != '+') {
                                }
                                read2 = read();
                                this.current = read2;
                                switch (read2) {
                                }
                                switch (this.current) {
                                }
                                if (!z3) {
                                }
                                int i6 = i4 + i2;
                                if (!z) {
                                }
                                return buildFloat(i, i6);
                        }
                    }
            }
        } else {
            z = false;
        }
        this.current = read();
        switch (this.current) {
        }
    }

    private void reportUnexpectedCharacterError(char c) {
        throw new RuntimeException("Unexpected char '" + c + "'.");
    }

    private static float buildFloat(int i, int i2) {
        if (i2 < -125 || i == 0) {
            return 0.0f;
        }
        if (i2 >= 128) {
            return i > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        }
        if (i2 == 0) {
            return (float) i;
        }
        if (i >= 67108864) {
            i++;
        }
        double d = (double) i;
        double[] dArr = pow10;
        return (float) (i2 > 0 ? d * dArr[i2] : d / dArr[-i2]);
    }

    static {
        int i = 0;
        while (true) {
            double[] dArr = pow10;
            if (i < dArr.length) {
                dArr[i] = Math.pow(10.0d, (double) i);
                i++;
            } else {
                return;
            }
        }
    }

    public float nextFloat() {
        skipWhitespace();
        float parseFloat = parseFloat();
        skipNumberSeparator();
        return parseFloat;
    }
}
