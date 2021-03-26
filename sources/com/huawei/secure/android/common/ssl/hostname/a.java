package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

public class a {
    private final String W;
    private int X;
    private int Y;
    private char[] Z;
    private int end;
    private final int length;
    private int pos;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.W = name;
        this.length = name.length();
    }

    private String e() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        while (true) {
            i = this.pos;
            i2 = this.length;
            if (i >= i2 || this.Z[i] != ' ') {
                break;
            }
            this.pos = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.X = i;
        this.pos = i + 1;
        while (true) {
            i3 = this.pos;
            i4 = this.length;
            if (i3 >= i4) {
                break;
            }
            char[] cArr = this.Z;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.pos = i3 + 1;
        }
        if (i3 < i4) {
            this.end = i3;
            if (this.Z[i3] == ' ') {
                while (true) {
                    i5 = this.pos;
                    i6 = this.length;
                    if (i5 >= i6) {
                        break;
                    }
                    char[] cArr2 = this.Z;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.pos = i5 + 1;
                }
                if (this.Z[i5] != '=' || i5 == i6) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.W);
                }
            }
            this.pos++;
            while (true) {
                int i7 = this.pos;
                if (i7 >= this.length || this.Z[i7] != ' ') {
                    break;
                }
                this.pos = i7 + 1;
            }
            int i8 = this.end;
            int i9 = this.X;
            if (i8 - i9 > 4) {
                char[] cArr3 = this.Z;
                if (cArr3[i9 + 3] == '.' && ((cArr3[i9] == 'O' || cArr3[i9] == 'o') && ((cArr3[i9 + 1] == 'I' || cArr3[i9 + 1] == 'i') && (cArr3[i9 + 2] == 'D' || cArr3[i9 + 2] == 'd')))) {
                    this.X = i9 + 4;
                }
            }
            char[] cArr4 = this.Z;
            int i10 = this.X;
            return new String(cArr4, i10, this.end - i10);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.W);
    }

    private String f() {
        int i = this.pos + 1;
        this.pos = i;
        this.X = i;
        this.end = i;
        while (true) {
            int i2 = this.pos;
            if (i2 != this.length) {
                char[] cArr = this.Z;
                if (cArr[i2] == '\"') {
                    this.pos = i2 + 1;
                    while (true) {
                        int i3 = this.pos;
                        if (i3 >= this.length || this.Z[i3] != ' ') {
                            break;
                        }
                        this.pos = i3 + 1;
                    }
                    char[] cArr2 = this.Z;
                    int i4 = this.X;
                    return new String(cArr2, i4, this.end - i4);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.end] = i();
                } else {
                    cArr[this.end] = cArr[i2];
                }
                this.pos++;
                this.end++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.W);
            }
        }
    }

    private String g() {
        int i;
        int i2 = this.pos;
        if (i2 + 4 < this.length) {
            this.X = i2;
            this.pos = i2 + 1;
            while (true) {
                i = this.pos;
                if (i == this.length) {
                    break;
                }
                char[] cArr = this.Z;
                if (cArr[i] == '+' || cArr[i] == ',' || cArr[i] == ';') {
                    break;
                } else if (cArr[i] == ' ') {
                    this.end = i;
                    this.pos = i + 1;
                    while (true) {
                        int i3 = this.pos;
                        if (i3 >= this.length || this.Z[i3] != ' ') {
                            break;
                        }
                        this.pos = i3 + 1;
                    }
                } else {
                    if (cArr[i] >= 'A' && cArr[i] <= 'F') {
                        cArr[i] = (char) (cArr[i] + ' ');
                    }
                    this.pos = i + 1;
                }
            }
            this.end = i;
            int i4 = this.end;
            int i5 = this.X;
            int i6 = i4 - i5;
            if (i6 < 5 || (i6 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.W);
            }
            int i7 = i6 / 2;
            byte[] bArr = new byte[i7];
            int i8 = i5 + 1;
            for (int i9 = 0; i9 < i7; i9++) {
                bArr[i9] = (byte) a(i8);
                i8 += 2;
            }
            return new String(this.Z, this.X, i6);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.W);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0097, code lost:
        r1 = r8.Z;
        r2 = r8.X;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a3, code lost:
        return new java.lang.String(r1, r2, r8.Y - r2);
     */
    private String h() {
        int i;
        int i2;
        int i3 = this.pos;
        this.X = i3;
        this.end = i3;
        while (true) {
            int i4 = this.pos;
            if (i4 < this.length) {
                char[] cArr = this.Z;
                char c = cArr[i4];
                if (c == ' ') {
                    int i5 = this.end;
                    this.Y = i5;
                    this.pos = i4 + 1;
                    this.end = i5 + 1;
                    cArr[i5] = ' ';
                    while (true) {
                        i = this.pos;
                        i2 = this.length;
                        if (i >= i2) {
                            break;
                        }
                        char[] cArr2 = this.Z;
                        if (cArr2[i] != ' ') {
                            break;
                        }
                        int i6 = this.end;
                        this.end = i6 + 1;
                        cArr2[i6] = ' ';
                        this.pos = i + 1;
                    }
                    if (i == i2) {
                        break;
                    }
                    char[] cArr3 = this.Z;
                    if (cArr3[i] == ',' || cArr3[i] == '+' || cArr3[i] == ';') {
                        break;
                    }
                } else if (c == ';') {
                    break;
                } else if (c != '\\') {
                    if (c == '+' || c == ',') {
                        break;
                    }
                    int i7 = this.end;
                    this.end = i7 + 1;
                    cArr[i7] = cArr[i4];
                    this.pos = i4 + 1;
                } else {
                    int i8 = this.end;
                    this.end = i8 + 1;
                    cArr[i8] = i();
                    this.pos++;
                }
            } else {
                char[] cArr4 = this.Z;
                int i9 = this.X;
                return new String(cArr4, i9, this.end - i9);
            }
        }
        char[] cArr5 = this.Z;
        int i10 = this.X;
        return new String(cArr5, i10, this.end - i10);
    }

    private char i() {
        int i = this.pos + 1;
        this.pos = i;
        if (i != this.length) {
            char[] cArr = this.Z;
            char c = cArr[i];
            if (!(c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#')) {
                switch (c) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return j();
                        }
                }
            }
            return cArr[i];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.W);
    }

    private char j() {
        int i;
        int i2;
        int a = a(this.pos);
        this.pos++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        if (a <= 223) {
            i2 = a & 31;
            i = 1;
        } else if (a <= 239) {
            i = 2;
            i2 = a & 15;
        } else {
            i = 3;
            i2 = a & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.pos + 1;
            this.pos = i4;
            if (i4 == this.length || this.Z[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.pos = i5;
            int a2 = a(i5);
            this.pos++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.length) {
            char[] cArr = this.Z;
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.W);
            } else {
                i2 = c - '7';
            }
            char c2 = cArr[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.W);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.W);
    }

    public String findMostSpecific(String str) {
        String str2;
        this.pos = 0;
        this.X = 0;
        this.end = 0;
        this.Y = 0;
        this.Z = this.W.toCharArray();
        String e = e();
        if (e == null) {
            return null;
        }
        do {
            int i = this.pos;
            if (i == this.length) {
                return null;
            }
            char c = this.Z[i];
            if (c != '\"') {
                str2 = c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : h() : g();
            } else {
                str2 = f();
            }
            if (str.equalsIgnoreCase(e)) {
                return str2;
            }
            int i2 = this.pos;
            if (i2 >= this.length) {
                return null;
            }
            char[] cArr = this.Z;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.pos = i2 + 1;
                e = e();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.W);
            }
        } while (e != null);
        throw new IllegalStateException("Malformed DN: " + this.W);
    }

    public List<String> a(String str) {
        String str2;
        this.pos = 0;
        this.X = 0;
        this.end = 0;
        this.Y = 0;
        this.Z = this.W.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String e = e();
        if (e == null) {
            return emptyList;
        }
        do {
            int i = this.pos;
            if (i < this.length) {
                char c = this.Z[i];
                if (c != '\"') {
                    str2 = c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : h() : g();
                } else {
                    str2 = f();
                }
                if (str.equalsIgnoreCase(e)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(str2);
                }
                int i2 = this.pos;
                if (i2 < this.length) {
                    char[] cArr = this.Z;
                    if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                        this.pos = i2 + 1;
                        e = e();
                    } else {
                        throw new IllegalStateException("Malformed DN: " + this.W);
                    }
                }
            }
            return emptyList;
        } while (e != null);
        throw new IllegalStateException("Malformed DN: " + this.W);
    }
}
