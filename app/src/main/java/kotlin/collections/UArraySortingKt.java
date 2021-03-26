package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
/* compiled from: UArraySorting.kt */
public final class UArraySortingKt {
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    private static final int m1103partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte b = UByteArray.m754getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = b & 255;
                if (Intrinsics.compare(UByteArray.m754getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m754getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte b2 = UByteArray.m754getw2LRezQ(bArr, i);
                UByteArray.m759setVurrAj0(bArr, i, UByteArray.m754getw2LRezQ(bArr, i2));
                UByteArray.m759setVurrAj0(bArr, i2, b2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    private static final void m1107quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int r0 = m1103partition4UcCI2c(bArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m1107quickSort4UcCI2c(bArr, i, i3);
        }
        if (r0 < i2) {
            m1107quickSort4UcCI2c(bArr, r0, i2);
        }
    }

    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    private static final int m1104partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short s = UShortArray.m990getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = s & 65535;
                if (Intrinsics.compare(UShortArray.m990getMh2AYeg(sArr, i) & 65535, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m990getMh2AYeg(sArr, i2) & 65535, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short s2 = UShortArray.m990getMh2AYeg(sArr, i);
                UShortArray.m995set01HTLdE(sArr, i, UShortArray.m990getMh2AYeg(sArr, i2));
                UShortArray.m995set01HTLdE(sArr, i2, s2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    private static final void m1108quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int r0 = m1104partitionAa5vz7o(sArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m1108quickSortAa5vz7o(sArr, i, i3);
        }
        if (r0 < i2) {
            m1108quickSortAa5vz7o(sArr, r0, i2);
        }
    }

    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    private static final int m1105partitionoBK06Vg(int[] iArr, int i, int i2) {
        int i3 = UIntArray.m824getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.uintCompare(UIntArray.m824getpVg5ArA(iArr, i), i3) < 0) {
                i++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m824getpVg5ArA(iArr, i2), i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                int i4 = UIntArray.m824getpVg5ArA(iArr, i);
                UIntArray.m829setVXSXFK8(iArr, i, UIntArray.m824getpVg5ArA(iArr, i2));
                UIntArray.m829setVXSXFK8(iArr, i2, i4);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    private static final void m1109quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int r0 = m1105partitionoBK06Vg(iArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m1109quickSortoBK06Vg(iArr, i, i3);
        }
        if (r0 < i2) {
            m1109quickSortoBK06Vg(iArr, r0, i2);
        }
    }

    /* renamed from: partition--nroSd4  reason: not valid java name */
    private static final int m1102partitionnroSd4(long[] jArr, int i, int i2) {
        long j = ULongArray.m894getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.ulongCompare(ULongArray.m894getsVKNKU(jArr, i), j) < 0) {
                i++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m894getsVKNKU(jArr, i2), j) > 0) {
                i2--;
            }
            if (i <= i2) {
                long j2 = ULongArray.m894getsVKNKU(jArr, i);
                ULongArray.m899setk8EXiF4(jArr, i, ULongArray.m894getsVKNKU(jArr, i2));
                ULongArray.m899setk8EXiF4(jArr, i2, j2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    private static final void m1106quickSortnroSd4(long[] jArr, int i, int i2) {
        int r0 = m1102partitionnroSd4(jArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m1106quickSortnroSd4(jArr, i, i3);
        }
        if (r0 < i2) {
            m1106quickSortnroSd4(jArr, r0, i2);
        }
    }

    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m1111sortArray4UcCI2c(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        m1107quickSort4UcCI2c(bArr, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m1112sortArrayAa5vz7o(short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "array");
        m1108quickSortAa5vz7o(sArr, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m1113sortArrayoBK06Vg(int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        m1109quickSortoBK06Vg(iArr, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m1110sortArraynroSd4(long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        m1106quickSortnroSd4(jArr, i, i2 - 1);
    }
}
