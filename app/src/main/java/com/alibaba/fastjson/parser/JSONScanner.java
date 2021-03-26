package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c >= '0' && c <= '9' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (!(c5 == '1' && (c6 == '0' || c6 == '1' || c6 == '2'))) {
                return false;
            }
            if (i == 48) {
                return i2 >= 49 && i2 <= 57;
            }
            if (i != 49 && i != 50) {
                return i == 51 && (i2 == 48 || i2 == 49);
            }
            if (i2 >= 48 && i2 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r6 <= '4') goto L_0x0020;
     */
    private boolean checkTime(char c, char c2, char c3, char c4, char c5, char c6) {
        if (c == '0') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c != '1') {
            if (c == '2') {
                if (c2 >= '0') {
                }
            }
            return false;
        } else if (c2 < '0' || c2 > '9') {
            return false;
        }
        if (c3 < '0' || c3 > '5') {
            if (!(c3 == '6' && c4 == '0')) {
                return false;
            }
        } else if (c4 < '0' || c4 > '9') {
            return false;
        }
        return (c5 < '0' || c5 > '5') ? c5 == '6' && c6 == '0' : c6 >= '0' && c6 <= '9';
    }

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        if (i >= this.len) {
            return 26;
        }
        return this.text.charAt(i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        char c;
        int i = this.bp + 1;
        this.bp = i;
        if (i >= this.len) {
            c = 26;
        } else {
            c = this.text.charAt(i);
        }
        this.ch = c;
        return c;
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    static boolean charArrayCompare(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) {
            int i = this.np + 1;
            int i2 = this.sp;
            if (i2 % 2 == 0) {
                int i3 = i2 / 2;
                byte[] bArr = new byte[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = (i4 * 2) + i;
                    char charAt = this.text.charAt(i5);
                    char charAt2 = this.text.charAt(i5 + 1);
                    char c = '0';
                    int i6 = charAt - (charAt <= '9' ? '0' : '7');
                    if (charAt2 > '9') {
                        c = '7';
                    }
                    bArr[i4] = (byte) ((i6 << 4) | (charAt2 - c));
                }
                return bArr;
            }
            throw new JSONException("illegal state. " + i2);
        } else if (!this.hasSpecial) {
            return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
        } else {
            return IOUtils.decodeBase64(new String(this.sbuf, 0, this.sp));
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.np + 1, this.sp);
        }
        return new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (!ASMUtils.IS_ANDROID) {
            return this.text.substring(i, i2 + i);
        }
        if (i2 < this.sbuf.length) {
            this.text.getChars(i, i + i2, this.sbuf, 0);
            return new String(this.sbuf, 0, i2);
        }
        char[] cArr = new char[i2];
        this.text.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i, int i2) {
        if (!ASMUtils.IS_ANDROID || i2 >= this.sbuf.length) {
            char[] cArr = new char[i2];
            this.text.getChars(i, i2 + i, cArr, 0);
            return cArr;
        }
        this.text.getChars(i, i2 + i, this.sbuf, 0);
        return this.sbuf;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.np;
        if (i < this.sbuf.length) {
            this.text.getChars(i2, i2 + i, this.sbuf, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr = new char[i];
        this.text.getChars(i2, i + i2, cArr, 0);
        return new BigDecimal(cArr);
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x0214 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0216  */
    private boolean scanISO8601DateIfMatch(boolean z, int i) {
        char c;
        char c2;
        char c3;
        char c4;
        int i2;
        int i3;
        int i4;
        int i5;
        char c5;
        char c6;
        char c7;
        char c8;
        char c9;
        char c10;
        int i6;
        int i7;
        char c11;
        char c12;
        char c13;
        char c14;
        char c15;
        char c16;
        char c17;
        int i8;
        char charAt;
        char c18;
        char charAt2;
        int i9;
        char charAt3;
        char charAt4;
        char charAt5;
        if (i < 8) {
            return false;
        }
        char charAt6 = charAt(this.bp);
        char charAt7 = charAt(this.bp + 1);
        char charAt8 = charAt(this.bp + 2);
        int i10 = 3;
        char charAt9 = charAt(this.bp + 3);
        char charAt10 = charAt(this.bp + 4);
        char charAt11 = charAt(this.bp + 5);
        char charAt12 = charAt(this.bp + 6);
        char charAt13 = charAt(this.bp + 7);
        if (!z) {
            if (i > 13) {
                char charAt14 = charAt((this.bp + i) - 1);
                char charAt15 = charAt((this.bp + i) - 2);
                if (charAt6 == '/' && charAt7 == 'D' && charAt8 == 'a' && charAt9 == 't' && charAt10 == 'e' && charAt11 == '(' && charAt14 == '/' && charAt15 == ')') {
                    int i11 = -1;
                    for (int i12 = 6; i12 < i; i12++) {
                        char charAt16 = charAt(this.bp + i12);
                        if (charAt16 != '+') {
                            if (charAt16 < '0' || charAt16 > '9') {
                                break;
                            }
                        } else {
                            i11 = i12;
                        }
                    }
                    if (i11 == -1) {
                        return false;
                    }
                    int i13 = this.bp + 6;
                    long parseLong = Long.parseLong(subString(i13, (this.bp + i11) - i13));
                    this.calendar = Calendar.getInstance(this.timeZone, this.locale);
                    this.calendar.setTimeInMillis(parseLong);
                    this.token = 5;
                    return true;
                }
            }
        }
        if (i == 8 || i == 14 || ((i == 16 && ((charAt5 = charAt(this.bp + 10)) == 'T' || charAt5 == ' ')) || (i == 17 && charAt(this.bp + 6) != '-'))) {
            if (z) {
                return false;
            }
            char charAt17 = charAt(this.bp + 8);
            boolean z2 = charAt10 == '-' && charAt13 == '-';
            boolean z3 = z2 && i == 16;
            boolean z4 = z2 && i == 17;
            if (z4 || z3) {
                c = charAt(this.bp + 9);
                c4 = charAt11;
                c3 = charAt12;
                c2 = charAt17;
            } else if (charAt10 == '-' && charAt12 == '-') {
                c3 = charAt11;
                c = charAt13;
                c4 = '0';
                c2 = '0';
            } else {
                c4 = charAt10;
                c3 = charAt11;
                c2 = charAt12;
                c = charAt13;
            }
            if (!checkDate(charAt6, charAt7, charAt8, charAt9, c4, c3, c2, c)) {
                return false;
            }
            setCalendar(charAt6, charAt7, charAt8, charAt9, c4, c3, c2, c);
            if (i != 8) {
                char charAt18 = charAt(this.bp + 9);
                char charAt19 = charAt(this.bp + 10);
                char charAt20 = charAt(this.bp + 11);
                char charAt21 = charAt(this.bp + 12);
                char charAt22 = charAt(this.bp + 13);
                if (!(z4 && charAt19 == 'T' && charAt22 == ':' && charAt(this.bp + 16) == 'Z') && (!z3 || !((charAt19 == ' ' || charAt19 == 'T') && charAt22 == ':'))) {
                    c10 = charAt18;
                    c9 = charAt19;
                    c6 = charAt20;
                    c8 = charAt21;
                    c5 = charAt17;
                    c7 = charAt22;
                } else {
                    char charAt23 = charAt(this.bp + 14);
                    c6 = charAt(this.bp + 15);
                    c9 = charAt23;
                    c5 = charAt20;
                    c10 = charAt21;
                    c8 = '0';
                    c7 = '0';
                }
                if (!checkTime(c5, c10, c9, c6, c8, c7)) {
                    return false;
                }
                if (i != 17 || z4) {
                    i6 = 0;
                } else {
                    char charAt24 = charAt(this.bp + 14);
                    char charAt25 = charAt(this.bp + 15);
                    char charAt26 = charAt(this.bp + 16);
                    if (charAt24 < '0' || charAt24 > '9' || charAt25 < '0' || charAt25 > '9' || charAt26 < '0' || charAt26 > '9') {
                        return false;
                    }
                    i6 = ((charAt24 - '0') * 100) + ((charAt25 - '0') * 10) + (charAt26 - '0');
                }
                i4 = (c7 - '0') + ((c8 - '0') * 10);
                i2 = ((c5 - '0') * 10) + (c10 - '0');
                i3 = i6;
                i5 = ((c9 - '0') * 10) + (c6 - '0');
            } else {
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
            }
            this.calendar.set(11, i2);
            this.calendar.set(12, i5);
            this.calendar.set(13, i4);
            this.calendar.set(14, i3);
            this.token = 5;
            return true;
        } else if (i < 9) {
            return false;
        } else {
            char charAt27 = charAt(this.bp + 8);
            char charAt28 = charAt(this.bp + 9);
            if ((charAt10 != '-' || charAt13 != '-') && (charAt10 != '/' || charAt13 != '/')) {
                if (charAt10 == '-' && charAt12 == '-') {
                    if (charAt27 == ' ') {
                        c15 = charAt8;
                        c12 = charAt11;
                        c17 = charAt6;
                        c16 = charAt7;
                        c13 = '0';
                        i7 = 8;
                    } else {
                        c15 = charAt8;
                        c17 = charAt6;
                        c13 = '0';
                        i7 = 9;
                        c12 = charAt11;
                        c16 = charAt7;
                        charAt7 = charAt27;
                        c11 = charAt13;
                        c14 = charAt9;
                        if (checkDate(c17, c16, c15, c14, c13, c12, c11, charAt7)) {
                        }
                    }
                } else if ((charAt8 == '.' && charAt11 == '.') || (charAt8 == '-' && charAt11 == '-')) {
                    c16 = charAt13;
                    c14 = charAt28;
                    c13 = charAt9;
                    c11 = charAt6;
                    i7 = 10;
                    c12 = charAt10;
                    c17 = charAt12;
                    c15 = charAt27;
                    if (checkDate(c17, c16, c15, c14, c13, c12, c11, charAt7)) {
                    }
                } else if (charAt27 == 'T') {
                    c13 = charAt10;
                    c12 = charAt11;
                    c17 = charAt6;
                    c16 = charAt7;
                    i7 = 8;
                    charAt7 = charAt13;
                    c14 = charAt9;
                    c11 = charAt12;
                    c15 = charAt8;
                    if (checkDate(c17, c16, c15, c14, c13, c12, c11, charAt7)) {
                        return false;
                    }
                    setCalendar(c17, c16, c15, c14, c13, c12, c11, charAt7);
                    char charAt29 = charAt(this.bp + i7);
                    char c19 = 'T';
                    if (charAt29 == 'T') {
                        if (i == 16 && i7 == 8 && charAt(this.bp + 15) == 'Z') {
                            char charAt30 = charAt(this.bp + i7 + 1);
                            char charAt31 = charAt(this.bp + i7 + 2);
                            char charAt32 = charAt(this.bp + i7 + 3);
                            char charAt33 = charAt(this.bp + i7 + 4);
                            char charAt34 = charAt(this.bp + i7 + 5);
                            char charAt35 = charAt(this.bp + i7 + 6);
                            if (!checkTime(charAt30, charAt31, charAt32, charAt33, charAt34, charAt35)) {
                                return false;
                            }
                            setTime(charAt30, charAt31, charAt32, charAt33, charAt34, charAt35);
                            this.calendar.set(14, 0);
                            if (this.calendar.getTimeZone().getRawOffset() != 0) {
                                String[] availableIDs = TimeZone.getAvailableIDs(0);
                                if (availableIDs.length > 0) {
                                    this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                }
                            }
                            this.token = 5;
                            return true;
                        }
                        c19 = 'T';
                    }
                    if (charAt29 == c19 || (charAt29 == ' ' && !z)) {
                        if (!(i >= i7 + 9 && charAt(this.bp + i7 + 3) == ':' && charAt(this.bp + i7 + 6) == ':')) {
                            return false;
                        }
                        char charAt36 = charAt(this.bp + i7 + 1);
                        char charAt37 = charAt(this.bp + i7 + 2);
                        char charAt38 = charAt(this.bp + i7 + 4);
                        char charAt39 = charAt(this.bp + i7 + 5);
                        char charAt40 = charAt(this.bp + i7 + 7);
                        char charAt41 = charAt(this.bp + i7 + 8);
                        if (!checkTime(charAt36, charAt37, charAt38, charAt39, charAt40, charAt41)) {
                            return false;
                        }
                        setTime(charAt36, charAt37, charAt38, charAt39, charAt40, charAt41);
                        int i14 = -1;
                        if (charAt(this.bp + i7 + 9) == '.') {
                            int i15 = i7 + 11;
                            if (i < i15 || (charAt2 = charAt(this.bp + i7 + 10)) < '0' || charAt2 > '9') {
                                return false;
                            }
                            int i16 = charAt2 - '0';
                            if (i <= i15 || (charAt4 = charAt(this.bp + i7 + 11)) < '0' || charAt4 > '9') {
                                i9 = 1;
                            } else {
                                i16 = (i16 * 10) + (charAt4 - '0');
                                i9 = 2;
                            }
                            if (i9 != 2 || (charAt3 = charAt(this.bp + i7 + 12)) < '0' || charAt3 > '9') {
                                i8 = i16;
                                i14 = i9;
                            } else {
                                i8 = (charAt3 - '0') + (i16 * 10);
                                i14 = 3;
                            }
                        } else {
                            i8 = 0;
                        }
                        this.calendar.set(14, i8);
                        char charAt42 = charAt(this.bp + i7 + 10 + i14);
                        if (charAt42 == ' ') {
                            i14++;
                            charAt42 = charAt(this.bp + i7 + 10 + i14);
                        }
                        if (charAt42 == '+' || charAt42 == '-') {
                            char charAt43 = charAt(this.bp + i7 + 10 + i14 + 1);
                            if (charAt43 < '0' || charAt43 > '1' || (charAt = charAt(this.bp + i7 + 10 + i14 + 2)) < '0' || charAt > '9') {
                                return false;
                            }
                            char charAt44 = charAt(this.bp + i7 + 10 + i14 + 3);
                            char c20 = '3';
                            if (charAt44 == ':') {
                                char charAt45 = charAt(this.bp + i7 + 10 + i14 + 4);
                                c18 = charAt(this.bp + i7 + 10 + i14 + 5);
                                if (charAt45 == '4' && c18 == '5') {
                                    if (!(charAt43 == '1' && (charAt == '2' || charAt == '3'))) {
                                        if (charAt43 != '0') {
                                            return false;
                                        }
                                        if (!(charAt == '5' || charAt == '8')) {
                                            return false;
                                        }
                                    }
                                } else if (!((charAt45 == '0' || charAt45 == '3') && c18 == '0')) {
                                    return false;
                                }
                                c20 = charAt45;
                                i10 = 6;
                            } else {
                                if (charAt44 == '0') {
                                    char charAt46 = charAt(this.bp + i7 + 10 + i14 + 4);
                                    if (!(charAt46 == '0' || charAt46 == '3')) {
                                        return false;
                                    }
                                    c20 = charAt46;
                                } else if (!(charAt44 == '3' && charAt(this.bp + i7 + 10 + i14 + 4) == '0')) {
                                    if (charAt44 == '4' && charAt(this.bp + i7 + 10 + i14 + 4) == '5') {
                                        c20 = '4';
                                        c18 = '5';
                                        i10 = 5;
                                    } else {
                                        c20 = '0';
                                        c18 = '0';
                                    }
                                }
                                c18 = '0';
                                i10 = 5;
                            }
                            setTimeZone(charAt42, charAt43, charAt, c20, c18);
                        } else if (charAt42 == 'Z') {
                            if (this.calendar.getTimeZone().getRawOffset() != 0) {
                                String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                                if (availableIDs2.length > 0) {
                                    this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                                }
                            }
                            i10 = 1;
                        } else {
                            i10 = 0;
                        }
                        int i17 = i7 + 10 + i14 + i10;
                        char charAt47 = charAt(this.bp + i17);
                        if (!(charAt47 == 26 || charAt47 == '\"')) {
                            return false;
                        }
                        int i18 = this.bp + i17;
                        this.bp = i18;
                        this.ch = charAt(i18);
                        this.token = 5;
                        return true;
                    } else if (charAt29 == '\"' || charAt29 == 26 || charAt29 == 26085 || charAt29 == 51068) {
                        this.calendar.set(11, 0);
                        this.calendar.set(12, 0);
                        this.calendar.set(13, 0);
                        this.calendar.set(14, 0);
                        int i19 = this.bp + i7;
                        this.bp = i19;
                        this.ch = charAt(i19);
                        this.token = 5;
                        return true;
                    } else if ((charAt29 != '+' && charAt29 != '-') || this.len != i7 + 6 || charAt(this.bp + i7 + 3) != ':' || charAt(this.bp + i7 + 4) != '0' || charAt(this.bp + i7 + 5) != '0') {
                        return false;
                    } else {
                        setTime('0', '0', '0', '0', '0', '0');
                        this.calendar.set(14, 0);
                        setTimeZone(charAt29, charAt(this.bp + i7 + 1), charAt(this.bp + i7 + 2));
                        return true;
                    }
                } else if (charAt10 != 24180 && charAt10 != 45380) {
                    return false;
                } else {
                    if (charAt13 == 26376 || charAt13 == 50900) {
                        if (charAt28 == 26085 || charAt28 == 51068) {
                            c13 = charAt11;
                            c14 = charAt9;
                            c17 = charAt6;
                            c16 = charAt7;
                            c11 = '0';
                            i7 = 10;
                        } else if (charAt(this.bp + 10) != 26085 && charAt(this.bp + 10) != 51068) {
                            return false;
                        } else {
                            c14 = charAt9;
                            c17 = charAt6;
                            i7 = 11;
                            c11 = charAt27;
                            c12 = charAt12;
                            c15 = charAt8;
                            c13 = charAt11;
                            c16 = charAt7;
                            charAt7 = charAt28;
                            if (checkDate(c17, c16, c15, c14, c13, c12, c11, charAt7)) {
                            }
                        }
                    } else if (charAt12 != 26376 && charAt12 != 50900) {
                        return false;
                    } else {
                        if (charAt27 == 26085 || charAt27 == 51068) {
                            c15 = charAt8;
                            c12 = charAt11;
                            c17 = charAt6;
                            c16 = charAt7;
                            c13 = '0';
                            i7 = 10;
                        } else if (charAt28 != 26085 && charAt28 != 51068) {
                            return false;
                        } else {
                            c15 = charAt8;
                            c17 = charAt6;
                            c13 = '0';
                            i7 = 10;
                            c12 = charAt11;
                            c16 = charAt7;
                            charAt7 = charAt27;
                            c11 = charAt13;
                            c14 = charAt9;
                            if (checkDate(c17, c16, c15, c14, c13, c12, c11, charAt7)) {
                            }
                        }
                    }
                }
                charAt7 = charAt13;
                c14 = charAt9;
                c11 = '0';
                if (checkDate(c17, c16, c15, c14, c13, c12, c11, charAt7)) {
                }
            } else if (charAt28 == ' ') {
                c13 = charAt11;
                c14 = charAt9;
                c17 = charAt6;
                c16 = charAt7;
                c11 = '0';
                i7 = 9;
            } else {
                c14 = charAt9;
                c17 = charAt6;
                i7 = 10;
                c11 = charAt27;
                c12 = charAt12;
                c15 = charAt8;
                c13 = charAt11;
                c16 = charAt7;
                charAt7 = charAt28;
                if (checkDate(c17, c16, c15, c14, c13, c12, c11, charAt7)) {
                }
            }
            charAt7 = charAt27;
            c12 = charAt12;
            c15 = charAt8;
            if (checkDate(c17, c16, c15, c14, c13, c12, c11, charAt7)) {
            }
        }
    }

    protected void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    protected void setTimeZone(char c, char c2, char c3) {
        setTimeZone(c, c2, c3, '0', '0');
    }

    protected void setTimeZone(char c, char c2, char c3, char c4, char c5) {
        int i = ((((c2 - '0') * 10) + (c3 - '0')) * 3600 * 1000) + ((((c4 - '0') * 10) + (c5 - '0')) * 60 * 1000);
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            this.calendar.setTimeZone(new SimpleTimeZone(i, Integer.toString(i)));
        }
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        this.calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        if (this.bp != this.len) {
            return this.ch == 26 && this.bp + 1 >= this.len;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b4  */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int scanFieldInt(char[] cArr) {
        int i;
        char charAt;
        int i2;
        char charAt2;
        this.matchStat = 0;
        int i3 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i4 = length + 1;
        char charAt3 = charAt(length);
        boolean z = charAt3 == '\"';
        if (z) {
            charAt3 = charAt(i4);
            i4++;
        }
        boolean z2 = charAt3 == '-';
        if (z2) {
            charAt3 = charAt(i4);
            i4++;
        }
        if (charAt3 < '0' || charAt3 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i5 = charAt3 - '0';
        while (true) {
            i = i4 + 1;
            charAt = charAt(i4);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            int i6 = i5 * 10;
            if (i6 < i5) {
                this.matchStat = -1;
                return 0;
            }
            i5 = i6 + (charAt - '0');
            i4 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i5 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0;
                }
                i2 = i + 1;
                charAt2 = charAt(i);
                i = i2;
                charAt = charAt2;
            }
            if (charAt != ',' || charAt == '}') {
                int i7 = i - 1;
                this.bp = i7;
                if (charAt != ',') {
                    int i8 = this.bp + 1;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 3;
                    this.token = 16;
                    return z2 ? -i5 : i5;
                }
                if (charAt == '}') {
                    this.bp = i7;
                    int i9 = this.bp + 1;
                    this.bp = i9;
                    char charAt4 = charAt(i9);
                    while (true) {
                        if (charAt4 == ',') {
                            this.token = 16;
                            int i10 = this.bp + 1;
                            this.bp = i10;
                            this.ch = charAt(i10);
                            break;
                        } else if (charAt4 == ']') {
                            this.token = 15;
                            int i11 = this.bp + 1;
                            this.bp = i11;
                            this.ch = charAt(i11);
                            break;
                        } else if (charAt4 == '}') {
                            this.token = 13;
                            int i12 = this.bp + 1;
                            this.bp = i12;
                            this.ch = charAt(i12);
                            break;
                        } else if (charAt4 == 26) {
                            this.token = 20;
                            break;
                        } else if (isWhitespace(charAt4)) {
                            int i13 = this.bp + 1;
                            this.bp = i13;
                            charAt4 = charAt(i13);
                        } else {
                            this.bp = i3;
                            this.ch = c;
                            this.matchStat = -1;
                            return 0;
                        }
                    }
                    this.matchStat = 4;
                }
                return z2 ? -i5 : i5;
            }
            if (isWhitespace(charAt)) {
                i2 = i + 1;
                charAt2 = charAt(i);
                i = i2;
                charAt = charAt2;
                if (charAt != ',') {
                }
                int i7 = i - 1;
                this.bp = i7;
                if (charAt != ',') {
                }
            }
            this.matchStat = -1;
            return 0;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i = this.bp;
        char c = this.ch;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (isWhitespace(this.ch)) {
                next();
            } else {
                this.matchStat = -2;
                return stringDefaultValue();
            }
        }
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', i2);
        if (indexOf != -1) {
            String subString = subString(i2, indexOf - i2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i3 = indexOf - 1;
                    int i4 = 0;
                    while (i3 >= 0 && charAt(i3) == '\\') {
                        i4++;
                        i3--;
                    }
                    if (i4 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int length2 = indexOf - ((this.bp + cArr.length) + 1);
                subString = readString(sub_chars(this.bp + cArr.length + 1, length2), length2);
            }
            char charAt = charAt(indexOf + 1);
            while (charAt != ',' && charAt != '}') {
                if (isWhitespace(charAt)) {
                    indexOf++;
                    charAt = charAt(indexOf + 1);
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            this.bp = indexOf + 1;
            this.ch = charAt;
            if (charAt == ',') {
                int i5 = this.bp + 1;
                this.bp = i5;
                this.ch = charAt(i5);
                this.matchStat = 3;
                return subString;
            }
            int i6 = this.bp + 1;
            this.bp = i6;
            char charAt2 = charAt(i6);
            if (charAt2 == ',') {
                this.token = 16;
                int i7 = this.bp + 1;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i8 = this.bp + 1;
                this.bp = i8;
                this.ch = charAt(i8);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i9 = this.bp + 1;
                this.bp = i9;
                this.ch = charAt(i9);
            } else if (charAt2 == 26) {
                this.token = 20;
            } else {
                this.bp = i;
                this.ch = c;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.matchStat = 4;
            return subString;
        }
        throw new JSONException("unclosed str");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] cArr) {
        char c;
        Date date;
        long j;
        char c2;
        int i;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c3 = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char charAt = charAt(length);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', i3);
            if (indexOf != -1) {
                this.bp = i3;
                if (scanISO8601DateIfMatch(false, indexOf - i3)) {
                    date = this.calendar.getTime();
                    c = charAt(indexOf + 1);
                    this.bp = i2;
                    while (c != ',' && c != '}') {
                        if (isWhitespace(c)) {
                            indexOf++;
                            c = charAt(indexOf + 1);
                        } else {
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c;
                } else {
                    this.bp = i2;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c4 = '9';
            char c5 = '0';
            if (charAt == '-' || (charAt >= '0' && charAt <= '9')) {
                if (charAt == '-') {
                    charAt = charAt(i3);
                    i3++;
                    z = true;
                }
                if (charAt < '0' || charAt > '9') {
                    c2 = charAt;
                    j = 0;
                } else {
                    j = (long) (charAt - '0');
                    while (true) {
                        i = i3 + 1;
                        c2 = charAt(i3);
                        if (c2 < c5 || c2 > c4) {
                            break;
                        }
                        j = (j * 10) + ((long) (c2 - '0'));
                        i3 = i;
                        c4 = '9';
                        c5 = '0';
                    }
                    if (c2 == ',' || c2 == '}') {
                        this.bp = i - 1;
                    }
                }
                if (j < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                c = c2;
                date = new Date(j);
            } else {
                this.matchStat = -1;
                return null;
            }
        }
        if (c == ',') {
            int i4 = this.bp + 1;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i5 = this.bp + 1;
        this.bp = i5;
        char charAt2 = charAt(i5);
        if (charAt2 == ',') {
            this.token = 16;
            int i6 = this.bp + 1;
            this.bp = i6;
            this.ch = charAt(i6);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else if (charAt2 == 26) {
            this.token = 20;
        } else {
            this.bp = i2;
            this.ch = c3;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(i);
            if (charAt == '\"') {
                this.bp = i2;
                char charAt2 = charAt(this.bp);
                this.ch = charAt2;
                while (charAt2 != ',') {
                    if (charAt2 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i3 = this.bp + 1;
                            this.bp = i3;
                            this.ch = charAt(i3);
                        } else if (current == ']') {
                            this.token = 15;
                            int i4 = this.bp + 1;
                            this.bp = i4;
                            this.ch = charAt(i4);
                        } else if (current == '}') {
                            this.token = 13;
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            this.ch = charAt(i5);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0;
                        }
                        this.matchStat = 4;
                        return j;
                    } else if (isWhitespace(charAt2)) {
                        int i6 = this.bp + 1;
                        this.bp = i6;
                        charAt2 = charAt(i6);
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                }
                int i7 = this.bp + 1;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return j;
            } else if (i2 > this.len) {
                this.matchStat = -1;
                return 0;
            } else {
                j = (j ^ ((long) charAt)) * 1099511628211L;
                i = i2;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dd, code lost:
        if (r1 != ']') goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e3, code lost:
        if (r3.size() != 0) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e5, code lost:
        r1 = r9 + 1;
        r2 = charAt(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ef, code lost:
        r17.matchStat = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f2, code lost:
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        char c;
        Collection<String> collection;
        char c2;
        int i;
        int i2;
        boolean z;
        char c3;
        int i3;
        char c4;
        this.matchStat = 0;
        while (true) {
            if (this.ch != '\n' && this.ch != ' ') {
                break;
            }
            int i4 = this.bp + 1;
            this.bp = i4;
            if (i4 >= this.len) {
                c = 26;
            } else {
                c = this.text.charAt(i4);
            }
            this.ch = c;
        }
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> newCollectionByType = newCollectionByType(cls);
        int i5 = this.bp;
        char c5 = this.ch;
        int length = this.bp + cArr.length;
        int i6 = length + 1;
        int i7 = -1;
        if (charAt(length) == '[') {
            int i8 = i6 + 1;
            char charAt = charAt(i6);
            while (true) {
                if (charAt == '\"') {
                    int indexOf = indexOf('\"', i8);
                    if (indexOf != i7) {
                        String subString = subString(i8, indexOf - i8);
                        if (subString.indexOf(92) != i7) {
                            while (true) {
                                int i9 = indexOf - 1;
                                int i10 = 0;
                                while (i9 >= 0 && charAt(i9) == '\\') {
                                    i10++;
                                    i9--;
                                }
                                if (i10 % 2 == 0) {
                                    break;
                                }
                                indexOf = indexOf('\"', indexOf + 1);
                            }
                            int i11 = indexOf - i8;
                            subString = readString(sub_chars(i8, i11), i11);
                        }
                        int i12 = indexOf + 1;
                        i3 = i12 + 1;
                        c4 = charAt(i12);
                        newCollectionByType.add(subString);
                    } else {
                        throw new JSONException("unclosed str");
                    }
                } else if (charAt != 'n' || !this.text.startsWith("ull", i8)) {
                    break;
                } else {
                    int i13 = i8 + 3;
                    i3 = i13 + 1;
                    c4 = charAt(i13);
                    newCollectionByType.add(null);
                }
                if (c4 == ',') {
                    i8 = i3 + 1;
                    charAt = charAt(i3);
                    i7 = -1;
                } else if (c4 == ']') {
                    i2 = i3 + 1;
                    c3 = charAt(i3);
                    while (isWhitespace(c3)) {
                        c3 = charAt(i2);
                        i2++;
                    }
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            collection = newCollectionByType;
            c2 = c3;
            i = 3;
        } else if (this.text.startsWith("ull", i6)) {
            i = 3;
            int i14 = i6 + 3;
            collection = null;
            c2 = charAt(i14);
            i2 = i14 + 1;
        } else {
            this.matchStat = -1;
            return null;
        }
        this.bp = i2;
        if (c2 == ',') {
            this.ch = charAt(this.bp);
            this.matchStat = i;
            return collection;
        } else if (c2 == '}') {
            char charAt2 = charAt(this.bp);
            do {
                if (charAt2 == ',') {
                    this.token = 16;
                    int i15 = this.bp + 1;
                    this.bp = i15;
                    this.ch = charAt(i15);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i16 = this.bp + 1;
                    this.bp = i16;
                    this.ch = charAt(i16);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i17 = this.bp + 1;
                    this.bp = i17;
                    this.ch = charAt(i17);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.ch = charAt2;
                } else {
                    z = false;
                    while (isWhitespace(charAt2)) {
                        int i18 = i2 + 1;
                        char charAt3 = charAt(i2);
                        this.bp = i18;
                        z = true;
                        charAt2 = charAt3;
                        i2 = i18;
                    }
                }
                this.matchStat = 4;
                return collection;
            } while (z);
            this.matchStat = -1;
            return null;
        } else {
            this.ch = c5;
            this.bp = i5;
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        this.matchStat = 0;
        int i2 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(length);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            charAt2 = charAt(i3);
            i3++;
        }
        if (charAt2 == '-') {
            z = true;
            charAt2 = charAt(i3);
            i3++;
        } else {
            z = false;
        }
        if (charAt2 >= '0') {
            char c2 = '9';
            if (charAt2 <= '9') {
                long j = (long) (charAt2 - '0');
                while (true) {
                    i = i3 + 1;
                    charAt = charAt(i3);
                    if (charAt < '0' || charAt > c2) {
                        break;
                    }
                    j = (j * 10) + ((long) (charAt - '0'));
                    i3 = i;
                    c2 = '9';
                }
                if (charAt == '.') {
                    this.matchStat = -1;
                    return 0;
                }
                if (z2) {
                    if (charAt != '\"') {
                        this.matchStat = -1;
                        return 0;
                    }
                    int i4 = i + 1;
                    char charAt3 = charAt(i);
                    i = i4;
                    charAt = charAt3;
                }
                if (charAt == ',' || charAt == '}') {
                    this.bp = i - 1;
                }
                if (!(j >= 0 || (j == Long.MIN_VALUE && z))) {
                    this.bp = i2;
                    this.ch = c;
                    this.matchStat = -1;
                    return 0;
                }
                while (charAt != ',') {
                    if (charAt == '}') {
                        int i5 = this.bp + 1;
                        this.bp = i5;
                        char charAt4 = charAt(i5);
                        while (true) {
                            if (charAt4 == ',') {
                                this.token = 16;
                                int i6 = this.bp + 1;
                                this.bp = i6;
                                this.ch = charAt(i6);
                                break;
                            } else if (charAt4 == ']') {
                                this.token = 15;
                                int i7 = this.bp + 1;
                                this.bp = i7;
                                this.ch = charAt(i7);
                                break;
                            } else if (charAt4 == '}') {
                                this.token = 13;
                                int i8 = this.bp + 1;
                                this.bp = i8;
                                this.ch = charAt(i8);
                                break;
                            } else if (charAt4 == 26) {
                                this.token = 20;
                                break;
                            } else if (isWhitespace(charAt4)) {
                                int i9 = this.bp + 1;
                                this.bp = i9;
                                charAt4 = charAt(i9);
                            } else {
                                this.bp = i2;
                                this.ch = c;
                                this.matchStat = -1;
                                return 0;
                            }
                        }
                        this.matchStat = 4;
                        return z ? -j : j;
                    } else if (isWhitespace(charAt)) {
                        this.bp = i;
                        int i10 = i + 1;
                        char charAt5 = charAt(i);
                        i = i10;
                        charAt = charAt5;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                }
                int i11 = this.bp + 1;
                this.bp = i11;
                this.ch = charAt(i11);
                this.matchStat = 3;
                this.token = 16;
                return z ? -j : j;
            }
        }
        this.bp = i2;
        this.ch = c;
        this.matchStat = -1;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x00fd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x010e  */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean scanFieldBoolean(char[] cArr) {
        char c;
        boolean z;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return false;
        }
        int i = this.bp;
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        char charAt = charAt(length);
        boolean z2 = charAt == '\"';
        if (z2) {
            charAt = charAt(i2);
            i2++;
        }
        if (charAt == 't') {
            int i3 = i2 + 1;
            if (charAt(i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i4 = i3 + 1;
            if (charAt(i3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            int i5 = i4 + 1;
            if (charAt(i4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            if (z2) {
                int i6 = i5 + 1;
                if (charAt(i5) != '\"') {
                    this.matchStat = -1;
                    return false;
                }
                i5 = i6;
            }
            this.bp = i5;
            c = charAt(this.bp);
        } else {
            if (charAt == 'f') {
                int i7 = i2 + 1;
                if (charAt(i2) != 'a') {
                    this.matchStat = -1;
                    return false;
                }
                int i8 = i7 + 1;
                if (charAt(i7) != 'l') {
                    this.matchStat = -1;
                    return false;
                }
                int i9 = i8 + 1;
                if (charAt(i8) != 's') {
                    this.matchStat = -1;
                    return false;
                }
                int i10 = i9 + 1;
                if (charAt(i9) != 'e') {
                    this.matchStat = -1;
                    return false;
                }
                if (z2) {
                    int i11 = i10 + 1;
                    if (charAt(i10) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i10 = i11;
                }
                this.bp = i10;
                c = charAt(this.bp);
            } else if (charAt == '1') {
                if (z2) {
                    int i12 = i2 + 1;
                    if (charAt(i2) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i2 = i12;
                }
                this.bp = i2;
                c = charAt(this.bp);
            } else if (charAt == '0') {
                if (z2) {
                    int i13 = i2 + 1;
                    if (charAt(i2) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i2 = i13;
                }
                this.bp = i2;
                c = charAt(this.bp);
            } else {
                this.matchStat = -1;
                return false;
            }
            z = false;
            while (true) {
                if (c != ',') {
                    int i14 = this.bp + 1;
                    this.bp = i14;
                    this.ch = charAt(i14);
                    this.matchStat = 3;
                    this.token = 16;
                    break;
                } else if (c == '}') {
                    int i15 = this.bp + 1;
                    this.bp = i15;
                    char charAt2 = charAt(i15);
                    while (true) {
                        if (charAt2 == ',') {
                            this.token = 16;
                            int i16 = this.bp + 1;
                            this.bp = i16;
                            this.ch = charAt(i16);
                            break;
                        } else if (charAt2 == ']') {
                            this.token = 15;
                            int i17 = this.bp + 1;
                            this.bp = i17;
                            this.ch = charAt(i17);
                            break;
                        } else if (charAt2 == '}') {
                            this.token = 13;
                            int i18 = this.bp + 1;
                            this.bp = i18;
                            this.ch = charAt(i18);
                            break;
                        } else if (charAt2 == 26) {
                            this.token = 20;
                            break;
                        } else if (isWhitespace(charAt2)) {
                            int i19 = this.bp + 1;
                            this.bp = i19;
                            charAt2 = charAt(i19);
                        } else {
                            this.matchStat = -1;
                            return false;
                        }
                    }
                    this.matchStat = 4;
                } else if (isWhitespace(c)) {
                    int i20 = this.bp + 1;
                    this.bp = i20;
                    c = charAt(i20);
                } else {
                    this.bp = i;
                    charAt(this.bp);
                    this.matchStat = -1;
                    return false;
                }
            }
            return z;
        }
        z = true;
        while (true) {
            if (c != ',') {
            }
            int i20 = this.bp + 1;
            this.bp = i20;
            c = charAt(i20);
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x010e  */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final int scanInt(char c) {
        int i;
        char charAt;
        int i2;
        char charAt2;
        this.matchStat = 0;
        int i3 = this.bp;
        int i4 = this.bp;
        int i5 = i4 + 1;
        char charAt3 = charAt(i4);
        while (isWhitespace(charAt3)) {
            int i6 = i5 + 1;
            char charAt4 = charAt(i5);
            i5 = i6;
            charAt3 = charAt4;
        }
        boolean z = charAt3 == '\"';
        if (z) {
            int i7 = i5 + 1;
            char charAt5 = charAt(i5);
            i5 = i7;
            charAt3 = charAt5;
        }
        boolean z2 = charAt3 == '-';
        if (z2) {
            int i8 = i5 + 1;
            char charAt6 = charAt(i5);
            i5 = i8;
            charAt3 = charAt6;
        }
        if (charAt3 < '0' || charAt3 > '9') {
            if (charAt3 == 'n') {
                int i9 = i5 + 1;
                if (charAt(i5) == 'u') {
                    int i10 = i9 + 1;
                    if (charAt(i9) == 'l') {
                        int i11 = i10 + 1;
                        if (charAt(i10) == 'l') {
                            this.matchStat = 5;
                            int i12 = i11 + 1;
                            char charAt7 = charAt(i11);
                            if (z && charAt7 == '\"') {
                                i = i12 + 1;
                                charAt = charAt(i12);
                                i12 = i;
                                charAt7 = charAt;
                            }
                            if (charAt7 != ',') {
                                if (charAt7 != ']') {
                                    if (isWhitespace(charAt7)) {
                                        i = i12 + 1;
                                        charAt = charAt(i12);
                                        i12 = i;
                                        charAt7 = charAt;
                                        if (charAt7 != ',') {
                                        }
                                    }
                                    this.matchStat = -1;
                                    return 0;
                                }
                                this.bp = i12;
                                this.ch = charAt(this.bp);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0;
                            }
                            this.bp = i12;
                            this.ch = charAt(this.bp);
                            this.matchStat = 5;
                            this.token = 16;
                            return 0;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return 0;
        }
        int i13 = charAt3 - '0';
        while (true) {
            i2 = i5 + 1;
            charAt2 = charAt(i5);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            int i14 = i13 * 10;
            if (i14 >= i13) {
                i13 = i14 + (charAt2 - '0');
                i5 = i2;
            } else {
                throw new JSONException("parseInt error : " + subString(i3, i2 - 1));
            }
        }
        if (charAt2 == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (z) {
            if (charAt2 != '\"') {
                this.matchStat = -1;
                return 0;
            }
            charAt2 = charAt(i2);
            i2++;
        }
        if (i13 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (charAt2 != c) {
            if (isWhitespace(charAt2)) {
                charAt2 = charAt(i2);
                i2++;
            } else {
                this.matchStat = -1;
                return z2 ? -i13 : i13;
            }
        }
        this.bp = i2;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        return z2 ? -i13 : i13;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public double scanDouble(char r22) {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanDouble(char):double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ff  */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        char charAt;
        int i2;
        char charAt2;
        boolean z = false;
        this.matchStat = 0;
        int i3 = this.bp;
        int i4 = i3 + 1;
        char charAt3 = charAt(i3);
        boolean z2 = charAt3 == '\"';
        if (z2) {
            int i5 = i4 + 1;
            char charAt4 = charAt(i4);
            i4 = i5;
            charAt3 = charAt4;
        }
        boolean z3 = charAt3 == '-';
        if (z3) {
            int i6 = i4 + 1;
            char charAt5 = charAt(i4);
            i4 = i6;
            charAt3 = charAt5;
        }
        char c2 = '0';
        if (charAt3 < '0' || charAt3 > '9') {
            if (charAt3 == 'n') {
                int i7 = i4 + 1;
                if (charAt(i4) == 'u') {
                    int i8 = i7 + 1;
                    if (charAt(i7) == 'l') {
                        int i9 = i8 + 1;
                        if (charAt(i8) == 'l') {
                            this.matchStat = 5;
                            int i10 = i9 + 1;
                            char charAt6 = charAt(i9);
                            if (z2 && charAt6 == '\"') {
                                i = i10 + 1;
                                charAt = charAt(i10);
                                i10 = i;
                                charAt6 = charAt;
                            }
                            if (charAt6 != ',') {
                                if (charAt6 != ']') {
                                    if (isWhitespace(charAt6)) {
                                        i = i10 + 1;
                                        charAt = charAt(i10);
                                        i10 = i;
                                        charAt6 = charAt;
                                        if (charAt6 != ',') {
                                        }
                                    }
                                    this.matchStat = -1;
                                    return 0;
                                }
                                this.bp = i10;
                                this.ch = charAt(this.bp);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0;
                            }
                            this.bp = i10;
                            this.ch = charAt(this.bp);
                            this.matchStat = 5;
                            this.token = 16;
                            return 0;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return 0;
        }
        long j = (long) (charAt3 - '0');
        while (true) {
            i2 = i4 + 1;
            charAt2 = charAt(i4);
            if (charAt2 < c2 || charAt2 > '9') {
                break;
            }
            j = (j * 10) + ((long) (charAt2 - '0'));
            i4 = i2;
            c2 = '0';
        }
        if (charAt2 == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (z2) {
            if (charAt2 != '\"') {
                this.matchStat = -1;
                return 0;
            }
            charAt2 = charAt(i2);
            i2++;
        }
        if (j >= 0 || (j == Long.MIN_VALUE && z3)) {
            z = true;
        }
        if (!z) {
            this.matchStat = -1;
            return 0;
        }
        while (charAt2 != c) {
            if (isWhitespace(charAt2)) {
                charAt2 = charAt(i2);
                i2++;
            } else {
                this.matchStat = -1;
                return j;
            }
        }
        this.bp = i2;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        return z3 ? -j : j;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanDate(char c) {
        char c2;
        Date date;
        long j;
        int i;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c3 = this.ch;
        int i3 = this.bp;
        int i4 = i3 + 1;
        char charAt = charAt(i3);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', i4);
            if (indexOf != -1) {
                this.bp = i4;
                if (scanISO8601DateIfMatch(false, indexOf - i4)) {
                    date = this.calendar.getTime();
                    c2 = charAt(indexOf + 1);
                    this.bp = i2;
                    while (c2 != ',' && c2 != ']') {
                        if (isWhitespace(c2)) {
                            indexOf++;
                            c2 = charAt(indexOf + 1);
                        } else {
                            this.bp = i2;
                            this.ch = c3;
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c2;
                } else {
                    this.bp = i2;
                    this.ch = c3;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c4 = '9';
            char c5 = '0';
            if (charAt == '-' || (charAt >= '0' && charAt <= '9')) {
                if (charAt == '-') {
                    charAt = charAt(i4);
                    i4++;
                    z = true;
                }
                if (charAt < '0' || charAt > '9') {
                    c2 = charAt;
                    j = 0;
                } else {
                    j = (long) (charAt - '0');
                    while (true) {
                        i = i4 + 1;
                        c2 = charAt(i4);
                        if (c2 < c5 || c2 > c4) {
                            break;
                        }
                        j = (j * 10) + ((long) (c2 - '0'));
                        i4 = i;
                        c4 = '9';
                        c5 = '0';
                    }
                    if (c2 == ',' || c2 == ']') {
                        this.bp = i - 1;
                    }
                }
                if (j < 0) {
                    this.bp = i2;
                    this.ch = c3;
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                date = new Date(j);
            } else {
                if (charAt == 'n') {
                    int i5 = i4 + 1;
                    if (charAt(i4) == 'u') {
                        int i6 = i5 + 1;
                        if (charAt(i5) == 'l') {
                            int i7 = i6 + 1;
                            if (charAt(i6) == 'l') {
                                c2 = charAt(i7);
                                this.bp = i7;
                                date = null;
                            }
                        }
                    }
                }
                this.bp = i2;
                this.ch = c3;
                this.matchStat = -1;
                return null;
            }
        }
        if (c2 == ',') {
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
            this.matchStat = 3;
            return date;
        }
        int i9 = this.bp + 1;
        this.bp = i9;
        char charAt2 = charAt(i9);
        if (charAt2 == ',') {
            this.token = 16;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = charAt(i11);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i12 = this.bp + 1;
            this.bp = i12;
            this.ch = charAt(i12);
        } else if (charAt2 == 26) {
            this.ch = 26;
            this.token = 20;
        } else {
            this.bp = i2;
            this.ch = c3;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < this.bp) {
            if (this.text.charAt(i) == '\n') {
                i2++;
                i3 = 1;
            }
            i++;
            i3++;
        }
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", line ");
        sb.append(i2);
        sb.append(", column ");
        sb.append(i3);
        if (this.text.length() < 65535) {
            sb.append(this.text);
        } else {
            sb.append(this.text.substring(0, 65535));
        }
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        char c;
        int i2;
        int i3 = this.bp;
        char c2 = this.ch;
        while (isWhitespace(this.ch)) {
            next();
        }
        if (cArr != null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.bp + cArr.length;
            int i4 = length + 1;
            char charAt = this.text.charAt(length);
            while (isWhitespace(charAt)) {
                charAt = this.text.charAt(i4);
                i4++;
            }
            if (charAt == ':') {
                i2 = i4 + 1;
                c = this.text.charAt(i4);
                while (isWhitespace(c)) {
                    c = this.text.charAt(i2);
                    i2++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i2 = this.bp + 1;
            c = this.ch;
        }
        if (c == '[') {
            this.bp = i2;
            this.ch = this.text.charAt(this.bp);
            String[] strArr = i >= 0 ? new String[i] : new String[4];
            int i5 = 0;
            while (true) {
                if (isWhitespace(this.ch)) {
                    next();
                } else if (this.ch != '\"') {
                    this.bp = i3;
                    this.ch = c2;
                    this.matchStat = -1;
                    return null;
                } else {
                    String scanSymbol = scanSymbol(symbolTable, '\"');
                    if (i5 == strArr.length) {
                        String[] strArr2 = new String[(strArr.length + (strArr.length >> 1) + 1)];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i6 = i5 + 1;
                    strArr[i5] = scanSymbol;
                    while (isWhitespace(this.ch)) {
                        next();
                    }
                    if (this.ch == ',') {
                        next();
                        i5 = i6;
                    } else {
                        if (strArr.length != i6) {
                            String[] strArr3 = new String[i6];
                            System.arraycopy(strArr, 0, strArr3, 0, i6);
                            strArr = strArr3;
                        }
                        while (isWhitespace(this.ch)) {
                            next();
                        }
                        if (this.ch == ']') {
                            next();
                            return strArr;
                        }
                        this.bp = i3;
                        this.ch = c2;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else if (c != 'n' || !this.text.startsWith("ull", this.bp + 1)) {
            this.matchStat = -1;
            return null;
        } else {
            this.bp += 4;
            this.ch = this.text.charAt(this.bp);
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean matchField2(char[] cArr) {
        while (isWhitespace(this.ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char charAt = this.text.charAt(length);
        while (isWhitespace(charAt)) {
            charAt = this.text.charAt(i);
            i++;
        }
        if (charAt == ':') {
            this.bp = i;
            this.ch = charAt(this.bp);
            return true;
        }
        this.matchStat = -2;
        return false;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject() {
        skipObject(false);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char charAt = this.text.charAt(i);
            if (charAt == '\\') {
                if (i < this.len - 1) {
                    i++;
                } else {
                    this.ch = charAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
            } else if (charAt == '\"') {
                z2 = !z2;
            } else if (charAt == '{') {
                if (!z2) {
                    i2++;
                }
            } else if (charAt == '}' && !z2 && i2 - 1 == -1) {
                this.bp = i + 1;
                char c = 26;
                if (this.bp == this.text.length()) {
                    this.ch = 26;
                    this.token = 20;
                    return;
                }
                this.ch = this.text.charAt(this.bp);
                if (this.ch == ',') {
                    this.token = 16;
                    int i3 = this.bp + 1;
                    this.bp = i3;
                    if (i3 < this.text.length()) {
                        c = this.text.charAt(i3);
                    }
                    this.ch = c;
                    return;
                } else if (this.ch == '}') {
                    this.token = 13;
                    next();
                    return;
                } else if (this.ch == ']') {
                    this.token = 15;
                    next();
                    return;
                } else {
                    nextToken(16);
                    return;
                }
            }
            i++;
        }
        for (int i4 = 0; i4 < this.bp; i4++) {
            if (i4 < this.text.length() && this.text.charAt(i4) == ' ') {
                i++;
            }
        }
        if (i == this.text.length()) {
            throw new JSONException("illegal str, " + info());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipArray() {
        skipArray(false);
    }

    public final void skipArray(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char charAt = this.text.charAt(i);
            if (charAt == '\\') {
                if (i < this.len - 1) {
                    i++;
                } else {
                    this.ch = charAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
            } else if (charAt == '\"') {
                z2 = !z2;
            } else if (charAt != '[') {
                char c = 26;
                if (charAt == '{' && z) {
                    int i3 = this.bp + 1;
                    this.bp = i3;
                    if (i3 < this.text.length()) {
                        c = this.text.charAt(i3);
                    }
                    this.ch = c;
                    skipObject(z);
                } else if (charAt == ']' && !z2 && i2 - 1 == -1) {
                    this.bp = i + 1;
                    if (this.bp == this.text.length()) {
                        this.ch = 26;
                        this.token = 20;
                        return;
                    }
                    this.ch = this.text.charAt(this.bp);
                    nextToken(16);
                    return;
                }
            } else if (!z2) {
                i2++;
            }
            i++;
        }
        if (i == this.text.length()) {
            throw new JSONException("illegal str, " + info());
        }
    }

    public final void skipString() {
        if (this.ch == '\"') {
            int i = this.bp;
            while (true) {
                i++;
                if (i < this.text.length()) {
                    char charAt = this.text.charAt(i);
                    if (charAt == '\\') {
                        if (i < this.len - 1) {
                            i++;
                        }
                    } else if (charAt == '\"') {
                        String str = this.text;
                        int i2 = i + 1;
                        this.bp = i2;
                        this.ch = str.charAt(i2);
                        return;
                    }
                } else {
                    throw new JSONException("unclosed str");
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean seekArrayToItem(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index must > 0, but " + i);
        } else if (this.token == 20) {
            return false;
        } else {
            if (this.token == 14) {
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 < i) {
                        skipWhitespace();
                        if (this.ch == '\"' || this.ch == '\'') {
                            skipString();
                            if (this.ch == ',') {
                                next();
                            } else if (this.ch == ']') {
                                next();
                                nextToken(16);
                                return false;
                            } else {
                                throw new JSONException("illegal json.");
                            }
                        } else {
                            if (this.ch == '{') {
                                next();
                                this.token = 12;
                                skipObject(false);
                            } else if (this.ch == '[') {
                                next();
                                this.token = 14;
                                skipArray(false);
                            } else {
                                int i3 = this.bp + 1;
                                while (true) {
                                    if (i3 >= this.text.length()) {
                                        z = false;
                                        break;
                                    }
                                    char charAt = this.text.charAt(i3);
                                    if (charAt == ',') {
                                        this.bp = i3 + 1;
                                        this.ch = charAt(this.bp);
                                        break;
                                    } else if (charAt == ']') {
                                        this.bp = i3 + 1;
                                        this.ch = charAt(this.bp);
                                        nextToken();
                                        return false;
                                    } else {
                                        i3++;
                                    }
                                }
                                if (!z) {
                                    throw new JSONException("illegal json.");
                                }
                            }
                            if (this.token != 16) {
                                if (this.token == 15) {
                                    return false;
                                }
                                throw new UnsupportedOperationException();
                            }
                        }
                        i2++;
                    } else {
                        nextToken();
                        return true;
                    }
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long j, boolean z) {
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        int i = -1;
        if (this.token == 20) {
            return -1;
        }
        if (this.token != 13) {
            int i2 = 15;
            if (this.token != 15) {
                int i3 = 16;
                if (this.token == 12 || this.token == 16) {
                    while (this.ch != '}') {
                        if (this.ch == 26) {
                            return i;
                        }
                        if (this.ch != '\"') {
                            skipWhitespace();
                        }
                        if (this.ch == '\"') {
                            long j2 = -3750763034362895579L;
                            int i4 = this.bp + 1;
                            while (true) {
                                if (i4 >= this.text.length()) {
                                    break;
                                }
                                char charAt = this.text.charAt(i4);
                                if (charAt == '\\') {
                                    i4++;
                                    if (i4 != this.text.length()) {
                                        charAt = this.text.charAt(i4);
                                    } else {
                                        throw new JSONException("unclosed str, " + info());
                                    }
                                }
                                if (charAt == '\"') {
                                    this.bp = i4 + 1;
                                    if (this.bp >= this.text.length()) {
                                        c7 = 26;
                                    } else {
                                        c7 = this.text.charAt(this.bp);
                                    }
                                    this.ch = c7;
                                } else {
                                    j2 = (j2 ^ ((long) charAt)) * 1099511628211L;
                                    i4++;
                                }
                            }
                            if (j2 == j) {
                                if (this.ch != ':') {
                                    skipWhitespace();
                                }
                                if (this.ch != ':') {
                                    return 3;
                                }
                                int i5 = this.bp + 1;
                                this.bp = i5;
                                if (i5 >= this.text.length()) {
                                    c = 26;
                                } else {
                                    c = this.text.charAt(i5);
                                }
                                this.ch = c;
                                if (this.ch == ',') {
                                    int i6 = this.bp + 1;
                                    this.bp = i6;
                                    if (i6 >= this.text.length()) {
                                        c4 = 26;
                                    } else {
                                        c4 = this.text.charAt(i6);
                                    }
                                    this.ch = c4;
                                    this.token = i3;
                                    return 3;
                                } else if (this.ch == ']') {
                                    int i7 = this.bp + 1;
                                    this.bp = i7;
                                    if (i7 >= this.text.length()) {
                                        c3 = 26;
                                    } else {
                                        c3 = this.text.charAt(i7);
                                    }
                                    this.ch = c3;
                                    this.token = i2;
                                    return 3;
                                } else if (this.ch == '}') {
                                    int i8 = this.bp + 1;
                                    this.bp = i8;
                                    if (i8 >= this.text.length()) {
                                        c2 = 26;
                                    } else {
                                        c2 = this.text.charAt(i8);
                                    }
                                    this.ch = c2;
                                    this.token = 13;
                                    return 3;
                                } else if (this.ch < '0' || this.ch > '9') {
                                    nextToken(2);
                                    return 3;
                                } else {
                                    this.sp = 0;
                                    this.pos = this.bp;
                                    scanNumber();
                                    return 3;
                                }
                            } else {
                                if (this.ch != ':') {
                                    skipWhitespace();
                                }
                                if (this.ch == ':') {
                                    int i9 = this.bp + 1;
                                    this.bp = i9;
                                    if (i9 >= this.text.length()) {
                                        c5 = 26;
                                    } else {
                                        c5 = this.text.charAt(i9);
                                    }
                                    this.ch = c5;
                                    if (!(this.ch == '\"' || this.ch == '\'' || this.ch == '{' || this.ch == '[' || this.ch == '0' || this.ch == '1' || this.ch == '2' || this.ch == '3' || this.ch == '4' || this.ch == '5' || this.ch == '6' || this.ch == '7' || this.ch == '8' || this.ch == '9' || this.ch == '+' || this.ch == '-')) {
                                        skipWhitespace();
                                    }
                                    if (this.ch == '-' || this.ch == '+' || (this.ch >= '0' && this.ch <= '9')) {
                                        next();
                                        while (this.ch >= '0' && this.ch <= '9') {
                                            next();
                                        }
                                        if (this.ch == '.') {
                                            next();
                                            while (this.ch >= '0' && this.ch <= '9') {
                                                next();
                                            }
                                        }
                                        if (this.ch == 'E' || this.ch == 'e') {
                                            next();
                                            if (this.ch == '-' || this.ch == '+') {
                                                next();
                                            }
                                            while (this.ch >= '0' && this.ch <= '9') {
                                                next();
                                            }
                                        }
                                        if (this.ch != ',') {
                                            skipWhitespace();
                                        }
                                        if (this.ch == ',') {
                                            next();
                                        }
                                    } else if (this.ch == '\"') {
                                        skipString();
                                        if (!(this.ch == ',' || this.ch == '}')) {
                                            skipWhitespace();
                                        }
                                        if (this.ch == ',') {
                                            next();
                                        }
                                    } else if (this.ch == 't') {
                                        next();
                                        if (this.ch == 'r') {
                                            next();
                                            if (this.ch == 'u') {
                                                next();
                                                if (this.ch == 'e') {
                                                    next();
                                                }
                                            }
                                        }
                                        if (!(this.ch == ',' || this.ch == '}')) {
                                            skipWhitespace();
                                        }
                                        if (this.ch == ',') {
                                            next();
                                        }
                                    } else if (this.ch == 'n') {
                                        next();
                                        if (this.ch == 'u') {
                                            next();
                                            if (this.ch == 'l') {
                                                next();
                                                if (this.ch == 'l') {
                                                    next();
                                                }
                                            }
                                        }
                                        if (!(this.ch == ',' || this.ch == '}')) {
                                            skipWhitespace();
                                        }
                                        if (this.ch == ',') {
                                            next();
                                        }
                                    } else if (this.ch == 'f') {
                                        next();
                                        if (this.ch == 'a') {
                                            next();
                                            if (this.ch == 'l') {
                                                next();
                                                if (this.ch == 's') {
                                                    next();
                                                    if (this.ch == 'e') {
                                                        next();
                                                    }
                                                }
                                            }
                                        }
                                        if (!(this.ch == ',' || this.ch == '}')) {
                                            skipWhitespace();
                                        }
                                        if (this.ch == ',') {
                                            next();
                                        }
                                    } else if (this.ch == '{') {
                                        int i10 = this.bp + 1;
                                        this.bp = i10;
                                        if (i10 >= this.text.length()) {
                                            c6 = 26;
                                        } else {
                                            c6 = this.text.charAt(i10);
                                        }
                                        this.ch = c6;
                                        if (z) {
                                            this.token = 12;
                                            return 1;
                                        }
                                        skipObject(false);
                                        if (this.token == 13) {
                                            return -1;
                                        }
                                    } else if (this.ch == '[') {
                                        next();
                                        if (z) {
                                            this.token = 14;
                                            return 2;
                                        }
                                        skipArray(false);
                                        if (this.token == 13) {
                                            return -1;
                                        }
                                    } else {
                                        throw new UnsupportedOperationException();
                                    }
                                    i = -1;
                                    i2 = 15;
                                    i3 = 16;
                                } else {
                                    throw new JSONException("illegal json, " + info());
                                }
                            }
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    }
                    next();
                    nextToken();
                    return i;
                }
                throw new UnsupportedOperationException(JSONToken.name(this.token));
            }
        }
        nextToken();
        return -1;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long[] jArr) {
        char c;
        char c2;
        char c3;
        if (this.token == 12 || this.token == 16) {
            while (this.ch != '}') {
                char c4 = 26;
                if (this.ch == 26) {
                    this.matchStat = -1;
                    return -1;
                }
                if (this.ch != '\"') {
                    skipWhitespace();
                }
                if (this.ch == '\"') {
                    long j = -3750763034362895579L;
                    int i = this.bp;
                    while (true) {
                        i++;
                        if (i >= this.text.length()) {
                            break;
                        }
                        char charAt = this.text.charAt(i);
                        if (charAt == '\\') {
                            i++;
                            if (i != this.text.length()) {
                                charAt = this.text.charAt(i);
                            } else {
                                throw new JSONException("unclosed str, " + info());
                            }
                        }
                        if (charAt == '\"') {
                            this.bp = i + 1;
                            if (this.bp >= this.text.length()) {
                                c3 = 26;
                            } else {
                                c3 = this.text.charAt(this.bp);
                            }
                            this.ch = c3;
                        } else {
                            j = (j ^ ((long) charAt)) * 1099511628211L;
                        }
                    }
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jArr.length) {
                            i2 = -1;
                            break;
                        } else if (j == jArr[i2]) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 != -1) {
                        if (this.ch != ':') {
                            skipWhitespace();
                        }
                        if (this.ch == ':') {
                            int i3 = this.bp + 1;
                            this.bp = i3;
                            if (i3 >= this.text.length()) {
                                c = 26;
                            } else {
                                c = this.text.charAt(i3);
                            }
                            this.ch = c;
                            if (this.ch == ',') {
                                int i4 = this.bp + 1;
                                this.bp = i4;
                                if (i4 < this.text.length()) {
                                    c4 = this.text.charAt(i4);
                                }
                                this.ch = c4;
                                this.token = 16;
                            } else if (this.ch == ']') {
                                int i5 = this.bp + 1;
                                this.bp = i5;
                                if (i5 < this.text.length()) {
                                    c4 = this.text.charAt(i5);
                                }
                                this.ch = c4;
                                this.token = 15;
                            } else if (this.ch == '}') {
                                int i6 = this.bp + 1;
                                this.bp = i6;
                                if (i6 < this.text.length()) {
                                    c4 = this.text.charAt(i6);
                                }
                                this.ch = c4;
                                this.token = 13;
                            } else if (this.ch < '0' || this.ch > '9') {
                                nextToken(2);
                            } else {
                                this.sp = 0;
                                this.pos = this.bp;
                                scanNumber();
                            }
                        }
                        this.matchStat = 3;
                        return i2;
                    }
                    if (this.ch != ':') {
                        skipWhitespace();
                    }
                    if (this.ch == ':') {
                        int i7 = this.bp + 1;
                        this.bp = i7;
                        if (i7 >= this.text.length()) {
                            c2 = 26;
                        } else {
                            c2 = this.text.charAt(i7);
                        }
                        this.ch = c2;
                        if (!(this.ch == '\"' || this.ch == '\'' || this.ch == '{' || this.ch == '[' || this.ch == '0' || this.ch == '1' || this.ch == '2' || this.ch == '3' || this.ch == '4' || this.ch == '5' || this.ch == '6' || this.ch == '7' || this.ch == '8' || this.ch == '9' || this.ch == '+' || this.ch == '-')) {
                            skipWhitespace();
                        }
                        if (this.ch == '-' || this.ch == '+' || (this.ch >= '0' && this.ch <= '9')) {
                            next();
                            while (this.ch >= '0' && this.ch <= '9') {
                                next();
                            }
                            if (this.ch == '.') {
                                next();
                                while (this.ch >= '0' && this.ch <= '9') {
                                    next();
                                }
                            }
                            if (this.ch == 'E' || this.ch == 'e') {
                                next();
                                if (this.ch == '-' || this.ch == '+') {
                                    next();
                                }
                                while (this.ch >= '0' && this.ch <= '9') {
                                    next();
                                }
                            }
                            if (this.ch != ',') {
                                skipWhitespace();
                            }
                            if (this.ch == ',') {
                                next();
                            }
                        } else if (this.ch == '\"') {
                            skipString();
                            if (!(this.ch == ',' || this.ch == '}')) {
                                skipWhitespace();
                            }
                            if (this.ch == ',') {
                                next();
                            }
                        } else if (this.ch == '{') {
                            int i8 = this.bp + 1;
                            this.bp = i8;
                            if (i8 < this.text.length()) {
                                c4 = this.text.charAt(i8);
                            }
                            this.ch = c4;
                            skipObject(false);
                        } else if (this.ch == '[') {
                            next();
                            skipArray(false);
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        throw new JSONException("illegal json, " + info());
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            }
            next();
            nextToken();
            this.matchStat = -1;
            return -1;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String scanTypeName(SymbolTable symbolTable) {
        int indexOf;
        if (!this.text.startsWith("\"@type\":\"", this.bp) || (indexOf = this.text.indexOf(34, this.bp + 9)) == -1) {
            return null;
        }
        this.bp += 9;
        int i = 0;
        for (int i2 = this.bp; i2 < indexOf; i2++) {
            i = (i * 31) + this.text.charAt(i2);
        }
        String addSymbol = addSymbol(this.bp, indexOf - this.bp, i, symbolTable);
        char charAt = this.text.charAt(indexOf + 1);
        if (!(charAt == ',' || charAt == ']')) {
            return null;
        }
        this.bp = indexOf + 2;
        this.ch = this.text.charAt(this.bp);
        return addSymbol;
    }
}
