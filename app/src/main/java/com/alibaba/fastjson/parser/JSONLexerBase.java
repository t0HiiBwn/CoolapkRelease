package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    protected static final int[] digits = new int[103];
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected int bp;
    protected Calendar calendar = null;
    protected char ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;
    protected int nanos = 0;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected int token;

    public static boolean isWhitespace(char c) {
        return c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b');
    }

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    protected abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    protected abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    protected abstract void copyTo(int i, int i2, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public abstract int indexOf(char c, int i);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanTypeName(SymbolTable symbolTable) {
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i, int i2);

    protected abstract char[] sub_chars(int i, int i2);

    protected void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    static {
        for (int i = 48; i <= 57; i++) {
            digits[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            digits[i2] = (i2 - 97) + 10;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            digits[i3] = (i3 - 65) + 10;
        }
    }

    public JSONLexerBase(int i) {
        this.features = i;
        if ((i & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public final int matchStat() {
        return this.matchStat;
    }

    public void setToken(int i) {
        this.token = i;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c = this.ch;
            if (c == '/') {
                skipComment();
            } else if (c == '\"') {
                scanString();
                return;
            } else if (c == ',') {
                next();
                this.token = 16;
                return;
            } else if (c >= '0' && c <= '9') {
                scanNumber();
                return;
            } else if (c == '-') {
                scanNumber();
                return;
            } else {
                switch (c) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        continue;
                    case '\'':
                        if (isEnabled(Feature.AllowSingleQuotes)) {
                            scanStringSingleQuote();
                            return;
                        }
                        throw new JSONException("Feature.AllowSingleQuotes is false");
                    case '(':
                        next();
                        this.token = 10;
                        return;
                    case ')':
                        next();
                        this.token = 11;
                        return;
                    case '+':
                        next();
                        scanNumber();
                        return;
                    case '.':
                        next();
                        this.token = 25;
                        return;
                    case ':':
                        next();
                        this.token = 17;
                        return;
                    case ';':
                        next();
                        this.token = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        scanIdent();
                        return;
                    case '[':
                        next();
                        this.token = 14;
                        return;
                    case ']':
                        next();
                        this.token = 15;
                        return;
                    case 'f':
                        scanFalse();
                        return;
                    case 'n':
                        scanNullOrNew();
                        return;
                    case 't':
                        scanTrue();
                        return;
                    case 'x':
                        scanHex();
                        return;
                    case '{':
                        next();
                        this.token = 12;
                        return;
                    case '}':
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (!isEOF()) {
                            char c2 = this.ch;
                            if (c2 <= 31 || c2 == 127) {
                                next();
                                continue;
                            } else {
                                lexError("illegal.char", String.valueOf((int) c2));
                                next();
                                return;
                            }
                        } else if (this.token != 20) {
                            this.token = 20;
                            int i = this.bp;
                            this.pos = i;
                            this.eofPos = i;
                            return;
                        } else {
                            throw new JSONException("EOF error");
                        }
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i == 2) {
                char c = this.ch;
                if (c >= '0' && c <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 4) {
                char c2 = this.ch;
                if (c2 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c2 >= '0' && c2 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c2 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c2 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 12) {
                char c3 = this.ch;
                if (c3 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c3 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else if (i != 18) {
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c4 = this.ch;
                            if (c4 == '[') {
                                this.token = 14;
                                next();
                                return;
                            } else if (c4 == '{') {
                                this.token = 12;
                                next();
                                return;
                            }
                            break;
                        case 15:
                            if (this.ch == ']') {
                                this.token = 15;
                                next();
                                return;
                            }
                            break;
                        case 16:
                            char c5 = this.ch;
                            if (c5 == ',') {
                                this.token = 16;
                                next();
                                return;
                            } else if (c5 == '}') {
                                this.token = 13;
                                next();
                                return;
                            } else if (c5 == ']') {
                                this.token = 15;
                                next();
                                return;
                            } else if (c5 == 26) {
                                this.token = 20;
                                return;
                            } else if (c5 == 'n') {
                                scanNullOrNew(false);
                                return;
                            }
                            break;
                    }
                }
                if (this.ch == 26) {
                    this.token = 20;
                    return;
                }
            } else {
                nextIdent();
                return;
            }
            char c6 = this.ch;
            if (c6 == ' ' || c6 == '\n' || c6 == '\r' || c6 == '\t' || c6 == '\f' || c6 == '\b') {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c = this.ch;
        if (c == '_' || c == '$' || Character.isLetter(c)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    public final void nextTokenWithChar(char c) {
        this.sp = 0;
        while (true) {
            char c2 = this.ch;
            if (c2 == c) {
                next();
                nextToken();
                return;
            } else if (c2 == ' ' || c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == '\f' || c2 == '\b') {
                next();
            } else {
                throw new JSONException("not match " + c + " - " + this.ch + ", info : " + info());
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        long j;
        long j2;
        boolean z = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i = this.np;
        int i2 = this.sp + i;
        char c = ' ';
        char charAt = charAt(i2 - 1);
        if (charAt == 'B') {
            i2--;
            c = 'B';
        } else if (charAt == 'L') {
            i2--;
            c = 'L';
        } else if (charAt == 'S') {
            i2--;
            c = 'S';
        }
        if (charAt(this.np) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        long j3 = -922337203685477580L;
        if (i < i2) {
            j2 = (long) (-(charAt(i) - '0'));
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            int charAt2 = charAt(i) - '0';
            if (j2 < j3) {
                return new BigInteger(numberString());
            }
            long j4 = j2 * 10;
            long j5 = (long) charAt2;
            if (j4 < j + j5) {
                return new BigInteger(numberString());
            }
            j2 = j4 - j5;
            i = i3;
            j3 = -922337203685477580L;
        }
        if (!z) {
            long j6 = -j2;
            if (j6 > 2147483647L || c == 'L') {
                return Long.valueOf(j6);
            }
            if (c == 'S') {
                return Short.valueOf((short) ((int) j6));
            }
            if (c == 'B') {
                return Byte.valueOf((byte) ((int) j6));
            }
            return Integer.valueOf((int) j6);
        } else if (i <= this.np + 1) {
            throw new NumberFormatException(numberString());
        } else if (j2 < -2147483648L || c == 'L') {
            return Long.valueOf(j2);
        } else {
            if (c == 'S') {
                return Short.valueOf((short) ((int) j2));
            }
            if (c == 'B') {
                return Byte.valueOf((byte) ((int) j2));
            }
            return Integer.valueOf((int) j2);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i) {
        nextTokenWithChar(':');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        char charAt;
        String numberString = numberString();
        float parseFloat = Float.parseFloat(numberString);
        if ((parseFloat != 0.0f && parseFloat != Float.POSITIVE_INFINITY) || (charAt = numberString.charAt(0)) <= '0' || charAt > '9') {
            return parseFloat;
        }
        throw new JSONException("float overflow : " + numberString);
    }

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z) {
        int config = Feature.config(this.features, feature, z);
        this.features = config;
        if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    public final boolean isEnabled(int i, int i2) {
        return ((this.features & i2) == 0 && (i & i2) == 0) ? false : true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    protected void skipComment() {
        char c;
        next();
        char c2 = this.ch;
        if (c2 == '/') {
            do {
                next();
                c = this.ch;
                if (c == '\n') {
                    next();
                    return;
                }
            } while (c != 26);
        } else if (c2 == '*') {
            next();
            while (true) {
                char c3 = this.ch;
                if (c3 == 26) {
                    return;
                }
                if (c3 == '*') {
                    next();
                    if (this.ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c = this.ch;
        if (c == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        } else if (c == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c == 26) {
            this.token = 20;
            return null;
        } else if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            throw new JSONException("syntax error");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c) {
        String str;
        this.np = this.bp;
        this.sp = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            char next = next();
            if (next == c) {
                this.token = 4;
                if (!z) {
                    int i2 = this.np;
                    str = addSymbol(i2 == -1 ? 0 : i2 + 1, this.sp, i, symbolTable);
                } else {
                    str = symbolTable.addSymbol(this.sbuf, 0, this.sp, i);
                }
                this.sp = 0;
                next();
                return str;
            } else if (next == 26) {
                throw new JSONException("unclosed.str");
            } else if (next == '\\') {
                if (!z) {
                    int i3 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i3 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i3 <= length) {
                            i3 = length;
                        }
                        char[] cArr2 = new char[i3];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                    z = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i = (i * 31) + 34;
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i = (i * 31) + 92;
                            putChar('\\');
                        } else if (next2 == 'b') {
                            i = (i * 31) + 8;
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i = (i * 31) + 10;
                                putChar('\n');
                            } else if (next2 == 'r') {
                                i = (i * 31) + 13;
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i = (i * 31) + 47;
                                        putChar('/');
                                        continue;
                                    case '0':
                                        i = (i * 31) + next2;
                                        putChar(0);
                                        continue;
                                    case '1':
                                        i = (i * 31) + next2;
                                        putChar(1);
                                        continue;
                                    case '2':
                                        i = (i * 31) + next2;
                                        putChar(2);
                                        continue;
                                    case '3':
                                        i = (i * 31) + next2;
                                        putChar(3);
                                        continue;
                                    case '4':
                                        i = (i * 31) + next2;
                                        putChar(4);
                                        continue;
                                    case '5':
                                        i = (i * 31) + next2;
                                        putChar(5);
                                        continue;
                                    case '6':
                                        i = (i * 31) + next2;
                                        putChar(6);
                                        continue;
                                    case '7':
                                        i = (i * 31) + next2;
                                        putChar(7);
                                        continue;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i = (i * 31) + 9;
                                                putChar('\t');
                                                continue;
                                            case 'u':
                                                int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i = (i * 31) + parseInt;
                                                putChar((char) parseInt);
                                                continue;
                                            case 'v':
                                                i = (i * 31) + 11;
                                                putChar(11);
                                                continue;
                                                continue;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char next3 = next();
                                this.ch = next3;
                                char next4 = next();
                                this.ch = next4;
                                int[] iArr = digits;
                                char c2 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i = (i * 31) + c2;
                                putChar(c2);
                            }
                        }
                    }
                    i = (i * 31) + 12;
                    putChar('\f');
                } else {
                    i = (i * 31) + 39;
                    putChar('\'');
                }
            } else {
                i = (i * 31) + next;
                if (!z) {
                    this.sp++;
                } else {
                    int i4 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i4 == cArr3.length) {
                        putChar(next);
                    } else {
                        this.sp = i4 + 1;
                        cArr3[i4] = next;
                    }
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        boolean z = false;
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i = this.ch;
        if (i >= zArr.length || zArr[i]) {
            z = true;
        }
        if (z) {
            boolean[] zArr2 = IOUtils.identifierFlags;
            this.np = this.bp;
            this.sp = 1;
            while (true) {
                char next = next();
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i = (i * 31) + next;
                this.sp++;
            }
            this.ch = charAt(this.bp);
            this.token = 18;
            if (this.sp == 4 && i == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
                return null;
            }
            if (symbolTable == null) {
                return subString(this.np, this.sp);
            }
            return addSymbol(this.np, this.sp, i, symbolTable);
        }
        throw new JSONException("illegal identifier : " + this.ch + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanString() {
        char next;
        char next2;
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next3 = next();
            if (next3 == '\"') {
                this.token = 4;
                this.ch = next();
                return;
            } else if (next3 != 26) {
                boolean z = true;
                if (next3 == '\\') {
                    if (!this.hasSpecial) {
                        this.hasSpecial = true;
                        int i = this.sp;
                        char[] cArr = this.sbuf;
                        if (i >= cArr.length) {
                            int length = cArr.length * 2;
                            if (i <= length) {
                                i = length;
                            }
                            char[] cArr2 = new char[i];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            this.sbuf = cArr2;
                        }
                        copyTo(this.np + 1, this.sp, this.sbuf);
                    }
                    char next4 = next();
                    if (next4 == '\"') {
                        putChar('\"');
                    } else if (next4 != '\'') {
                        if (next4 != 'F') {
                            if (next4 == '\\') {
                                putChar('\\');
                            } else if (next4 == 'b') {
                                putChar('\b');
                            } else if (next4 != 'f') {
                                if (next4 == 'n') {
                                    putChar('\n');
                                } else if (next4 == 'r') {
                                    putChar('\r');
                                } else if (next4 != 'x') {
                                    switch (next4) {
                                        case '/':
                                            putChar('/');
                                            continue;
                                        case '0':
                                            putChar(0);
                                            continue;
                                        case '1':
                                            putChar(1);
                                            continue;
                                        case '2':
                                            putChar(2);
                                            continue;
                                        case '3':
                                            putChar(3);
                                            continue;
                                        case '4':
                                            putChar(4);
                                            continue;
                                        case '5':
                                            putChar(5);
                                            continue;
                                        case '6':
                                            putChar(6);
                                            continue;
                                        case '7':
                                            putChar(7);
                                            continue;
                                        default:
                                            switch (next4) {
                                                case 't':
                                                    putChar('\t');
                                                    continue;
                                                case 'u':
                                                    putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                    continue;
                                                case 'v':
                                                    putChar(11);
                                                    continue;
                                                    continue;
                                                default:
                                                    this.ch = next4;
                                                    throw new JSONException("unclosed string : " + next4);
                                            }
                                    }
                                } else {
                                    next = next();
                                    next2 = next();
                                    boolean z2 = (next >= '0' && next <= '9') || (next >= 'a' && next <= 'f') || (next >= 'A' && next <= 'F');
                                    if ((next2 < '0' || next2 > '9') && ((next2 < 'a' || next2 > 'f') && (next2 < 'A' || next2 > 'F'))) {
                                        z = false;
                                    }
                                    if (z2 && z) {
                                        int[] iArr = digits;
                                        putChar((char) ((iArr[next] * 16) + iArr[next2]));
                                    }
                                }
                            }
                        }
                        putChar('\f');
                    } else {
                        putChar('\'');
                    }
                } else if (!this.hasSpecial) {
                    this.sp++;
                } else {
                    int i2 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i2 == cArr3.length) {
                        putChar(next3);
                    } else {
                        this.sp = i2 + 1;
                        cArr3[i2] = next3;
                    }
                }
            } else if (!isEOF()) {
                putChar(26);
            } else {
                throw new JSONException("unclosed string : " + next3);
            }
        }
        throw new JSONException("invalid escape character \\x" + next + next2);
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone2) {
        this.timeZone = timeZone2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale2) {
        this.locale = locale2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        boolean z;
        int i;
        int i2;
        int i3 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i4 = this.np;
        int i5 = this.sp + i4;
        if (charAt(i4) == '-') {
            i = Integer.MIN_VALUE;
            i4++;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i4 < i5) {
            i3 = -(charAt(i4) - '0');
            i4++;
        }
        while (true) {
            if (i4 >= i5) {
                break;
            }
            i2 = i4 + 1;
            char charAt = charAt(i4);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                break;
            }
            int i6 = charAt - '0';
            if (((long) i3) >= -214748364) {
                int i7 = i3 * 10;
                if (i7 >= i + i6) {
                    i3 = i7 - i6;
                    i4 = i2;
                } else {
                    throw new NumberFormatException(numberString());
                }
            } else {
                throw new NumberFormatException(numberString());
            }
        }
        i4 = i2;
        if (!z) {
            return -i3;
        }
        if (i4 > this.np + 1) {
            return i3;
        }
        throw new NumberFormatException(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        if (this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f') {
            return true;
        }
        return false;
    }

    public final int scanType(String str) {
        this.matchStat = 0;
        char[] cArr = typeFieldName;
        if (!charArrayCompare(cArr)) {
            return -2;
        }
        int length = this.bp + cArr.length;
        int length2 = str.length();
        for (int i = 0; i < length2; i++) {
            if (str.charAt(i) != charAt(length + i)) {
                return -1;
            }
        }
        int i2 = length + length2;
        if (charAt(i2) != '\"') {
            return -1;
        }
        int i3 = i2 + 1;
        char charAt = charAt(i3);
        this.ch = charAt;
        if (charAt == ',') {
            int i4 = i3 + 1;
            this.ch = charAt(i4);
            this.bp = i4;
            this.token = 16;
            return 3;
        }
        if (charAt == '}') {
            i3++;
            char charAt2 = charAt(i3);
            this.ch = charAt2;
            if (charAt2 == ',') {
                this.token = 16;
                i3++;
                this.ch = charAt(i3);
            } else if (charAt2 == ']') {
                this.token = 15;
                i3++;
                this.ch = charAt(i3);
            } else if (charAt2 == '}') {
                this.token = 13;
                i3++;
                this.ch = charAt(i3);
            } else if (charAt2 != 26) {
                return -1;
            } else {
                this.token = 20;
            }
            this.matchStat = 4;
        }
        this.bp = i3;
        return this.matchStat;
    }

    public final boolean matchField(char[] cArr) {
        while (!charArrayCompare(cArr)) {
            if (!isWhitespace(this.ch)) {
                return false;
            }
            next();
        }
        int length = this.bp + cArr.length;
        this.bp = length;
        char charAt = charAt(length);
        this.ch = charAt;
        if (charAt == '{') {
            next();
            this.token = 12;
        } else if (charAt == '[') {
            next();
            this.token = 14;
        } else if (charAt == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
            int i = this.bp + 3;
            this.bp = i;
            this.ch = charAt(i);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public int matchField(long j) {
        throw new UnsupportedOperationException();
    }

    public boolean seekArrayToItem(int i) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToField(long j, boolean z) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToField(long[] jArr) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToFieldDeepScan(long j) {
        throw new UnsupportedOperationException();
    }

    public void skipObject() {
        throw new UnsupportedOperationException();
    }

    public void skipObject(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void skipArray() {
        throw new UnsupportedOperationException();
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (indexOf != -1) {
            int length2 = this.bp + cArr.length + 1;
            String subString = subString(length2, indexOf - length2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i2 = indexOf - 1;
                    int i3 = 0;
                    while (i2 >= 0 && charAt(i2) == '\\') {
                        i3++;
                        i2--;
                    }
                    if (i3 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i4 = this.bp;
                int length3 = indexOf - ((cArr.length + i4) + 1);
                subString = readString(sub_chars(i4 + cArr.length + 1, length3), length3);
            }
            int i5 = this.bp;
            int length4 = i + (indexOf - ((cArr.length + i5) + 1)) + 1;
            int i6 = length4 + 1;
            char charAt = charAt(i5 + length4);
            if (charAt == ',') {
                int i7 = this.bp + i6;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return subString;
            } else if (charAt == '}') {
                int i8 = i6 + 1;
                char charAt2 = charAt(this.bp + i6);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i9 = this.bp + i8;
                    this.bp = i9;
                    this.ch = charAt(i9);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i10 = this.bp + i8;
                    this.bp = i10;
                    this.ch = charAt(i10);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i11 = this.bp + i8;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.bp += i8 - 1;
                    this.ch = 26;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
                this.matchStat = 4;
                return subString;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        } else {
            throw new JSONException("unclosed str");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c) {
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt != 'n') {
            int i = 1;
            while (charAt != '\"') {
                if (isWhitespace(charAt)) {
                    charAt = charAt(this.bp + i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            int i2 = this.bp + i;
            int indexOf = indexOf('\"', i2);
            if (indexOf != -1) {
                String subString = subString(this.bp + i, indexOf - i2);
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
                    int i5 = indexOf - i2;
                    subString = readString(sub_chars(this.bp + 1, i5), i5);
                }
                int i6 = i + (indexOf - i2) + 1;
                int i7 = i6 + 1;
                char charAt2 = charAt(this.bp + i6);
                while (charAt2 != c) {
                    if (isWhitespace(charAt2)) {
                        charAt2 = charAt(this.bp + i7);
                        i7++;
                    } else {
                        if (charAt2 == ']') {
                            int i8 = this.bp + i7;
                            this.bp = i8;
                            this.ch = charAt(i8);
                            this.matchStat = -1;
                        }
                        return subString;
                    }
                }
                int i9 = this.bp + i7;
                this.bp = i9;
                this.ch = charAt(i9);
                this.matchStat = 3;
                this.token = 16;
                return subString;
            }
            throw new JSONException("unclosed str");
        } else if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 1 + 1) != 'l' || charAt(this.bp + 1 + 2) != 'l') {
            this.matchStat = -1;
            return null;
        } else if (charAt(this.bp + 4) == c) {
            int i10 = this.bp + 5;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(this.bp + i);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                char charAt2 = charAt(this.bp + i2);
                if (charAt2 == ',') {
                    int i4 = this.bp + i3;
                    this.bp = i4;
                    this.ch = charAt(i4);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i5 = i3 + 1;
                    char charAt3 = charAt(this.bp + i3);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i6 = this.bp + i5;
                        this.bp = i6;
                        this.ch = charAt(i6);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i7 = this.bp + i5;
                        this.bp = i7;
                        this.ch = charAt(i7);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i8 = this.bp + i5;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i5 - 1;
                        this.ch = 26;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.matchStat = 4;
                    return j;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            } else {
                j = (j ^ ((long) charAt)) * 1099511628211L;
                if (charAt == '\\') {
                    this.matchStat = -1;
                    return 0;
                }
                i = i2;
            }
        }
    }

    public long scanEnumSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(this.bp + i);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                char charAt2 = charAt(this.bp + i2);
                if (charAt2 == ',') {
                    int i4 = this.bp + i3;
                    this.bp = i4;
                    this.ch = charAt(i4);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i5 = i3 + 1;
                    char charAt3 = charAt(this.bp + i3);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i6 = this.bp + i5;
                        this.bp = i6;
                        this.ch = charAt(i6);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i7 = this.bp + i5;
                        this.bp = i7;
                        this.ch = charAt(i7);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i8 = this.bp + i5;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i5 - 1;
                        this.ch = 26;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.matchStat = 4;
                    return j;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            } else {
                j = (j ^ ((long) ((charAt < 'A' || charAt > 'Z') ? charAt : charAt + ' '))) * 1099511628211L;
                if (charAt == '\\') {
                    this.matchStat = -1;
                    return 0;
                }
                i = i2;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c) {
        String scanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c);
        if (scanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, scanSymbolWithSeperator);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c) {
        int i = 0;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 1 + 1) != 'l' || charAt(this.bp + 1 + 2) != 'l') {
                this.matchStat = -1;
                return null;
            } else if (charAt(this.bp + 4) == c) {
                int i2 = this.bp + 5;
                this.bp = i2;
                this.ch = charAt(i2);
                this.matchStat = 3;
                return null;
            } else {
                this.matchStat = -1;
                return null;
            }
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        } else {
            int i3 = 1;
            while (true) {
                int i4 = i3 + 1;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == '\"') {
                    int i5 = this.bp;
                    int i6 = i5 + 0 + 1;
                    String addSymbol = addSymbol(i6, ((i5 + i4) - i6) - 1, i, symbolTable);
                    int i7 = i4 + 1;
                    char charAt3 = charAt(this.bp + i4);
                    while (charAt3 != c) {
                        if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i7);
                            i7++;
                        } else {
                            this.matchStat = -1;
                            return addSymbol;
                        }
                    }
                    int i8 = this.bp + i7;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 3;
                    return addSymbol;
                }
                i = (i * 31) + charAt2;
                if (charAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i3 = i4;
            }
        }
    }

    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(LinkedList.class)) {
            return new LinkedList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        char c;
        int i;
        int i2;
        char c2;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> newCollectionByType = newCollectionByType(cls);
        int length = cArr.length;
        int i3 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i4 = i3 + 1;
        char charAt = charAt(this.bp + i3);
        while (true) {
            if (charAt == '\"') {
                int indexOf = indexOf('\"', this.bp + i4);
                if (indexOf != -1) {
                    int i5 = this.bp + i4;
                    String subString = subString(i5, indexOf - i5);
                    if (subString.indexOf(92) != -1) {
                        while (true) {
                            int i6 = indexOf - 1;
                            int i7 = 0;
                            while (i6 >= 0 && charAt(i6) == '\\') {
                                i7++;
                                i6--;
                            }
                            if (i7 % 2 == 0) {
                                break;
                            }
                            indexOf = indexOf('\"', indexOf + 1);
                        }
                        int i8 = this.bp;
                        int i9 = indexOf - (i8 + i4);
                        subString = readString(sub_chars(i8 + i4, i9), i9);
                    }
                    int i10 = this.bp;
                    int i11 = i4 + (indexOf - (i10 + i4)) + 1;
                    i2 = i11 + 1;
                    c2 = charAt(i10 + i11);
                    newCollectionByType.add(subString);
                } else {
                    throw new JSONException("unclosed str");
                }
            } else if (charAt != 'n' || charAt(this.bp + i4) != 'u' || charAt(this.bp + i4 + 1) != 'l' || charAt(this.bp + i4 + 2) != 'l') {
                break;
            } else {
                int i12 = i4 + 3;
                int i13 = i12 + 1;
                c2 = charAt(this.bp + i12);
                newCollectionByType.add(null);
                i2 = i13;
            }
            if (c2 == ',') {
                int i14 = i2 + 1;
                charAt = charAt(this.bp + i2);
                i4 = i14;
            } else if (c2 == ']') {
                i = i2 + 1;
                c = charAt(this.bp + i2);
            } else {
                this.matchStat = -1;
                return null;
            }
        }
        if (charAt == ']' && newCollectionByType.size() == 0) {
            c = charAt(this.bp + i4);
            i = i4 + 1;
            if (c == ',') {
                int i15 = this.bp + i;
                this.bp = i15;
                this.ch = charAt(i15);
                this.matchStat = 3;
                return newCollectionByType;
            } else if (c == '}') {
                int i16 = i + 1;
                char charAt2 = charAt(this.bp + i);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i17 = this.bp + i16;
                    this.bp = i17;
                    this.ch = charAt(i17);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i18 = this.bp + i16;
                    this.bp = i18;
                    this.ch = charAt(i18);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i19 = this.bp + i16;
                    this.bp = i19;
                    this.ch = charAt(i19);
                } else if (charAt2 == 26) {
                    this.bp += i16 - 1;
                    this.token = 20;
                    this.ch = 26;
                } else {
                    this.matchStat = -1;
                    return null;
                }
                this.matchStat = 4;
                return newCollectionByType;
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            throw new JSONException("illega str");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void scanStringArray(Collection<String> collection, char c) {
        int i;
        char c2;
        int i2;
        char c3;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        char c4 = 'u';
        char c5 = 'n';
        if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l' && charAt(this.bp + 1 + 3) == c) {
            int i3 = this.bp + 5;
            this.bp = i3;
            this.ch = charAt(i3);
            this.matchStat = 5;
        } else if (charAt != '[') {
            this.matchStat = -1;
        } else {
            char charAt2 = charAt(this.bp + 1);
            int i4 = 2;
            while (true) {
                if (charAt2 != c5 || charAt(this.bp + i4) != c4 || charAt(this.bp + i4 + 1) != 'l' || charAt(this.bp + i4 + 2) != 'l') {
                    if (charAt2 == ']' && collection.size() == 0) {
                        i = i4 + 1;
                        c2 = charAt(this.bp + i4);
                        break;
                    } else if (charAt2 != '\"') {
                        this.matchStat = -1;
                        return;
                    } else {
                        int i5 = this.bp + i4;
                        int indexOf = indexOf('\"', i5);
                        if (indexOf != -1) {
                            String subString = subString(this.bp + i4, indexOf - i5);
                            if (subString.indexOf(92) != -1) {
                                while (true) {
                                    int i6 = indexOf - 1;
                                    int i7 = 0;
                                    while (i6 >= 0 && charAt(i6) == '\\') {
                                        i7++;
                                        i6--;
                                    }
                                    if (i7 % 2 == 0) {
                                        break;
                                    }
                                    indexOf = indexOf('\"', indexOf + 1);
                                }
                                int i8 = indexOf - i5;
                                subString = readString(sub_chars(this.bp + i4, i8), i8);
                            }
                            int i9 = this.bp;
                            int i10 = i4 + (indexOf - (i9 + i4)) + 1;
                            i2 = i10 + 1;
                            c3 = charAt(i9 + i10);
                            collection.add(subString);
                        } else {
                            throw new JSONException("unclosed str");
                        }
                    }
                } else {
                    int i11 = i4 + 3;
                    i2 = i11 + 1;
                    c3 = charAt(this.bp + i11);
                    collection.add(null);
                }
                if (c3 == ',') {
                    i4 = i2 + 1;
                    charAt2 = charAt(this.bp + i2);
                    c4 = 'u';
                    c5 = 'n';
                } else if (c3 == ']') {
                    i = i2 + 1;
                    c2 = charAt(this.bp + i2);
                } else {
                    this.matchStat = -1;
                    return;
                }
            }
            if (c2 == c) {
                int i12 = this.bp + i;
                this.bp = i12;
                this.ch = charAt(i12);
                this.matchStat = 3;
                return;
            }
            this.matchStat = -1;
        }
    }

    public int scanFieldInt(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        boolean z = charAt2 == '-';
        if (z) {
            charAt2 = charAt(this.bp + i2);
            i2++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i3 = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i3 = (i3 * 10) + (charAt - '0');
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if ((i3 < 0 || i > cArr.length + 14) && !(i3 == Integer.MIN_VALUE && i == 17 && z)) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i4 = this.bp + i;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z ? -i3 : i3;
        } else if (charAt == '}') {
            int i5 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i6 = this.bp + i5;
                this.bp = i6;
                this.ch = charAt(i6);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i7 = this.bp + i5;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i8 = this.bp + i5;
                this.bp = i8;
                this.ch = charAt(i8);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i5 - 1;
                this.ch = 26;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z ? -i3 : i3;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        int i;
        int i2;
        char c;
        boolean z;
        int i3;
        char charAt;
        this.matchStat = 0;
        int[] iArr = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i5 = i4 + 1;
        char charAt2 = charAt(this.bp + i4);
        int[] iArr2 = new int[16];
        if (charAt2 == ']') {
            i = i5 + 1;
            c = charAt(this.bp + i5);
            i2 = 0;
        } else {
            int i6 = 0;
            while (true) {
                if (charAt2 == '-') {
                    charAt2 = charAt(this.bp + i5);
                    i5++;
                    z = true;
                } else {
                    z = false;
                }
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                int i7 = charAt2 - '0';
                while (true) {
                    i3 = i5 + 1;
                    charAt = charAt(this.bp + i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i7 = (i7 * 10) + (charAt - '0');
                    i5 = i3;
                }
                if (i6 >= iArr2.length) {
                    int[] iArr3 = new int[((iArr2.length * 3) / 2)];
                    System.arraycopy(iArr2, 0, iArr3, 0, i6);
                    iArr2 = iArr3;
                }
                i2 = i6 + 1;
                if (z) {
                    i7 = -i7;
                }
                iArr2[i6] = i7;
                if (charAt == ',') {
                    i3++;
                    charAt = charAt(this.bp + i3);
                } else if (charAt == ']') {
                    i = i3 + 1;
                    c = charAt(this.bp + i3);
                    break;
                }
                i6 = i2;
                iArr = null;
                charAt2 = charAt;
                i5 = i3;
            }
            this.matchStat = -1;
            return iArr;
        }
        if (i2 != iArr2.length) {
            int[] iArr4 = new int[i2];
            System.arraycopy(iArr2, 0, iArr4, 0, i2);
            iArr2 = iArr4;
        }
        if (c == ',') {
            this.bp += i - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr2;
        } else if (c == '}') {
            int i8 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                this.bp += i8 - 1;
                next();
            } else if (charAt3 == ']') {
                this.token = 15;
                this.bp += i8 - 1;
                next();
            } else if (charAt3 == '}') {
                this.token = 13;
                this.bp += i8 - 1;
                next();
            } else if (charAt3 == 26) {
                this.bp += i8 - 1;
                this.token = 20;
                this.ch = 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr2;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean scanBoolean(char c) {
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i = 5;
        if (charAt == 't') {
            if (charAt(this.bp + 1) == 'r' && charAt(this.bp + 1 + 1) == 'u' && charAt(this.bp + 1 + 2) == 'e') {
                charAt = charAt(this.bp + 4);
                z = true;
            } else {
                this.matchStat = -1;
                return false;
            }
        } else if (charAt != 'f') {
            if (charAt == '1') {
                charAt = charAt(this.bp + 1);
                z = true;
            } else if (charAt == '0') {
                charAt = charAt(this.bp + 1);
            } else {
                i = 1;
            }
            i = 2;
        } else if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 's' && charAt(this.bp + 1 + 3) == 'e') {
            charAt = charAt(this.bp + 5);
            i = 6;
        } else {
            this.matchStat = -1;
            return false;
        }
        while (charAt != c) {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.bp + i);
                i++;
            } else {
                this.matchStat = -1;
                return z;
            }
        }
        int i2 = this.bp + i;
        this.bp = i2;
        this.ch = charAt(i2);
        this.matchStat = 3;
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e0  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c) {
        int i;
        int i2;
        int i3;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z = charAt2 == '\"';
        if (z) {
            charAt2 = charAt(this.bp + 1);
            i = 2;
        } else {
            i = 1;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            charAt2 = charAt(this.bp + i);
            i++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i4 = charAt2 - '0';
            while (true) {
                i3 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i4 = (i4 * 10) + (charAt - '0');
                i = i3;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            } else if (i4 < 0) {
                this.matchStat = -1;
                return 0;
            } else {
                while (charAt != c) {
                    if (isWhitespace(charAt)) {
                        i3++;
                        charAt = charAt(this.bp + i3);
                    } else {
                        this.matchStat = -1;
                        return z2 ? -i4 : i4;
                    }
                }
                int i5 = this.bp + i3;
                this.bp = i5;
                this.ch = charAt(i5);
                this.matchStat = 3;
                this.token = 16;
                return z2 ? -i4 : i4;
            }
        } else if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i6 = i + 3;
            int i7 = i6 + 1;
            char charAt3 = charAt(this.bp + i6);
            if (z && charAt3 == '\"') {
                i2 = i7 + 1;
                charAt3 = charAt(this.bp + i7);
                i7 = i2;
            }
            if (charAt3 != ',') {
                if (charAt3 != ']') {
                    if (isWhitespace(charAt3)) {
                        i2 = i7 + 1;
                        charAt3 = charAt(this.bp + i7);
                        i7 = i2;
                        if (charAt3 != ',') {
                        }
                    }
                    this.matchStat = -1;
                    return 0;
                }
                int i8 = this.bp + i7;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 5;
                this.token = 15;
                return 0;
            }
            int i9 = this.bp + i7;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 5;
            this.token = 16;
            return 0;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public boolean scanFieldBoolean(char[] cArr) {
        boolean z;
        int i;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt = charAt(this.bp + length);
        if (charAt == 't') {
            int i3 = i2 + 1;
            if (charAt(this.bp + i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i4 = i3 + 1;
            if (charAt(this.bp + i3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i = i4 + 1;
            if (charAt(this.bp + i4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = true;
        } else if (charAt == 'f') {
            int i5 = i2 + 1;
            if (charAt(this.bp + i2) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (charAt(this.bp + i5) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i7 = i6 + 1;
            if (charAt(this.bp + i6) != 's') {
                this.matchStat = -1;
                return false;
            }
            int i8 = i7 + 1;
            if (charAt(this.bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            i = i8;
            z = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        int i9 = i + 1;
        char charAt2 = charAt(this.bp + i);
        if (charAt2 == ',') {
            int i10 = this.bp + i9;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            this.token = 16;
            return z;
        } else if (charAt2 == '}') {
            int i11 = i9 + 1;
            char charAt3 = charAt(this.bp + i9);
            if (charAt3 == ',') {
                this.token = 16;
                int i12 = this.bp + i11;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i13 = this.bp + i11;
                this.bp = i13;
                this.ch = charAt(i13);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i14 = this.bp + i11;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i11 - 1;
                this.ch = 26;
            } else {
                this.matchStat = -1;
                return false;
            }
            this.matchStat = 4;
            return z;
        } else {
            this.matchStat = -1;
            return false;
        }
    }

    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i2);
            i2++;
            z = true;
        } else {
            z = false;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        long j = (long) (charAt2 - '0');
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j = (j * 10) + ((long) (charAt - '0'));
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (!(i - cArr.length < 21 && (j >= 0 || (j == Long.MIN_VALUE && z)))) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i3 = this.bp + i;
            this.bp = i3;
            this.ch = charAt(i3);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        } else if (charAt == '}') {
            int i4 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i5 = this.bp + i4;
                this.bp = i5;
                this.ch = charAt(i5);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i6 = this.bp + i4;
                this.bp = i6;
                this.ch = charAt(i6);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i7 = this.bp + i4;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i4 - 1;
                this.ch = 26;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z ? -j : j;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x011d  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        int i2;
        int i3;
        char charAt;
        char c2;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z = charAt2 == '\"';
        if (z) {
            charAt2 = charAt(this.bp + 1);
            i = 2;
        } else {
            i = 1;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            charAt2 = charAt(this.bp + i);
            i++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = (long) (charAt2 - '0');
            while (true) {
                i3 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + ((long) (charAt - '0'));
                i = i3;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            }
            if (j >= 0 || (j == Long.MIN_VALUE && z2)) {
                if (!z) {
                    c2 = c;
                } else if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0;
                } else {
                    charAt = charAt(this.bp + i3);
                    c2 = c;
                    i3++;
                }
                while (charAt != c2) {
                    if (isWhitespace(charAt)) {
                        charAt = charAt(this.bp + i3);
                        i3++;
                    } else {
                        this.matchStat = -1;
                        return j;
                    }
                }
                int i4 = this.bp + i3;
                this.bp = i4;
                this.ch = charAt(i4);
                this.matchStat = 3;
                this.token = 16;
                return z2 ? -j : j;
            }
            throw new NumberFormatException(subString(this.bp, i3 - 1));
        } else if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i5 = i + 3;
            int i6 = i5 + 1;
            char charAt3 = charAt(this.bp + i5);
            if (z && charAt3 == '\"') {
                i2 = i6 + 1;
                charAt3 = charAt(this.bp + i6);
                i6 = i2;
            }
            if (charAt3 != ',') {
                if (charAt3 != ']') {
                    if (isWhitespace(charAt3)) {
                        i2 = i6 + 1;
                        charAt3 = charAt(this.bp + i6);
                        i6 = i2;
                        if (charAt3 != ',') {
                        }
                    }
                    this.matchStat = -1;
                    return 0;
                }
                int i7 = this.bp + i6;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 5;
                this.token = 15;
                return 0;
            }
            int i8 = this.bp + i6;
            this.bp = i8;
            this.ch = charAt(i8);
            this.matchStat = 5;
            this.token = 16;
            return 0;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    public final float scanFieldFloat(char[] r22) {
        /*
        // Method dump skipped, instructions count: 563
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloat(char[]):float");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final float scanFloat(char r23) {
        /*
        // Method dump skipped, instructions count: 432
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFloat(char):float");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public double scanDouble(char r21) {
        /*
        // Method dump skipped, instructions count: 437
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDouble(char):double");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public java.math.BigDecimal scanDecimal(char r19) {
        /*
        // Method dump skipped, instructions count: 470
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDecimal(char):java.math.BigDecimal");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    public final float[] scanFieldFloatArray(char[] r20) {
        /*
        // Method dump skipped, instructions count: 450
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray(char[]):float[]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    public final float[][] scanFieldFloatArray2(char[] r22) {
        /*
        // Method dump skipped, instructions count: 546
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray2(char[]):float[][]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    public final double scanFieldDouble(char[] r24) {
        /*
        // Method dump skipped, instructions count: 564
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDouble(char[]):double");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    public java.math.BigDecimal scanFieldDecimal(char[] r19) {
        /*
        // Method dump skipped, instructions count: 493
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDecimal(char[]):java.math.BigDecimal");
    }

    public BigInteger scanFieldBigInteger(char[] cArr) {
        int i;
        char charAt;
        boolean z;
        int i2;
        int i3;
        BigInteger bigInteger;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        char charAt2 = charAt(this.bp + length);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            charAt2 = charAt(this.bp + i4);
            i4++;
        }
        boolean z3 = charAt2 == '-';
        if (z3) {
            charAt2 = charAt(this.bp + i4);
            i4++;
        }
        if (charAt2 >= '0') {
            char c = '9';
            if (charAt2 <= '9') {
                long j = (long) (charAt2 - '0');
                while (true) {
                    i = i4 + 1;
                    charAt = charAt(this.bp + i4);
                    if (charAt < '0' || charAt > c) {
                        break;
                    }
                    long j2 = (10 * j) + ((long) (charAt - '0'));
                    if (j2 < j) {
                        z = true;
                        break;
                    }
                    j = j2;
                    i4 = i;
                    c = '9';
                }
                z = false;
                if (!z2) {
                    int i5 = this.bp;
                    i3 = cArr.length + i5;
                    i2 = ((i5 + i) - i3) - 1;
                } else if (charAt != '\"') {
                    this.matchStat = -1;
                    return null;
                } else {
                    int i6 = i + 1;
                    charAt = charAt(this.bp + i);
                    int i7 = this.bp;
                    i3 = cArr.length + i7 + 1;
                    i2 = ((i7 + i6) - i3) - 2;
                    i = i6;
                }
                if (z || (i2 >= 20 && (!z3 || i2 >= 21))) {
                    bigInteger = new BigInteger(subString(i3, i2));
                } else {
                    if (z3) {
                        j = -j;
                    }
                    bigInteger = BigInteger.valueOf(j);
                }
                if (charAt == ',') {
                    int i8 = this.bp + i;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 3;
                    this.token = 16;
                    return bigInteger;
                } else if (charAt == '}') {
                    int i9 = i + 1;
                    char charAt3 = charAt(this.bp + i);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i10 = this.bp + i9;
                        this.bp = i10;
                        this.ch = charAt(i10);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i11 = this.bp + i9;
                        this.bp = i11;
                        this.ch = charAt(i11);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i12 = this.bp + i9;
                        this.bp = i12;
                        this.ch = charAt(i12);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i9 - 1;
                        this.ch = 26;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                    this.matchStat = 4;
                    return bigInteger;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
        }
        if (charAt2 == 'n' && charAt(this.bp + i4) == 'u' && charAt(this.bp + i4 + 1) == 'l' && charAt(this.bp + i4 + 2) == 'l') {
            this.matchStat = 5;
            int i13 = i4 + 3;
            int i14 = i13 + 1;
            char charAt4 = charAt(this.bp + i13);
            if (z2 && charAt4 == '\"') {
                charAt4 = charAt(this.bp + i14);
                i14++;
            }
            while (charAt4 != ',') {
                if (charAt4 == '}') {
                    int i15 = this.bp + i14;
                    this.bp = i15;
                    this.ch = charAt(i15);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                } else if (isWhitespace(charAt4)) {
                    charAt4 = charAt(this.bp + i14);
                    i14++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            int i16 = this.bp + i14;
            this.bp = i16;
            this.ch = charAt(i16);
            this.matchStat = 5;
            this.token = 16;
            return null;
        }
        this.matchStat = -1;
        return null;
    }

    public Date scanFieldDate(char[] cArr) {
        Date date;
        int i;
        long j;
        int i2;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr.length + 1;
                String subString = subString(length2, indexOf - length2);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i4 = indexOf - 1;
                        int i5 = 0;
                        while (i4 >= 0 && charAt(i4) == '\\') {
                            i5++;
                            i4--;
                        }
                        if (i5 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i6 = this.bp;
                    int length3 = indexOf - ((cArr.length + i6) + 1);
                    subString = readString(sub_chars(i6 + cArr.length + 1, length3), length3);
                }
                int i7 = this.bp;
                int length4 = i3 + (indexOf - ((cArr.length + i7) + 1)) + 1;
                i = length4 + 1;
                charAt2 = charAt(i7 + length4);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                    } else {
                        this.matchStat = -1;
                        jSONScanner.close();
                        return null;
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt2 == '-' || (charAt2 >= '0' && charAt2 <= '9')) {
            if (charAt2 == '-') {
                charAt2 = charAt(this.bp + i3);
                i3++;
                z = true;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                i = i3;
                j = 0;
            } else {
                j = (long) (charAt2 - '0');
                while (true) {
                    i2 = i3 + 1;
                    charAt = charAt(this.bp + i3);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j = (j * 10) + ((long) (charAt - '0'));
                    i3 = i2;
                }
                charAt2 = charAt;
                i = i2;
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        } else {
            this.matchStat = -1;
            return null;
        }
        if (charAt2 == ',') {
            int i8 = this.bp + i;
            this.bp = i8;
            this.ch = charAt(i8);
            this.matchStat = 3;
            return date;
        } else if (charAt2 == '}') {
            int i9 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i10 = this.bp + i9;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i11 = this.bp + i9;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i12 = this.bp + i9;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i9 - 1;
                this.ch = 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    public Date scanDate(char c) {
        Date date;
        int i;
        long j;
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i2 = 5;
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf != -1) {
                int i3 = this.bp + 1;
                String subString = subString(i3, indexOf - i3);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i4 = indexOf - 1;
                        int i5 = 0;
                        while (i4 >= 0 && charAt(i4) == '\\') {
                            i5++;
                            i4--;
                        }
                        if (i5 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i6 = this.bp;
                    int i7 = indexOf - (i6 + 1);
                    subString = readString(sub_chars(i6 + 1, i7), i7);
                }
                int i8 = this.bp;
                int i9 = (indexOf - (i8 + 1)) + 1 + 1;
                int i10 = i9 + 1;
                charAt = charAt(i8 + i9);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                        jSONScanner.close();
                        i2 = i10;
                    } else {
                        this.matchStat = -1;
                        jSONScanner.close();
                        return null;
                    }
                } catch (Throwable th) {
                    jSONScanner.close();
                    throw th;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c2 = '9';
            int i11 = 2;
            if (charAt == '-' || (charAt >= '0' && charAt <= '9')) {
                if (charAt == '-') {
                    charAt = charAt(this.bp + 1);
                    z = true;
                } else {
                    i11 = 1;
                }
                if (charAt >= '0' && charAt <= '9') {
                    j = (long) (charAt - '0');
                    while (true) {
                        i = i11 + 1;
                        charAt = charAt(this.bp + i11);
                        if (charAt < '0' || charAt > c2) {
                            break;
                        }
                        j = (j * 10) + ((long) (charAt - '0'));
                        i11 = i;
                        c2 = '9';
                    }
                } else {
                    j = 0;
                    i = i11;
                }
                if (j < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                date = new Date(j);
                i2 = i;
            } else if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                this.matchStat = 5;
                charAt = charAt(this.bp + 4);
                date = null;
            } else {
                this.matchStat = -1;
                return null;
            }
        }
        if (charAt == ',') {
            int i12 = this.bp + i2;
            this.bp = i12;
            this.ch = charAt(i12);
            this.matchStat = 3;
            this.token = 16;
            return date;
        } else if (charAt == ']') {
            int i13 = i2 + 1;
            char charAt2 = charAt(this.bp + i2);
            if (charAt2 == ',') {
                this.token = 16;
                int i14 = this.bp + i13;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i15 = this.bp + i13;
                this.bp = i15;
                this.ch = charAt(i15);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i16 = this.bp + i13;
                this.bp = i16;
                this.ch = charAt(i16);
            } else if (charAt2 == 26) {
                this.token = 20;
                this.bp += i13 - 1;
                this.ch = 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public UUID scanFieldUUID(char[] cArr) {
        char c;
        UUID uuid;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i15 = length + 1;
        char charAt = charAt(this.bp + length);
        char c2 = 4;
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr.length + 1;
                int i16 = indexOf - length2;
                char c3 = 'F';
                char c4 = 'f';
                char c5 = 'A';
                char c6 = '0';
                if (i16 == 36) {
                    int i17 = 0;
                    long j = 0;
                    while (i17 < 8) {
                        char charAt2 = charAt(length2 + i17);
                        if (charAt2 < '0' || charAt2 > '9') {
                            if (charAt2 >= 'a' && charAt2 <= 'f') {
                                i14 = charAt2 - 'a';
                            } else if (charAt2 < 'A' || charAt2 > c3) {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i14 = charAt2 - 'A';
                            }
                            i13 = i14 + 10;
                        } else {
                            i13 = charAt2 - '0';
                        }
                        j = (j << 4) | ((long) i13);
                        i17++;
                        indexOf = indexOf;
                        c3 = 'F';
                    }
                    int i18 = 9;
                    int i19 = 13;
                    while (i18 < i19) {
                        char charAt3 = charAt(length2 + i18);
                        if (charAt3 < '0' || charAt3 > '9') {
                            if (charAt3 >= 'a' && charAt3 <= 'f') {
                                i12 = charAt3 - 'a';
                            } else if (charAt3 < c5 || charAt3 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i12 = charAt3 - 'A';
                            }
                            i11 = i12 + 10;
                        } else {
                            i11 = charAt3 - '0';
                        }
                        j = (j << c2) | ((long) i11);
                        i18++;
                        i19 = 13;
                        c5 = 'A';
                        c2 = 4;
                    }
                    long j2 = j;
                    for (int i20 = 14; i20 < 18; i20++) {
                        char charAt4 = charAt(length2 + i20);
                        if (charAt4 < '0' || charAt4 > '9') {
                            if (charAt4 >= 'a' && charAt4 <= 'f') {
                                i9 = charAt4 - 'a';
                            } else if (charAt4 < 'A' || charAt4 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i9 = charAt4 - 'A';
                            }
                            i10 = i9 + 10;
                        } else {
                            i10 = charAt4 - '0';
                        }
                        j2 = (j2 << 4) | ((long) i10);
                    }
                    long j3 = 0;
                    for (int i21 = 19; i21 < 23; i21++) {
                        char charAt5 = charAt(length2 + i21);
                        if (charAt5 < '0' || charAt5 > '9') {
                            if (charAt5 >= 'a' && charAt5 <= 'f') {
                                i7 = charAt5 - 'a';
                            } else if (charAt5 < 'A' || charAt5 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i7 = charAt5 - 'A';
                            }
                            i8 = i7 + 10;
                        } else {
                            i8 = charAt5 - '0';
                        }
                        j3 = (j3 << 4) | ((long) i8);
                    }
                    int i22 = 24;
                    long j4 = j3;
                    int i23 = 36;
                    while (i22 < i23) {
                        char charAt6 = charAt(length2 + i22);
                        if (charAt6 < c6 || charAt6 > '9') {
                            if (charAt6 >= 'a' && charAt6 <= c4) {
                                i5 = charAt6 - 'a';
                            } else if (charAt6 < 'A' || charAt6 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i5 = charAt6 - 'A';
                            }
                            i6 = i5 + 10;
                        } else {
                            i6 = charAt6 - '0';
                        }
                        j4 = (j4 << 4) | ((long) i6);
                        i22++;
                        i15 = i15;
                        i23 = 36;
                        c6 = '0';
                        c4 = 'f';
                    }
                    uuid = new UUID(j2, j4);
                    int i24 = this.bp;
                    int length3 = i15 + (indexOf - ((cArr.length + i24) + 1)) + 1;
                    i = length3 + 1;
                    c = charAt(i24 + length3);
                } else {
                    if (i16 == 32) {
                        long j5 = 0;
                        for (int i25 = 0; i25 < 16; i25++) {
                            char charAt7 = charAt(length2 + i25);
                            if (charAt7 < '0' || charAt7 > '9') {
                                if (charAt7 >= 'a' && charAt7 <= 'f') {
                                    i3 = charAt7 - 'a';
                                } else if (charAt7 < 'A' || charAt7 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i3 = charAt7 - 'A';
                                }
                                i4 = i3 + 10;
                            } else {
                                i4 = charAt7 - '0';
                            }
                            j5 = (j5 << 4) | ((long) i4);
                        }
                        int i26 = 16;
                        long j6 = 0;
                        for (int i27 = 32; i26 < i27; i27 = 32) {
                            char charAt8 = charAt(length2 + i26);
                            if (charAt8 >= '0' && charAt8 <= '9') {
                                i2 = charAt8 - '0';
                            } else if (charAt8 >= 'a' && charAt8 <= 'f') {
                                i2 = (charAt8 - 'a') + 10;
                            } else if (charAt8 < 'A' || charAt8 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i2 = (charAt8 - 'A') + 10;
                                j6 = (j6 << 4) | ((long) i2);
                                i26++;
                            }
                            j6 = (j6 << 4) | ((long) i2);
                            i26++;
                        }
                        uuid = new UUID(j5, j6);
                        int i28 = this.bp;
                        int length4 = i15 + (indexOf - ((cArr.length + i28) + 1)) + 1;
                        i = length4 + 1;
                        c = charAt(i28 + length4);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            if (charAt == 'n') {
                int i29 = i15 + 1;
                if (charAt(this.bp + i15) == 'u') {
                    int i30 = i29 + 1;
                    if (charAt(this.bp + i29) == 'l') {
                        int i31 = i30 + 1;
                        if (charAt(this.bp + i30) == 'l') {
                            c = charAt(this.bp + i31);
                            i = i31 + 1;
                            uuid = null;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return null;
        }
        if (c == ',') {
            int i32 = this.bp + i;
            this.bp = i32;
            this.ch = charAt(i32);
            this.matchStat = 3;
            return uuid;
        } else if (c == '}') {
            int i33 = i + 1;
            char charAt9 = charAt(this.bp + i);
            if (charAt9 == ',') {
                this.token = 16;
                int i34 = this.bp + i33;
                this.bp = i34;
                this.ch = charAt(i34);
            } else if (charAt9 == ']') {
                this.token = 15;
                int i35 = this.bp + i33;
                this.bp = i35;
                this.ch = charAt(i35);
            } else if (charAt9 == '}') {
                this.token = 13;
                int i36 = this.bp + i33;
                this.bp = i36;
                this.ch = charAt(i36);
            } else if (charAt9 == 26) {
                this.token = 20;
                this.bp += i33 - 1;
                this.ch = 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public UUID scanUUID(char c) {
        char c2;
        int i;
        UUID uuid;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i15 = 13;
        char c3 = 4;
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf != -1) {
                int i16 = this.bp + 1;
                int i17 = indexOf - i16;
                char c4 = 'f';
                char c5 = 'A';
                char c6 = 'a';
                if (i17 == 36) {
                    int i18 = 0;
                    long j = 0;
                    while (i18 < 8) {
                        char charAt2 = charAt(i16 + i18);
                        if (charAt2 < '0' || charAt2 > '9') {
                            if (charAt2 >= 'a' && charAt2 <= c4) {
                                i14 = charAt2 - 'a';
                            } else if (charAt2 < 'A' || charAt2 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i14 = charAt2 - 'A';
                            }
                            i13 = i14 + 10;
                        } else {
                            i13 = charAt2 - '0';
                        }
                        j = (j << 4) | ((long) i13);
                        i18++;
                        c4 = 'f';
                    }
                    int i19 = 9;
                    while (i19 < i15) {
                        char charAt3 = charAt(i16 + i19);
                        if (charAt3 < '0' || charAt3 > '9') {
                            if (charAt3 >= 'a' && charAt3 <= 'f') {
                                i12 = charAt3 - 'a';
                            } else if (charAt3 < c5 || charAt3 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i12 = charAt3 - 'A';
                            }
                            i11 = i12 + 10;
                        } else {
                            i11 = charAt3 - '0';
                        }
                        j = (j << 4) | ((long) i11);
                        i19++;
                        i15 = 13;
                        c5 = 'A';
                    }
                    long j2 = j;
                    for (int i20 = 14; i20 < 18; i20++) {
                        char charAt4 = charAt(i16 + i20);
                        if (charAt4 < '0' || charAt4 > '9') {
                            if (charAt4 >= 'a' && charAt4 <= 'f') {
                                i10 = charAt4 - 'a';
                            } else if (charAt4 < 'A' || charAt4 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i10 = charAt4 - 'A';
                            }
                            i9 = i10 + 10;
                        } else {
                            i9 = charAt4 - '0';
                        }
                        j2 = (j2 << 4) | ((long) i9);
                    }
                    int i21 = 19;
                    long j3 = 0;
                    while (i21 < 23) {
                        char charAt5 = charAt(i16 + i21);
                        if (charAt5 < '0' || charAt5 > '9') {
                            if (charAt5 >= c6 && charAt5 <= 'f') {
                                i8 = charAt5 - 'a';
                            } else if (charAt5 < 'A' || charAt5 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i8 = charAt5 - 'A';
                            }
                            i7 = i8 + 10;
                        } else {
                            i7 = charAt5 - '0';
                        }
                        j3 = (j3 << c3) | ((long) i7);
                        i21++;
                        c6 = 'a';
                        c3 = 4;
                    }
                    long j4 = j3;
                    for (int i22 = 24; i22 < 36; i22++) {
                        char charAt6 = charAt(i16 + i22);
                        if (charAt6 < '0' || charAt6 > '9') {
                            if (charAt6 >= 'a' && charAt6 <= 'f') {
                                i5 = charAt6 - 'a';
                            } else if (charAt6 < 'A' || charAt6 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i5 = charAt6 - 'A';
                            }
                            i6 = i5 + 10;
                        } else {
                            i6 = charAt6 - '0';
                        }
                        j4 = (j4 << 4) | ((long) i6);
                    }
                    uuid = new UUID(j2, j4);
                    int i23 = this.bp;
                    int i24 = 1 + (indexOf - (i23 + 1)) + 1;
                    i = i24 + 1;
                    c2 = charAt(i23 + i24);
                } else {
                    if (i17 == 32) {
                        long j5 = 0;
                        for (int i25 = 0; i25 < 16; i25++) {
                            char charAt7 = charAt(i16 + i25);
                            if (charAt7 < '0' || charAt7 > '9') {
                                if (charAt7 >= 'a' && charAt7 <= 'f') {
                                    i3 = charAt7 - 'a';
                                } else if (charAt7 < 'A' || charAt7 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i3 = charAt7 - 'A';
                                }
                                i4 = i3 + 10;
                            } else {
                                i4 = charAt7 - '0';
                            }
                            j5 = (j5 << 4) | ((long) i4);
                        }
                        int i26 = 16;
                        long j6 = 0;
                        for (int i27 = 32; i26 < i27; i27 = 32) {
                            char charAt8 = charAt(i16 + i26);
                            if (charAt8 >= '0' && charAt8 <= '9') {
                                i2 = charAt8 - '0';
                            } else if (charAt8 >= 'a' && charAt8 <= 'f') {
                                i2 = (charAt8 - 'a') + 10;
                            } else if (charAt8 < 'A' || charAt8 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i2 = (charAt8 - 'A') + 10;
                            }
                            j6 = (j6 << 4) | ((long) i2);
                            i26++;
                        }
                        uuid = new UUID(j5, j6);
                        int i28 = this.bp;
                        int i29 = 1 + (indexOf - (i28 + 1)) + 1;
                        i = i29 + 1;
                        c2 = charAt(i28 + i29);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
            i = 5;
            c2 = charAt(this.bp + 4);
            uuid = null;
        } else {
            this.matchStat = -1;
            return null;
        }
        if (c2 == ',') {
            int i30 = this.bp + i;
            this.bp = i30;
            this.ch = charAt(i30);
            this.matchStat = 3;
            return uuid;
        } else if (c2 == ']') {
            int i31 = i + 1;
            char charAt9 = charAt(this.bp + i);
            if (charAt9 == ',') {
                this.token = 16;
                int i32 = this.bp + i31;
                this.bp = i32;
                this.ch = charAt(i32);
            } else if (charAt9 == ']') {
                this.token = 15;
                int i33 = this.bp + i31;
                this.bp = i33;
                this.ch = charAt(i33);
            } else if (charAt9 == '}') {
                this.token = 13;
                int i34 = this.bp + i31;
                this.bp = i34;
                this.ch = charAt(i34);
            } else if (charAt9 == 26) {
                this.token = 20;
                this.bp += i31 - 1;
                this.ch = 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public final void scanTrue() {
        if (this.ch == 't') {
            next();
            if (this.ch == 'r') {
                next();
                if (this.ch == 'u') {
                    next();
                    if (this.ch == 'e') {
                        next();
                        char c = this.ch;
                        if (c == ' ' || c == ',' || c == '}' || c == ']' || c == '\n' || c == '\r' || c == '\t' || c == 26 || c == '\f' || c == '\b' || c == ':' || c == '/') {
                            this.token = 6;
                            return;
                        }
                        throw new JSONException("scan true error");
                    }
                    throw new JSONException("error parse true");
                }
                throw new JSONException("error parse true");
            }
            throw new JSONException("error parse true");
        }
        throw new JSONException("error parse true");
    }

    public final void scanNullOrNew() {
        scanNullOrNew(true);
    }

    public final void scanNullOrNew(boolean z) {
        if (this.ch == 'n') {
            next();
            char c = this.ch;
            if (c == 'u') {
                next();
                if (this.ch == 'l') {
                    next();
                    if (this.ch == 'l') {
                        next();
                        char c2 = this.ch;
                        if (c2 == ' ' || c2 == ',' || c2 == '}' || c2 == ']' || c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == 26 || ((c2 == ':' && z) || c2 == '\f' || c2 == '\b')) {
                            this.token = 8;
                            return;
                        }
                        throw new JSONException("scan null error");
                    }
                    throw new JSONException("error parse null");
                }
                throw new JSONException("error parse null");
            } else if (c == 'e') {
                next();
                if (this.ch == 'w') {
                    next();
                    char c3 = this.ch;
                    if (c3 == ' ' || c3 == ',' || c3 == '}' || c3 == ']' || c3 == '\n' || c3 == '\r' || c3 == '\t' || c3 == 26 || c3 == '\f' || c3 == '\b') {
                        this.token = 9;
                        return;
                    }
                    throw new JSONException("scan new error");
                }
                throw new JSONException("error parse new");
            } else {
                throw new JSONException("error parse new");
            }
        } else {
            throw new JSONException("error parse null or new");
        }
    }

    public final void scanFalse() {
        if (this.ch == 'f') {
            next();
            if (this.ch == 'a') {
                next();
                if (this.ch == 'l') {
                    next();
                    if (this.ch == 's') {
                        next();
                        if (this.ch == 'e') {
                            next();
                            char c = this.ch;
                            if (c == ' ' || c == ',' || c == '}' || c == ']' || c == '\n' || c == '\r' || c == '\t' || c == 26 || c == '\f' || c == '\b' || c == ':' || c == '/') {
                                this.token = 7;
                                return;
                            }
                            throw new JSONException("scan false error");
                        }
                        throw new JSONException("error parse false");
                    }
                    throw new JSONException("error parse false");
                }
                throw new JSONException("error parse false");
            }
            throw new JSONException("error parse false");
        }
        throw new JSONException("error parse false");
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if ("null".equalsIgnoreCase(stringVal)) {
            this.token = 8;
        } else if ("new".equals(stringVal)) {
            this.token = 9;
        } else if ("true".equals(stringVal)) {
            this.token = 6;
        } else if ("false".equals(stringVal)) {
            this.token = 7;
        } else if ("undefined".equals(stringVal)) {
            this.token = 23;
        } else if ("Set".equals(stringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(stringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    public static String readString(char[] cArr, int i) {
        int i2;
        char[] cArr2 = new char[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            char c = cArr[i3];
            if (c != '\\') {
                cArr2[i4] = c;
                i4++;
            } else {
                i3++;
                char c2 = cArr[i3];
                if (c2 == '\"') {
                    i2 = i4 + 1;
                    cArr2[i4] = '\"';
                } else if (c2 != '\'') {
                    if (c2 != 'F') {
                        if (c2 == '\\') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\\';
                        } else if (c2 == 'b') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\b';
                        } else if (c2 != 'f') {
                            if (c2 == 'n') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\n';
                            } else if (c2 == 'r') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\r';
                            } else if (c2 != 'x') {
                                switch (c2) {
                                    case '/':
                                        i2 = i4 + 1;
                                        cArr2[i4] = '/';
                                        break;
                                    case '0':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 0;
                                        break;
                                    case '1':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 1;
                                        break;
                                    case '2':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 2;
                                        break;
                                    case '3':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 3;
                                        break;
                                    case '4':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 4;
                                        break;
                                    case '5':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 5;
                                        break;
                                    case '6':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 6;
                                        break;
                                    case '7':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 7;
                                        break;
                                    default:
                                        switch (c2) {
                                            case 't':
                                                i2 = i4 + 1;
                                                cArr2[i4] = '\t';
                                                break;
                                            case 'u':
                                                i2 = i4 + 1;
                                                int i5 = i3 + 1;
                                                int i6 = i5 + 1;
                                                int i7 = i6 + 1;
                                                i3 = i7 + 1;
                                                cArr2[i4] = (char) Integer.parseInt(new String(new char[]{cArr[i5], cArr[i6], cArr[i7], cArr[i3]}), 16);
                                                break;
                                            case 'v':
                                                i2 = i4 + 1;
                                                cArr2[i4] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i2 = i4 + 1;
                                int[] iArr = digits;
                                int i8 = i3 + 1;
                                i3 = i8 + 1;
                                cArr2[i4] = (char) ((iArr[cArr[i8]] * 16) + iArr[cArr[i3]]);
                            }
                        }
                    }
                    i2 = i4 + 1;
                    cArr2[i4] = '\f';
                } else {
                    i2 = i4 + 1;
                    cArr2[i4] = '\'';
                }
                i4 = i2;
            }
            i3++;
        }
        return new String(cArr2, 0, i4);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            if (charAt == 26) {
                this.token = 20;
                return true;
            } else if (!isWhitespace(charAt)) {
                return false;
            } else {
                i++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (true) {
            char c = this.ch;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                next();
            } else if (c == '/') {
                skipComment();
            } else {
                return;
            }
        }
    }

    private void scanStringSingleQuote() {
        char next;
        char next2;
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next3 = next();
            if (next3 == '\'') {
                this.token = 4;
                next();
                return;
            } else if (next3 != 26) {
                boolean z = true;
                if (next3 == '\\') {
                    if (!this.hasSpecial) {
                        this.hasSpecial = true;
                        int i = this.sp;
                        char[] cArr = this.sbuf;
                        if (i > cArr.length) {
                            char[] cArr2 = new char[(i * 2)];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            this.sbuf = cArr2;
                        }
                        copyTo(this.np + 1, this.sp, this.sbuf);
                    }
                    char next4 = next();
                    if (next4 == '\"') {
                        putChar('\"');
                    } else if (next4 != '\'') {
                        if (next4 != 'F') {
                            if (next4 == '\\') {
                                putChar('\\');
                            } else if (next4 == 'b') {
                                putChar('\b');
                            } else if (next4 != 'f') {
                                if (next4 == 'n') {
                                    putChar('\n');
                                } else if (next4 == 'r') {
                                    putChar('\r');
                                } else if (next4 != 'x') {
                                    switch (next4) {
                                        case '/':
                                            putChar('/');
                                            continue;
                                        case '0':
                                            putChar(0);
                                            continue;
                                        case '1':
                                            putChar(1);
                                            continue;
                                        case '2':
                                            putChar(2);
                                            continue;
                                        case '3':
                                            putChar(3);
                                            continue;
                                        case '4':
                                            putChar(4);
                                            continue;
                                        case '5':
                                            putChar(5);
                                            continue;
                                        case '6':
                                            putChar(6);
                                            continue;
                                        case '7':
                                            putChar(7);
                                            continue;
                                        default:
                                            switch (next4) {
                                                case 't':
                                                    putChar('\t');
                                                    continue;
                                                case 'u':
                                                    putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                    continue;
                                                case 'v':
                                                    putChar(11);
                                                    continue;
                                                    continue;
                                                default:
                                                    this.ch = next4;
                                                    throw new JSONException("unclosed single-quote string");
                                            }
                                    }
                                } else {
                                    next = next();
                                    next2 = next();
                                    boolean z2 = (next >= '0' && next <= '9') || (next >= 'a' && next <= 'f') || (next >= 'A' && next <= 'F');
                                    if ((next2 < '0' || next2 > '9') && ((next2 < 'a' || next2 > 'f') && (next2 < 'A' || next2 > 'F'))) {
                                        z = false;
                                    }
                                    if (z2 && z) {
                                        int[] iArr = digits;
                                        putChar((char) ((iArr[next] * 16) + iArr[next2]));
                                    }
                                }
                            }
                        }
                        putChar('\f');
                    } else {
                        putChar('\'');
                    }
                } else if (!this.hasSpecial) {
                    this.sp++;
                } else {
                    int i2 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i2 == cArr3.length) {
                        putChar(next3);
                    } else {
                        this.sp = i2 + 1;
                        cArr3[i2] = next3;
                    }
                }
            } else if (!isEOF()) {
                putChar(26);
            } else {
                throw new JSONException("unclosed single-quote string");
            }
        }
        throw new JSONException("invalid escape character \\x" + next + next2);
    }

    protected final void putChar(char c) {
        int i = this.sp;
        char[] cArr = this.sbuf;
        if (i == cArr.length) {
            char[] cArr2 = new char[(cArr.length * 2)];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i2 = this.sp;
        this.sp = i2 + 1;
        cArr3[i2] = c;
    }

    public final void scanHex() {
        char next;
        if (this.ch == 'x') {
            next();
            if (this.ch == '\'') {
                this.np = this.bp;
                next();
                if (this.ch == '\'') {
                    next();
                    this.token = 26;
                    return;
                }
                while (true) {
                    next = next();
                    if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                        break;
                    }
                    this.sp++;
                }
                if (next == '\'') {
                    this.sp++;
                    next();
                    this.token = 26;
                    return;
                }
                throw new JSONException("illegal state. " + next);
            }
            throw new JSONException("illegal state. " + this.ch);
        }
        throw new JSONException("illegal state. " + this.ch);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanNumber() {
        char c;
        char c2;
        this.np = this.bp;
        boolean z = true;
        if (this.ch == '-') {
            this.sp++;
            next();
        }
        while (true) {
            c = this.ch;
            if (c < '0' || c > '9') {
                break;
            }
            this.sp++;
            next();
        }
        boolean z2 = false;
        if (c == '.') {
            this.sp++;
            next();
            while (true) {
                char c3 = this.ch;
                if (c3 < '0' || c3 > '9') {
                    break;
                }
                this.sp++;
                next();
            }
            z2 = true;
        }
        char c4 = this.ch;
        if (c4 == 'L') {
            this.sp++;
            next();
        } else if (c4 == 'S') {
            this.sp++;
            next();
        } else if (c4 == 'B') {
            this.sp++;
            next();
        } else {
            if (c4 == 'F') {
                this.sp++;
                next();
            } else if (c4 == 'D') {
                this.sp++;
                next();
            } else if (c4 == 'e' || c4 == 'E') {
                this.sp++;
                next();
                char c5 = this.ch;
                if (c5 == '+' || c5 == '-') {
                    this.sp++;
                    next();
                }
                while (true) {
                    c2 = this.ch;
                    if (c2 < '0' || c2 > '9') {
                        break;
                    }
                    this.sp++;
                    next();
                }
                if (c2 == 'D' || c2 == 'F') {
                    this.sp++;
                    next();
                }
            }
            if (!z) {
                this.token = 3;
                return;
            } else {
                this.token = 2;
                return;
            }
        }
        z = z2;
        if (!z) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0085  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final long longValue() throws NumberFormatException {
        long j;
        long j2;
        int i;
        boolean z = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i2 = this.np;
        int i3 = this.sp + i2;
        if (charAt(i2) == '-') {
            j = Long.MIN_VALUE;
            i2++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        if (i2 < i3) {
            i = i2 + 1;
            j2 = (long) (-(charAt(i2) - '0'));
        } else {
            j2 = 0;
            if (i2 < i3) {
                i = i2 + 1;
                char charAt = charAt(i2);
                if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                    i2 = i;
                } else {
                    int i4 = charAt - '0';
                    if (j2 >= -922337203685477580L) {
                        long j3 = j2 * 10;
                        long j4 = (long) i4;
                        if (j3 >= j + j4) {
                            j2 = j3 - j4;
                        }
                        throw new NumberFormatException(numberString());
                    }
                    throw new NumberFormatException(numberString());
                }
            }
            if (z) {
                return -j2;
            }
            if (i2 > this.np + 1) {
                return j2;
            }
            throw new NumberFormatException(numberString());
        }
        i2 = i;
        if (i2 < i3) {
        }
        if (z) {
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z) {
        char charAt = charAt((this.np + this.sp) - 1);
        if (charAt == 'F') {
            try {
                return Float.valueOf(Float.parseFloat(numberString()));
            } catch (NumberFormatException e) {
                throw new JSONException(e.getMessage() + ", " + info());
            }
        } else if (charAt == 'D') {
            return Double.valueOf(Double.parseDouble(numberString()));
        } else {
            if (z) {
                return decimalValue();
            }
            return Double.valueOf(doubleValue());
        }
    }

    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        throw new UnsupportedOperationException();
    }

    public boolean matchField2(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int getFeatures() {
        return this.features;
    }
}
