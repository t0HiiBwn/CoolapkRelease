package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\n¨\u0006\u000f"}, d2 = {"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "kotlin-stdlib"}, k = 5, mv = {1, 4, 1}, xi = 1, xs = "kotlin/text/CharsKt")
/* compiled from: Char.kt */
class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static final boolean isSurrogate(char c) {
        return 55296 <= c && 57343 >= c;
    }

    public static final int digitToInt(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        throw new IllegalArgumentException("Char " + c + " is not a decimal digit");
    }

    public static final int digitToInt(char c, int i) {
        Integer digitToIntOrNull = CharsKt.digitToIntOrNull(c, i);
        if (digitToIntOrNull != null) {
            return digitToIntOrNull.intValue();
        }
        throw new IllegalArgumentException("Char " + c + " is not a digit in the given radix=" + i);
    }

    public static final Integer digitToIntOrNull(char c) {
        if ('0' <= c && '9' >= c) {
            return Integer.valueOf(c - '0');
        }
        return null;
    }

    public static final Integer digitToIntOrNull(char c, int i) {
        if (2 > i || 36 < i) {
            throw new IllegalArgumentException("Invalid radix: " + i + ". Valid radix values are in range 2..36");
        } else if ('0' <= c && '9' >= c) {
            int i2 = c - 48;
            if (i2 < i) {
                return Integer.valueOf(i2);
            }
            return null;
        } else {
            int i3 = (c - (Intrinsics.compare(c, 90) <= 0 ? 65 : 97)) + 10;
            if (10 <= i3 && i > i3) {
                return Integer.valueOf(i3);
            }
            return null;
        }
    }

    public static final char digitToChar(int i) {
        if (i >= 0 && 9 >= i) {
            return (char) (i + 48);
        }
        throw new IllegalArgumentException("Int " + i + " is not a decimal digit");
    }

    public static final char digitToChar(int i, int i2) {
        if (2 > i2 || 36 < i2) {
            throw new IllegalArgumentException("Invalid radix: " + i2 + ". Valid radix values are in range 2..36");
        } else if (i < 0 || i >= i2) {
            throw new IllegalArgumentException("Digit " + i + " does not represent a valid digit in radix " + i2);
        } else {
            return (char) (i < 10 ? i + 48 : ((char) (i + 65)) - '\n');
        }
    }

    private static final String plus(char c, String str) {
        return String.valueOf(c) + str;
    }

    public static /* synthetic */ boolean equals$default(char c, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return CharsKt.equals(c, c2, z);
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }
}
