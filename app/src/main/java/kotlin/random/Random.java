package kotlin.random;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
/* compiled from: Random.kt */
public abstract class Random {
    public static final Default Default = new Default(null);
    private static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();

    public abstract int nextBits(int i);

    public int nextInt() {
        return nextBits(32);
    }

    public int nextInt(int i) {
        return nextInt(0, i);
    }

    public int nextInt(int i, int i2) {
        int i3;
        int nextInt;
        int i4;
        RandomKt.checkRangeBounds(i, i2);
        int i5 = i2 - i;
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            if (((-i5) & i5) == i5) {
                i3 = nextBits(RandomKt.fastLog2(i5));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i4 = nextInt % i5;
                } while ((nextInt - i4) + (i5 - 1) < 0);
                i3 = i4;
            }
            return i + i3;
        }
        while (true) {
            int nextInt2 = nextInt();
            if (i <= nextInt2 && i2 > nextInt2) {
                return nextInt2;
            }
        }
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public long nextLong(long j) {
        return nextLong(0, j);
    }

    public long nextLong(long j, long j2) {
        long j3;
        long nextLong;
        long j4;
        int nextInt;
        RandomKt.checkRangeBounds(j, j2);
        long j5 = j2 - j;
        if (j5 > 0) {
            if (((-j5) & j5) == j5) {
                int i = (int) j5;
                int i2 = (int) (j5 >>> 32);
                if (i != 0) {
                    nextInt = nextBits(RandomKt.fastLog2(i));
                } else if (i2 == 1) {
                    nextInt = nextInt();
                } else {
                    j3 = (((long) nextBits(RandomKt.fastLog2(i2))) << 32) + ((long) nextInt());
                }
                j3 = ((long) nextInt) & 4294967295L;
            } else {
                do {
                    nextLong = nextLong() >>> 1;
                    j4 = nextLong % j5;
                } while ((nextLong - j4) + (j5 - 1) < 0);
                j3 = j4;
            }
            return j + j3;
        }
        while (true) {
            long nextLong2 = nextLong();
            if (j <= nextLong2 && j2 > nextLong2) {
                return nextLong2;
            }
        }
    }

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public double nextDouble(double d) {
        return nextDouble(0.0d, d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    public double nextDouble(double d, double d2) {
        double d3;
        RandomKt.checkRangeBounds(d, d2);
        double d4 = d2 - d;
        if (Double.isInfinite(d4)) {
            boolean z = true;
            if (!Double.isInfinite(d) && !Double.isNaN(d)) {
                if (Double.isInfinite(d2) || Double.isNaN(d2)) {
                    z = false;
                }
                if (z) {
                    double d5 = (double) 2;
                    double nextDouble = nextDouble() * ((d2 / d5) - (d / d5));
                    d3 = d + nextDouble + nextDouble;
                    return d3 < d2 ? Math.nextAfter(d2, Double.NEGATIVE_INFINITY) : d3;
                }
            }
        }
        d3 = d + (nextDouble() * d4);
        if (d3 < d2) {
        }
    }

    public float nextFloat() {
        return ((float) nextBits(24)) / ((float) 16777216);
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return random.nextBytes(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0086  */
    public byte[] nextBytes(byte[] bArr, int i, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "array");
        int length = bArr.length;
        boolean z2 = true;
        if (i >= 0 && length >= i) {
            int length2 = bArr.length;
            if (i2 >= 0 && length2 >= i2) {
                z = true;
                if (!z) {
                    if (i > i2) {
                        z2 = false;
                    }
                    if (z2) {
                        int i3 = (i2 - i) / 4;
                        for (int i4 = 0; i4 < i3; i4++) {
                            int nextInt = nextInt();
                            bArr[i] = (byte) nextInt;
                            bArr[i + 1] = (byte) (nextInt >>> 8);
                            bArr[i + 2] = (byte) (nextInt >>> 16);
                            bArr[i + 3] = (byte) (nextInt >>> 24);
                            i += 4;
                        }
                        int i5 = i2 - i;
                        int nextBits = nextBits(i5 * 8);
                        for (int i6 = 0; i6 < i5; i6++) {
                            bArr[i + i6] = (byte) (nextBits >>> (i6 * 8));
                        }
                        return bArr;
                    }
                    throw new IllegalArgumentException(("fromIndex (" + i + ") must be not greater than toIndex (" + i2 + ").").toString());
                }
                throw new IllegalArgumentException(("fromIndex (" + i + ") or toIndex (" + i2 + ") are out of range: 0.." + bArr.length + '.').toString());
            }
        }
        z = false;
        if (!z) {
        }
    }

    public byte[] nextBytes(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        return nextBytes(bArr, 0, bArr.length);
    }

    public byte[] nextBytes(int i) {
        return nextBytes(new byte[i]);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0017H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    /* compiled from: Random.kt */
    public static final class Default extends Random {
        private Default() {
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // kotlin.random.Random
        public int nextBits(int i) {
            return Random.defaultRandom.nextBits(i);
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public int nextInt(int i) {
            return Random.defaultRandom.nextInt(i);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i, int i2) {
            return Random.defaultRandom.nextInt(i, i2);
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        public long nextLong(long j) {
            return Random.defaultRandom.nextLong(j);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j, long j2) {
            return Random.defaultRandom.nextLong(j, j2);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d) {
            return Random.defaultRandom.nextDouble(d);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d, double d2) {
            return Random.defaultRandom.nextDouble(d, d2);
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "array");
            return Random.defaultRandom.nextBytes(bArr);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int i) {
            return Random.defaultRandom.nextBytes(i);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] bArr, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "array");
            return Random.defaultRandom.nextBytes(bArr, i, i2);
        }
    }
}
