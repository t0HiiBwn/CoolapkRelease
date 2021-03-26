package com.alibaba.fastjson;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public abstract class JSONValidator implements Cloneable {
    protected char ch;
    protected int count = 0;
    protected boolean eof;
    protected int pos = -1;
    protected boolean supportMultiValue = true;
    protected Type type;

    public enum Type {
        Object,
        Array,
        Value
    }

    static final boolean isWhiteSpace(char c) {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n' || c == '\f' || c == '\b';
    }

    public void close() throws IOException {
    }

    abstract void next();

    public static JSONValidator fromUtf8(byte[] bArr) {
        return new UTF8Validator(bArr);
    }

    public static JSONValidator fromUtf8(InputStream inputStream) {
        return new UTF8InputStreamValidator(inputStream);
    }

    public static JSONValidator from(String str) {
        return new UTF16Validator(str);
    }

    public static JSONValidator from(Reader reader) {
        return new ReaderValidator(reader);
    }

    public Type getType() {
        return this.type;
    }

    public boolean validate() {
        do {
            any();
            this.count++;
            if (!this.supportMultiValue || this.eof) {
                break;
            }
            skipWhiteSpace();
        } while (!this.eof);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011d  */
    void any() {
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6 = this.ch;
        if (c6 != '\"') {
            if (!(c6 == '+' || c6 == '-')) {
                if (c6 != '[') {
                    if (c6 != 'f') {
                        if (c6 != 'n') {
                            if (c6 == 't') {
                                next();
                                if (this.ch != 'r') {
                                    error();
                                }
                                next();
                                if (this.ch != 'u') {
                                    error();
                                }
                                next();
                                if (this.ch != 'e') {
                                    error();
                                }
                                next();
                                if (isWhiteSpace(this.ch) || (c5 = this.ch) == ',' || c5 == ']' || c5 == '}' || c5 == 0) {
                                    this.type = Type.Value;
                                    return;
                                }
                                error();
                            } else if (c6 != '{') {
                                switch (c6) {
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
                                        error();
                                        return;
                                }
                            } else {
                                next();
                                skipWhiteSpace();
                                if (this.ch == '}') {
                                    next();
                                    this.type = Type.Object;
                                    return;
                                }
                                while (true) {
                                    if (this.ch == '\"') {
                                        fieldName();
                                    } else {
                                        error();
                                    }
                                    skipWhiteSpace();
                                    if (this.ch == ':') {
                                        next();
                                    } else {
                                        error();
                                    }
                                    skipWhiteSpace();
                                    any();
                                    skipWhiteSpace();
                                    char c7 = this.ch;
                                    if (c7 == ',') {
                                        next();
                                        skipWhiteSpace();
                                    } else if (c7 == '}') {
                                        next();
                                        this.type = Type.Object;
                                        return;
                                    }
                                }
                            }
                        }
                        next();
                        if (this.ch != 'u') {
                            error();
                        }
                        next();
                        if (this.ch != 'l') {
                            error();
                        }
                        next();
                        if (this.ch != 'l') {
                            error();
                        }
                        next();
                        if (!isWhiteSpace(this.ch) || (c3 = this.ch) == ',' || c3 == ']' || c3 == '}' || c3 == 0) {
                            this.type = Type.Value;
                            return;
                        }
                        error();
                        error();
                        return;
                    }
                    next();
                    if (this.ch != 'a') {
                        error();
                    }
                    next();
                    if (this.ch != 'l') {
                        error();
                    }
                    next();
                    if (this.ch != 's') {
                        error();
                    }
                    next();
                    if (this.ch != 'e') {
                        error();
                    }
                    next();
                    if (isWhiteSpace(this.ch) || (c4 = this.ch) == ',' || c4 == ']' || c4 == '}' || c4 == 0) {
                        this.type = Type.Value;
                        return;
                    }
                    error();
                    next();
                    if (this.ch != 'u') {
                    }
                    next();
                    if (this.ch != 'l') {
                    }
                    next();
                    if (this.ch != 'l') {
                    }
                    next();
                    if (!isWhiteSpace(this.ch)) {
                    }
                    this.type = Type.Value;
                    return;
                }
                next();
                skipWhiteSpace();
                if (this.ch == ']') {
                    next();
                    this.type = Type.Array;
                    return;
                }
                while (true) {
                    any();
                    skipWhiteSpace();
                    char c8 = this.ch;
                    if (c8 == ',') {
                        next();
                        skipWhiteSpace();
                    } else if (c8 == ']') {
                        next();
                        this.type = Type.Array;
                        return;
                    } else {
                        error();
                    }
                }
            }
            if (c6 == '-' || c6 == '+') {
                next();
                skipWhiteSpace();
                char c9 = this.ch;
                if (c9 < '0' || c9 > '9') {
                    error();
                }
            }
            do {
                next();
                c = this.ch;
                if (c >= '0') {
                }
                if (c == '.') {
                    next();
                    char c10 = this.ch;
                    if (c10 < '0' || c10 > '9') {
                        error();
                    }
                    while (true) {
                        char c11 = this.ch;
                        if (c11 >= '0' && c11 <= '9') {
                            next();
                        }
                    }
                }
                char c12 = this.ch;
                if (c12 == 'e' || c12 == 'E') {
                    next();
                    char c13 = this.ch;
                    if (c13 == '-' || c13 == '+') {
                        next();
                    }
                    c2 = this.ch;
                    if (c2 >= '0' || c2 > '9') {
                        error();
                    } else {
                        next();
                    }
                    while (true) {
                        char c14 = this.ch;
                        if (c14 >= '0' && c14 <= '9') {
                            next();
                        }
                    }
                }
                this.type = Type.Value;
                return;
            } while (c <= '9');
            if (c == '.') {
            }
            char c12 = this.ch;
            next();
            char c13 = this.ch;
            next();
            c2 = this.ch;
            if (c2 >= '0') {
            }
            error();
            while (true) {
                char c14 = this.ch;
                next();
            }
            this.type = Type.Value;
            return;
        }
        next();
        while (true) {
            char c15 = this.ch;
            if (c15 == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else if (c15 == '\"') {
                next();
                this.type = Type.Value;
                return;
            } else {
                next();
            }
        }
    }

    protected void fieldName() {
        next();
        while (true) {
            char c = this.ch;
            if (c == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else if (c == '\"') {
                next();
                return;
            } else {
                next();
            }
        }
    }

    void error() {
        throw new JSONException("error : " + this.pos);
    }

    void skipWhiteSpace() {
        while (isWhiteSpace(this.ch)) {
            next();
        }
    }

    static class UTF8Validator extends JSONValidator {
        private final byte[] bytes;

        public UTF8Validator(byte[] bArr) {
            this.bytes = bArr;
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void next() {
            this.pos++;
            int i = this.pos;
            byte[] bArr = this.bytes;
            if (i >= bArr.length) {
                this.ch = 0;
                this.eof = true;
                return;
            }
            this.ch = (char) bArr[this.pos];
        }
    }

    static class UTF8InputStreamValidator extends JSONValidator {
        private static final ThreadLocal<byte[]> bufLocal = new ThreadLocal<>();
        private byte[] buf;
        private int end = -1;
        private final InputStream is;
        private int readCount = 0;

        public UTF8InputStreamValidator(InputStream inputStream) {
            this.is = inputStream;
            ThreadLocal<byte[]> threadLocal = bufLocal;
            byte[] bArr = threadLocal.get();
            this.buf = bArr;
            if (bArr != null) {
                threadLocal.set(null);
            } else {
                this.buf = new byte[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void next() {
            if (this.pos < this.end) {
                byte[] bArr = this.buf;
                int i = this.pos + 1;
                this.pos = i;
                this.ch = (char) bArr[i];
            } else if (!this.eof) {
                try {
                    InputStream inputStream = this.is;
                    byte[] bArr2 = this.buf;
                    int read = inputStream.read(bArr2, 0, bArr2.length);
                    this.readCount++;
                    if (read > 0) {
                        this.ch = (char) this.buf[0];
                        this.pos = 0;
                        this.end = read - 1;
                    } else if (read == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                    } else {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                        throw new JSONException("read error");
                    }
                } catch (IOException unused) {
                    throw new JSONException("read error");
                }
            }
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void error() {
            throw new JSONException("error, readCount " + this.readCount + ", valueCount : " + this.count + ", pos " + this.pos);
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.is.close();
        }
    }

    static class UTF16Validator extends JSONValidator {
        private final String str;

        public UTF16Validator(String str2) {
            this.str = str2;
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void next() {
            this.pos++;
            if (this.pos >= this.str.length()) {
                this.ch = 0;
                this.eof = true;
                return;
            }
            this.ch = this.str.charAt(this.pos);
        }
    }

    static class ReaderValidator extends JSONValidator {
        private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
        private char[] buf;
        private int end = -1;
        final Reader r;
        private int readCount = 0;

        ReaderValidator(Reader reader) {
            this.r = reader;
            ThreadLocal<char[]> threadLocal = bufLocal;
            char[] cArr = threadLocal.get();
            this.buf = cArr;
            if (cArr != null) {
                threadLocal.set(null);
            } else {
                this.buf = new char[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void next() {
            if (this.pos < this.end) {
                char[] cArr = this.buf;
                int i = this.pos + 1;
                this.pos = i;
                this.ch = cArr[i];
            } else if (!this.eof) {
                try {
                    Reader reader = this.r;
                    char[] cArr2 = this.buf;
                    int read = reader.read(cArr2, 0, cArr2.length);
                    this.readCount++;
                    if (read > 0) {
                        this.ch = this.buf[0];
                        this.pos = 0;
                        this.end = read - 1;
                    } else if (read == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                    } else {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = 0;
                        this.eof = true;
                        throw new JSONException("read error");
                    }
                } catch (IOException unused) {
                    throw new JSONException("read error");
                }
            }
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void error() {
            throw new JSONException("error, readCount " + this.readCount + ", valueCount : " + this.count + ", pos " + this.pos);
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.r.close();
        }
    }
}
