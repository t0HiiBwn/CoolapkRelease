package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 i2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001iB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b'\u0010(J\u0016\u0010)\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u0005J\u0016\u0010+\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010\u0005J\u001b\u0010-\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b.\u0010\u000fJ\u001b\u0010-\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u0012J\u001b\u0010-\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u001fJ\u001b\u0010-\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0018J\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b3\u0010\u000bJ\u001b\u00104\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u000fJ\u001b\u00104\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0012J\u001b\u00104\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b7\u0010\u001fJ\u001b\u00104\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b8\u0010\u0018J\u001b\u00109\u001a\u00020:2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u000fJ\u001b\u0010=\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u0012J\u001b\u0010=\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u001fJ\u001b\u0010=\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0018J\u001b\u0010B\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u000fJ\u001b\u0010B\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u0012J\u001b\u0010B\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u001fJ\u001b\u0010B\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bF\u0010\u0018J\u0010\u0010G\u001a\u00020\u0003H\b¢\u0006\u0004\bH\u0010\u0005J\u0010\u0010I\u001a\u00020JH\b¢\u0006\u0004\bK\u0010LJ\u0010\u0010M\u001a\u00020NH\b¢\u0006\u0004\bO\u0010PJ\u0010\u0010Q\u001a\u00020\rH\b¢\u0006\u0004\bR\u0010(J\u0010\u0010S\u001a\u00020TH\b¢\u0006\u0004\bU\u0010VJ\u0010\u0010W\u001a\u00020XH\b¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\\H\u0016¢\u0006\u0004\b]\u0010^J\u0016\u0010_\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b`\u0010\u0005J\u0016\u0010a\u001a\u00020\u0010H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bb\u0010(J\u0016\u0010c\u001a\u00020\u0013H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bd\u0010VJ\u0016\u0010e\u001a\u00020\u0016H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bf\u0010ZJ\u001b\u0010g\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\bh\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006j"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
/* compiled from: UByte.kt */
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m699boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private int m700compareTo7apg3OU(byte b) {
        return m701compareTo7apg3OU(this.data, b);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m705constructorimpl(byte b) {
        return b;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m711equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m746unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m712equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m713hashCodeimpl(byte b) {
        return b;
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m734toByteimpl(byte b) {
        return b;
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m735toDoubleimpl(byte b) {
        return (double) (b & 255);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m736toFloatimpl(byte b) {
        return (float) (b & 255);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m737toIntimpl(byte b) {
        return b & 255;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m738toLongimpl(byte b) {
        return ((long) b) & 255;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m739toShortimpl(byte b) {
        return (short) (((short) b) & 255);
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m741toUBytew2LRezQ(byte b) {
        return b;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return m711equalsimpl(this.data, obj);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return m713hashCodeimpl(this.data);
    }

    @Override // java.lang.Object
    public String toString() {
        return m740toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m746unboximpl() {
        return this.data;
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return m700compareTo7apg3OU(uByte.m746unboximpl());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    /* compiled from: UByte.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static int m701compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m704compareToxj2QHRw(byte b, short s) {
        return Intrinsics.compare(b & 255, s & 65535);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m703compareToWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.uintCompare(UInt.m773constructorimpl(b & 255), i);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m702compareToVKZWuLQ(byte b, long j) {
        return UnsignedKt.ulongCompare(ULong.m843constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m721plus7apg3OU(byte b, byte b2) {
        return UInt.m773constructorimpl(UInt.m773constructorimpl(b & 255) + UInt.m773constructorimpl(b2 & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m724plusxj2QHRw(byte b, short s) {
        return UInt.m773constructorimpl(UInt.m773constructorimpl(b & 255) + UInt.m773constructorimpl(s & 65535));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m723plusWZ4Q5Ns(byte b, int i) {
        return UInt.m773constructorimpl(UInt.m773constructorimpl(b & 255) + i);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m722plusVKZWuLQ(byte b, long j) {
        return ULong.m843constructorimpl(ULong.m843constructorimpl(((long) b) & 255) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m716minus7apg3OU(byte b, byte b2) {
        return UInt.m773constructorimpl(UInt.m773constructorimpl(b & 255) - UInt.m773constructorimpl(b2 & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m719minusxj2QHRw(byte b, short s) {
        return UInt.m773constructorimpl(UInt.m773constructorimpl(b & 255) - UInt.m773constructorimpl(s & 65535));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m718minusWZ4Q5Ns(byte b, int i) {
        return UInt.m773constructorimpl(UInt.m773constructorimpl(b & 255) - i);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m717minusVKZWuLQ(byte b, long j) {
        return ULong.m843constructorimpl(ULong.m843constructorimpl(((long) b) & 255) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m730times7apg3OU(byte b, byte b2) {
        return UInt.m773constructorimpl(UInt.m773constructorimpl(b & 255) * UInt.m773constructorimpl(b2 & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m733timesxj2QHRw(byte b, short s) {
        return UInt.m773constructorimpl(UInt.m773constructorimpl(b & 255) * UInt.m773constructorimpl(s & 65535));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m732timesWZ4Q5Ns(byte b, int i) {
        return UInt.m773constructorimpl(UInt.m773constructorimpl(b & 255) * i);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m731timesVKZWuLQ(byte b, long j) {
        return ULong.m843constructorimpl(ULong.m843constructorimpl(((long) b) & 255) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m707div7apg3OU(byte b, byte b2) {
        return UnsignedKt.m1002uintDivideJ1ME1BU(UInt.m773constructorimpl(b & 255), UInt.m773constructorimpl(b2 & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m710divxj2QHRw(byte b, short s) {
        return UnsignedKt.m1002uintDivideJ1ME1BU(UInt.m773constructorimpl(b & 255), UInt.m773constructorimpl(s & 65535));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m709divWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m1002uintDivideJ1ME1BU(UInt.m773constructorimpl(b & 255), i);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m708divVKZWuLQ(byte b, long j) {
        return UnsignedKt.m1004ulongDivideeb3DHEI(ULong.m843constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m726rem7apg3OU(byte b, byte b2) {
        return UnsignedKt.m1003uintRemainderJ1ME1BU(UInt.m773constructorimpl(b & 255), UInt.m773constructorimpl(b2 & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m729remxj2QHRw(byte b, short s) {
        return UnsignedKt.m1003uintRemainderJ1ME1BU(UInt.m773constructorimpl(b & 255), UInt.m773constructorimpl(s & 65535));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m728remWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m1003uintRemainderJ1ME1BU(UInt.m773constructorimpl(b & 255), i);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m727remVKZWuLQ(byte b, long j) {
        return UnsignedKt.m1005ulongRemaindereb3DHEI(ULong.m843constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: inc-w2LRezQ  reason: not valid java name */
    private static final byte m714incw2LRezQ(byte b) {
        return m705constructorimpl((byte) (b + 1));
    }

    /* renamed from: dec-w2LRezQ  reason: not valid java name */
    private static final byte m706decw2LRezQ(byte b) {
        return m705constructorimpl((byte) (b - 1));
    }

    /* renamed from: rangeTo-7apg3OU  reason: not valid java name */
    private static final UIntRange m725rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(UInt.m773constructorimpl(b & 255), UInt.m773constructorimpl(b2 & 255), null);
    }

    /* renamed from: and-7apg3OU  reason: not valid java name */
    private static final byte m698and7apg3OU(byte b, byte b2) {
        return m705constructorimpl((byte) (b & b2));
    }

    /* renamed from: or-7apg3OU  reason: not valid java name */
    private static final byte m720or7apg3OU(byte b, byte b2) {
        return m705constructorimpl((byte) (b | b2));
    }

    /* renamed from: xor-7apg3OU  reason: not valid java name */
    private static final byte m745xor7apg3OU(byte b, byte b2) {
        return m705constructorimpl((byte) (b ^ b2));
    }

    /* renamed from: inv-w2LRezQ  reason: not valid java name */
    private static final byte m715invw2LRezQ(byte b) {
        return m705constructorimpl((byte) (~b));
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m744toUShortMh2AYeg(byte b) {
        return UShort.m941constructorimpl((short) (((short) b) & 255));
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m742toUIntpVg5ArA(byte b) {
        return UInt.m773constructorimpl(b & 255);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m743toULongsVKNKU(byte b) {
        return ULong.m843constructorimpl(((long) b) & 255);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m740toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }
}
